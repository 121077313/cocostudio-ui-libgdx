package cocostudio.ui.widget;

import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.util.FontUtil;
import cocostudio.ui.util.StringUtil;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * 让Label支持TTF,使用ttf后Label的font不会发生变化,每次修改Text的时候重新创建font
 * 
 * @author i see
 * 
 */
public class TTFLabel extends Label {

	TTFLabelStyle ttfLabelStyle;

	public TTFLabel(CharSequence text, TTFLabelStyle ttfLabelStyle) {
		super(text, ttfLabelStyle.getLabelStyle());
		this.ttfLabelStyle = ttfLabelStyle;
	}

	@Override
	public void setText(CharSequence newText) {
		LabelStyle style = getStyle();
		style.font = FontUtil.createFont(ttfLabelStyle.getFileHandle(), ""
				+ newText, ttfLabelStyle.getFontSize());
		setStyle(style);

		super.setText(newText);
	}

}
