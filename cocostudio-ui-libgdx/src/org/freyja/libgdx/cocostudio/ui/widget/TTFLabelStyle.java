package org.freyja.libgdx.cocostudio.ui.widget;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class TTFLabelStyle extends LabelStyle {

	private FileHandle fontFileHandle;

	private int fontSize;

	public TTFLabelStyle(LabelStyle labelStyle, FileHandle fontFileHandle,
			int fontSize) {
		super(labelStyle);
		this.fontFileHandle = fontFileHandle;
		this.fontSize = fontSize;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public FileHandle getFontFileHandle() {
		return fontFileHandle;
	}

	public void setFontFileHandle(FileHandle fontFileHandle) {
		this.fontFileHandle = fontFileHandle;
	}

}
