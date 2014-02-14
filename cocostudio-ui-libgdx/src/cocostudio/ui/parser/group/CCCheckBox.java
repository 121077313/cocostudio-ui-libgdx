package cocostudio.ui.parser.group;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;

public class CCCheckBox extends GroupParser {

	@Override
	public String getClassName() {
		return "CheckBox";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {
		CheckBoxStyle style = new CheckBoxStyle(null, null, new BitmapFont(),
				Color.BLACK);
		if (option.getFrontCrossData() != null) {// 选中图片
			style.checkboxOn = editor.findDrawable(option, option
					.getFrontCrossData().getPath());
		}

		if (option.getFrontCrossDisabledData() != null) {// 没选中图片

			style.checkboxOff = editor.findDrawable(option, option
					.getFrontCrossDisabledData().getPath());
		}

		CheckBox checkBox = new CheckBox("", style);
		return checkBox;
	}
}
