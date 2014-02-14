package cocostudio.ui;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import cocostudio.ui.model.CCExport;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.group.CCButton;
import cocostudio.ui.parser.group.CCCheckBox;
import cocostudio.ui.parser.group.CCPanel;
import cocostudio.ui.parser.group.CCScrollView;
import cocostudio.ui.parser.widget.CCImageView;
import cocostudio.ui.parser.widget.CCLabel;
import cocostudio.ui.parser.widget.CCLabelBMFont;
import cocostudio.ui.parser.widget.CCLoadingBar;
import cocostudio.ui.parser.widget.CCTextField;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
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
public class CocoStudioUIEditor {

	final String tag = CocoStudioUIEditor.class.getName();

	/** json文件所在目录 */
	private String dirName;

	/** 当前画布的所有纹理 */
	protected TextureAtlas textureAtlas;

	/** 控件集合 */
	protected Map<String, Array<Actor>> actors;

	/** 字体集合 */
	protected Map<String, FileHandle> ttfs;

	/** BitmapFont集合,key:font.fnt */
	protected Map<String, BitmapFont> bitmapFonts;

	/** 导出的json结构 */
	protected CCExport export;

	protected Map<String, BaseWidgetParser> parsers;

	/**
	 * 不需要显示文字
	 * 
	 * @param jsonFile
	 * @param textureAtlas
	 *            资源文件,传入 null表示使用小文件方式加载图片
	 */
	public CocoStudioUIEditor(FileHandle jsonFile, TextureAtlas textureAtlas) {
		this(jsonFile, textureAtlas, null, null);
	}

	/** 添加转换器 */
	public void addParser(BaseWidgetParser parser) {
		parsers.put(parser.getClassName(), parser);
	}

	/**
	 * 
	 * @param jsonFile
	 *            ui编辑成生成的json文件
	 * @param textureAtlas
	 *            资源文件,传入 null表示使用小文件方式加载图片
	 * 
	 * @param ttfs
	 *            字体文件集合
	 * @param bitmapFonts
	 *            自定义字体文件集合
	 */
	public CocoStudioUIEditor(FileHandle jsonFile, TextureAtlas textureAtlas,
			Map<String, FileHandle> ttfs, Map<String, BitmapFont> bitmapFonts) {
		this.textureAtlas = textureAtlas;
		this.ttfs = ttfs;
		this.bitmapFonts = bitmapFonts;
		parsers = new HashMap<String, BaseWidgetParser>();

		addParser(new CCButton());
		addParser(new CCCheckBox());
		addParser(new CCImageView());
		addParser(new CCLabel());
		addParser(new CCLabelBMFont());
		addParser(new CCPanel());
		addParser(new CCScrollView());
		addParser(new CCTextField());
		addParser(new CCLoadingBar());
		actors = new HashMap<String, Array<Actor>>();
		dirName = jsonFile.parent().toString() + "\\";

		String json = jsonFile.readString("utf-8");
		Json jj = new Json();
		jj.setIgnoreUnknownFields(true);
		export = jj.fromJson(CCExport.class, json);

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
		Actor actor = parseWidget(null, export.getWidgetTree());

		return (Group) actor;

	}

	/**
	 * 获取材质
	 * 
	 * @param option
	 * @param name
	 * @return
	 */
	public TextureRegion findTextureRegion(CCOption option, String name) {
		if (name == null || name.equals("")) {
			return null;
		}
		TextureRegion tr = null;
		if (textureAtlas == null) {// 不使用合并纹理
			tr = new TextureRegion(new Texture(Gdx.files.internal(dirName
					+ name)));
		} else {

			// name = name.substring(parentName.length(), name.length() - 4);

			try {
				String[] arr = name.split("\\/");
				name = name.substring(arr[0].length() + 1, name.length() - 4);
			} catch (Exception e) {
				error(option, "名称不符合约定,无法解析.请查看github项目wiki");
			}

			// 考虑index下标

			if (name.indexOf("_") == -1) {
				tr = textureAtlas.findRegion(name);
			} else {
				try {
					int length = name.lastIndexOf("_");
					Integer index = Integer.parseInt(name.substring(length + 1,
							name.length()));
					name = name.substring(0, length);
					tr = textureAtlas.findRegion(name, index);
				} catch (Exception e) {
					tr = textureAtlas.findRegion(name);
				}
			}
		}
		if (tr == null) {
			debug(option, "找不到纹理");
		}

		if (option.isFlipX() || option.isFlipY()) {

			if (textureAtlas == null) {
				tr.flip(option.isFlipX(), option.isFlipY());
			} else {
				tr = new TextureRegion(tr);
				tr.flip(option.isFlipX(), option.isFlipY());
			}
		}

		return tr;
	}

