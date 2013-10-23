package com.pix.mind.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.StaticWall;

public class StaticWallActor extends Image {
	StaticWall staticWall;

	public StaticWallActor(StaticWall wall) {
//		super(PixMindGame.getSkin().getDrawable(
//				PixMindGame.platformColorToTexture.get(color)));
		staticWall = wall;
		initialize();
	}

	public StaticWallActor(World world, float posX, float posY, float width,
			float height, Color color, boolean active) {
//		super(PixMindGame.getSkin().getDrawable(
//				PixMindGame.platformColorToTexture.get(color)));
		staticWall = new StaticWall(world, posX, posY, width, height);
		initialize();
	}

	private void initialize() {
		setColor(Color.BLACK);
		staticWall.fixture.setUserData(this);
		this.setSize(staticWall.PlatformWidth * PixMindGame.BOX_TO_WORLD * 2,
				staticWall.PlatformHeight * PixMindGame.BOX_TO_WORLD * 2);
		this.setPosition(staticWall.getPosX(), staticWall.getPosY());
	}
}
