package com.pix.mind;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.pix.mind.levels.FirstLevel;

public class PixMindGame extends Game {
	private FirstLevel firstLevel;
	public static final float WORLD_TO_BOX = 0.01f;
	public static final float BOX_TO_WORLD = 100f;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		firstLevel = new FirstLevel(this);
		changeLevel(getFirstLevel());
	}
	
	public FirstLevel getFirstLevel() {
		return firstLevel;
	}
	
	public void changeLevel(Screen screen){
		this.setScreen(screen);
	}
}
