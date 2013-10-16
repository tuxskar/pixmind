package com.pix.mind.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pix.mind.PixMindGame;

public class MainMenuScreen implements Screen {
	
	private PixMindGame game;
	Texture playImage;
	SpriteBatch batch;
	OrthographicCamera camera;
	
	public MainMenuScreen(PixMindGame game) {
		super();
		this.game = game;
		//Loading button textures
		playImage = new Texture(Gdx.files.internal("data/images/playImage.png"));
		//Creating batch
		batch = new SpriteBatch();
		//Creating camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		Gdx.gl.glClearColor(1, 1, 1, 1); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		batch.draw(playImage, game.w / 8, game.h / 4);
		
		batch.end();
		
		if(Gdx.input.justTouched())
            game.setScreen(game.getSplashScreen());
		
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
	    batch.dispose();
		
	}

}
