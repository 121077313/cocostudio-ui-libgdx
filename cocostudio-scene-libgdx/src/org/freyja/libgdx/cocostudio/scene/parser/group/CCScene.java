package org.freyja.libgdx.cocostudio.scene.parser.group;

import org.freyja.libgdx.cocostudio.scene.CocoStudioSceneEditor;
import org.freyja.libgdx.cocostudio.scene.model.CCComponent;
import org.freyja.libgdx.cocostudio.scene.model.CCGameObject;
import org.freyja.libgdx.cocostudio.scene.model.CCSceneExport;
import org.freyja.libgdx.cocostudio.scene.parser.GroupParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * @tip 还未支持单色背景属性,背景图片在Cocostudio里面并不是铺满,而是居中
 * @author i see
 * 
 */
public class CCScene extends GroupParser {

	@Override
	public String getClassName() {
		return "CCScene";
	}

	@Override
	public Actor parse(CocoStudioSceneEditor editor, CCGameObject widget,
			CCComponent option) {
		Table table = new Table();
		CCSceneExport export = (CCSceneExport) widget;
		table.setSize(export.getCanvasSize().get_width(), export
				.getCanvasSize().get_height());
		return table;
	}

}
