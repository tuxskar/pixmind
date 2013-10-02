package com.pix.mind.box2d.bodies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class StaticPlatform {
	static public final String PLATFORM_ID = "staticPlatform";
	public StaticPlatform(World world, float posX, float posY, float width, float height){
			// Create our body definition
			BodyDef groundBodyDef =new BodyDef();  
			// Set its world position
			groundBodyDef.position.set(new Vector2(posX, posY));  

			// Create a body from the defintion and add it to the world
			Body groundBody = world.createBody(groundBodyDef);  

			// Create a polygon shape
			PolygonShape groundBox = new PolygonShape();  
			// Set the polygon shape as a box which is twice the size of our view port and 20 high
			// (setAsBox takes half-width and half-height as arguments)
			//	groundBox.setAsBox(camera.viewportWidth, 10.0f);
			groundBox.setAsBox(width, height);
			// Create a fixture definition to apply our shape to
			FixtureDef fixtureDef = new FixtureDef();
			fixtureDef.shape = groundBox;
			fixtureDef.density = 0.5f; 
			fixtureDef.friction = 0.4f;
			fixtureDef.restitution = 0.6f; // Make it bounce a little bit
			// Create our fixture and attach it to the body
			Fixture fixture = groundBody.createFixture(fixtureDef);
			fixture.setUserData(StaticPlatform.PLATFORM_ID);
			// Clean up after ourselves
			groundBox.dispose();
	}
}
