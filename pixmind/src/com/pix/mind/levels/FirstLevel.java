package com.pix.mind.levels;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.ActiveColor;
import com.pix.mind.actors.ActiveColors;
import com.pix.mind.actors.MapZoom;
import com.pix.mind.actors.PixGuyActor;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.Box2DWorldContactListener;
import com.pix.mind.box2d.bodies.PixGuy;
import com.pix.mind.box2d.bodies.PlatformActivator;
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
	private ArrayList<StaticPlatformActor> platformList;
	private ArrayList<PlatformActivatorActor> activatorList;
	private ActiveColors actColors;
	public String levelTitle = "First Level";
	private PixGuyController controller;
	private Group groupStage;
	private Box2DWorldContactListener contactListener;
	private MapZoom mapZoom;
	// adjust this value to show the entire Level
	// the zoom is pointing to 0,0 stage coordinate

	// needed for the camera to point to the center when zoom in
	// aspect ratio and levelSize needs to be 1.3 ALWAYS(minimum resolution
	// device)
	public float levelSizeHeight = 1000;
	public float levelSizeWidth = 1333;
	public float zoom = PixMindGame.h / levelSizeHeight;

	// smooth camera following
	// this point is the first platform + its half height

	public FirstLevel(PixMindGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// debugRenderer.render(world, camera.combined);
		stage.draw();
		stageGui.draw();

		if (pixGuy.body.getLinearVelocity().y > 0) {
			pixGuy.body.getFixtureList().get(0).setSensor(true);
		} else {
			if (!contactListener.isColliding())
				pixGuy.body.getFixtureList().get(0).setSensor(false);
		}

		if (!mapZoom.isMapActive()) {
			if (contactListener.getLastPlatformHeight() > pixGuy.getPosY()) {

				contactListener.setLastPlatformHeight(pixGuy.getPosY());
				stage.getCamera().position.x = pixGuy.getPosX();
				stage.getCamera().position.y = contactListener
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
				stage.getCamera().position.x = pixGuy.getPosX();
				stage.getCamera().position.y = contactListener
						.getAnteriorHeight();
				camera.position.x = pixGuy.getPosX() * PixMindGame.WORLD_TO_BOX;
				camera.position.y = contactListener.getAnteriorHeight()
						* PixMindGame.WORLD_TO_BOX;
				camera.update();
			}
			world.step(delta, 6, 2);
			pixGuy.setActualPosition();
		}
		stage.act();		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		
		/** SCENE 2D SETUP **/ 	 

		stage = new Stage(PixMindGame.w, PixMindGame.h, true);
		stageGui = new Stage(PixMindGame.w, PixMindGame.h, true);		
		Gdx.input.setInputProcessor(stageGui);
		groupStage = new Group();
		groupStage.setOrigin(levelSizeWidth / 2, levelSizeHeight / 2);
		
		/** BOX2D SETTINGS **/
		
		//set up camera for the debugRenderer		
		camera = new OrthographicCamera(PixMindGame.w
				* PixMindGame.WORLD_TO_BOX, PixMindGame.h
				* PixMindGame.WORLD_TO_BOX);		
		camera.translate(PixMindGame.w / 2 * PixMindGame.WORLD_TO_BOX,
				PixMindGame.h / 2 * PixMindGame.WORLD_TO_BOX);
		
		// Box2d code
		world = new World(new Vector2(0, -10f), true);
		debugRenderer = new Box2DDebugRenderer();
		
		/** COMBINING BOX2D WITH SCENE2D **/
		
		// main character initialization
		pixGuy = new PixGuy(world, 4, 4, 0.2f, 0.2f);
		pixGuySkin = new PixGuyActor(pixGuy);
		controller = new ArrowController(pixGuy, stageGui);
		pixGuy.setController(controller);
		groupStage.addActor(pixGuySkin);
		
		//platform Actors and Activator Actors List
		platformList = new ArrayList<StaticPlatformActor>();
		activatorList = new ArrayList<PlatformActivatorActor>();

		//Creating All Static Platforms
		
		//Box2D platforms
		StaticPlatform sPlatform = new StaticPlatform(world, 8, 5, 1f, 0.1f);
		StaticPlatform s2Platform = new StaticPlatform(world, 3, 2, 1, 0.1f);
		StaticPlatform s3Platform = new StaticPlatform(world, 5, 3, 1, 0.1f);
		StaticPlatform s4Platform = new StaticPlatform(world, 6, 4, 1, 0.1f);
		StaticPlatform s5Platform = new StaticPlatform(world, 1, 1f, 1, 0.1f);
		StaticPlatform s6Platform = new StaticPlatform(world, 2, 3, 1, 0.1f);
		StaticPlatform s7Platform = new StaticPlatform(world, 1.5f, 4.2f, 1, 0.1f);
		StaticPlatform s8Platform = new StaticPlatform(world, -15f, 0, 30, 0.1f);
		
		//Actor Platforms
		StaticPlatformActor s1Skin = new StaticPlatformActor(sPlatform,
				Color.RED, false);
		StaticPlatformActor s2Skin = new StaticPlatformActor(s2Platform,
				Color.BLUE, true);
		StaticPlatformActor s3Skin = new StaticPlatformActor(s3Platform,
				Color.GREEN, false);
		StaticPlatformActor s4Skin = new StaticPlatformActor(s4Platform,
				Color.BLACK, true);
		StaticPlatformActor s5Skin = new StaticPlatformActor(s5Platform,
				Color.RED, false);
		StaticPlatformActor s6Skin = new StaticPlatformActor(s6Platform,
				Color.BLACK, true);
		StaticPlatformActor s7Skin = new StaticPlatformActor(s7Platform,
				Color.BLACK, true);
		StaticPlatformActor s8Skin = new StaticPlatformActor(s8Platform,
				Color.BLACK, true);
		
		//Add platforms to Stage
		
		groupStage.addActor(s1Skin);
		groupStage.addActor(s2Skin);
		groupStage.addActor(s3Skin);
		groupStage.addActor(s4Skin);
		groupStage.addActor(s5Skin);
		groupStage.addActor(s6Skin);
		groupStage.addActor(s7Skin);
		groupStage.addActor(s8Skin);
		
		//Add to platform list
		
		platformList.add(s1Skin);
		platformList.add(s2Skin);
		platformList.add(s3Skin);
		platformList.add(s4Skin);
		platformList.add(s5Skin);
		platformList.add(s6Skin);
		platformList.add(s7Skin);
		platformList.add(s8Skin);

		
		//Creating All Activator 
		
		//Box2D Activator
		
		PlatformActivator pActivator = new PlatformActivator(world, 0, 5, 0.1f);
		PlatformActivator p2Activator = new PlatformActivator(world, 8, 6, 0.1f);
		PlatformActivator p3Activator = new PlatformActivator(world, 0, 2, 0.1f);
		PlatformActivator p4Activator = new PlatformActivator(world, 2, 5, 0.1f);
		PlatformActivator p5Activator = new PlatformActivator(world,
				levelSizeWidth * PixMindGame.WORLD_TO_BOX, levelSizeHeight
						* PixMindGame.WORLD_TO_BOX, 0.1f);
		
		//Actor Activator
		
		PlatformActivatorActor a1Skin = new PlatformActivatorActor(pActivator,
				Color.RED, false);
		PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator,
				Color.BLACK, true);
		PlatformActivatorActor a3Skin = new PlatformActivatorActor(p3Activator,
				Color.GREEN, false);
		PlatformActivatorActor a4Skin = new PlatformActivatorActor(p4Activator,
				Color.BLUE, true);
		PlatformActivatorActor a5Skin = new PlatformActivatorActor(p5Activator,
				Color.BLUE, true);
		
		//Add activators to Stage
		
		groupStage.addActor(a1Skin);
		groupStage.addActor(a2Skin);
		groupStage.addActor(a3Skin);
		groupStage.addActor(a4Skin);
		groupStage.addActor(a5Skin);
		
		//Add to activator list
		
		activatorList.add(a1Skin);
		activatorList.add(a2Skin);
		activatorList.add(a3Skin);
		activatorList.add(a4Skin);
		activatorList.add(a5Skin);

		
		// add to stage the group of actors
		
		stage.addActor(groupStage);

		// Active colors
		
		int nColors = 3;
		actColors = new ActiveColors(stageGui, nColors);
		for (ActiveColor actColor : actColors.colors) {
			stageGui.addActor(actColor);
		}
		actColors.newActive(Color.BLUE);

		camera.update();

		contactListener = new Box2DWorldContactListener(game, platformList,
				activatorList, actColors, 210, 210);
		world.setContactListener(contactListener);
		
		mapZoom = new MapZoom(stageGui, controller, groupStage,
				contactListener, levelSizeWidth, levelSizeHeight, zoom,
				pixGuySkin);

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

	}

}
