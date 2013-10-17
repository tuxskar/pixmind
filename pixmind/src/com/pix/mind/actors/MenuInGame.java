package com.pix.mind.actors;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;

public class MenuInGame extends Group {	
	Image nextLevel;
	Image interLevel;
	Stage stageGui;
	public MenuInGame(Stage stageGui){
		super();
		this.stageGui = stageGui;
		interLevel = new Image(PixMindGame.getSkin().getDrawable("interlevel"));		
		nextLevel = new Image (PixMindGame.getSkin().getDrawable("nextlevel"));
		this.addActor(interLevel);
	}
	public Group showWin(){
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
	

	
	
	
}
