package org.freyja.libgdx.cocostudio.ui.parser.widget;

import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.parser.WidgetParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class CCSpriteView extends WidgetParser {

	@Override
	public String getClassName() {
		return "SpriteObjectData";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, ObjectData widget) {

		Drawable tr = editor.findDrawable(widget, widget.getFileData());
		if (tr == null) {
			return new Image();
		}
		Image image = new Image(tr);

		return image;
	}

	@Override
	public Group widgetChildrenParse(CocoStudioUIEditor editor,
			ObjectData widget, Group parent, Actor actor) {
		Group group = super.widgetChildrenParse(editor, widget, parent, actor);

		group.setTouchable(Touchable.enabled);

		return group;
	}
}
