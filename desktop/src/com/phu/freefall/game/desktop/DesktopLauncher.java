package com.phu.freefall.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.phu.freefall.game.FreeFall;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FreeFall.WIDTH;
		config.height = FreeFall.HEIGHT;
		config.foregroundFPS = 60;
		config.x = 690;
		config.y = 10;
		config.title = "\"Free Fall\" why are you reading this,just play the game!!!";

		new LwjglApplication(new FreeFall(), config);
	}
}
