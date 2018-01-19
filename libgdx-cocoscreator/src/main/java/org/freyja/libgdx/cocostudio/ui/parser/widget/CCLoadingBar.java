package org.freyja.libgdx.cocostudio.ui.parser.widget;

import org.freyja.libgdx.cocos.creator.ui.CocoCreatorUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.parser.WidgetParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class CCLoadingBar extends WidgetParser {

	@Override
	public String getClassName() {
		return "LoadingBarObjectData";
	}

	@Override
	public Actor parse(CocoCreatorUIEditor editor, ObjectData widget) {

		if (widget.getImageFileData() == null) {
			return new Image();
		}
		Drawable tr = editor.findDrawable(widget, widget.getImageFileData());
		if (tr == null) {
			return new Image();
		}
		Image image = new Image(tr);
		return image;

	}

}
