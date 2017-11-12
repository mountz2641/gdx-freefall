package com.phu.freefall.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.phu.freefall.game.FreeFall;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width + 800;
		config.height = 600;
		new LwjglApplication(new FreeFall(), config);
	}
}
