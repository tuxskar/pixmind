package com.pix.mind.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pix.mind.PixMindGame;

public class InterLevelScreen implements Screen {
	private Screen NextScreen;
	private PixMindGame game;
	
	public InterLevelScreen(Screen nextScreen, PixMindGame game){
		setNextScreen(nextScreen);
		this.game = game;
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		BitmapFont font = new BitmapFont(Gdx.files.internal("data/fonts/calibri.fnt"),Gdx.files.internal("data/fonts/calibri.png"),false);
		font.setColor(Color.BLUE);
		SpriteBatch batch = new SpriteBatch();
		batch.begin();
		font.draw(batch, "Congratullation You have pass this level", 10, game.h/2);
		batch.end();
        if(Gdx.input.justTouched())
            game.setScreen(getNextScreen());
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
		
	}
	
	public Screen getNextScreen() {
		return NextScreen;
	}
	public void setNextScreen(Screen nextScreen) {
		this.NextScreen = nextScreen;
	}

}
