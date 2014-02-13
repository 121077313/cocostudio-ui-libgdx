package cocostudio.ui;

import java.util.HashMap;
import java.util.Map;

import cocostudio.ui.model.CCExport;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;

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
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
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
import com.badlogic.gdx.utils.Json;

/**
 * CocoStudio ui 解析器.根据CocoStudio的ui编辑器生成的json文件,创建出一个对应Group.
 * 本解析器还处于初级阶段,部分控件与属性不支持.
 * 
 * @author i see
 * @email 121077313@qq.com
 */
public class CocoStudioUIEditor {

	final String tag = CocoStudioUIEditor.class.getName();

	/** json文件所在目录 */
	private String dirName;

	/** 当前画布的所有纹理 */
	protected TextureAtlas textureAtlas;

	/** 控件集合 */
	protected Map<String, Actor> actors;

	/** 字体集合 */
	protected Map<String, FileHandle> ttfs;

	/** BitmapFont集合,key:font.fnt */
	protected Map<String, BitmapFont> bitmapFonts;

	/** 导出的json结构 */
	protected CCExport export;

	/**
	 * 不需要显示文字
	 * 
	 * @param jsonFile
	 * @param textureAtlas
	 */
	public CocoStudioUIEditor(FileHandle jsonFile, TextureAtlas textureAtlas) {
		this(jsonFile, textureAtlas, null, null);
	}

	/**
	 * 
	 * @param jsonFile
	 *            ui编辑成生成的json文件
	 * @param textureAtlas
	 *            资源文件
	 * @param ttfs
	 *            字体文件集合
	 */
	public CocoStudioUIEditor(FileHandle jsonFile, TextureAtlas textureAtlas,
			Map<String, FileHandle> ttfs, Map<String, BitmapFont> bitmapFonts) {
		this.textureAtlas = textureAtlas;
		this.ttfs = ttfs;
		this.bitmapFonts = bitmapFonts;
		actors = new HashMap<String, Actor>();
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
		return actors.get(name);
	}

	/**
	 * 根据json文件创建并返回Group
	 * 
	 * @return
	 */
	public Group createGroup() {
		Actor actor = parseWidget(export.getWidgetTree());

		if (actor instanceof Group) {
			return (Group) actor;
		}
		Group group = new Group();
		group.addActor(actor);
		return group;
	}

