package org.freyja.libgdx.cocostudio.ui.parser.group;

import org.freyja.libgdx.cocos.creator.ui.CocoCreatorUIEditor;
import org.freyja.libgdx.cocos.creator.ui.model.AANode;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;
import org.freyja.libgdx.cocostudio.ui.widget.TTFLabel;
import org.freyja.libgdx.cocostudio.ui.widget.TTFLabelStyle;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CCGroup extends GroupParser {

	@Override
	public String getClassName() {
		return "cc.Scene";
	}

	protected CocoCreatorUIEditor editor;

	@Override
	public Actor parse(CocoCreatorUIEditor editor, final ObjectData widget) {

		Group group = new Group();

		for (AANode cNode : widget._components) {

			Actor childrenActor = editor.parseWidget(group, (ObjectData) cNode);
			if (childrenActor == null) {
				continue;
			}
			
			group.addActor(childrenActor);

		}

		return group;
	}

}
