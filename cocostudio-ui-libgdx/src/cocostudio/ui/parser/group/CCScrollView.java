package cocostudio.ui.parser.group;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

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
			// scrollPane.setForceScroll(true, false);
			scrollPane.setScrollingDisabled(false, false);
			break;

		case 3:
			scrollPane.setScrollingDisabled(false, false);
			// scrollPane.setForceScroll(true, true);
			break;
		}

		// scrollPane.setFlickScroll(option.isBounceEnable());
		return scrollPane;
	}

	@Override
	public Group groupParse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option, Group parent, Actor actor) {
		ScrollPane scrollPane = (ScrollPane) actor;
		Table table = new Table();
		for (CCWidget cWidget : widget.getChildren()) {
			Actor cGroup = editor.parseWidget(table, cWidget);
			if (cGroup == null) {
				continue;
			}

			table.setSize(Math.max(table.getWidth(), cGroup.getRight()),
					Math.max(table.getHeight(), cGroup.getTop()));
			table.addActor(cGroup);
		}
		sort(widget, table);
		//

		scrollPane.setWidget(table);

		return scrollPane;
	}

}
