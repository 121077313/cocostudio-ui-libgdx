package org.freyja.libgdx.cocostudio.scene;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.freyja.libgdx.cocostudio.scene.model.CCComponent;
import org.freyja.libgdx.cocostudio.scene.model.CCGameObject;
import org.freyja.libgdx.cocostudio.scene.model.CCSceneExport;
import org.freyja.libgdx.cocostudio.scene.parser.group.CCNode;
import org.freyja.libgdx.cocostudio.scene.parser.group.CCScene;
import org.freyja.libgdx.cocostudio.scene.parser.widget.CCSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

/**
 * CocoStudio ui 解析器.根据CocoStudio的ui编辑器生成的json文件,创建出一个对应Group.
 * 本解析器还处于初级阶段,部分控件与属性不支持.
 * 
 * @author i see
 * @email 121077313@qq.com
 * @wiki https://github.com/121077313/cocostudio-ui-libgdx/wiki
 * @tip https://github.com/121077313/cocostudio-ui-libgdx/wiki/疑难解答
 */
public class CocoStudioSceneEditor {

	final String tag = CocoStudioSceneEditor.class.getName();

	/** json文件所在目录 */
	protected String dirName;

	/** 所有纹理 */
	protected Collection<TextureAtlas> textureAtlas;

	/** 控件集合 */
	protected Map<String, Array<Actor>> actors;

	protected Map<Integer, Actor> actionActors;

	Map<String, Map<Actor, Action>> animations;

	/** 字体集合 */
	protected Map<String, FileHandle> ttfs;

	/** BitmapFont集合,key:font.fnt */
	protected Map<String, BitmapFont> bitmapFonts;

	/** 导出的json结构 */
	protected CCSceneExport export;

	protected Map<String, BaseWidgetParser> parsers;

	/** 添加转换器 */
	public void addParser(BaseWidgetParser parser) {
		parsers.put(parser.getClassName(), parser);
	}

	/** 默认ttf字体文件 */
	protected FileHandle defaultFont;

	/**
	 * 不需要显示文字
	 * 
	 * @param jsonFile
	 * @param textureAtlas
	 *            资源文件,传入 null表示使用小文件方式加载图片
	 */
	public CocoStudioSceneEditor(FileHandle jsonFile,
			Collection<TextureAtlas> textureAtlas) {
		this(jsonFile, null, null, null, textureAtlas);
	}

	/**
	 * 
	 * @param jsonFile
	 *            ui编辑成生成的json文件
	 * @param textureAtlas
	 *            资源文件,传入 null表示使用小文件方式加载图片.
	 * 
	 * @param ttfs
	 *            字体文件集合
	 * @param bitmapFonts
	 *            自定义字体文件集合
	 * @param defaultFont
	 *            默认ttf字体文件
	 */
	public CocoStudioSceneEditor(FileHandle jsonFile,
			Map<String, FileHandle> ttfs, Map<String, BitmapFont> bitmapFonts,
			FileHandle defaultFont, Collection<TextureAtlas> textureAtlas) {
		this.textureAtlas = textureAtlas;
		this.ttfs = ttfs;
		this.bitmapFonts = bitmapFonts;
		this.defaultFont = defaultFont;
		parsers = new HashMap<String, BaseWidgetParser>();

		// addParser(new CCButton());
		// addParser(new CCCheckBox());
		addParser(new CCSprite());
		addParser(new CCScene());
		addParser(new CCNode());
		// addParser(new CCLabel());
		// addParser(new CCLabelBMFont());
		// addParser(new CCPanel());
		// addParser(new CCScrollView());
		// addParser(new CCTextField());
		// addParser(new CCLoadingBar());
		//
		// addParser(new CCLabelAtlas());
		// addParser(new CCSlider());
		actors = new HashMap<String, Array<Actor>>();
		actionActors = new HashMap<Integer, Actor>();

		animations = new HashMap<String, Map<Actor, Action>>();

		dirName = jsonFile.parent().toString();

		if (!dirName.equals("")) {
			dirName += File.separator;
		}
		String json = jsonFile.readString("utf-8");
		Json jj = new Json();
		jj.setIgnoreUnknownFields(true);
		export = jj.fromJson(CCSceneExport.class, json);

	}

