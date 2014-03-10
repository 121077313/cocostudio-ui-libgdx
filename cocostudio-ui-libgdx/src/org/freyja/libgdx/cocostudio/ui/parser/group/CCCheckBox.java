package org.freyja.libgdx.cocostudio.ui.parser.group;

import org.freyja.libgdx.cocostudio.ui.BaseWidgetParser;
import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CCOption;
import org.freyja.libgdx.cocostudio.ui.model.CCWidget;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;

/**
 * @tip libgdx的CheckBox只有选中和未选中两个状态的图片显示
 * @author i see
 * 
 */
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

		if (option.getBackGroundBoxData() != null) {// 选中图片

			style.checkboxOff = editor.findDrawable(option, option
					.getBackGroundBoxData().getPath());
		}
		if (option.getFrontCrossData() != null) {// 没选中图片
			style.checkboxOn = editor.findDrawable(option, option
					.getFrontCrossData().getPath());
		}
		CheckBox checkBox = new CheckBox("", style);
		checkBox.setChecked(option.isSelectedState());
		return checkBox;
	}
}
