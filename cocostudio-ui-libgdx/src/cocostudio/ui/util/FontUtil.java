package cocostudio.ui.util;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontUtil {

	public static BitmapFont createFont(FileHandle fontHandle, String text,
			int fontSize) {

		if (fontHandle == null) {
			return new BitmapFont();
		}

		BitmapFont font = null;
		FreeTypeFontGenerator generator = null;
		try {
			generator = new FreeTypeFontGenerator(fontHandle);
			String newText = StringUtil.removeRepeatedChar(text);
			font = generator.generateFont(fontSize, newText, false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (generator != null) {
				generator.dispose();
			}
		}
		if (font == null) {
			return new BitmapFont();
		}
		return font;

	}
}
