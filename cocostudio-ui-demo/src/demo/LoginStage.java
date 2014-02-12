package demo;

import framework.CommonStage;
import cocostudio.ui.CocoStudioUIEditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * 登录界面界面
 * 
 * @author i see
 * 
 */
public class LoginStage extends CommonStage {

	public LoginStage() {
		init();
	}

	Actor login;

	@Override
	public void init() {
		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("res/login.ExportJson"), Assets.gui);
		Group group = editer.createGroup();
		addActor(group);
		login = editer.findActor("login");
		login.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

				System.out.println("click LOGIN");
				super.clicked(event, x, y);
			}
		});

	}
}
