package com.pix.mind.screens;

import com.badlogic.gdx.Screen;

public class InterLevelScreen implements Screen {
	private Screen PrevScreen;
	private Screen NextScreen;
	
	public InterLevelScreen(Screen prevScreen, Screen nextScreen){
		setPrevScreen(prevScreen);
		setNextScreen(nextScreen);
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
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
	
	public Screen getPrevScreen() {
		return PrevScreen;
	}
	public void setPrevScreen(Screen prevScreen) {
		PrevScreen = prevScreen;
	}
	
	public Screen getNextScreen() {
		return NextScreen;
	}
	public void setNextScreen(Screen nextScreen) {
		this.NextScreen = nextScreen;
	}

}
