package demo;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;

public class MyGame extends Game {

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		this.setScreen(new LoginScreen());
	}

}
