package org.freyja.libgdx.cocostudio.ui.parser.group;

import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * @tip 滚动方向,回弹滚动支持不是很好
 * @author i see
 * 
 */
public class CCScrollView extends GroupParser {

	@Override
	public String getClassName() {
		return "ScrollViewObjectData";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, ObjectData widget) {
		ScrollPaneStyle style = new ScrollPaneStyle();

		if (widget.getFileData() != null) {

			style.background = editor
					.findDrawable(widget, widget.getFileData());
		}

		ScrollPane scrollPane = new ScrollPane(null, style);

		if ("Vertical_Horizontal".equals(widget.getScrollDirectionType())) {
			scrollPane.setForceScroll(true, true);
		} else if ("Horizontal".equals(widget.getScrollDirectionType())) {
			scrollPane.setForceScroll(true, false);
		} else if ("Vertical".equals(widget.getScrollDirectionType())) {
			scrollPane.setForceScroll(false, true);
		}

		scrollPane.setClamp(widget.isClipAble());
		scrollPane.setFlickScroll(widget.isIsBounceEnabled());

		Table table = new Table();
		table.setSize(widget.getInnerNodeSize().getWidth(), widget
				.getInnerNodeSize().getHeight());

		if (widget.getComboBoxIndex() == 0) {// 无颜色

		} else if (widget.getComboBoxIndex() == 1) {// 单色

			Pixmap pixmap = new Pixmap((int) table.getWidth(),
					(int) table.getHeight(), Format.RGBA8888);
			Color color = editor.getColor(widget.getSingleColor(),
					widget.getBackColorAlpha());

			pixmap.setColor(color);

			pixmap.fill();

			Drawable drawable = new TextureRegionDrawable(new TextureRegion(
					new Texture(pixmap)));

			table.setBackground(drawable);
			pixmap.dispose();

		} else {// 渐变色

		}
		scrollPane.setWidget(table);
		return scrollPane;
	}

	@Override
	public Group groupChildrenParse(CocoStudioUIEditor editor,
			ObjectData widget, Group parent, Actor actor) {
		ScrollPane scrollPane = (ScrollPane) actor;
		Table table = new Table();
		for (ObjectData childrenWidget : widget.getChildren()) {
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
