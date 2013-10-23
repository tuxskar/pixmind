package com.pix.mind.box2d.bodies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.pix.mind.PixMindGame;

public class StaticWall {
	static public final String PLATFORM_ID = "StaticWall";
	public float PlatformWidth = 10;
	public float PlatformHeight = 2;
	public float posX = 0;
	public float posY = 0;
	public Fixture fixture;

	public StaticWall(World world, float posX, float posY, float width,
			float height) {
		// Create our body definition
		BodyDef groundBodyDef = new BodyDef();
		// Set its world position
		groundBodyDef.position.set(new Vector2(posX, posY));
		// Create a body from the defintion and add it to the world
		Body groundBody = world.createBody(groundBodyDef);
		// Create a polygon shape
		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox(width, height);
		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = groundBox;
		fixtureDef.density = 1f;
//		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.4f; // Make it bounce a little bit
		// Create our fixture and attach it to the body
		fixture = groundBody.createFixture(fixtureDef);
		// fixture.setUserData(PLATFORM_ID);
		// Clean up after ourselves
		groundBox.dispose();
		PlatformWidth = width;
		PlatformHeight = height;
		this.posX = posX;
		this.posY = posY;
	}

	public float getPosX() {
		return posX * PixMindGame.BOX_TO_WORLD - PlatformWidth
				* PixMindGame.BOX_TO_WORLD;
	}

	public float getPosY() {
		return posY * PixMindGame.BOX_TO_WORLD - PlatformHeight
				* PixMindGame.BOX_TO_WORLD;
	}

	public float getPlatformWidth() {
		return PlatformWidth;
	}

	public float getPlatformHeight() {
		return PlatformHeight;
	}
}
