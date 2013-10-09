package com.pix.mind.levels;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PixGuyActor;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PixGuy;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.controllers.ArrowController;
import com.pix.mind.controllers.PixGuyController;

public class SecondLevel extends PixGuyLevel{
	
	private Image pixGuySkin;
	
	public SecondLevel(PixMindGame game, int maxColors, int maxColorsInUse) {
		// TODO Auto-generated constructor stub
		super(game, maxColors, maxColorsInUse);
			
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		// main character initialization
		pixGuy = new PixGuy(world, 4, 4, 0.2f, 0.2f);
		PixGuyController controller = new ArrowController(pixGuy, stageGui);
		pixGuy.setController(controller);
		pixGuySkin = new PixGuyActor(pixGuy);
				
		//////////////////
		// LEVEL DESIGN //
		//////////////////
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		// creating platforms (box2D)
		StaticPlatform sPlatform = new StaticPlatform(world, 8, 5, 1, 0.1f);
		StaticPlatform s2Platform = new StaticPlatform(world, 3, 2, 1, 0.1f);
		StaticPlatform s3Platform = new StaticPlatform(world, 5, 3, 1, 0.1f);
		StaticPlatform s4Platform = new StaticPlatform(world, 6, 4, 1, 0.1f);
		StaticPlatform s5Platform = new StaticPlatform(world, 1, 1, 1, 0.1f);
		StaticPlatform s6Platform = new StaticPlatform(world, 2, 3, 1, 0.1f);
		StaticPlatform s7Platform = new StaticPlatform(world, 1.5f, 4, 1, 0.1f);

		// creating platforms activators (box2D)
		PlatformActivator pActivator = new PlatformActivator(world, 0, 5, 0.1f);
		PlatformActivator p2Activator = new PlatformActivator(world, 8, 6, 0.1f);
		PlatformActivator p3Activator = new PlatformActivator(world, 0, 2, 0.1f);
		PlatformActivator p4Activator = new PlatformActivator(world, 2, 5, 0.1f);

		// creating platforms (skin)
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

		// creating platforms activators (skin)
		PlatformActivatorActor a1Skin = new PlatformActivatorActor(pActivator,
				Color.RED, false);
		PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator,
				Color.BLACK, true);
		PlatformActivatorActor a3Skin = new PlatformActivatorActor(p3Activator,
				Color.GREEN, false);
		PlatformActivatorActor a4Skin = new PlatformActivatorActor(p4Activator,
				Color.BLUE, true);

		// adding platforms and platforms activators into the lists
		platformList.add(s1Skin);
		platformList.add(s2Skin);
		platformList.add(s3Skin);
		platformList.add(s4Skin);
		platformList.add(s5Skin);
		platformList.add(s6Skin);
		platformList.add(s7Skin);

		activatorList.add(a1Skin);
		activatorList.add(a2Skin);
		activatorList.add(a3Skin);
		activatorList.add(a4Skin);

		// adding actors
		stage.addActor(pixGuySkin);

		stage.addActor(s1Skin);
		stage.addActor(s2Skin);
		stage.addActor(s3Skin);
		stage.addActor(s4Skin);
		stage.addActor(s5Skin);
		stage.addActor(s6Skin);
		stage.addActor(s7Skin);

		stage.addActor(a1Skin);
		stage.addActor(a2Skin);
		stage.addActor(a3Skin);
		stage.addActor(a4Skin);
		 
        ////////////////////////////////////////////////////////////////////////////////////////
		
		// checking collisions
		super.collisions();
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
