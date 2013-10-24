package com.pix.mind.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.pix.mind.PixMindGame;
import com.pix.mind.levels.PixMindLevel;

public class MenuInGame extends Group {	
	
	Image nextLevel, retry, exit;
	Image donut, fondo;
	Group animatedGroup;
	Stage stageGui;
	public boolean active = false;
	PixMindLevel activeLevelScreen;
	PixMindLevel nextLevelScreen;
	PixMindGame game;
	public MenuInGame(Stage stageGui, final PixMindGame game){
		super();
		this.stageGui = stageGui;
		this.game = game;
		donut = new Image(PixMindGame.getSkin().getDrawable("donut"));	
		fondo = new Image(PixMindGame.getSkin().getDrawable("personaje fondo 1"));		
		//interLevel.setSize(300, 300);
		nextLevel = new Image (PixMindGame.getSkin().getDrawable("next level no selec"));
		nextLevel.setPosition(-70, 140);
	
		retry = new Image (PixMindGame.getSkin().getDrawable("retry no selec"));
		retry.setPosition(-70, -45);
		
		exit = new Image (PixMindGame.getSkin().getDrawable("exit no selec 1"));
		exit.setPosition(140, -10);
		
		this.setPosition(PixMindGame.w/2-donut.getWidth()/2,PixMindGame.h/2 - donut.getHeight()/2);
		fondo.setPosition(60, -45);
		this.addActor(fondo);
		
		animatedGroup = new Group();
		//animatedGroup.setOrigin(PixMindGame.w/2, PixMindGame.h/2);
		animatedGroup.setOrigin(70,70);
		this.setOrigin(PixMindGame.w/2, PixMindGame.h/2);
		animatedGroup.addActor(donut);
		animatedGroup.addActor(retry);
		animatedGroup.addActor(exit);
		this.addActor(animatedGroup);
		nextLevel.addListener(new ActorGestureListener(){
			boolean selected = true;
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				nextLevel.setDrawable(PixMindGame.getSkin().getDrawable("next level selec"));
				selected = true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				if(selected){ 
					if(PixMindGame.infoFx)
						PixMindGame.getMenuClick().play(0.3f);	
					game.setScreen(getNextLevelScreen());
				}
			}

			@Override
			public void pan(InputEvent event, float x, float y, float deltaX,
					float deltaY) {
				// TODO Auto-generated method stub
				  if(x<nextLevel.getX() || x> nextLevel.getX() + nextLevel.getWidth()|| y<nextLevel.getY()  || y> nextLevel.getHeight()){
					   nextLevel.setDrawable(PixMindGame.getSkin().getDrawable("next level no selec"));
				   selected= false;
				   }		
			}
			
			
			
		});
				
		
		exit.addListener(new ActorGestureListener(){
			boolean selected = true;
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				exit.setDrawable(PixMindGame.getSkin().getDrawable("exit selec 1"));
				selected = true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				if(selected){ 
					if(PixMindGame.infoFx)
						PixMindGame.getMenuClick().play(0.3f);	
					game.setScreen(game.getMainMenuScreen());
				}
			}

			@Override
			public void pan(InputEvent event, float x, float y, float deltaX,
					float deltaY) {
				// TODO Auto-generated method stub
				  if(x<exit.getX() || x> exit.getX() + exit.getWidth()|| y<exit.getY()  || y> exit.getHeight()){
					  exit.setDrawable(PixMindGame.getSkin().getDrawable("exit no selec 1"));
				   selected= false;
				   }		
			}
			
			
			
		});
		
		
		retry.addListener(new ActorGestureListener(){
			boolean selected = true;
			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				retry.setDrawable(PixMindGame.getSkin().getDrawable("retry selec"));
				selected = true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				if(selected){ 
					if(PixMindGame.infoFx)
						PixMindGame.getMenuClick().play(0.3f);	
					game.setScreen(getActiveLevelScreen());
				}
			}

			@Override
			public void pan(InputEvent event, float x, float y, float deltaX,
					float deltaY) {
				// TODO Auto-generated method stub
				  if(x<retry.getX() || x> retry.getX() + retry.getWidth()|| y<retry.getY()  || y> retry.getHeight()){
					  retry.setDrawable(PixMindGame.getSkin().getDrawable("retry no selec"));
				   selected= false;
				   }		
			}
			
			
			
		});
		
		
		
		
		
		
		/*ActorGestureListener listener = new ActorGestureListener(){

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
			
		};*/
		//this.addListener(listener);
		
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
		Interpolation interpolation = Interpolation.swingOut;
		animatedGroup.setScale(0.1f,0.1f);
		animatedGroup.setRotation(180);
		animatedGroup.addAction(Actions.parallel(Actions.rotateBy(180, 1f, interpolation),Actions.scaleTo(1, 1, 1f, interpolation) ));
		
		
		active = true;
		stageGui.addActor(this);
		animatedGroup.addActor(nextLevel);	
		if(PixMindGame.infoFx)			
			PixMindGame.getWinning().play(0.5f);
		int activeLevel = getActiveLevelScreen().levelNumber;
		
		Preferences prefs = Gdx.app.getPreferences("SweetMindPrefs");		
		int topLevel = prefs.getInteger("topLevel", 1);
		
		if(topLevel == activeLevel){
			System.out.println("PREFERENCIAS - NIVEL");
			if(topLevel==24)
				prefs.putInteger("topLevel", activeLevel);
			else
				prefs.putInteger("topLevel", activeLevel+1);
			prefs.flush();
		}
		
		
		
		
	}
	public void showLose(){
		Interpolation interpolation = Interpolation.swingOut;
		animatedGroup.setScale(0.1f,0.1f);
		animatedGroup.setRotation(180);
		animatedGroup.addAction(Actions.parallel(Actions.rotateBy(180, 1f, interpolation),Actions.scaleTo(1, 1, 1f, interpolation) ));
		

		if(PixMindGame.infoFx)			
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
