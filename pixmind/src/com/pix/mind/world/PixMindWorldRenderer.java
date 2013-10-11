package com.pix.mind.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.MapZoom;
import com.pix.mind.box2d.Box2DWorldContactListener;
import com.pix.mind.box2d.bodies.PixGuy;

public class PixMindWorldRenderer {

	private PixMindScene2D scene2D;
	private PixGuy pixGuy;
	private Box2DWorldContactListener contactListener;
	private MapZoom mapZoom;
	private OrthographicCamera camera;
	World world;
	private Box2DDebugRenderer debugRenderer;
	
	public PixMindWorldRenderer( PixMindScene2D scene2D, PixGuy pixGuy,Box2DWorldContactListener contactListener,  MapZoom mapZoom, World world){
		this.scene2D = scene2D;
		this.pixGuy = pixGuy;
		this.contactListener = contactListener;
		this.mapZoom = mapZoom;
		this.world = world;
		
		//set up camera for the debugRenderer		
		camera = new OrthographicCamera(PixMindGame.w
				* PixMindGame.WORLD_TO_BOX, PixMindGame.h
				* PixMindGame.WORLD_TO_BOX);		
		camera.translate(PixMindGame.w / 2 * PixMindGame.WORLD_TO_BOX,
				PixMindGame.h / 2 * PixMindGame.WORLD_TO_BOX);
		debugRenderer = new Box2DDebugRenderer();
	}
	
	
	public void render(float delta){
		debugRenderer.render(world, camera.combined);
		scene2D.getStage().draw();
		scene2D.getStageGui().draw();
		

		if (pixGuy.body.getLinearVelocity().y > 0) {
			pixGuy.body.getFixtureList().get(0).setSensor(true);
		} else {
			if (!contactListener.isColliding())
				pixGuy.body.getFixtureList().get(0).setSensor(false);
		}

		if (!mapZoom.isMapActive()) {
			if (contactListener.getLastPlatformHeight() > pixGuy.getPosY()) {

				contactListener.setLastPlatformHeight(pixGuy.getPosY());
				scene2D.getStage().getCamera().position.x = pixGuy.getPosX();
				scene2D.getStage().getCamera().position.y = contactListener
						.getLastPlatformHeight();
				camera.position.x = pixGuy.getPosX() * PixMindGame.WORLD_TO_BOX;
				camera.position.y = contactListener.getLastPlatformHeight()
						* PixMindGame.WORLD_TO_BOX;
				camera.update();

			} else {
				if (contactListener.getLastPlatformHeight() > contactListener
						.getAnteriorHeight()) {
					contactListener.setAnteriorHeight(contactListener
							.getAnteriorHeight() + 3);
					if (contactListener.getAnteriorHeight() >= contactListener
							.getLastPlatformHeight()) {
						contactListener.setAnteriorHeight(contactListener
								.getLastPlatformHeight());
					}
				}
				scene2D.getStage().getCamera().position.x = pixGuy.getPosX();
				scene2D.getStage().getCamera().position.y = contactListener
						.getAnteriorHeight();
				camera.position.x = pixGuy.getPosX() * PixMindGame.WORLD_TO_BOX;
				camera.position.y = contactListener.getAnteriorHeight()
						* PixMindGame.WORLD_TO_BOX;
				camera.update();
			}
			world.step(delta, 6, 2);
			pixGuy.setActualPosition();
		}
		scene2D.getStage().act();	
	}
}