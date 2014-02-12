package demo;
import framework.MyScreen;
import framework.MyStage;

import org.lwjgl.opengl.XRandR.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * 加载登录界面
 * 
 * @author i see
 * 
 */
public class LoginLoadScreen extends MyScreen {

	boolean load = false;

	@Override
	public void render(float delta) {
		if (load && MyGame.manager.update(500)) {
			load = false;

			loadData();
			Assets.loadAssets();

			game.setScreen(new LoginScreen());
			return;
		}

		stage.act();
		stage.draw();
	}

	@Override
	public void show() {

		stage = new MyStage();
		Assets.load = new Texture(Gdx.files.internal("res/loading.jpg"));
		Image bg = new Image(Assets.load);

		bg.setFillParent(true);
		stage.addActor(bg);

		Gdx.app.postRunnable(new Runnable() {

			@Override
			public void run() {

				loading();
				load = true;
			}
		});

	}

	public void loading() {
		MyGame.manager.load("res/gui.txt", TextureAtlas.class);
	}

	void loadData() {
	}

}
