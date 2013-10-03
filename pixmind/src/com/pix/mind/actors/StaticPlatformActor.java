package com.pix.mind.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.StaticPlatform;

public class StaticPlatformActor extends Image {
	StaticPlatform staticPlatform;
	boolean active = true;
	
	public StaticPlatformActor(StaticPlatform platform, Color color, boolean active){
		super(new Texture(Gdx.files.internal("data/textures/pixel.png")));
		
		staticPlatform = platform;
		this.setSize(staticPlatform.PlatformWidth * PixMindGame.BOX_TO_WORLD * 2, staticPlatform.PlatformHeight * PixMindGame.BOX_TO_WORLD * 2);
		this.setPosition(staticPlatform.getPosX(), staticPlatform.getPosY());
		this.setColor(color);
		if (!active){
			this.setColor(color.r, color.g, color.b, 0.5f);
			this.active = false;
		}
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


}
