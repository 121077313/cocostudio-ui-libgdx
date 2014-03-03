package cocostudio.ui.parser.widget;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.WidgetParser;
import cocostudio.ui.widget.TTFLabelStyle;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;

public class CCTextField extends WidgetParser {

	@Override
	public String getClassName() {
		return "TextField";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {

		TTFLabelStyle labelStyle = editor.createLabelStyle(option);

		TextFieldStyle style = new TextFieldStyle(
				labelStyle.getLabelStyle().font,
				labelStyle.getLabelStyle().fontColor, null, null, null);
		TextField textField = new TextField(option.getText(), style);
		textField.setMessageText(option.getPlaceHolder());
		textField.setPasswordMode(option.isPasswordEnable());
		textField.setPasswordCharacter(option.getPasswordStyleText());

		return textField;
	}

}