	protected TextureRegion findTextureRegion(CCOption option, String name) {
		if (name == null || name.equals("")) {
			return null;
		}
		TextureRegion tr = null;
		if (!option.isUseMergedTexture()) {// 不使用合并纹理

			tr = new TextureRegion(new Texture(Gdx.files.internal(dirName
					+ name)));
			if (option.isFlipX() || option.isFlipY()) {
				tr.flip(option.isFlipX(), option.isFlipY());
			}
			return tr;
		}
		// name = name.substring(parentName.length(), name.length() - 4);

		try {
			String[] arr = name.split("\\/");
			name = name.substring(arr[0].length() + 1, name.length() - 4);
		} catch (Exception e) {
			error(option, "纹理名称不符合约定,无法解析.");
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

		if (tr == null) {
			debug(option, "找不到纹理");
		}

		if (option.isFlipX() || option.isFlipY()) {
			tr = new TextureRegion(tr);
			tr.flip(option.isFlipX(), option.isFlipY());
		}

		return tr;
	}

	protected Drawable findDrawable(CCOption option, String name) {
		TextureRegion tr = findTextureRegion(option, name);
		if (tr == null) {
			return null;
		}
		return new TextureRegionDrawable(tr);
	}

	protected void debug(String message) {
		Gdx.app.debug(tag, message);
	}

	protected void debug(CCOption option, String message) {
		Gdx.app.debug(tag, "控件: " + option.getName() + " " + message);
	}

	protected void error(String message) {
		Gdx.app.error(tag, message);
	}

	protected void error(CCOption option, String message) {
		Gdx.app.error(tag, "控件: " + option.getName() + " " + message);
	}

	/***
	 * 解析节点,创建控件
	 * 
	 * @param node
	 * @return
	 */
	protected Actor parseWidget(CCWidget widget) {

		CCOption option = widget.getOptions();
		String className = option.getClassname();

		Actor actor = null;
		if (className.equals("ImageView")) {
			TextureRegion tr = findTextureRegion(option, option
					.getFileNameData().getPath());
			if (tr == null) {
				return null;
			}
			actor = new Image(tr);
		} else if (className.equals("Button")) {

			ImageButtonStyle style = new ImageButtonStyle(null, null, null,
					findDrawable(option, option.getNormalData().getPath()),
					findDrawable(option, option.getPressedData().getPath()),
					null);
			style.imageDisabled = findDrawable(option, option.getDisabledData()
					.getPath());
			actor = new ImageButton(style);

			if (option.getText() != null && !option.getText().equals("")
					&& ttfs != null) {
				Button button = (Button) actor;
				LabelStyle labelStyle = createLabelStyle(option);
				if (labelStyle != null) {
					Label label = new Label(option.getText(), labelStyle);
					label.setPosition(button.getWidth() / 2,
							button.getHeight() / 2);
					button.addActor(label);
				}
			}
		} else if (className.equals("LabelBMFont")) {
			BitmapFont font = null;
			if (bitmapFonts != null) {
				font = bitmapFonts.get(option.getFileNameData().getPath());
			} else {

				font = new BitmapFont(Gdx.files.internal(dirName
						+ option.getFileNameData().getPath()));
			}

			if (font == null) {
				debug(option, "字体:" + option.getFileNameData().getPath()
						+ "不存在,使用默认字体");
				font = new BitmapFont();
			}
			Color textColor = new Color(option.getColorR() / 255,
					option.getColorG() / 255, option.getColorB() / 255,
					option.getOpacity() / 255);
			LabelStyle style = new LabelStyle(font, textColor);
			actor = new Label(option.getText(), style);

		} else if (className.equals("TextField")) {// TextField

			LabelStyle labelStyle = createLabelStyle(option);
			TextFieldStyle style = new TextFieldStyle(labelStyle.font,
					labelStyle.fontColor, null, null, null);
			actor = new TextField(option.getText(), style);
			TextField textField = (TextField) actor;
			textField.setPasswordMode(option.isPasswordEnable());
			textField.setPasswordCharacter(option.getPasswordStyleText());
		} else if (className.equals("Label")) {// Label

			LabelStyle labelStyle = createLabelStyle(option);
			actor = new Label(option.getText(), labelStyle);
			Label label = (Label) actor;
			label.setAlignment(option.getvAlignment(), option.gethAlignment());
		} else if (className.equals("Panel")) {// Table
			actor = new Table();
			Table table = (Table) actor;
			if (option.getBackGroundImageData() != null) {// Panel的图片并不是拉伸平铺的!!
				// table.setBackground(findDrawable(option, option
				// .getBackGroundImageData().getPath()));
				Image bg = new Image(findTextureRegion(option, option
						.getBackGroundImageData().getPath()));
				bg.setPosition((option.getWidth() - bg.getWidth()) / 2,
						(option.getHeight() - bg.getHeight()) / 2);
				table.addActor(bg);
			}

			table.setClip(option.isClipAble());
		} else if (className.equals("ListView")) {//
			debug(option, "not support Widget:" + className);
			return null;
		} else if (className.equals("ScrollView")) {// ScrollPane

			ScrollPaneStyle style = new ScrollPaneStyle();

			if (option.getBackGroundImageData() != null) {

				style.background = findDrawable(option, option
						.getBackGroundImageData().getPath());
			}

			actor = new ScrollPane(null, style);

			ScrollPane scrollPane = (ScrollPane) actor;

			switch (option.getDirection()) {
			case 1:
				scrollPane.setForceScroll(false, true);
				// scrollPane.setScrollingDisabled(true,true);
				break;
			case 2:
				// scrollPane.setForceScroll(true, false);
				scrollPane.setScrollingDisabled(false, false);
				break;

			case 3:
				scrollPane.setScrollingDisabled(false, false);
				// scrollPane.setForceScroll(true, true);
				break;
			}

			// scrollPane.setFlickScroll(option.isBounceEnable());
		} else if (className.equals("PageView")) {
			debug(option, "not support Widget:" + className);
			return null;
		} else if (className.equals("LabelAtlas")) {// 数字标签

			debug(option, "not support Widget:" + className);
			return null;
		}

		else {

			debug(option, "not support Widget:" + className);
			return null;
		}
		actor.setName(option.getName());

		if (option.isIgnoreSize()) {// 忽略大小,指的是编辑器无法指定大小(?)

		} else {
			actor.setSize(option.getWidth(), option.getHeight());
		}

		actor.setX(option.getX() - option.getAnchorPointX() * option.getWidth());

		actor.setY(option.getY() - option.getAnchorPointY()
				* option.getHeight());

		actor.setOrigin(option.getAnchorPointX() * option.getWidth(),
				option.getAnchorPointY() * option.getHeight());
		
		// CocoStudio的编辑器ScaleX,ScaleY 会有负数情况
		
		actor.setScale(Math.abs(option.getScaleX()),
				Math.abs(option.getScaleY()));

		if (option.getRotation() != 0) {// CocoStudio 是顺时针方向旋转,转换下.
			// 设置旋转中心为锚点

			actor.setRotation(360 - option.getRotation() % 360);
			if (actor instanceof Group) {// 必须设置Transform 为true 子控件才会跟着旋转.
				Group g = (Group) actor;
				g.setTransform(true);
			}
		}

		actor.setVisible(option.isVisible());

		actor.setColor(option.getColorR(), option.getColorG(),
				option.getColorB(), option.getOpacity() / 255);

		actor.setZIndex(option.getZOrder());

		if (actors.containsKey(actor.getName())) {
			// debug(option, "重名");
		}

		actors.put(actor.getName(), actor);

		actor.setTouchable(option.isTouchAble() ? Touchable.enabled
				: Touchable.disabled);

		if (widget.getChildren().size() == 0) {

			return actor;
		}

		if (actor instanceof Group) {// Group 虽然自己不接收事件,但是子控件得接收
			actor.setTouchable(option.isTouchAble() ? Touchable.enabled
					: Touchable.childrenOnly);

			Group group = (Group) actor;

			if (actor instanceof ScrollPane) {
				ScrollPane scrollPane = (ScrollPane) actor;
				Table table = new Table();
				// table.setClip(option.isClipAble());

				for (CCWidget cWidget : widget.getChildren()) {
					Actor cGroup = parseWidget(cWidget);
					if (cGroup == null) {
						continue;
					}
					table.addActor(cGroup);

					table.setSize(
							Math.max(table.getWidth(), cGroup.getRight()),
							Math.max(table.getHeight(), cGroup.getTop()));
				}
				scrollPane.setWidget(table);
			} else {
				for (CCWidget cWidget : widget.getChildren()) {
					Actor cGroup = parseWidget(cWidget);
					if (cGroup == null) {
						continue;
					}
					group.addActor(cGroup);
				}
			}

			return actor;
		}

		Table table = new Table();
		table.setVisible(option.isVisible());
		table.setClip(option.isClipAble());
		table.setSize(actor.getWidth(), actor.getHeight());
		table.setPosition(actor.getX(), actor.getY());
		table.addActor(actor);
		for (CCWidget cWidget : widget.getChildren()) {
			Actor cGroup = parseWidget(cWidget);
			if (cGroup == null) {
				continue;
			}
			table.addActor(cGroup);
		}

		return table;

	}

	/**
	 * 创建LabelStyle
	 * 
	 * @param option
	 * @return
	 */
	protected LabelStyle createLabelStyle(CCOption option) {
		FileHandle fontFile = ttfs.get(option.getFontName());

		Color textColor = new Color(option.getTextColorR() / 255,
				option.getTextColorG() / 255, option.getTextColorB() / 255,
				option.getOpacity() / 255);

		if (fontFile == null) {
			debug(option, "字体:" + option.getFontName() + "不存在,使用默认字体");

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

}
