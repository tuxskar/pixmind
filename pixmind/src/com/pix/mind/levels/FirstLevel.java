package com.pix.mind.levels;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.ActiveColor;
import com.pix.mind.actors.ActiveColors;
import com.pix.mind.actors.MapZoom;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PixGuy;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.controllers.PixGuyController;
import com.pix.mind.world.Box2DWorldContactListener;
import com.pix.mind.world.PixMindBox2DInitialization;
import com.pix.mind.world.PixMindGuiInitialization;
import com.pix.mind.world.PixMindPixGuyInitialization;
import com.pix.mind.world.PixMindScene2DInitialization;
import com.pix.mind.world.PixMindWorldRenderer;

public class FirstLevel implements Screen {
	
	

	private PixMindGame game;
	public String levelTitle = "First Level";
	

	private MapZoom mapZoom;
	private PixMindWorldRenderer worldRenderer;
	private PixMindScene2DInitialization scene2D;
	private PixMindBox2DInitialization box2D;
	private PixMindGuiInitialization gui;

	


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
		
		// variables of the screen
		
	
		// aspect ratio and levelSize needs to be 1.3 ALWAYS
		// (to support minimum resolution device)
		
		float levelSizeHeight = 1000;
		float levelSizeWidth = 1333;
		
		// this point must be the first platform contact + its half height
		float cameraBeginsY = 210;
		
		//point of start of pixGuy in meters...
		
		float pixGuyBeginsX = 4;
		float pixGuyBeginsY = 4;
		
		//max number of active colors
		
		int nColors = 3;
		
		
		
		
		
		
		//Scene 2D initialization
		
		scene2D = new PixMindScene2DInitialization();			
		scene2D.setLevelSize(levelSizeWidth, levelSizeHeight);
				
		//gui initialization
		
		gui = new PixMindGuiInitialization(scene2D, nColors);
		
		//World initialization
		
		box2D = new PixMindBox2DInitialization (scene2D, game, gui, cameraBeginsY);		
		box2D.setPixGuyPosition(pixGuyBeginsX, pixGuyBeginsY);
	
		
		//platform Actors and Activator Actors List
	
		

		
		//Creating All Static Platforms
		
		//Box2D platforms
		StaticPlatform sPlatform = new StaticPlatform(box2D.getWorld(), 8, 5, 1f, 0.1f);
		StaticPlatform s2Platform = new StaticPlatform(box2D.getWorld(), 3, 2, 1, 0.1f);
		StaticPlatform s3Platform = new StaticPlatform(box2D.getWorld(), 5, 3, 1, 0.1f);
		StaticPlatform s4Platform = new StaticPlatform(box2D.getWorld(), 6, 4, 1, 0.1f);
		StaticPlatform s5Platform = new StaticPlatform(box2D.getWorld(), 1, 1f, 1, 0.1f);
		StaticPlatform s6Platform = new StaticPlatform(box2D.getWorld(), 2, 3, 1, 0.1f);
		StaticPlatform s7Platform = new StaticPlatform(box2D.getWorld(), 1.5f, 4.2f, 1, 0.1f);
		StaticPlatform s8Platform = new StaticPlatform(box2D.getWorld(), -15f, 0, 30, 0.1f);
		
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
		
		box2D.getPlatformList().add(s1Skin);
		box2D.getPlatformList().add(s2Skin);
		box2D.getPlatformList().add(s3Skin);
		box2D.getPlatformList().add(s4Skin);
		box2D.getPlatformList().add(s5Skin);
		box2D.getPlatformList().add(s6Skin);
		box2D.getPlatformList().add(s7Skin);
		box2D.getPlatformList().add(s8Skin);

		
		//Creating All Activator 
		
		//Box2D Activator
		
		PlatformActivator pActivator = new PlatformActivator(box2D.getWorld(), 0, 5, 0.1f);
		PlatformActivator p2Activator = new PlatformActivator(box2D.getWorld(), 8, 6, 0.1f);
		PlatformActivator p3Activator = new PlatformActivator(box2D.getWorld(), 0, 2, 0.1f);
		PlatformActivator p4Activator = new PlatformActivator(box2D.getWorld(), 2, 5, 0.1f);
		
		
		//Actor Activator
		
		PlatformActivatorActor a1Skin = new PlatformActivatorActor(pActivator,
				Color.RED, false);
		PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator,
				Color.BLACK, true);
		PlatformActivatorActor a3Skin = new PlatformActivatorActor(p3Activator,
				Color.GREEN, false);
		PlatformActivatorActor a4Skin = new PlatformActivatorActor(p4Activator,
				Color.BLUE, true);
	
		//Add activators to Stage
		
		scene2D.getGroupStage().addActor(a1Skin);
		scene2D.getGroupStage().addActor(a2Skin);
		scene2D.getGroupStage().addActor(a3Skin);
		scene2D.getGroupStage().addActor(a4Skin);
		
		
		//Add to activator list
		
		box2D.getActivatorList().add(a1Skin);
		box2D.getActivatorList().add(a2Skin);
		box2D.getActivatorList().add(a3Skin);
		box2D.getActivatorList().add(a4Skin);
		

		
		
		
		// add to stage the group of actors
		
		

		// Active colors		
		
		mapZoom = new MapZoom(scene2D, box2D,box2D.getContactListener(), levelSizeWidth, levelSizeHeight);
		
		worldRenderer = new PixMindWorldRenderer(scene2D,  box2D, box2D.getContactListener(), mapZoom);

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
