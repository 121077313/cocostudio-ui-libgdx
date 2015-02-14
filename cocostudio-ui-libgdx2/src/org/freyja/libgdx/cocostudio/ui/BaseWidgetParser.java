package org.freyja.libgdx.cocostudio.ui;

import java.util.Comparator;

import org.freyja.libgdx.cocostudio.ui.model.CColor;
import org.freyja.libgdx.cocostudio.ui.model.ObjectData;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;

/**
 * 控件 转换器
 * 
 * @author i see
 * 
 */
public abstract class BaseWidgetParser {

	/** get widget type name */
	public abstract String getClassName();

	/** convert cocostudio widget to libgdx actor */
	public abstract Actor parse(CocoStudioUIEditor editor, ObjectData widget);

	/**
	 * common attribute parser<br>
	 * 
	 * according cocstudio ui setting properties of the configuration file
	 * 
	 * 
	 * @param editor
	 * @param widget
	 * @param option
	 * @param parent
	 * @param actor
	 * @return
	 */
	public Actor commonParse(CocoStudioUIEditor editor, ObjectData widget,
			Group parent, Actor actor) {

		actor.setName(widget.getName());
		actor.setSize(widget.getSize().getX(), widget.getSize().getY());

		// set origin
		actor.setOrigin(widget.getAnchorPoint().getScaleX() * actor.getWidth(),
				widget.getAnchorPoint().getScaleY() * actor.getHeight());

		if (parent == null) {
			actor.setPosition(widget.getPosition().getX() - actor.getOriginX(),
					widget.getPosition().getY() - actor.getOriginY());
		} else {

			// 锚点要算上父控件的锚点,也就是原点
			actor.setX(parent.getOriginX()
					- (actor.getOriginX() - widget.getPosition().getX()));

			actor.setY(parent.getOriginY()
					- (actor.getOriginY() - widget.getPosition().getY()));
		}

		// CocoStudio的编辑器ScaleX,ScaleY 会有负数情况
		actor.setScale(widget.getScale().getScaleX(), widget.getScale()
				.getScaleY());

		if (widget.getRotation() != 0) {// CocoStudio 是顺时针方向旋转,转换下.
			actor.setRotation(360 - widget.getRotation() % 360);
		}

		// 设置可见
		actor.setVisible(widget.isVisibleForFrame());

		Color color = editor.getColor(widget.getCColor(), widget.getAlpha());

		actor.setColor(color);

		actor.setTouchable(widget.isTouchEnable() ? Touchable.enabled
				: Touchable.disabled);

		addActor(editor, actor, widget);

		if (widget.getChildren() == null || widget.getChildren().size() == 0) {
			return actor;
		}

		return null;
	}

	protected void addActor(CocoStudioUIEditor editor, Actor actor,
			ObjectData option) {

		Array<Actor> arrayActors = editor.getActors().get(actor.getName());
		if (arrayActors == null) {
			arrayActors = new Array<Actor>();
		}
		arrayActors.add(actor);
		editor.getActors().put(actor.getName(), arrayActors);

		editor.getActionActors().put(option.getActionTag(), actor);
	}

	/** 子控件根据zOrder属性排序 */
	protected void sort(final ObjectData widget, Group group) {
		group.getChildren().sort(new Comparator<Actor>() {
			@Override
			public int compare(Actor arg0, Actor arg1) {
				return getZOrder(widget, arg0.getName())
						- getZOrder(widget, arg1.getName());
			}
		});

	}

	/** 由于libgdx的zindex并不表示渲染层级,所以这里采用这种方式来获取子控件的当前层级 */
	public static int getZOrder(ObjectData widget, String name) {
		if (name == null) {
			return 0;
		}
		for (ObjectData child : widget.getChildren()) {
			if (name.equals(child.getName())) {
				return child.getZOrder();
			}
		}
		return 0;
	}
}
