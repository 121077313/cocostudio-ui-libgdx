package cocostudio.ui.parser.widget;

import cocostudio.ui.BaseWidgetParser;
import cocostudio.ui.CocoStudioUIEditor;
import cocostudio.ui.model.CCOption;
import cocostudio.ui.model.CCWidget;
import cocostudio.ui.parser.WidgetParser;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class CCLoadingBar extends WidgetParser {

	@Override
	public String getClassName() {
		return "LoadingBar";
	}

	@Override
	public Actor parse(CocoStudioUIEditor editor, CCWidget widget,
			CCOption option) {

		if (option.getTextureData() == null) {
			return new Image();
		}
		TextureRegion tr = editor.findTextureRegion(option, option
				.getTextureData().getPath());
		if (tr == null) {
			return new Image();
		}
		Image image = new Image(tr);
		return image;

	}

}
