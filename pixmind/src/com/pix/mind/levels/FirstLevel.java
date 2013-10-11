package com.pix.mind.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
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

public class FirstLevel extends PixGuyLevel {
	
	private Image pixGuySkin;
	public String levelTitle = "First Level";
	private PixGuyController controller;
    private boolean mapActive= false;
	private boolean showingMap = false;
	private boolean hidingMap = false;
	private Image zoomInActor, zoomOutActor;
	private Stage stage;
	private Stage stageGui;
	
	public FirstLevel(PixMindGame game, int maxColors, int maxColorsInUse) {
		// TODO Auto-generated constructor stub
		super(game, maxColors, maxColorsInUse);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		//debugRenderer.render(world, camera.combined);
		
		stage.draw();
		stageGui.draw();
		
		System.out.println(colliding + " " +pixGuy.body.getLinearVelocity().y);
		
		if(pixGuy.body.getLinearVelocity().y > 0){
			pixGuy.body.getFixtureList().get(0).setSensor(true);
		}else{
			if(!colliding)
			pixGuy.body.getFixtureList().get(0).setSensor(false);
		}
			
		if(!mapActive){	
			
			if(lastPlatformHeight>pixGuy.getPosY()){
			
				lastPlatformHeight = pixGuy.getPosY();
				stage.getCamera().position.x = pixGuy.getPosX();
				stage.getCamera().position.y = lastPlatformHeight;		
				camera.position.x = pixGuy.getPosX() * PixMindGame.WORLD_TO_BOX;
				camera.position.y = lastPlatformHeight * PixMindGame.WORLD_TO_BOX;		
				camera.update();
				
			}else{
	
				if(lastPlatformHeight>anteriorHeight){
					
					anteriorHeight += 3f;
					
						if(anteriorHeight>=lastPlatformHeight){
							
								anteriorHeight = lastPlatformHeight;
						}
				}
			
				stage.getCamera().position.x = pixGuy.getPosX();
				stage.getCamera().position.y =anteriorHeight;		
				camera.position.x = pixGuy.getPosX() * PixMindGame.WORLD_TO_BOX;
				camera.position.y = anteriorHeight * PixMindGame.WORLD_TO_BOX;		
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
		// TODO Auto-generated method stub
		
		// creating the stage and stageGui
		stage = new Stage(PixMindGame.w, PixMindGame.h, true);
		stageGui = new Stage(PixMindGame.w, PixMindGame.h, true) {

				@Override
				public boolean touchDown(int screenX, int screenY, int pointer,
						int button) {
					// TODO Auto-generated method stub

					if (screenY / PixMindGame.fromRealScreenToFixedScreenWidth < 100
							&& screenX
									/ PixMindGame.fromRealScreenToFixedScreenHeight < 100
							&& !mapActive) {
						showMap();
						return true;
					}
					if (screenY / PixMindGame.fromRealScreenToFixedScreenWidth < 100
							&& screenX
									/ PixMindGame.fromRealScreenToFixedScreenHeight < 100
							&& mapActive) {
						hideMap();
						return true;
					}
					return true;
				}
			};

			Gdx.input.setInputProcessor(stageGui);

			float zoomMargin = 10;
			zoomInActor = new Image(PixMindGame.getSkin().getDrawable("zoomin"));
			zoomOutActor = new Image(PixMindGame.getSkin().getDrawable("zoomout"));
			zoomInActor.setSize(60, 60);
			zoomInActor.setPosition(0 + zoomMargin,
					PixMindGame.h - zoomInActor.getHeight() - zoomMargin);
			zoomOutActor.setSize(60, 60);
			zoomOutActor.setPosition(0 + zoomMargin,
					PixMindGame.h - zoomInActor.getHeight() - zoomMargin);
				
		//////////////////
		// LEVEL DESIGN //
		//////////////////
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		// creating platforms (box2D)
		StaticPlatform sPlatform = new StaticPlatform(world, 8, 5, 1f, 0.1f);
		StaticPlatform s2Platform = new StaticPlatform(world, 3, 2, 1, 0.1f);
		StaticPlatform s3Platform = new StaticPlatform(world, 5, 3, 1, 0.1f);
		StaticPlatform s4Platform = new StaticPlatform(world, 6, 4, 1, 0.1f);
		StaticPlatform s5Platform = new StaticPlatform(world, 1, 1f, 1, 0.1f);
		StaticPlatform s6Platform = new StaticPlatform(world, 2,3, 1, 0.1f);
		StaticPlatform s7Platform = new StaticPlatform(world, 1.5f, 4.2f, 1, 0.1f);
		StaticPlatform s8Platform = new StaticPlatform(world, -15f, 0, 30, 0.1f);		

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
		StaticPlatformActor s8Skin = new StaticPlatformActor(s8Platform,
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
		platformList.add(s8Skin);

		activatorList.add(a1Skin);
		activatorList.add(a2Skin);
		activatorList.add(a3Skin);
		activatorList.add(a4Skin);
	
		// main character initialization
		pixGuy = new PixGuy(world, 4,4, 0.2f, 0.2f);
		controller = new ArrowController(pixGuy, stageGui);
		pixGuy.setController(controller);
		pixGuySkin = new PixGuyActor(pixGuy);

		//adding actors
		stage.addActor(pixGuySkin);

		stage.addActor(s1Skin);
		stage.addActor(s2Skin);
		stage.addActor(s3Skin);
		stage.addActor(s4Skin);
		stage.addActor(s5Skin);
		stage.addActor(s6Skin);
		stage.addActor(s7Skin);
		stage.addActor(s8Skin);
		
		stage.addActor(a1Skin);
		stage.addActor(a2Skin);
		stage.addActor(a3Skin);
		stage.addActor(a4Skin);
		
		stageGui.addActor(zoomInActor);		
		 
        ////////////////////////////////////////////////////////////////////////////////////////
		
		// checking collisions
		super.collisions();
				
	}
	
	void hideMap() {
		// TODO Auto-generated method stub
		if (showingMap == false && hidingMap == false) {
			System.out.println("hiding MAP");
			hidingMap = true;

			OrthographicCamera orthoCam = (OrthographicCamera) stage
					.getCamera();
			orthoCam.position.x = pixGuySkin.getX();
			orthoCam.position.y = lastPlatformHeight;
			Action finalAction = new Action() {

				@Override
				public boolean act(float delta) {
					// TODO Auto-generated method stub
					mapActive = false;
					hidingMap = false;
					controller.setActive(true);
					zoomOutActor.remove();
					stageGui.addActor(zoomInActor);
					return true;
				}
			};
			stage.addAction(Actions.sequence(
					Actions.scaleTo(1f, 1f, 2, Interpolation.pow4), finalAction));
		}
	}
	
	
	void showMap() {
		System.out.println("showing MAP");
		mapActive = true;
		showingMap = true;
		controller.setActive(false);
		OrthographicCamera orthoCam = (OrthographicCamera) stage.getCamera();
		orthoCam.position.x = PixMindGame.w / 2;
		orthoCam.position.y = PixMindGame.h / 2;

		Action finalAction = new Action() {

			@Override
			public boolean act(float delta) {
				// TODO Auto-generated method stub
				showingMap = false;
				System.out.println("final action show");
				zoomInActor.remove();
				stageGui.addActor(zoomOutActor);
				return true;
			}
		};
		stage.addAction(Actions.sequence(
				Actions.scaleTo(zoom, zoom, 2, Interpolation.pow4), finalAction));
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

