package cocostudio.ui.parser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;

public abstract class WidgetParser extends BaseWidgetParser {

	@Override
	public Actor commonParse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option, Group parent, Actor actor) {
		Actor ac = super.commonParse(editor, widget, option, parent, actor);
		if (ac!=null) {
			return ac;
		}
		return widgetChildrenParse(editor, widget, option, parent, actor);
	}

	/** 解析子控件 */
	public Group widgetChildrenParse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option, Group parent, Actor actor) {
		Table table = new Table();
		table.setVisible(option.isVisible());
		table.setClip(option.isClipAble());
		table.setSize(actor.getWidth(), actor.getHeight());
		table.setPosition(actor.getX(), actor.getY());
		table.addActor(actor);
		for (CCWidget childrenWidget : widget.getChildren()) {
			Actor childrenActor = editor.parseWidget(table, childrenWidget);
			if (childrenActor == null) {
				continue;
			}
			table.addActor(childrenActor);
		}
		sort(widget, table);
		return table;
	}

}
