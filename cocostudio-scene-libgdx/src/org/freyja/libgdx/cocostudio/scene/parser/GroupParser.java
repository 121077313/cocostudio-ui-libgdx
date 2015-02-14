package org.freyja.libgdx.cocostudio.scene.parser;

import org.freyja.libgdx.cocostudio.scene.BaseWidgetParser;
import org.freyja.libgdx.cocostudio.scene.CocoStudioSceneEditor;
import org.freyja.libgdx.cocostudio.scene.model.CCComponent;
import org.freyja.libgdx.cocostudio.scene.model.CCGameObject;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * 控件组转换器
 * 
 * @author i see
 * 
 */
public abstract class GroupParser extends BaseWidgetParser {

	@Override
	public Actor commonParse(CocoStudioSceneEditor editor, CCGameObject widget,
			CCComponent option, Group parent, Actor actor) {
		Actor ac = super.commonParse(editor, widget, option, parent, actor);
		if (ac != null) {
			return ac;
		}
		return groupChildrenParse(editor, widget, option, parent, actor);
	}

	/** 解析group控件,当前控件类型为Group的时候处理与Widget类型处理不同 */
	public Group groupChildrenParse(CocoStudioSceneEditor editor,
			CCGameObject widget, CCComponent option, Group parent, Actor actor) {

		Group group = (Group) actor;

		// Group 虽然自己不接收事件,但是子控件得接收
		// actor.setTouchable(option.isTouchAble() ? Touchable.enabled
		// : Touchable.childrenOnly);
		// 必须设置Transform 为true 子控件才会跟着旋转.

		// group.setTransform(true);

		if (widget.getScalex() != 1 || widget.getScaley() != 1
				|| widget.getRotation() != 0) {
			group.setTransform(true);
		}

		for (CCGameObject childrenWidget : widget.getGameobjects()) {
			Actor childrenActor = editor.parseWidget(group, childrenWidget);
			if (childrenActor == null) {
				continue;
			}
			group.addActor(childrenActor);
		}
		sort(widget, group);

		return group;

	}

}
