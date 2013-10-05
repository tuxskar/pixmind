package com.pix.mind.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PixGuyActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PixGuy;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.controllers.ArrowController;
import com.pix.mind.controllers.PixGuyController;

public class FirstLevel implements Screen {
	private OrthographicCamera camera;
	private World world;
	private PixGuy pixGuy;
	private Box2DDebugRenderer debugRenderer; 
	private PixMindGame game;
	private Image pixGuySkin;
	private Stage stage;
	private Stage stageGui;
	
	public FirstLevel(PixMindGame game){
		this.game = game;
		
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		debugRenderer.render(world, camera.combined);	
		stage.draw();
		stageGui.draw();
		stage.getCamera().position.x = pixGuy.getPosX();
		stage.getCamera().position.y = pixGuy.getPosY();
		camera.position.x = pixGuy.getPosX() * PixMindGame.WORLD_TO_BOX;
		camera.position.y = pixGuy.getPosY() * PixMindGame.WORLD_TO_BOX;
		camera.update();
		world.step(delta, 6, 2);
		pixGuy.setActualPosition();
		stage.act();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//float w = Gdx.graphics.getWidth();
		//float h = Gdx.graphics.getHeight();
		
	
		
		
		camera = new OrthographicCamera(PixMindGame.w * PixMindGame.WORLD_TO_BOX, PixMindGame.h * PixMindGame.WORLD_TO_BOX);
		camera.translate(PixMindGame.w/2 * PixMindGame.WORLD_TO_BOX, PixMindGame.h/2 * PixMindGame.WORLD_TO_BOX);
		// Box2d code
		world = new World(new Vector2(0, -10), true);
		debugRenderer = new Box2DDebugRenderer();
		

		
		// comment to be commited
		float posX = 2f, posY = 2f, width=1f, heigth=0.2f;
		StaticPlatform sPlatform = new StaticPlatform(world, posX, posY, width, heigth);
		StaticPlatform s2Platform = new StaticPlatform(world, posX+1, posY+1, width, heigth);
		StaticPlatform s3Platform = new StaticPlatform(world, posX+3, posY, width, heigth);
		StaticPlatform s4Platform = new StaticPlatform(world, posX, posY-1, width+100, heigth);

		StaticPlatformActor s1Skin = new StaticPlatformActor(sPlatform, Color.RED, true);
		StaticPlatformActor s2Skin = new StaticPlatformActor(s2Platform, Color.BLUE, false);
		StaticPlatformActor s3Skin = new StaticPlatformActor(s3Platform, Color.GREEN, true);
		StaticPlatformActor s4Skin = new StaticPlatformActor(s4Platform, Color.BLACK, false);
		
		
		width = 0.2f;
		heigth = 0.2f;
		// main character initialization
		pixGuy = new PixGuy(world, posX+2, posY+3, width, heigth);
		stage = new Stage(PixMindGame.w, PixMindGame.h, true);
		stageGui = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		PixGuyController controller = new ArrowController(pixGuy, stageGui);
		pixGuy.setController(controller);
		pixGuySkin = new PixGuyActor(pixGuy);
		stage.addActor(pixGuySkin);
		stage.addActor(s1Skin);
		stage.addActor(s2Skin);
		stage.addActor(s3Skin);
		stage.addActor(s4Skin);
		camera.update();
		
		world.setContactListener(new ContactListener(){

			@Override
			public void beginContact(Contact contact) {
				// TODO Auto-generated method stub
				Fixture fixGuy;
				Fixture fixPlatform;
				if (contact.getFixtureA().getUserData().equals(PixGuy.PIX_ID)){
					fixGuy = contact.getFixtureA();
					//fixPlatform = contact.getFixtureB();
				}else{
					//fixPlatform = contact.getFixtureA();
					fixGuy = contact.getFixtureB();
				}
				fixGuy.getBody().setLinearVelocity(0, 0);
				fixGuy.getBody().applyLinearImpulse(new Vector2(0, 0.1f), fixGuy.getBody().getWorldCenter(), true);
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
