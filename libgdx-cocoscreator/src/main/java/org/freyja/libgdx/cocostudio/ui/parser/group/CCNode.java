package org.freyja.libgdx.cocostudio.ui.parser.group;

import org.freyja.libgdx.cocos.creator.ui.CocoCreatorUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * @tip 还未支持单色背景属性,背景图片在Cocostudio里面并不是铺满,而是居中
 * @author i see
 * 
 */
public class CCNode extends GroupParser {

	@Override
	public String getClassName() {
		return "SingleNodeObjectData";
	}

	@Override
	public Actor parse(CocoCreatorUIEditor editor, ObjectData widget) {
		Group table = new Group();

		return table;
	}

}
