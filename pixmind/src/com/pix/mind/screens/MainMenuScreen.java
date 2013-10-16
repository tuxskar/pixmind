package com.pix.mind.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pix.mind.PixMindGame;

public class MainMenuScreen implements Screen {
	
	private PixMindGame game;
	Texture playImage, backGroundImage;
	SpriteBatch batch;
	OrthographicCamera camera;
	Music mainMenuMusic;
	
	public MainMenuScreen(PixMindGame game) {
		super();
		this.game = game;
		//Loading textures
		playImage = new Texture(Gdx.files.internal("data/images/playImage.png"));
		backGroundImage = new Texture(Gdx.files.internal("data/images/smbBack.jpg"));
		//Creating batch
		batch = new SpriteBatch();
		//Creating camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		//Loading and playing main menu music loop
		mainMenuMusic = Gdx.audio.newMusic(Gdx.files.internal("data/music/smlo.mp3"));
		mainMenuMusic.setLooping(true);
		mainMenuMusic.setVolume(0.7f);
		mainMenuMusic.play();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		Gdx.gl.glClearColor(1, 1, 1, 1); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		batch.draw(backGroundImage, 0, 0);
		batch.draw(playImage, game.w / 8, game.h / 4);
		
		batch.end();
		
		if(Gdx.input.justTouched()) {
			mainMenuMusic.stop();
			game.setScreen(game.getSplashScreen());
			
		}
 
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
		playImage.dispose();
		backGroundImage.dispose();
	    batch.dispose();
	    mainMenuMusic.dispose();
		
	}

}
