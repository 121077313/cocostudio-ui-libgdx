package demo;

import org.lwjgl.input.Keyboard;

import cocostudio.ui.CocoStudioUIEditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

import framework.CommonStage;

/**
 * 登录界面界面
 * 
 * @author i see
 * 
 */
public class DemoStage extends CommonStage {

	public DemoStage() {
		init();
	}

	boolean listener = false;
	int i = 6;

	@Override
	public void init() {

		switch (i) {
		case 1:
			initHead();
			break;
		case 2:
			initShop();
			break;
		case 3:
			initUI();
			break;
		case 4:
			initDemo();
			break;
		case 5:
			initUI2();
			break;
		case 6:
			initLogin();
			break;

		case 7:
			initMap();
			break;

		case 8:
			initSampleChangeEquip();
			break;
		default:
			i = 1;
			init();
			break;
		}

		if (listener) {
			return;
		}
		listener = addListener(new ClickListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				getActors().clear();
				i++;
				init();
				return super.keyDown(event, keycode);
			}
		});

		System.out.println("按任意键可切换场景,out文件夹内有UI的工程文件.");
	}

	/** 头像Demo,使用小图片方式 */
	private void initHead() {

		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("head/DemoHead_UI.json"), null, null, null);
		Group group = editer.createGroup();
		addActor(group);
	}

	/** 商店Demo,使用小图片方式 */
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

	/** ui例子,使用小图片方式 */
	void initUI() {
		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("ui/ui.json"), null, null, null);
		Group group = editer.createGroup();
		addActor(group);
	}

	/** ui例子2,使用TextureAtlas方式 */
	void initUI2() {

		TextureAtlas gui = new TextureAtlas(Gdx.files.internal("ui/gui.txt"));
		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("ui/ui.ExportJson"), gui, null, null);
		Group group = editer.createGroup();
		addActor(group);
	}

	void initDemo() {

		TextureAtlas gui = new TextureAtlas(Gdx.files.internal("demo/gui.txt"));
		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("demo/login.ExportJson"), gui, null, null);
		Group group = editer.createGroup();
		addActor(group);

	}

	void initLogin() {

		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("DemoLogin/DemoLogin.json"), null, null,
				null);
		Group group = editer.createGroup();
		addActor(group);

	}

	void initMap() {

		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files.internal("DemoMap/DemoMap.json"), null, null, null);
		Group group = editer.createGroup();
		addActor(group);

	}

	void initSampleChangeEquip() {
		CocoStudioUIEditor editer = new CocoStudioUIEditor(
				Gdx.files
						.internal("SampleChangeEquip/SampleChangeEquip_1.json"),
				null, null, null);
		Group group = editer.createGroup();
		addActor(group);
	}

}
