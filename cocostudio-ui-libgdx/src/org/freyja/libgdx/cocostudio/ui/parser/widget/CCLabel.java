package org.freyja.libgdx.cocostudio.ui.parser.widget;

import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CCOption;
import org.freyja.libgdx.cocostudio.ui.model.CCWidget;
import org.freyja.libgdx.cocostudio.ui.parser.WidgetParser;
import org.freyja.libgdx.cocostudio.ui.util.FontUtil;
import org.freyja.libgdx.cocostudio.ui.widget.TTFLabel;
import org.freyja.libgdx.cocostudio.ui.widget.TTFLabelStyle;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

public class CCLabel extends WidgetParser {

	@Override
	public String getClassName() {
		return "Label";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {

		final TTFLabelStyle labelStyle = editor.createLabelStyle(option);

		TTFLabel label = new TTFLabel(option.getText(), labelStyle);

		// 水平
		int h = 0;
		switch (option.gethAlignment()) {
		case 0:
			h = Align.left;
			break;
		case 1:
			h = Align.center;
			break;
		default:
			h = Align.right;
			break;
		}

		// 垂直
		int v = 0;
		switch (option.getvAlignment()) {
		case 0:
			v = Align.top;
			break;
		case 1:
			v = Align.center;
			break;
		default:
			v = Align.bottom;
			break;
		}
		label.setAlignment(h, v);

		return label;
	}
}
