package framework;

import demo.MyGame;





/**
 * 加载战斗界面
 * 
 * @author i see
 * 
 */
public class CommonScreen extends MyScreen {

	@Override
	public MyGame getGame() {
		return (MyGame) super.getGame();
	}
}
