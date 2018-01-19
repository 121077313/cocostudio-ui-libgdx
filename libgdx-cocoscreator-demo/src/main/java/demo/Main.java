package demo;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "UI编辑器DEMO2";
//		cfg.useGL20 = true;
//		cfg.width = 480;
//		cfg.height = 320;
		
		cfg.width = 800;
		cfg.height = 480;
		
		cfg.resizable = true;
		new LwjglApplication(new MyGame(), cfg);
	}
}