	public Drawable findDrawable(CCOption option, String name) {
		TextureRegion tr = findTextureRegion(option, name);
		if (tr == null) {
			return null;
		}
		return new TextureRegionDrawable(tr);
	}

	public void debug(String message) {
		Gdx.app.debug(tag, message);
	}

	public void debug(CCOption option, String message) {
		Gdx.app.debug(tag, "控件: " + option.getName() + " " + message);
	}

	public void error(String message) {
		Gdx.app.error(tag, message);
	}

	public void error(CCOption option, String message) {
		Gdx.app.error(tag, "控件: " + option.getName() + " " + message);
	}

	/***
	 * 解析节点,创建控件
	 * 
	 * @param node
	 * @return
	 */
	public Actor parseWidget(Group parent, CCWidget widget) {

		CCOption option = widget.getOptions();
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

	/** 获取BitmapFont */
	public BitmapFont getBitmapFont(CCOption option) {
		BitmapFont font = null;
		if (bitmapFonts != null) {
			font = bitmapFonts.get(option.getFileNameData().getPath());
		} else {
			font = new BitmapFont(Gdx.files.internal(dirName
					+ option.getFileNameData().getPath()));
		}

		if (font == null) {
			debug(option, "BitmapFont字体:" + option.getFileNameData().getPath()
					+ " 不存在");
			font = new BitmapFont();
		}
		return font;
	}

	/**
	 * 创建LabelStyle
	 * 
	 * @param option
	 * @return
	 */
	public LabelStyle createLabelStyle(CCOption option) {

		FileHandle fontFile = null;
		if (ttfs != null) {
			fontFile = ttfs.get(option.getFontName());
		}

		Color textColor = new Color(option.getTextColorR() / 255,
				option.getTextColorG() / 255, option.getTextColorB() / 255,
				option.getOpacity() / 255);

		if (fontFile == null) {
			debug(option, "ttf字体:" + option.getFontName() + " 不存在");

			return new LabelStyle(new BitmapFont(), textColor);
		} else {
			FreeTypeFontGenerator generator = null;
			BitmapFont font;
			try {
				generator = new FreeTypeFontGenerator(fontFile);
				String text = removeRepeatedChar(option.getText());
				font = generator
						.generateFont(option.getFontSize(), text, false);
				generator.dispose();
				return new LabelStyle(font, textColor);
			} catch (Exception e) {
				error(option, "创建字体错误,fontName:" + option.getFontName()
						+ ",text:" + option.getText());
				e.printStackTrace();
				return null;
			}
		}

	}

	/** 去除重复字符 */
	public static String removeRepeatedChar(String text) {
		char[] chars = text.toCharArray();
		char[] existChar = new char[chars.length];
		int i = 0;
		StringBuffer sb = new StringBuffer();
		for (char ch : chars) {
			if (isExistsChar(existChar, ch)) {
				continue;
			}
			existChar[i] = ch;
			sb.append(ch);
			i++;
		}

		if (chars.length == i) {// 没有重复项避免创建String
			return text;
		}
		return sb.toString();
	}

	/** 检查是否存在字符 */
	static boolean isExistsChar(char[] chars, char ch) {
		for (char c : chars) {
			if (c == ch) {
				return true;
			}
		}
		return false;
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

}
