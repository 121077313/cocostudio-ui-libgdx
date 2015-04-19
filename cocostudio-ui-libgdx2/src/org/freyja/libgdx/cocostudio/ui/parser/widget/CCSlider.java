package org.freyja.libgdx.cocostudio.ui.parser.widget;

import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;

/**
 * 滑动条
 * 
 * @author i see
 * 
 */
public class CCSlider extends GroupParser {

	@Override
	public String getClassName() {
		return "SliderObjectData2";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, ObjectData widget) {

		SliderStyle style = new SliderStyle(editor.findDrawable(widget,
				widget.getBackGroundData()), editor.findDrawable(widget,
				widget.getBallNormalData()));

		
		
		style.knob= editor.findDrawable(widget,
				widget.getProgressBarData());
		style.disabledBackground= editor.findDrawable(widget,
				widget.getBallDisabledData());
		if (widget.getProgressBarData() != null) {
			style.knobBefore = editor.findDrawable(widget,
					widget.getProgressBarData());
		}
		if (widget.getBallDisabledData() != null) {
			style.disabledKnob = editor.findDrawable(widget,
					widget.getBallDisabledData());
		}
		// 这里滑动条只支持1以上?

		float percent = widget.getPercentInfo();

		// if (percent <= 0) {// 进度不能小于等于0
		// percent = 0.1f;
		// }
		Slider slider = new Slider(0.1f, 100f, 0.1f, false, style);
		slider.setValue(percent);
		return slider;
	}

}
