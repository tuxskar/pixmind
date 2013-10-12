package com.pix.mind.actors;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.pix.mind.PixMindGame;
import com.pix.mind.controllers.PixGuyController;
import com.pix.mind.world.Box2DWorldContactListener;
import com.pix.mind.world.PixMindBox2DInitialization;
import com.pix.mind.world.PixMindScene2DInitialization;

public class MapZoom {
	
	
	private boolean mapActive= false;
	private boolean showingMap = false;
	private boolean hidingMap = false;
	private Image zoomInActor, zoomOutActor;
	private PixGuyController controller;

	private Box2DWorldContactListener contactListener;
	private float levelSizeWidth;
	private float levelSizeHeight;
	
	private Image pixGuySkin;
	private PixMindScene2DInitialization scene2D;
	public MapZoom(PixMindBox2DInitialization box2D, PixMindScene2DInitialization scene2D){
		
		
		scene2D.getStageGui().addListener(new ActorGestureListener(){

			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				System.out.println("x " + x + " y " + y);
				if(x<100 && y > 380 && !mapActive){
					
					showMap();
					
				}
				if(x<100 && y > 380  && mapActive ){
					
					hideMap();
					
				}			
				
			}
			
			
			
		});
		float zoomMargin = 10;
		zoomInActor = new Image (PixMindGame.getSkin().getDrawable("zoomin"));
		zoomOutActor = new Image (PixMindGame.getSkin().getDrawable("zoomout"));
		zoomInActor.setSize(60, 60);
		zoomInActor.setPosition(0+zoomMargin,PixMindGame.h -  zoomInActor.getHeight()-zoomMargin);
		zoomOutActor.setSize(60, 60);
		zoomOutActor.setPosition(0+zoomMargin, PixMindGame.h - zoomInActor.getHeight()-zoomMargin);
		scene2D.getStageGui().addActor(zoomInActor);		
		this.controller  = box2D.getPixGuy().getController();
	this.scene2D = scene2D;
		this.contactListener = box2D.getContactListener();
		//setLevelSize(LevelGenerator.getScene2D().getLevelSizeWidth(), LevelGenerator.getScene2D().getLevelSizeHeight());
		
		
		this.pixGuySkin = box2D.getPixGuy().getPixGuySkin();
		
	}
	
	protected void showMap() {
		
		mapActive = true;
		showingMap = true;
		controller.setActive(false);
		Action finalAction = new Action(){

			@Override
			public boolean act(float delta) {
				// TODO Auto-generated method stub
				showingMap = false;	
				System.out.println("final action show");
				zoomInActor.remove();
				scene2D.getStageGui().addActor(zoomOutActor);
				return true;
			}			
		};		
		scene2D.getGroupStage().addAction(Actions.sequence(Actions.parallel(Actions.scaleTo(PixMindGame.h /scene2D.getLevelSizeHeight(), PixMindGame.h /scene2D.getLevelSizeHeight(), 1,Interpolation.pow4), Actions.moveTo( -((scene2D.getLevelSizeWidth()/2)- pixGuySkin.getX()),  -((scene2D.getLevelSizeHeight()/2)- contactListener.getLastPlatformHeight()), 1,Interpolation.pow4)),finalAction));	
	
		
		
		 System.out.println("chamo2 " +scene2D.getLevelSizeWidth()/2+ " " +pixGuySkin.getX() + " "+(scene2D.getLevelSizeHeight()/2) + " "+contactListener.getLastPlatformHeight() );
			
	
	}
	
	protected void hideMap() {
		// TODO Auto-generated method stub
		if(showingMap==false && hidingMap == false){
			
		hidingMap = true;			
		Action finalAction = new Action(){

			@Override
			public boolean act(float delta) {
				// TODO Auto-generated method stub
				mapActive = false;
				hidingMap = false;
				controller.setActive(true);
				zoomOutActor.remove();
				scene2D.getStageGui().addActor(zoomInActor);
				return true;
			}
			
		};
		
		 scene2D.getGroupStage().addAction(Actions.sequence(Actions.parallel(Actions.scaleTo(1, 1, 1,Interpolation.pow4), Actions.moveTo( 0,0, 1,Interpolation.pow4)),finalAction));	
			
			
		}
		
	}

	public boolean isMapActive() {
		return mapActive;
	}
	public void setLevelSize(float levelSizeWidth, float levelSizeHeight){
		this.levelSizeWidth = levelSizeWidth;
		this.levelSizeHeight = levelSizeHeight;		
		scene2D.getGroupStage().setOrigin(levelSizeWidth / 2, levelSizeHeight / 2);
	}
	
	

}
