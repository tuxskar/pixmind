package com.pix.mind.levels;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
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
import com.pix.mind.world.PixMindScene2D;
import com.pix.mind.world.PixMindWorldRenderer;

public class FirstLevel implements Screen {
	private OrthographicCamera camera;
	private World world;
	private PixGuy pixGuy;
	private PixMindGame game;
	private Image pixGuySkin;	
	private ArrayList<StaticPlatformActor> platformList;
	private ArrayList<PlatformActivatorActor> activatorList;
	private ActiveColors actColors;
	public String levelTitle = "First Level";
	private PixGuyController controller;
	private Box2DWorldContactListener contactListener;
	private MapZoom mapZoom;
	private PixMindWorldRenderer worldRenderer;
	// adjust this value to show the entire Level
	// the zoom is pointing to 0,0 stage coordinate

	// needed for the camera to point to the center when zoom in
	// aspect ratio and levelSize needs to be 1.3 ALWAYS(minimum resolution
	// device)
	public float levelSizeHeight = 1000;
	public float levelSizeWidth = 1333;

	private PixMindScene2D scene2D;
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

		worldRenderer.render(delta);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		
		/** SCENE 2D SETUP **/ 	 

		scene2D = new PixMindScene2D(levelSizeWidth, levelSizeHeight);
		
	
	
		
		/** BOX2D SETTINGS **/
		
	
		
		// Box2d code
		world = new World(new Vector2(0, -10f), true);
	
		
		/** COMBINING BOX2D WITH SCENE2D **/
		
		// main character initialization
		pixGuy = new PixGuy(world, 4, 4, 0.2f, 0.2f);
		pixGuySkin = new PixGuyActor(pixGuy);
		controller = new ArrowController(pixGuy, scene2D.getStageGui());
		pixGuy.setController(controller);
		scene2D.getGroupStage().addActor(pixGuySkin);
		
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
		
		scene2D.getGroupStage().addActor(s1Skin);
		scene2D.getGroupStage().addActor(s2Skin);
		scene2D.getGroupStage().addActor(s3Skin);
		scene2D.getGroupStage().addActor(s4Skin);
		scene2D.getGroupStage().addActor(s5Skin);
		scene2D.getGroupStage().addActor(s6Skin);
		scene2D.getGroupStage().addActor(s7Skin);
		scene2D.getGroupStage().addActor(s8Skin);
		
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
		
		scene2D.getGroupStage().addActor(a1Skin);
		scene2D.getGroupStage().addActor(a2Skin);
		scene2D.getGroupStage().addActor(a3Skin);
		scene2D.getGroupStage().addActor(a4Skin);
		scene2D.getGroupStage().addActor(a5Skin);
		
		//Add to activator list
		
		activatorList.add(a1Skin);
		activatorList.add(a2Skin);
		activatorList.add(a3Skin);
		activatorList.add(a4Skin);
		activatorList.add(a5Skin);

		
		// add to stage the group of actors
		
		scene2D.getStage().addActor(scene2D.getGroupStage());

		// Active colors
		
		int nColors = 3;
		actColors = new ActiveColors(scene2D.getStageGui(), nColors);
		for (ActiveColor actColor : actColors.colors) {
			scene2D.getStageGui().addActor(actColor);
		}
		actColors.newActive(Color.BLUE);

		contactListener = new Box2DWorldContactListener(game, platformList,
				activatorList, actColors, 210, 210);
		world.setContactListener(contactListener);
		
		mapZoom = new MapZoom(scene2D.getStageGui(), controller, scene2D.getGroupStage(),
				contactListener, levelSizeWidth, levelSizeHeight, pixGuySkin);
		
	 worldRenderer = new PixMindWorldRenderer(scene2D, pixGuy, contactListener, mapZoom, world);

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
