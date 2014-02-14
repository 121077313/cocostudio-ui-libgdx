package cocostudio.ui.parser.widget;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.WidgetParser;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class CCLabelBMFont extends WidgetParser {

	@Override
	public String getClassName() {
		return "LabelBMFont";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {
		BitmapFont font = null;
		if (editor.getBitmapFonts() != null) {
			font = editor.getBitmapFonts().get(
					option.getFileNameData().getPath());
		} else {

			font = new BitmapFont(Gdx.files.internal(editor.getDirName()
					+ option.getFileNameData().getPath()));
		}

		if (font == null) {
			editor.debug(option, "BitmapFont字体:"
					+ option.getFileNameData().getPath() + " 不存在");
			font = new BitmapFont();
		}
		Color textColor = new Color(option.getColorR() / 255,
				option.getColorG() / 255, option.getColorB() / 255,
				option.getOpacity() / 255);
		LabelStyle style = new LabelStyle(font, textColor);
		Label label = new Label(option.getText(), style);
		return label;
	}

}
