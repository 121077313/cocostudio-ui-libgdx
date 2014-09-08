package org.freyja.libgdx.cocostudio.ui.parser.group;

import org.freyja.libgdx.cocostudio.ui.BaseWidgetParser;
import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CCOption;
import org.freyja.libgdx.cocostudio.ui.model.CCWidget;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * @tip 滚动方向,回弹滚动支持不是很好
 * @author i see
 * 
 */
public class CCScrollView extends GroupParser {

	@Override
	public String getClassName() {
		return "ScrollView";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {
		ScrollPaneStyle style = new ScrollPaneStyle();

		if (option.getBackGroundImageData() != null) {

			style.background = editor.findDrawable(option, option
					.getBackGroundImageData().getPath());
		}

		ScrollPane scrollPane = new ScrollPane(null, style);
		switch (option.getDirection()) {
		case 1:
			scrollPane.setForceScroll(false, true);
			// scrollPane.setScrollingDisabled(true,true);
			break;
		case 2:
			scrollPane.setForceScroll(true, false);
			// scrollPane.setScrollingDisabled(false, false);
			break;

		case 3:
			scrollPane.setForceScroll(true, true);
			// scrollPane.setScrollingDisabled(false, false);
			break;
		}
//		scrollPane.setClamp(false);
		scrollPane.setFlickScroll(option.isBounceEnable());
		return scrollPane;
	}

	@Override
	public Group groupChildrenParse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option, Group parent, Actor actor) {
		ScrollPane scrollPane = (ScrollPane) actor;
		Table table = new Table();
		for (CCWidget childrenWidget : widget.getChildren()) {
			Actor childrenActor = editor.parseWidget(table, childrenWidget);
			if (childrenActor == null) {
				continue;
			}

			table.setSize(Math.max(table.getWidth(), childrenActor.getRight()),
					Math.max(table.getHeight(), childrenActor.getTop()));
			table.addActor(childrenActor);
		}
		sort(widget, table);
		//

		scrollPane.setWidget(table);

		return scrollPane;
	}

}
