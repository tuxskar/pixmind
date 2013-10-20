package com.pix.mind;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "pixmind";
		//For using images not only pow of 2 sizes
		cfg.useGL20 = true;
		cfg.width = 640;
		cfg.height = 480;
		
		new LwjglApplication(new PixMindGame(), cfg);
	}
}
