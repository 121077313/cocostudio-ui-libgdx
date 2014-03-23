package org.freyja.libgdx.cocostudio.ui.parser.widget;

import org.freyja.libgdx.cocostudio.ui.BaseWidgetParser;
import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CCOption;
import org.freyja.libgdx.cocostudio.ui.model.CCWidget;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;
import org.freyja.libgdx.cocostudio.ui.widget.TTFLabel;
import org.freyja.libgdx.cocostudio.ui.widget.TTFLabelStyle;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
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
		return "Slider";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {

		SliderStyle style = new SliderStyle(editor.findDrawable(option, option
				.getBarFileNameData().getPath()), editor.findDrawable(option,
				option.getBallNormalData().getPath()));
		// 这里滑动条只支持1以上?

		float percent = option.getPercent();

		if (percent <= 0) {// 进度不能小于等于0
			percent = 0.1f;
		}

		Slider slider = new Slider(0.1f, 100f, percent, false, style);

		return slider;
	}

}
