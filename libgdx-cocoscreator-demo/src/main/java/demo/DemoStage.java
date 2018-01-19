package demo;

import org.freyja.libgdx.cocos.creator.ui.CocoCreatorUIEditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Group;

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
	int i = 4;

	@Override
	public void init() {

		switch (i) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			initDemo();
			break;
		case 5:
			break;
		case 6:
			break;

		case 7:
			break;

		case 8:
			break;

		case 9:
			break;

		default:
			i = 1;
			init();
			break;
		}

		if (listener) {
			return;
		}
//		listener = addListener(new ClickListener() {
//			@Override
//			public boolean keyDown(InputEvent event, int keycode) {
//				getActors().clear();
//				i++;
//				init();
//				return super.keyDown(event, keycode);
//			}
//		});

		System.out.println("按任意键可切换场景,out文件夹内有UI的工程文件.");
	}

	void initDemo() {

		FileHandle defaultFont = Gdx.files
				.internal("demo/FangZhengZhunYuan_GBK.TTF");

		CocoCreatorUIEditor editor = new CocoCreatorUIEditor(
				Gdx.files.internal("demo/ship.fire"), null, null, defaultFont,
				null);
		Group group = editor.createGroup();
		addActor(group);

	}

}
