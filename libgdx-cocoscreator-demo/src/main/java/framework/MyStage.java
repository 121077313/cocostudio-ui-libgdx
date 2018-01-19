package framework;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MyStage extends Stage {

	protected Game game;

	public MyStage() {
		this(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
	}

	public MyStage(float width, float height, boolean keepAspectRatio) {
		super(new StretchViewport(width, height));
		this.game = (Game) Gdx.app.getApplicationListener();
	}

	public MyStage(float width, float height, boolean keepAspectRatio,
			SpriteBatch batch) {
		super(new StretchViewport(width, height));
		this.game = (Game) Gdx.app.getApplicationListener();
	}

	/** 居中对齐 */
	public void layerCenter(Actor actor) {
		actor.setPosition((getWidth() - actor.getWidth()) / 2,
				(getHeight() - actor.getHeight()) / 2);
	}

	/** X轴中间对齐 */
	public void layerXCenter(Actor actor) {
		actor.setX((getWidth() - actor.getWidth()) / 2);
	}

	/** X轴中间对齐 */
	public void layerYCenter(Actor actor) {
		actor.setY((getHeight() - actor.getHeight()) / 2);
	}

	/** 右顶端对齐 */
	public void layerTopRight(Actor actor) {
		actor.setPosition((getWidth() - actor.getWidth()),
				(getHeight() - actor.getHeight()));
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Screen getScreen() {
		return game.getScreen();
	}

}
