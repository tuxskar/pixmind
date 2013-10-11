package com.pix.mind.levels;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PixGuy;

public abstract class PixGuyLevel implements Screen {

	// common variables and structures of each level
	OrthographicCamera camera;
	World world;
	PixGuy pixGuy;
	Box2DDebugRenderer debugRenderer;
	PixMindGame game;
	
	ArrayList<StaticPlatformActor> platformList;
	ArrayList<PlatformActivatorActor> activatorList;
	// how many differents platform colors the level has
	int maxColors;
	// how many differents platform colors player can use
	int maxColorsInUse;
	
	// adjust this value to show the entire Level
	// the zoom is pointing to 0,0 stage coordinate
	float zoom = 0.5f;

	//smooth camera following
	//this point is the first platform + its half height
	float lastPlatformHeight = 210;
	float anteriorHeight = 210;
	boolean colliding = false;
	
	
	public PixGuyLevel(PixMindGame game, int maxColors, int maxColorsInUse){
		this.game = game;
		this.maxColors = maxColors;
		this.maxColorsInUse = maxColorsInUse;
		
		// box2d code: creating the box2D world
		world = new World(new Vector2(0, -10), true);

		debugRenderer = new Box2DDebugRenderer();
		
		// creating the camera and positioning it
		camera = new OrthographicCamera(
				PixMindGame.w * PixMindGame.WORLD_TO_BOX, 
				PixMindGame.h * PixMindGame.WORLD_TO_BOX);

		camera.translate(
				PixMindGame.w / 2 * PixMindGame.WORLD_TO_BOX,
				PixMindGame.h / 2 * PixMindGame.WORLD_TO_BOX);
		
		// creating platforms and activators lists
		platformList = new ArrayList<StaticPlatformActor>();
		activatorList = new ArrayList<PlatformActivatorActor>();

	}
	
	
	public void collisions(){
		// colissions and reactions
		world.setContactListener(new ContactListener() {

			@Override
			public void beginContact(Contact contact) {
				// TODO Auto-generated method stub
				Fixture fixGuy = null;
				Fixture fixPlatform = null;
				Fixture fixActivator = null;
				// get fixture fixguy
				if (contact.getFixtureA().getUserData().equals(PixGuy.PIX_ID)) {
					fixGuy = contact.getFixtureA();
					// fixPlatform = contact.getFixtureB();
				} else {
					// fixPlatform = contact.getFixtureA();
					fixGuy = contact.getFixtureB();
				}

				// get fixture Platform
				if (contact.getFixtureA().getUserData() instanceof StaticPlatformActor
						|| contact.getFixtureB().getUserData() instanceof StaticPlatformActor) {

					if (contact.getFixtureA().getUserData() instanceof StaticPlatformActor) {
						fixPlatform = contact.getFixtureA();

					} else {

						fixPlatform = contact.getFixtureB();
					}
				}

				// get fixture PlatformActivator
				if (contact.getFixtureA().getUserData() instanceof PlatformActivatorActor
						|| contact.getFixtureB().getUserData() instanceof PlatformActivatorActor) {

					if (contact.getFixtureA().getUserData() instanceof PlatformActivatorActor) {
						fixActivator = contact.getFixtureA();

					} else {

						fixActivator = contact.getFixtureB();
					}

				}

				// collision with an Activator
				if (fixActivator != null) {
					PlatformActivatorActor platformActivatorActor = (PlatformActivatorActor) fixActivator
							.getUserData();
					if (platformActivatorActor.isActive()) {
						// if activator is black go to next level
						if (platformActivatorActor.color.equals(Color.BLACK)) {
							game.changeLevel(game.getSecondLevel());
						}

						// get all platform of the same color and change state

						for (StaticPlatformActor sp : platformList) {
							if (platformActivatorActor.color.equals(sp.color))
								sp.setActive(false);
						}
						// get all activator of the same color and change state
						for (PlatformActivatorActor sp : activatorList) {
							if (platformActivatorActor.color.equals(sp.color))
								sp.setActive(false);
						}
					} else {
						// platformActivatorActor.setActive(true);
						// get all platform of the same color and change state
						for (StaticPlatformActor sp : platformList) {
							if (platformActivatorActor.color.equals(sp.color))
								sp.setActive(true);
						}
						for (PlatformActivatorActor sp : activatorList) {
							if (platformActivatorActor.color.equals(sp.color))
								sp.setActive(true);
						}
					}
				}

				// jump only if collide with a platform and its not sensor
				if (fixPlatform != null && !fixPlatform.isSensor()) {
					// only jump if bottom position of pixguy is equal or above
					// of top position of the platform

					StaticPlatformActor platformActor = (StaticPlatformActor) fixPlatform
							.getUserData();
					// opoppo

					float topPosPlatform = fixPlatform.getBody().getPosition().y
							+ platformActor.getHeight()
							* PixMindGame.WORLD_TO_BOX / 2;
					float bottomPosGuy = fixGuy.getBody().getPosition().y
							- PixGuy.pixHeight * PixMindGame.WORLD_TO_BOX / 2;

					// System.out.println(topPosPlatform);
					// System.out.println(bottomPosGuy);
					if (bottomPosGuy >= topPosPlatform) {
						//if(anteriorHeight>lastPlatformHeight)

						anteriorHeight = lastPlatformHeight;
						lastPlatformHeight = (fixPlatform.getBody()
								.getPosition().y + platformActor.getHeight()
								* PixMindGame.WORLD_TO_BOX / 2)
								* PixMindGame.BOX_TO_WORLD;
						if (lastPlatformHeight < anteriorHeight) {
							anteriorHeight = lastPlatformHeight;
						}
						fixGuy.getBody().setLinearVelocity(
								fixGuy.getBody().getLinearVelocity().x, 0);
						fixGuy.getBody().applyLinearImpulse(
								new Vector2(0, 0.2f),
								fixGuy.getBody().getWorldCenter(), true);
					}
				}
				System.out.println("contanto");
				colliding = true;
			}

			@Override
			public void endContact(Contact contact) {
				// TODO Auto-generated method stub

			}

			@Override
			public void preSolve(Contact contact, Manifold oldManifold) {
				// TODO Auto-generated method stub

			}

			@Override
			public void postSolve(Contact contact, ContactImpulse impulse) {
				// TODO Auto-generated method stub

			}

		});
	}
	

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public abstract void show();

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
