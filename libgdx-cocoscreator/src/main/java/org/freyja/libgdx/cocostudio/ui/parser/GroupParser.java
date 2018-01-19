package org.freyja.libgdx.cocostudio.ui.parser;

import org.freyja.libgdx.cocos.creator.ui.BaseWidgetParser;
import org.freyja.libgdx.cocos.creator.ui.CocoCreatorUIEditor;
import org.freyja.libgdx.cocos.creator.ui.model.AANode;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * 控件组转换器
 * 
 * @author i see
 * 
 */
public abstract class GroupParser extends BaseWidgetParser {

	@Override
	public Actor commonParse(CocoCreatorUIEditor editor, ObjectData widget,
			Group parent, Actor actor) {
		Actor ac = super.commonParse(editor, widget, parent, actor);
		if (ac != null) {
			return ac;
		}
		return groupChildrenParse(editor, widget, parent, actor);
	}

	/** 解析group控件,当前控件类型为Group的时候处理与Widget类型处理不同 */
	public Group groupChildrenParse(CocoCreatorUIEditor editor,
			ObjectData widget, Group parent, Actor actor) {

		Group group = (Group) actor;

		// Group 虽然自己不接收事件,但是子控件得接收
		actor.setTouchable(widget.isTouchEnable() ? Touchable.enabled
				: Touchable.childrenOnly);
		// 必须设置Transform 为true 子控件才会跟着旋转.

		// group.setTransform(true);

		if (widget.getScale() != null || widget.getRotation() != 0) {
			group.setTransform(true);
		}

		for (AANode childrenWidget : widget._children) {
			Actor childrenActor = editor.parseWidget(group, (ObjectData) childrenWidget);
			if (childrenActor == null) {
				continue;
			}
			group.addActor(childrenActor);
		}
		sort(widget, group);

		return group;

	}

}
