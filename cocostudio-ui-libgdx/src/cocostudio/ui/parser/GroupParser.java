package cocostudio.ui.parser;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public abstract class GroupParser extends BaseWidgetParser {

	@Override
	public Actor commonParse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option, Group parent, Actor actor) {
		Actor ac = super.commonParse(editor, widget, option, parent, actor);
		if (ac != null) {
			return ac;
		}
		return groupParse(editor, widget, option, parent, actor);
	}

	/** 解析group控件,当前控件类型为Group的时候处理与Widget类型处理不同 */
	public Group groupParse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option, Group parent, Actor actor) {
		// Group 虽然自己不接收事件,但是子控件得接收
		// actor.setTouchable(option.isTouchAble() ? Touchable.enabled
		// : Touchable.childrenOnly);

		Group group = (Group) actor;

		for (CCWidget cWidget : widget.getChildren()) {
			Actor cGroup = editor.parseWidget(group, cWidget);
			if (cGroup == null) {
				continue;
			}
			group.addActor(cGroup);
		}
		sort(widget, group);

		return group;

	}

}
