package org.freyja.libgdx.cocostudio.scene.parser.group;

import org.freyja.libgdx.cocostudio.scene.CocoStudioSceneEditor;
import org.freyja.libgdx.cocostudio.scene.model.CCComponent;
import org.freyja.libgdx.cocostudio.scene.model.CCGameObject;
import org.freyja.libgdx.cocostudio.scene.parser.GroupParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * @tip 还未支持单色背景属性,背景图片在Cocostudio里面并不是铺满,而是居中
 * @author i see
 * 
 */
public class CCNode extends GroupParser {

	@Override
	public String getClassName() {
		return "CCComAttribute";
	}

	@Override
	public Actor parse(CocoStudioSceneEditor editor, CCGameObject widget,
			CCComponent option) {
		Table table = new Table();

//		if (option.getColorType() == 0) {// 无颜色
//
//		} else if (option.getColorType() == 1) {// 单色
//
//			Pixmap pixmap = new Pixmap((int) option.getWidth(),
//					(int) option.getHeight(), Format.RGBA8888);
//			pixmap.setColor(option.getBgColorR() / 255f,
//					option.getBgColorG() / 255f, option.getBgColorB() / 255f,
//					option.getBgColorOpacity() / 255f);
//
//			pixmap.fill();
//
//			table.setBackground(new TextureRegionDrawable(new TextureRegion(
//					new Texture(pixmap))));
//			pixmap.dispose();
//		} else {// 渐变色
//
//		}

//		if (option.getBackGroundImageData() != null) {// Panel的图片并不是拉伸平铺的!!.但是这里修改为填充
//			Drawable tr = editor.findDrawable(option, option
//					.getBackGroundImageData().getPath());
//			if (tr != null) {
//				Image bg = new Image(tr);
//				bg.setPosition((option.getWidth() - bg.getWidth()) / 2,
//						(option.getHeight() - bg.getHeight()) / 2);
//				// bg.setFillParent(true);
//				bg.setTouchable(Touchable.disabled);
//
//				bg.setColor(option.getColorR() / 255f,
//						option.getColorG() / 255f, option.getColorB() / 255f,
//						option.getOpacity() / 255f);
//				table.addActor(bg);
//			}
//		}

//		table.setClip(option.isClipAble());

		return table;
	}

}
