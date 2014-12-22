package org.freyja.libgdx.cocostudio.scene;

import java.util.Comparator;

import org.freyja.libgdx.cocostudio.scene.model.CCComponent;
import org.freyja.libgdx.cocostudio.scene.model.CCGameObject;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
	public abstract Actor parse(CocoStudioSceneEditor editor,
			CCGameObject widget, CCComponent option);

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
	public Actor commonParse(CocoStudioSceneEditor editor, CCGameObject widget,
			CCComponent option, Group parent, Actor actor) {

		actor.setName(widget.getName());

		// if (option.isIgnoreSize()) {// ignore size option
		//
		// } else {
		// actor.setSize(option.getWidth(), option.getHeight());
		// }

		// set origin
		actor.setOrigin(0.5f * actor.getWidth(), 0.5f * actor.getHeight());

		if (parent == null) {
			actor.setPosition(widget.getX() - actor.getOriginX(), widget.getY()
					- actor.getOriginY());
		} else {

			// 锚点要算上父控件的锚点,也就是原点
			actor.setX(parent.getOriginX()
					- (actor.getOriginX() - widget.getX()));

			actor.setY(parent.getOriginY()
					- (actor.getOriginY() - widget.getY()));
		}

		// CocoStudio的编辑器ScaleX,ScaleY 会有负数情况
		actor.setScale(widget.getScalex(), widget.getScaley());

		if (widget.getRotation() != 0) {// CocoStudio 是顺时针方向旋转,转换下.
			actor.setRotation(360 - widget.getRotation() % 360);
		}

		// 设置可见
		actor.setVisible(widget.isVisible());

		// actor.setColor(option.getColorR() / 255f, option.getColorG() / 255f,
		// option.getColorB() / 255f, option.getOpacity() / 255f);
		// actor.setTouchable(option.isTouchAble() ? Touchable.enabled
		// : Touchable.disabled);

		addActor(editor, actor, option, widget);

		if (widget.getGameobjects().size() == 0) {
			return actor;
		}

		return null;
	}

	protected void addActor(CocoStudioSceneEditor editor, Actor actor,
			CCComponent option, CCGameObject widget) {

		Array<Actor> arrayActors = editor.getActors().get(actor.getName());
		if (arrayActors == null) {
			arrayActors = new Array<Actor>();
		}
		arrayActors.add(actor);
		editor.getActors().put(actor.getName(), arrayActors);

		editor.getActionActors().put(widget.getObjecttag(), actor);
	}

	/** 子控件根据zOrder属性排序 */
	protected void sort(final CCGameObject widget, Group group) {
		group.getChildren().sort(new Comparator<Actor>() {
			@Override
			public int compare(Actor arg0, Actor arg1) {

				return getZOrder(widget, arg0.getName())
						- getZOrder(widget, arg1.getName());
			}
		});

	}

	/** 由于libgdx的zindex并不表示渲染层级,所以这里采用这种方式来获取子控件的当前层级 */
	public static int getZOrder(CCGameObject widget, String name) {
		if (name == null) {
			return 0;
		}
		for (CCGameObject child : widget.getGameobjects()) {
			if (name.equals(child.getName())) {
				return widget.getZorder();
			}
		}
		return 0;
	}
}
