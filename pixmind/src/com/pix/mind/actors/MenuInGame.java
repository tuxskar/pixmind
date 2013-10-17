package com.pix.mind.actors;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;

public class MenuInGame extends Group {	
	Image nextLevel;
	Image interLevel;
	Stage stageGui;
	boolean active = false;
	public MenuInGame(Stage stageGui){
		super();
		this.stageGui = stageGui;
		interLevel = new Image(PixMindGame.getSkin().getDrawable("interlevel"));		
		nextLevel = new Image (PixMindGame.getSkin().getDrawable("nextlevel"));
		nextLevel.setPosition(70, 30);
		this.setPosition(PixMindGame.w/2-interLevel.getWidth()/2,PixMindGame.h/2 - interLevel.getHeight()/2);
		
		this.addActor(interLevel);
	}
	public Group showWin(){
		active = true;
		stageGui.addActor(this);
		addActor(nextLevel);		
		return this;
		
	}
	public Group showLose(){
		stageGui.addActor(this);
		nextLevel.remove();
		return this;
	}
	public void removeMenu(){
		nextLevel.remove();
		this.remove();
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

	
	
	
}
