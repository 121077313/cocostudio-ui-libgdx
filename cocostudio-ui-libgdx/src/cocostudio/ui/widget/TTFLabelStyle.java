package cocostudio.ui.widget;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class TTFLabelStyle {

	private LabelStyle labelStyle;

	private FileHandle fileHandle;

	private int fontSize;

	public TTFLabelStyle(LabelStyle labelStyle, FileHandle fileHandle,
			int fontSize) {
		this.labelStyle = labelStyle;
		this.fileHandle = fileHandle;
		this.fontSize = fontSize;
	}

	public LabelStyle getLabelStyle() {
		return labelStyle;
	}

	public void setLabelStyle(LabelStyle labelStyle) {
		this.labelStyle = labelStyle;
	}

	public FileHandle getFileHandle() {
		return fileHandle;
	}

	public void setFileHandle(FileHandle fileHandle) {
		this.fileHandle = fileHandle;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

}
