package demo;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;

public class MyGame extends Game {

	public static AssetManager manager;

	public MyGame() {

	}

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		manager = new AssetManager();

		this.setScreen(new LoginLoadScreen());
	}

	@Override
	public void setScreen(Screen screen) {

		Screen old = getScreen();
		if (old != null) {
			old.dispose();
		}

		super.setScreen(screen);
	}

}
