package demo;

import framework.CommonStage;
import cocostudio.ui.CocoStudioUIEditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

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

	@Override
	public void init() {
//		initHead();
//		initShop();
		
		initUI();
	}

	private void initHead() {

		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("head/DemoHead_UI.json"), null, null, null);
		Group group = editer.createGroup();
		addActor(group);
	}

	private void initShop() {

		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("shop/DemoShop.json"), null);
		Group group = editer.createGroup();
		addActor(group);
		final Actor buy_panel = editer.findActor("buy_Panel");
		Actor close_button = editer.findActor("close_Button");

		close_button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				buy_panel.setVisible(false);
				super.clicked(event, x, y);
			}
		});

		Array<Actor> buy_buttons = editer.findActors("buy_Button");

		for (Actor buy_button : buy_buttons) {
			buy_button.addListener(new ClickListener() {

				@Override
				public void clicked(InputEvent event, float x, float y) {
					buy_panel.setVisible(true);

					super.clicked(event, x, y);
				}
			});

		}
	}
	void initUI() {
		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("ui/ui.json"), null, null, null);
		Group group = editer.createGroup();
		addActor(group);
	}
}
