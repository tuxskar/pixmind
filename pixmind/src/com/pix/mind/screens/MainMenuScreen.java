package com.pix.mind.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.pix.mind.PixMindGame;

public class MainMenuScreen implements Screen {
	
	private PixMindGame game;
	//OrthographicCamera camera;
	//Music mainMenuMusic;
	Stage mainMenuStage;
	Image playImageS2D, optionsImageS2D, exitImageS2D, titleImageS2D, backgroundImage;
	
	public MainMenuScreen(PixMindGame game) {
		super();
		this.game = game;
		

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		Gdx.gl.glClearColor(1, 1, 1, 1); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
		
		mainMenuStage.draw();
		//MainMenuStage.act();
 
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		// creating actors (image)
		mainMenuStage = new Stage(PixMindGame.w, PixMindGame.h, true);
		
		Gdx.input.setInputProcessor(mainMenuStage);
		
		Gdx.input.setCatchBackKey(true);
		
		Group menuGroup = new Group(); //to move according to the resolutuion
		
		backgroundImage = new Image(PixMindGame.getSkin().getDrawable("emptyscreen"));
		playImageS2D = new Image(PixMindGame.getSkin().getDrawable("play"));
		optionsImageS2D = new Image(PixMindGame.getSkin().getDrawable("options"));
		exitImageS2D = new Image(PixMindGame.getSkin().getDrawable("exitmenu"));
		titleImageS2D = new Image(PixMindGame.getSkin().getDrawable("sweetmind"));
		
		
		// adding actor listeners
		playImageS2D.addListener(new ActorGestureListener(){
			public void touchDown (InputEvent event, float x, float y, int pointer, int button) {
	               System.out.println("PLAY TOUCHED");
	               game.changeLevel(game.getLevelSelector1Screen());
	          }
		});
		//playImageS2D.setTouchable(Touchable.enabled);
		
		exitImageS2D.addListener(new ActorGestureListener(){
			public void touchDown (InputEvent event, float x, float y, int pointer, int button) {
	               System.out.println("EXIT TOUCHED");
	               Gdx.app.exit();
	          }
		});
	//	exitImageS2D.setTouchable(Touchable.enabled);
		
		
		// adding actors to the stage
		menuGroup.addActor(backgroundImage);
		menuGroup.addActor(playImageS2D);
		menuGroup.addActor(optionsImageS2D);
		menuGroup.addActor(exitImageS2D);
		menuGroup.addActor(titleImageS2D);
		menuGroup.setPosition(-(854-PixMindGame.w)/2, 0);
		mainMenuStage.addActor(menuGroup);
		
		// setting sizes, positions, origins
		//playImageS2D.setSize(playImageS2D.getWidth(), playImageS2D.getHeight());
		playImageS2D.setPosition(320, 240);
		//playImageS2D.setOrigin(playImageS2D.getImageWidth()/2, playImageS2D.getImageHeight()/2);
		
		//optionsImageS2D.setSize(optionsImageS2D.getWidth(), optionsImageS2D.getHeight());
		optionsImageS2D.setPosition(320, 140);
		//optionsImageS2D.setOrigin(optionsImageS2D.getImageWidth()/2, optionsImageS2D.getImageHeight()/2);
		
	//	exitImageS2D.setSize(exitImageS2D.getWidth(), exitImageS2D.getHeight());
		exitImageS2D.setPosition(320, 40);
		//exitImageS2D.setOrigin(exitImageS2D.getImageWidth()/2, exitImageS2D.getImageHeight()/2);
		
	//	titleImageS2D.setSize(titleImageS2D.getWidth(), titleImageS2D.getHeight());
		titleImageS2D.setPosition(250, 400);
		//titleImageS2D.setOrigin(titleImageS2D.getImageWidth()/2, titleImageS2D.getImageHeight()/2);
		
		
		// Loading and playing main menu music loop
		/*mainMenuMusic = Gdx.audio.newMusic(Gdx.files.internal("data/music/smlo.mp3"));
		mainMenuMusic.setLooping(true);
		mainMenuMusic.setVolume(0.9f);
		mainMenuMusic.play();*/
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
//		backGroundImage.dispose();
//	    batch.dispose();
	   		
	}

}
