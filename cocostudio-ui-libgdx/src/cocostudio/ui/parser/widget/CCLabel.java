package cocostudio.ui.parser.widget;

import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.WidgetParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class CCLabel extends WidgetParser {

	@Override
	public String getClassName() {
		return "Label";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {

		LabelStyle labelStyle = editor.createLabelStyle(option);
		if (labelStyle == null) {
			return null;
		}
		Label label = new Label(option.getText(), labelStyle);
		label.setAlignment(option.getvAlignment(), option.gethAlignment());
		return label;
	}

}
