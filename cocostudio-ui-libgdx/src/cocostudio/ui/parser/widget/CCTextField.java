package cocostudio.ui.parser.widget;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.WidgetParser;

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
		
		LabelStyle labelStyle = editor.createLabelStyle(option);

		if (labelStyle == null) {
			return null;
		}
		TextFieldStyle style = new TextFieldStyle(labelStyle.font,
				labelStyle.fontColor, null, null, null);
		TextField textField = new TextField(option.getText(), style);
		textField.setMessageText(option.getPlaceHolder());
		textField.setPasswordMode(option.isPasswordEnable());
		textField.setPasswordCharacter(option.getPasswordStyleText());
		return textField;
	}

}