	/**
	 * 根据控件名字查找Actor
	 * 
	 * @param name
	 *            控件名字
	 * @return
	 */
	public Actor findActor(String name) {
		Array<Actor> array = actors.get(name);
		if (array == null || array.size == 0) {
			return null;
		}
		return array.get(0);
	}

	/** 查找所有同名的控件 */
	public Array<Actor> findActors(String name) {

		return actors.get(name);
	}

	/**
	 * 根据json文件创建并返回Group
	 * 
	 * @return
	 */
	public Group createGroup() {
		Actor actor = parseWidget(null, export);

		return (Group) actor;
	}

	/** 查找动画 */
	public Map<Actor, Action> getAction(String animationName) {

		return animations.get(animationName);
	}

	public Interpolation getInterpolation(int tweenType) {
		return null;
	}

	protected TextureRegion findRegion(String name) {
		for (TextureAtlas ta : textureAtlas) {
			if (ta == null) {
				continue;
			}
			TextureRegion tr = ta.findRegion(name);
			if (tr != null) {
				return tr;
			}
		}
		return null;
	}

	protected TextureRegion findRegion(String name, int index) {
		for (TextureAtlas ta : textureAtlas) {
			if (ta == null) {
				continue;
			}
			TextureRegion tr = ta.findRegion(name, index);
			if (tr != null) {
				return tr;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String[] arr = "".split("\\/");
		System.out.println(arr.length);
	}

	/**
	 * 获取材质
	 * 
	 * @param option
	 * @param name
	 * @return
	 */
	public TextureRegion findTextureRegion(CCComponent option, String name) {
		if (name == null || name.equals("")) {
			return null;
		}
		TextureRegion tr = null;
		if (textureAtlas == null || textureAtlas.size() == 0) {// 不使用合并纹理
			try {
				tr = new TextureRegion(new Texture(Gdx.files.internal(dirName
						+ name)));
			} catch (Exception e) {


			}
		} else {

			try {
				String[] arr = name.split("\\/");
				if (arr.length == 1) {
					// support same folder with json file
					// add by @xiaozc

					name = name.substring(0, name.length() - 4);
				} else {
					name = name.substring(arr[0].length() + 1,
							name.length() - 4);
				}
			} catch (Exception e) {
				error(option, "资源名称不符合约定,无法解析.请查看github项目wiki第十条");
			}

			// 考虑index下标

			if (name.indexOf("_") == -1) {
				tr = findRegion(name);
			} else {
				try {
					int length = name.lastIndexOf("_");

					Integer index = Integer.parseInt(name.substring(length + 1,
							name.length()));
					// 这里可能报错,属于正常,因为会出现 xx_xx名字的资源而不是xx_2这种

					name = name.substring(0, length);

					tr = findRegion(name, index);

				} catch (Exception e) {
					tr = findRegion(name);
				}
			}
		}
		if (tr == null) {
			debug(option, "找不到纹理");
		}

		// if (option.isFlipX() || option.isFlipY()) {
		//
		// if (textureAtlas == null) {
		// tr.flip(option.isFlipX(), option.isFlipY());
		// } else {
		// tr = new TextureRegion(tr);
		// tr.flip(option.isFlipX(), option.isFlipY());
		// }
		// }

		return tr;
	}

	/**
	 * .9文件生成
	 * 
	 * @param option
	 * @param name
	 * @author wujj
	 * @return
	 */
	// public NinePatch findNinePatch(CCOption option, String name) {
	// if (name == null || name.equals("")) {
	// return null;
	// }
	//
	// NinePatch tr = null;
	// if (textureAtlas == null || textureAtlas.size() == 0) {// 不使用合并纹理
	// tr = new NinePatch(new Texture(Gdx.files.internal(dirName + name)),
	// option.getCapInsetsX(), option.getCapInsetsX()
	// + option.getCapInsetsWidth(),
	// option.getCapInsetsY(), option.getCapInsetsY()
	// + option.getCapInsetsHeight());
	// } else {
	// name = name.substring(0, name.indexOf("."));
	// // 考虑index下标
	//
	// if (name.indexOf("_") == -1) {
	// for (TextureAtlas atlas : textureAtlas) {
	// tr = atlas.createPatch(name);
	// if (tr != null) {
	// break;
	// }
	// }
	// } else {
	// try {
	// // 不支持同名索引查找
	// int length = name.lastIndexOf("_");
	// Integer index = Integer.parseInt(name.substring(length + 1,
	// name.length()));
	// name = name.substring(0, length);
	// for (TextureAtlas atlas : textureAtlas) {
	// tr = atlas.createPatch(name);
	// if (tr != null) {
	// break;
	// }
	// }
	// } catch (Exception e) {
	// for (TextureAtlas atlas : textureAtlas) {
	// tr = atlas.createPatch(name);
	// if (tr != null) {
	// break;
	// }
	// }
	// }
	// }
	// }
	// if (tr == null) {
	// debug(option, "找不到纹理");
	// }
	// // 不支持翻转和镜像
	// return tr;
	// }

	public Drawable findDrawable(CCComponent option, String name) {

		// if (option.isScale9Enable()) {// 九宫格支持
		// NinePatch np = findNinePatch(option, name);
		// if (np == null) {
		// return null;
		// }
		// return new NinePatchDrawable(np);
		// }

		TextureRegion tr = findTextureRegion(option, name);
		if (tr == null) {
			return null;
		}

		return new TextureRegionDrawable(tr);
	}

	public void debug(String message) {
		Gdx.app.debug(tag, message);
	}

	public void debug(CCComponent option, String message) {
		Gdx.app.debug(tag, "控件: " + option.getName() + " " + message);
	}

	public void error(String message) {
		Gdx.app.error(tag, message);
	}

	public void error(CCComponent option, String message) {
		Gdx.app.error(tag, "控件: " + option.getName() + " " + message);
	}

	/***
	 * 解析节点,创建控件
	 * 
	 * @param node
	 * @return
	 */
	public Actor parseWidget(Group parent, CCGameObject widget) {

		if (widget.getGameobjects().size() == 0) {
			CCComponent option = null;
			if (widget.getComponents().size() > 0) {
				option = widget.getComponents().get(0);
			}

			if (option == null) {
				return null;
			}

			String className = option.getClassname();
			BaseWidgetParser parser = parsers.get(className);

			if (parser == null) {

				debug(option, "not support Widget:" + className);
				return null;
			}
			Actor actor = parser.parse(this, widget, option);

			actor = parser.commonParse(this, widget, option, parent, actor);

			return actor;
		}

		for (CCGameObject gameObject : widget.getGameobjects()) {

			CCComponent option = null;

			if (widget.getComponents().size() > 0) {
				option = widget.getComponents().get(0);
			}
			if (option == null) {
				continue;
			}

			String className = option.getClassname();
			BaseWidgetParser parser = parsers.get(className);

			if (parser == null) {

				// debug(gameObject, "not support Widget:" + className);
				continue;
			}

			Actor actor = parser.parse(this, widget, option);

			actor = parser.commonParse(this, widget, option, parent, actor);

			return actor;

		}

		// for (CCComponent option : widget.getComponents()) {
		// String className = option.getClassname();
		// BaseWidgetParser parser = parsers.get(className);
		//
		// if (parser == null) {
		//
		// debug(option, "not support Widget:" + className);
		// return null;
		// }
		// Actor actor = parser.parse(this, widget, option);
		//
		// actor = parser.commonParse(this, widget, option, parent, actor);
		//
		// return actor;
		//
		// }
		return null;

	}

	public Map<String, Array<Actor>> getActors() {
		return actors;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public Map<String, FileHandle> getTtfs() {
		return ttfs;
	}

	public void setTtfs(Map<String, FileHandle> ttfs) {
		this.ttfs = ttfs;
	}

	public Map<String, BitmapFont> getBitmapFonts() {
		return bitmapFonts;
	}

	public void setBitmapFonts(Map<String, BitmapFont> bitmapFonts) {
		this.bitmapFonts = bitmapFonts;
	}

	public void setActors(Map<String, Array<Actor>> actors) {
		this.actors = actors;
	}

	public Map<Integer, Actor> getActionActors() {
		return actionActors;
	}

	public void setActionActors(Map<Integer, Actor> actionActors) {
		this.actionActors = actionActors;
	}

}
