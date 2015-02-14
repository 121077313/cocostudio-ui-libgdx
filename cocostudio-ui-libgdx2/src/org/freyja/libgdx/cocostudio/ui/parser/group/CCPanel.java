package org.freyja.libgdx.cocostudio.ui.parser.group;

import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CColor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;
import org.freyja.libgdx.cocostudio.ui.model.Size;
import org.freyja.libgdx.cocostudio.ui.parser.GroupParser;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * @tip 还未支持单色背景属性,背景图片在Cocostudio里面并不是铺满,而是居中
 * @author i see
 * 
 */
public class CCPanel extends GroupParser {

	@Override
	public String getClassName() {
		return "PanelObjectData";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, ObjectData widget) {
		Table table = new Table();

		Size size = widget.getSize();
		if (widget.getComboBoxIndex() == 0) {// 无颜色

		} else if (widget.getComboBoxIndex() == 1) {// 单色

			Pixmap pixmap = new Pixmap((int) size.getX(), (int) size.getY(),
					Format.RGBA8888);

			pixmap.setColor(editor.getColor(widget.getSingleColor(),
					widget.getBackColorAlpha()));

			pixmap.fill();

			Drawable d = new TextureRegionDrawable(new TextureRegion(
					new Texture(pixmap)));
			table.setBackground(d);
			pixmap.dispose();

			// table.addActor(new Image(d));

		} else {// 渐变色

		}

		if (widget.getFileData() != null) {// Panel的图片并不是拉伸平铺的!!.但是这里修改为填充
			Drawable tr = editor.findDrawable(widget, widget.getFileData()
					.getPath());
			if (tr != null) {
				Image bg = new Image(tr);
				bg.setPosition((size.getX() - bg.getWidth()) / 2,
						(size.getY() - bg.getHeight()) / 2);
				// bg.setFillParent(true);
				bg.setTouchable(Touchable.disabled);

				table.addActor(bg);
			}
		}

		table.setClip(widget.isClipAble());

		return table;
	}

}
