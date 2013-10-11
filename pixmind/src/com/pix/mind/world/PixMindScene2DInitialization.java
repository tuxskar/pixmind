package com.pix.mind.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pix.mind.PixMindGame;

public class PixMindScene2DInitialization {
	
	private Stage stage;
	private Stage stageGui;
	private Group groupStage;
	float levelSizeWidth;
	float levelSizeHeight;
	
	public PixMindScene2DInitialization(float levelSizeWidth , float levelSizeHeight) {
		stage = new Stage(PixMindGame.w, PixMindGame.h, true);
		stageGui = new Stage(PixMindGame.w, PixMindGame.h, true);		
		Gdx.input.setInputProcessor(stageGui);
		groupStage = new Group();
		groupStage.setOrigin(levelSizeWidth / 2, levelSizeHeight / 2);
		this.levelSizeWidth = levelSizeWidth;
		this.levelSizeHeight = levelSizeHeight;
		
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Stage getStageGui() {
		return stageGui;
	}

	public void setStageGui(Stage stageGui) {
		this.stageGui = stageGui;
	}

	public Group getGroupStage() {
		return groupStage;
	}

	public void setGroupStage(Group groupStage) {
		this.groupStage = groupStage;
	}
	
	
	
	

}
