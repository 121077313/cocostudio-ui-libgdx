package cocostudio.ui;

import java.util.Comparator;

import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;

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

	/** 获取控件类型名称 */
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
					- (actor.getOriginX() - option.getX()));

			actor.setY(parent.getOriginY()
					- (actor.getOriginY() - option.getY()));
		}

		// CocoStudio的编辑器ScaleX,ScaleY 会有负数情况
		actor.setScale(option.getScaleX(), option.getScaleY());

		if (option.getRotation() != 0) {// CocoStudio 是顺时针方向旋转,转换下.
			actor.setRotation(360 - option.getRotation() % 360);
		}

		// 设置可见
		actor.setVisible(option.isVisible());

		actor.setColor(option.getColorR() / 255f, option.getColorG() / 255f,
				option.getColorB() / 255f, option.getOpacity() / 255f);
		actor.setTouchable(option.isTouchAble() ? Touchable.enabled
				: Touchable.disabled);

		addActor(editor, actor, option);

		if (widget.getChildren().size() == 0) {
			return actor;
		}

		return null;
	}

	protected void addActor(CocoStudioUIEditor editor, Actor actor,
			CCOption option) {

		Array<Actor> arrayActors = editor.getActors().get(actor.getName());
		if (arrayActors == null) {
			arrayActors = new Array<Actor>();
		}
		arrayActors.add(actor);
		editor.getActors().put(actor.getName(), arrayActors);

		editor.getActionActors().put(option.getActiontag(), actor);
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
