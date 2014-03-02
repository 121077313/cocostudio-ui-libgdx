package demo;

import java.util.Map;

import org.lwjgl.input.Keyboard;

import cocostudio.ui.CocoStudioUIEditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

import framework.CommonStage;

/**
 * 
 * @author i see
 * 
 */
public class DemoStage extends CommonStage {

	public DemoStage() {
		init();
	}

	boolean listener = false;
	int i = 7;

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

		case 9:
			SampleUIAnimation();
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

	/** 移植的简单动作编辑器功能 */
	private void SampleUIAnimation() {

		CocoStudioUIEditor editor = new CocoStudioUIEditor(
				Gdx.files.internal("SampleUIAnimation/SampleUIAnimation.json"),
				null, null, null, null);
		Group group = editor.createGroup();
		addActor(group);
		// 查找动画
		Map<Actor, Action> actions = editor.getAction("Animation1");
		// 查找演员
		final Actor actor = editor.findActor("ImageView");
		// 查找动作
		final Action action = actions.get(actor);

		Actor textButton = editor.findActor("TextButton");

		textButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

				// 点击的时候把动作添加到演员上去,然后play!!!
				actor.addAction(action);

				super.clicked(event, x, y);
			}
		});
	}

	/** 头像Demo,使用小图片方式 */
	private void initHead() {

		CocoStudioUIEditor editor = new CocoStudioUIEditor(
				Gdx.files.internal("head/DemoHead_UI.json"), null, null, null,
				null);
		Group group = editor.createGroup();

		addActor(group);

		Actor head = editor.findActor("ImageView");

		Actor panel = editor.findActor("Panel");

		// head.setVisible(true);
		// head.setPosition(0, 0);
		// addActor(head);
		// System.out.println();
	}

	/** 商店Demo,使用小图片方式 */
	private void initShop() {

		CocoStudioUIEditor editor = new CocoStudioUIEditor(
				Gdx.files.internal("shop/DemoShop.json"), null);
		Group group = editor.createGroup();
		addActor(group);
		final Actor buy_panel = editor.findActor("buy_Panel");
		Actor close_button = editor.findActor("close_Button");

		close_button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				buy_panel.setVisible(false);
				super.clicked(event, x, y);
			}
		});

		Array<Actor> buy_buttons = editor.findActors("buy_Button");

		for (Actor buy_button : buy_buttons) {
			buy_button.addListener(new ClickListener() {

				@Override
				public void clicked(InputEvent event, float x, float y) {
					buy_panel.setVisible(true);

					super.clicked(event, x, y);
				}
			});

		}

		Actor back_Label = editor.findActor("back_LabelBMFont");

		back_Label.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

				System.out.println("点击2");
				super.clicked(event, x, y);
			}
		});
		Actor back_Button = editor.findActor("back_Button");

		back_Button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

				System.out.println("点击");
				super.clicked(event, x, y);
			}
		});
		System.out.println(back_Label.getHeight() + "," + back_Label.getX());

		System.out.println(back_Button.getHeight() + "," + back_Button.getX());
	}

	/** ui例子,使用小图片方式 */
	void initUI() {
		CocoStudioUIEditor editor = new CocoStudioUIEditor(
				Gdx.files.internal("ui/ui.json"), null, null, null, null);
		Group group = editor.createGroup();
		addActor(group);

	}

	/** ui例子2,使用TextureAtlas方式 */
	void initUI2() {

		TextureAtlas gui = new TextureAtlas(Gdx.files.internal("ui/gui.txt"));
		CocoStudioUIEditor editor = new CocoStudioUIEditor(
				Gdx.files.internal("ui/ui.ExportJson"), gui, null, null);
		Group group = editor.createGroup();
		addActor(group);
	}

	void initDemo() {

		TextureAtlas gui = new TextureAtlas(Gdx.files.internal("demo/gui.txt"));
		CocoStudioUIEditor editor = new CocoStudioUIEditor(
				Gdx.files.internal("demo/login.ExportJson"), gui, null, null);
		Group group = editor.createGroup();
		addActor(group);

	}

	void initLogin() {

		CocoStudioUIEditor editor = new CocoStudioUIEditor(
				Gdx.files.internal("DemoLogin/DemoLogin.json"), null, null,
				null, null);
		Group group = editor.createGroup();
		addActor(group);

	}

	void initMap() {

		CocoStudioUIEditor editor = new CocoStudioUIEditor(
				Gdx.files.internal("DemoMap/DemoMap.json"), null, null, null,
				null);
		Group group = editor.createGroup();
		addActor(group);

		Actor dragPanel = editor.findActor("DragPanel");

		// dragPanel.addListener(new ClickListener() {
		// @Override
		// public void clicked(InputEvent event, float x, float y) {
		//
		// System.out.println("click");
		//
		// super.clicked(event, x, y);
		// }
		// });

		final Actor boxPanel = editor.findActor("box_Panel");

		// boxPanel.addListener(new ClickListener() {
		//
		// @Override
		// public boolean touchDown(InputEvent event, float x, float y,
		// int pointer, int button) {
		//
		// return super.touchDown(event, x, y, pointer, button);
		// }
		//
		// @Override
		// public void clicked(InputEvent event, float x, float y) {
		//
		// System.out.println("click2");
		//
		// super.clicked(event, x, y);
		// }
		// });

	}

	void initSampleChangeEquip() {
		CocoStudioUIEditor editor = new CocoStudioUIEditor(
				Gdx.files
						.internal("SampleChangeEquip/SampleChangeEquip_1.json"),
				null, null, null, null);
		Group group = editor.createGroup();
		addActor(group);

		System.out.println();

	}

}
