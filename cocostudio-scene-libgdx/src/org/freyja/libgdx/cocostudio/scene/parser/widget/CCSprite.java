package org.freyja.libgdx.cocostudio.scene.parser.widget;

import org.freyja.libgdx.cocostudio.scene.BaseWidgetParser;
import org.freyja.libgdx.cocostudio.scene.CocoStudioSceneEditor;
import org.freyja.libgdx.cocostudio.scene.model.CCComponent;
import org.freyja.libgdx.cocostudio.scene.model.CCGameObject;
import org.freyja.libgdx.cocostudio.scene.parser.WidgetParser;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class CCSprite extends WidgetParser {

	@Override
	public String getClassName() {
		return "CCSprite";
	}

	@Override
	public Actor parse(CocoStudioSceneEditor editor, CCGameObject widget,
			CCComponent option) {

		Drawable tr = editor.findDrawable(option, option.getFileData()
				.getPath());
		if (tr == null) {
			return new Image();
		}
		Image image = new Image(tr);

		return image;
	}

}
