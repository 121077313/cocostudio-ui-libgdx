package framework;

import demo.MyGame;

/** 游戏场景,封装一些公共组件 */
public abstract class CommonStage extends MyStage {

	@Override
	public MyGame getGame() {
		return (MyGame) super.getGame();
	}

	public abstract void init();

}
