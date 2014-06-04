package org.freyja.libgdx.cocostudio.ui.parser.widget;

import org.freyja.libgdx.cocostudio.ui.CocoStudioUIEditor;
import org.freyja.libgdx.cocostudio.ui.model.CCOption;
import org.freyja.libgdx.cocostudio.ui.model.CCWidget;
import org.freyja.libgdx.cocostudio.ui.parser.WidgetParser;
import org.freyja.libgdx.cocostudio.ui.widget.ProgressBar;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

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
		Drawable tr = editor.findDrawable(option, option.getTextureData()
				.getPath());
		if (tr == null) {
			return new Image();
		}
		Image image = new Image(tr);
		return image;
		
		
//		if (option.getTextureData() == null) {
//			return new Image();
//		}
//		Drawable tr = editor.findDrawable(option, option.getTextureData()
//				.getPath());
//		if (tr == null) {
//			return new Image();
//		}
//		
//		
//		ProgressBar.ProgressBarStyle mBarStyle = new ProgressBar
//				.ProgressBarStyle(tr,
//				new TextureRegionDrawable(new TextureRegion(new Texture("pic/mainInterface/progressSolid.png"))));
//		
//		
//		ProgressBar mProgressBar = new ProgressBar(1, 100, 1, false, mBarStyle);
//		
//		mProgressBar.setSize(option.getWidth() * option.getScaleX(), option.getHeight() * option.getScaleY());
//		return mProgressBar;

	}

}
