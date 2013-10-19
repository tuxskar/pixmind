package com.pix.mind.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.pix.mind.PixMindGame;
import com.pix.mind.controllers.AccController;

public class OptionsMenuScreen implements Screen {
	
	private PixMindGame game;

	Stage optionsMenuStage;
	Image 
		accelerometerOrTouchImageS2D,
		musicOnOffImageS2D,
		backToMainMenuImageS2D,
		backgroundOptionsMenuImage;
	
	public OptionsMenuScreen(PixMindGame game) {
		super();
		this.game = game;
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		Gdx.gl.glClearColor(1, 1, 1, 1); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		optionsMenuStage.draw();
		optionsMenuStage.act();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		// creating actors (image)
		optionsMenuStage = new Stage(PixMindGame.w, PixMindGame.h, true);

		Gdx.input.setInputProcessor(optionsMenuStage);

		// to move according to the resolutuion, we create a group to put inside all menu elements
		Group optionsGroup = new Group();

		accelerometerOrTouchImageS2D = new Image(PixMindGame.getSkin().getDrawable("touch"));
		musicOnOffImageS2D = new Image(PixMindGame.getSkin().getDrawable("musicon"));
		backToMainMenuImageS2D = new Image(PixMindGame.getSkin().getDrawable("exit"));
		backgroundOptionsMenuImage = new Image(PixMindGame.getSkin().getDrawable("emptyscreen"));
		

		// adding actor listeners
		accelerometerOrTouchImageS2D.addListener(new ActorGestureListener() {
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				System.out.println("ACCELEROMETER/TOUCH CONTROL TOUCHED");
				if (accelerometerOrTouchImageS2D.getDrawable().equals(PixMindGame.getSkin().getDrawable("touch"))){
					
					System.out.println("---> control ACCELEROMETER");
					accelerometerOrTouchImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("accelerometer"));
					//cambiar el controlador 
					game.setPixGuyController("acc");

					
				}else{
					
					System.out.println("---> control TOUCH");
					accelerometerOrTouchImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("touch"));
					//cambiar el controlador 
					game.setPixGuyController("arr");
				}
			}
		});

		musicOnOffImageS2D.addListener(new ActorGestureListener() {
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				System.out.println("MUSIC ON/OFF TOUCHED");
				if (musicOnOffImageS2D.getDrawable().equals(PixMindGame.getSkin().getDrawable("musicon"))){
					
					System.out.println("---> music OFF");
					musicOnOffImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("musicoff"));
					
				}else{
					
					System.out.println("---> music ON");
					musicOnOffImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("musicon"));
				}
				
			}
		});

		backToMainMenuImageS2D.addListener(new ActorGestureListener() {
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				System.out.println("BACK TO THE MAIN MENU TOUCHED");
				game.changeLevel(game.getMainMenuScreen());
			}
		});

		// adding actors to the stage (to an stage group)
		optionsGroup.addActor(backgroundOptionsMenuImage);
		optionsGroup.addActor(accelerometerOrTouchImageS2D);
		optionsGroup.addActor(musicOnOffImageS2D);
		optionsGroup.addActor(backToMainMenuImageS2D);
		optionsGroup.setPosition(-(854 - PixMindGame.w) / 2, 0);
		optionsMenuStage.addActor(optionsGroup);

		// setting actors positions
		musicOnOffImageS2D.setPosition(320, 240);
		accelerometerOrTouchImageS2D.setPosition(320, 140);
		backToMainMenuImageS2D.setPosition(320, 40);

		// loading and playing main menu music loop
		PixMindGame.getMusic().setLooping(true);
		PixMindGame.getMusic().setVolume(0.9f);
		PixMindGame.getMusic().play();
		
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
		optionsMenuStage.dispose();
	}
	
	

}
