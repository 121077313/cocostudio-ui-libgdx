package org.freyja.libgdx.cocostudio.scene.parser;

import org.freyja.libgdx.cocostudio.scene.BaseWidgetParser;
import org.freyja.libgdx.cocostudio.scene.CocoStudioSceneEditor;
import org.freyja.libgdx.cocostudio.scene.model.CCComponent;
import org.freyja.libgdx.cocostudio.scene.model.CCGameObject;

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
	public Actor commonParse(CocoStudioSceneEditor editor, CCGameObject widget,
			CCComponent option, Group parent, Actor actor) {
		Actor ac = super.commonParse(editor, widget, option, parent, actor);
		if (ac != null) {
			return ac;
		}
		return widgetChildrenParse(editor, widget, option, parent, actor);
	}

	/** 解析子控件 */
	public Group widgetChildrenParse(CocoStudioSceneEditor editor,
			CCGameObject widget, CCComponent option, Group parent, Actor actor) {
		Table table = new Table();
		table.setVisible(widget.isVisible());
		table.setName(actor.getName());
		table.setScale(widget.getScalex(), widget.getScaley());
		table.setRotation(actor.getRotation());
		table.setVisible(actor.isVisible());

		actor.setVisible(true);
		actor.setTouchable(Touchable.disabled);

		if (widget.getScalex() != 1 || widget.getScaley() != 1
				|| widget.getRotation() != 0) {
			table.setTransform(true);
		}

		table.setSize(actor.getWidth(), actor.getHeight());

		if (parent.getWidth() == 0 && parent.getHeight() == 0) {
			parent.setSize(table.getWidth(), table.getHeight());
		}

		table.setPosition(actor.getX(), actor.getY());

		// 锚点就是子控件的锚点
		table.setOrigin(0.5f * table.getWidth(), 0.5f * table.getHeight());

		for (CCGameObject childrenWidget : widget.getGameobjects()) {
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
