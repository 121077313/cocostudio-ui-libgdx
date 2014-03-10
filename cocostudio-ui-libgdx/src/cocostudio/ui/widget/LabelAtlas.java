package cocostudio.ui.widget;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * 数字标签控件,暂时不支持.首字符设置.也就是说数字图片必须是0-9
 * 
 * @author i see
 * 
 */
public class LabelAtlas extends Table {
	final char[] chars = "0123456789".toCharArray();

	TextureRegion[] trs;
	int tileWidth;
	int tileHeight;

	public LabelAtlas(TextureRegion tr, int tileWidth, int tileHeight,
			String startCharMap, String stringValue) {
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		TextureRegion[][] arr = tr.split(tileWidth, tileHeight);
		trs = arr[0];

		if (stringValue != null) {
			setText(stringValue);
		}
	}

	public LabelAtlas(TextureRegion tr, int tileWidth, int tileHeight,
			String startCharMap) {
		this(tr, tileWidth, tileHeight, startCharMap, null);
	}

	String text;

	public void setText(String text) {
		this.text = text;
		clearChildren();

		char[] arr = text.toCharArray();
		for (char c : arr) {
			int index = index(c, chars);
			Image img = new Image(trs[index]);
			add(img);
		}

		setSize(tileWidth * arr.length, tileHeight);

	}

	int index(char c, char[] chars) {
		int index = 0;
		for (char cc : chars) {
			if (cc == c) {
				return index;
			}
			index++;
		}
		return -1;

	}

}
