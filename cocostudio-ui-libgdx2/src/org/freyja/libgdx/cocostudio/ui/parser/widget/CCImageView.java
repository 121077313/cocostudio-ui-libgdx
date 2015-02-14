package org.freyja.libgdx.cocostudio.ui.parser.widget;

import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.parser.WidgetParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class CCImageView extends WidgetParser {

	@Override
	public String getClassName() {
		return "ImageViewObjectData";
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

}
