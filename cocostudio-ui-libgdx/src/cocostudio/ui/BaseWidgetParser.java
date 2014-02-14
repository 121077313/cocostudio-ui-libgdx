package cocostudio.ui;

import java.util.Comparator;

import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
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

	/** 控件类型名称 */
	public abstract String getClassName();

	/** 转换控件 */
	public abstract Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option);

	/** 公共属性解析器 */
	public Actor commonParse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option, Group parent, Actor actor) {
		actor.setName(option.getName());

		if (option.isIgnoreSize()) {// 忽略大小,指的是编辑器无法指定大小(?)

		} else {
			actor.setSize(option.getWidth(), option.getHeight());
		}

		// 设置锚点
		actor.setOrigin(option.getAnchorPointX() * option.getWidth(),
				option.getAnchorPointY() * option.getHeight());

		if (parent == null) {
			actor.setPosition(option.getX() - actor.getOriginX(), option.getY()
					- actor.getOriginY());
		} else {
			// 锚点要算上父控件的锚点,也就是原点
			actor.setX(parent.getOriginX()
					+ (option.getX() - actor.getOriginX()));

			actor.setY(parent.getOriginY()
					+ (option.getY() - actor.getOriginY()));
		}

		// CocoStudio的编辑器ScaleX,ScaleY 会有负数情况
		actor.setScale(Math.abs(option.getScaleX()),
				Math.abs(option.getScaleY()));

		if (option.getRotation() != 0) {// CocoStudio 是顺时针方向旋转,转换下.

			actor.setRotation(360 - option.getRotation() % 360);
			if (actor instanceof Group) {// 必须设置Transform 为true 子控件才会跟着旋转.
				Group g = (Group) actor;
				g.setTransform(true);
			}
		}

		// 设置可见
		actor.setVisible(option.isVisible());

		actor.setColor(option.getColorR(), option.getColorG(),
				option.getColorB(), option.getOpacity() / 255);
		// actor.setTouchable(option.isTouchAble() ? Touchable.enabled
		// : Touchable.disabled);

		Array<Actor> arrayActors = editor.getActors().get(actor.getName());
		if (arrayActors == null) {
			arrayActors = new Array<Actor>();
		}
		arrayActors.add(actor);
		editor.getActors().put(actor.getName(), arrayActors);

		if (widget.getChildren().size() == 0) {
			return actor;
		}

		return null;
	}

	/** 子控件根据zOrder属性排序 */
	protected void sort(final CCWidget widget, Group group) {
		group.getChildren().sort(new Comparator<Actor>() {
			@Override
			public int compare(Actor arg0, Actor arg1) {
				return getZOrder(widget, arg0.getName())
						- getZOrder(widget, arg1.getName());
			}
		});

	}

	/** 由于libgdx的zindex并不表示渲染层级,所以这里采用这种方式来获取子控件的当前层级 */
	public static int getZOrder(CCWidget widget, String name) {
		if (name == null) {
			return 0;
		}
		for (CCWidget child : widget.getChildren()) {
			if (name.equals(child.getOptions().getName())) {
				return child.getOptions().getZOrder();
			}
		}
		return 0;
	}

}
