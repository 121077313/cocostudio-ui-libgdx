package cocostudio.ui.parser.group;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class CCButton extends GroupParser {

	@Override
	public String getClassName() {
		return "Button";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {

		ImageButtonStyle style = new ImageButtonStyle(null, null, null,
				editor.findDrawable(option, option.getNormalData().getPath()),
				editor.findDrawable(option, option.getPressedData().getPath()),
				null);
		style.imageDisabled = editor.findDrawable(option, option
				.getDisabledData().getPath());
		ImageButton button = new ImageButton(style);

		if (option.getText() != null && !option.getText().equals("")) {
			LabelStyle labelStyle = editor.createLabelStyle(option);
			if (labelStyle != null) {
				Label label = new Label(option.getText(), labelStyle);
				label.setPosition(button.getWidth() / 2, button.getHeight() / 2);
				button.addActor(label);
			}
		}
		return button;
	}

}
