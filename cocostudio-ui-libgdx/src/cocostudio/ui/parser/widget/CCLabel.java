package cocostudio.ui.parser.widget;

import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.WidgetParser;
import cocostudio.ui.widget.TTFLabel;
import cocostudio.ui.widget.TTFLabelStyle;

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

		TTFLabelStyle labelStyle = editor.createLabelStyle(option);
		if (labelStyle == null) {
			return null;
		}
		TTFLabel label = new TTFLabel(option.getText(), labelStyle);
		label.setAlignment(option.getvAlignment(), option.gethAlignment());

		return label;
	}

}
