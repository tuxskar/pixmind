package com.pix.mind.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.pix.mind.PixMindGame;
import com.pix.mind.levels.FirstLevel;
import com.pix.mind.levels.LevelOne;

public class SplashScreen implements  Screen{
	private PixMindGame game;
	// image that is showed while all assets for the game are been loading by the AssetManager
	private Texture splashScreenImage;
	SpriteBatch batch;
	OrthographicCamera camera;
	
	public SplashScreen(PixMindGame game) {
		// TODO Auto-generated constructor stub
		this.game = game;
		batch = new SpriteBatch();
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
		splashScreenImage = PixMindGame.getSplashSkin().getRegion("splash screen").getTexture();
		
		batch.begin();
		batch.draw(splashScreenImage, 0, 0);
		batch.end();
		
		// waiting for it to finish loading the game atlas
		if (game.getAssetManager().update()) {
	
			game.setSkin(new Skin(game.getAssetManager().get(
				"data/textureatlas/PixmindTextureAtlas.pack", TextureAtlas.class)));
			
			game.setScreen(game.getMainMenuScreen());
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		game.getAssetManager().load("data/textureatlas/SplashTextureAtlas.pack", TextureAtlas.class);
		while (!game.getAssetManager().update()){
			System.out.println("Loading: splash screen atlas");
		}
		System.out.println("Ready: splash screen atlas");
		game.setSplashSkin(new Skin(game.getAssetManager().get("data/textureatlas/SplashTextureAtlas.pack", TextureAtlas.class)));
		
		// loading game atlas
		game.getAssetManager().load("data/textureatlas/PixmindTextureAtlas.pack", TextureAtlas.class);
		
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
		splashScreenImage.dispose();
	    batch.dispose();
		
	}

}
