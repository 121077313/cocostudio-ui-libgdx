package demo;


import framework.CommonScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

/**
 * 登录界面
 * 
 * @author i see
 * 
 */
public class DemoScreen extends CommonScreen {

	@Override
	public void show() {

		stage = new DemoStage();

		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);
	}

}
