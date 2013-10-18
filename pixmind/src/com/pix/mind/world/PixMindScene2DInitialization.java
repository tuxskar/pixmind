package com.pix.mind.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;

public class PixMindScene2DInitialization {
	
	private Stage stage;
	private Stage stageGui;
	private Group groupStage;
	float levelSizeWidth;
	float levelSizeHeight;
	
	public PixMindScene2DInitialization(float levelSizeWidth, float levelSizeHeight) {
		stage = new Stage(PixMindGame.w, PixMindGame.h, true);
		stageGui = new Stage(PixMindGame.w, PixMindGame.h, true);		
		Gdx.input.setInputProcessor(stageGui);
		Gdx.input.setCatchBackKey(true);
		groupStage = new Group();
		groupStage.setOrigin(levelSizeWidth / 2, levelSizeHeight / 2);		
		stage.addActor(groupStage);
		this.levelSizeWidth = levelSizeWidth;
		this.levelSizeHeight = levelSizeHeight;
		
		
	
		//background dimensions
		
		float width = PixMindGame.getSkin().getSprite("fondoingame").getWidth();
		float height = PixMindGame.getSkin().getSprite("fondoingame").getHeight();
		
		
		//background creation		
		float timesWidth = 1 + 1 + Math.round(this.levelSizeWidth / width);
		float timesHeight = 1 + 1 + Math.round(this.levelSizeHeight / height);
		float beginWidth = -width;
		float beginHeight = -height;
		for (int i = 0; i < timesHeight; i++) {
			for (int j = 0; j < timesWidth; j++) {
				Image im = new Image(PixMindGame.getSkin().getDrawable("fondoingame"));
				getGroupStage().addActor(im);
				im.setPosition(beginWidth, beginHeight);
				beginWidth += width;
				System.out.println( beginWidth);
			}
			beginWidth = -width;
			beginHeight +=height;
		}
	
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

	public float getLevelSizeWidth() {
		return levelSizeWidth;
	}

	public void setLevelSizeWidth(float levelSizeWidth) {
		this.levelSizeWidth = levelSizeWidth;
	}

	public float getLevelSizeHeight() {
		return levelSizeHeight;
	}

	public void setLevelSizeHeight(float levelSizeHeight) {
		this.levelSizeHeight = levelSizeHeight;
	}
	
	
	
	
	

}
