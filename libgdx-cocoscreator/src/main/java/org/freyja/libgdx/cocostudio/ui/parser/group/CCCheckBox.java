package org.freyja.libgdx.cocostudio.ui.parser.group;

import org.freyja.libgdx.cocos.creator.ui.CocoCreatorUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
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
		return "CheckBoxObjectData";
	}

	@Override
	public Actor parse(CocoCreatorUIEditor editor, ObjectData widget) {
		CheckBoxStyle style = new CheckBoxStyle(null, null, new BitmapFont(),
				Color.BLACK);

		if (widget.getNodeNormalFileData() != null) {// 选中图片

			style.checkboxOff = editor.findDrawable(widget,
					widget.getNodeNormalFileData());
		}
		if (widget.getNormalBackFileData() != null) {// 没选中图片
			style.checkboxOn = editor.findDrawable(widget,
					widget.getNormalBackFileData());
		}
		CheckBox checkBox = new CheckBox("", style);
		checkBox.setChecked(widget.isDisplayState());
		checkBox.setDisabled(widget.isDisplayState());
		return checkBox;
	}
}
