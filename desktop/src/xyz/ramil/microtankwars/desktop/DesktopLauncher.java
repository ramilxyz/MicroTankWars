package xyz.ramil.microtankwars.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import xyz.ramil.microtankwars.MicroTankWarsGame;

public class DesktopLauncher  {

	private static DesktopLauncher desktopLauncher;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		if(desktopLauncher == null) {
			desktopLauncher = new DesktopLauncher();
		}

		config.width = 800;
		config.height = 480;

		new LwjglApplication(new MicroTankWarsGame(), config);

	}


}
