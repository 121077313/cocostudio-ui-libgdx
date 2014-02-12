package demo;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class Assets {

	public static Texture load;

	public static TextureAtlas gui;

	public static class ui {

		static void init() {
			gui = MyGame.manager.get("res/gui.txt", TextureAtlas.class);
		}

	}

	public static void loadAssets() {

		init();
		ui.init();
	}

	/** 加载基础资源 */
	static void init() {
	}

}
