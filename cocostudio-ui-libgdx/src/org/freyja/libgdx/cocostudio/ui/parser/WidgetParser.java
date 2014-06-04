package org.freyja.libgdx.cocostudio.ui.parser;

import org.freyja.libgdx.cocostudio.ui.BaseWidgetParser;
import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CCOption;
import org.freyja.libgdx.cocostudio.ui.model.CCWidget;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * 单控件转换器
 * 
 * @author i see
 * 
 */
public abstract class WidgetParser extends BaseWidgetParser {

	@Override
	public Actor commonParse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option, Group parent, Actor actor) {
		Actor ac = super.commonParse(editor, widget, option, parent, actor);
		if (ac != null) {
			return ac;
		}
		return widgetChildrenParse(editor, widget, option, parent, actor);
	}

	/** 解析子控件 */
	public Group widgetChildrenParse(CocoStudioUIEditor editor,
			CCWidget widget, CCOption option, Group parent, Actor actor) {
		Table table = new Table();
		table.setVisible(option.isVisible());
		table.setClip(option.isClipAble());
		table.setName(actor.getName());
		table.setScale(option.getScaleX(), option.getScaleY());
		table.setRotation(actor.getRotation());
		table.setVisible(actor.isVisible());

		table.setTouchable(option.isTouchAble() ? Touchable.enabled
				: Touchable.childrenOnly);

//		editor.getActors().get(actor.getName()).removeValue(actor, true);
//
//		addActor(editor, table, option);

		actor.setVisible(true);
		actor.setTouchable(Touchable.disabled);

		if (option.getScaleX() != 0 || option.getScaleY() != 0
				|| option.getRotation() != 0) {
			table.setTransform(true);
		}

		table.setSize(actor.getWidth(), actor.getHeight());
		table.setPosition(actor.getX(), actor.getY());

		// 锚点就是子控件的锚点
		table.setOrigin(option.getAnchorPointX() * table.getWidth(),
				option.getAnchorPointY() * table.getHeight());

		for (CCWidget childrenWidget : widget.getChildren()) {
			Actor childrenActor = editor.parseWidget(table, childrenWidget);
			if (childrenActor == null) {
				continue;
			}
			table.addActor(childrenActor);
		}
		sort(widget, table);

		// Widget的位置应该与Table重合.相当于Widget的属性被移植到了Table
		actor.setPosition(0, 0);
		actor.setScale(1, 1);
		table.addActorAt(0, actor);
		return table;
	}

}
