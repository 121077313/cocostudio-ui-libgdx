package org.freyja.libgdx.cocostudio.ui.parser.group;

import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CColor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.model.Size;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * @tip 还未支持单色背景属性,背景图片在Cocostudio里面并不是铺满,而是居中
 * @author i see
 * 
 */
public class CCLayer extends GroupParser {

	@Override
	public String getClassName() {
		return "LayerObjectData";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, ObjectData widget) {
		Group table = new Group();

		return table;
	}

}
