package com.pix.mind.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.pix.mind.PixMindGame;
import com.pix.mind.levels.PixMindLevel;

public class MenuInGame extends Group {	
	Image nextLevel1;
	Image nextLevel;
	Image interLevel;
	Stage stageGui;
	public boolean active = false;
	PixMindLevel activeLevelScreen;
	PixMindLevel nextLevelScreen;
	PixMindGame game;
	public MenuInGame(Stage stageGui, final PixMindGame game){
		super();
		this.stageGui = stageGui;
		this.game = game;
		interLevel = new Image(PixMindGame.getSkin().getDrawable("interlevel"));		
		nextLevel = new Image (PixMindGame.getSkin().getDrawable("nextlevel"));
		nextLevel.setPosition(70, 30);
		
		this.setPosition(PixMindGame.w/2-interLevel.getWidth()/2,PixMindGame.h/2 - interLevel.getHeight()/2);
		this.addActor(interLevel);
	
		ActorGestureListener listener = new ActorGestureListener(){

			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				super.touchDown(event, x, y, pointer, button);
				System.out.println("X " + x + " Y " + y);
				
				if(y>125 && y< 175){
				if(x >0 && x<150){
					game.setScreen(game.getMainMenuScreen());
				}
				if(x >150 && x<300){
					game.setScreen(getActiveLevelScreen());
				}
				}
				if(y <100 && y>0 && x> 70 && x< 230){
					game.setScreen(getNextLevelScreen());
				}
				
			}
			
		};
		this.addListener(listener);
		
		stageGui.addListener(new InputListener(){

			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				// TODO Auto-generated method stub
				
				if(keycode == Keys.BACK && !active){
					showLose();
				}
				return false;
			}
			
			
		});
	}
	public void showWin(){
		
		
		active = true;
		stageGui.addActor(this);
		addActor(nextLevel);	
		
		PixMindGame.getWinning().play(0.5f);
		int activeLevel = getActiveLevelScreen().levelNumber;
		
		Preferences prefs = Gdx.app.getPreferences("SweetMindPrefs");		
		int topLevel = prefs.getInteger("topLevel", 1);
		
		if(topLevel == activeLevel){
			System.out.println("HOLA KE ASE");
			if(topLevel==24)
				prefs.putInteger("topLevel", activeLevel);
			else
				prefs.putInteger("topLevel", activeLevel+1);
			prefs.flush();
		}
		
		
		
		
	}
	public void showLose(){
		PixMindGame.getLosing().play(0.5f);
		active = true;
		stageGui.addActor(this);
		nextLevel.remove();
		
	}
	public void removeMenu(){
		active=false;
		nextLevel.remove();
		this.remove();
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public PixMindLevel getActiveLevelScreen() {
		return activeLevelScreen;
	}
	public void setActiveLevelScreen(PixMindLevel activeLevelScreen) {
		this.activeLevelScreen = activeLevelScreen;
	}
	public PixMindLevel getNextLevelScreen() {
		return nextLevelScreen;
	}
	public void setNextLevelScreen(PixMindLevel nextLevelScreen) {
		this.nextLevelScreen = nextLevelScreen;
	}
	

	
	
	
}
