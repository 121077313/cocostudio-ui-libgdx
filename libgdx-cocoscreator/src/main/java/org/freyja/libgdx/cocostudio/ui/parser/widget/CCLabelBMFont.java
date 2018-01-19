package org.freyja.libgdx.cocostudio.ui.parser.widget;

import org.freyja.libgdx.cocos.creator.ui.CocoCreatorUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CColor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.parser.WidgetParser;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class CCLabelBMFont extends WidgetParser {

	@Override
	public String getClassName() {
		return "TextBMFontObjectData";
	}

	@Override
	public Actor parse(CocoCreatorUIEditor editor, ObjectData widget) {
		BitmapFont font = null;
		if (editor.getBitmapFonts() != null) {
			font = editor.getBitmapFonts().get(
					widget.getLabelBMFontFile_CNB().getPath());
		}
		if (font == null) {// 备用创建字体方式
			font = new BitmapFont(Gdx.files.internal(editor.getDirName()
					+ widget.getLabelBMFontFile_CNB().getPath()));
		}

		if (font == null) {
			editor.debug(widget, "BitmapFont字体:"
					+ widget.getLabelBMFontFile_CNB().getPath() + " 不存在");
			font = new BitmapFont();
		}

		CColor color = widget.getCColor();

		Color textColor = new Color(color.getR() / 255.0f,
				color.getG() / 255.0f, color.getB() / 255.0f,
				widget.getAlpha() / 255.0f);
		LabelStyle style = new LabelStyle(font, textColor);
		Label label = new Label(widget.getLabelText(), style);
		return label;
	}

}
