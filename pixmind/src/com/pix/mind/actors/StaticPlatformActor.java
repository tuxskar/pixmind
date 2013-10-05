package com.pix.mind.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.StaticPlatform;

public class StaticPlatformActor extends Image {
	StaticPlatform staticPlatform;
Color color;
	public StaticPlatformActor(StaticPlatform platform, Color color,
			boolean active) {
		super(new Texture(Gdx.files.internal("data/textures/pixel.png")));

		staticPlatform = platform;
		this.setSize(staticPlatform.PlatformWidth * PixMindGame.BOX_TO_WORLD
				* 2, staticPlatform.PlatformHeight * PixMindGame.BOX_TO_WORLD
				* 2);
		this.setPosition(staticPlatform.getPosX(), staticPlatform.getPosY());
		this.color = color;		
		this.setActive(active);
	
	}

	public void setActive(boolean active) {

		if (active) {
			staticPlatform.fixture.setSensor(false);
			this.setColor(color.r, color.g, color.b, 1);
		} else {
			staticPlatform.fixture.setSensor(true);
			this.setColor(color.r, color.g, color.b, 0.2f);
		}
	}

}
