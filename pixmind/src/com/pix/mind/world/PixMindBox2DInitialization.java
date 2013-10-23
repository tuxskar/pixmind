package com.pix.mind.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.ActiveColors;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.actors.StaticWallActor;
import com.pix.mind.controllers.PixGuyController;

public class PixMindBox2DInitialization {
	private PixMindGame game;
	private OrthographicCamera camera;
	private World world;
	private Box2DWorldContactListener contactListener;
	private ActiveColors actColors;
	private PixMindPixGuyInitialization pixGuy;
	ArrayList<StaticPlatformActor> platformList;
	ArrayList<PlatformActivatorActor> activatorList;
	ArrayList<StaticWallActor> wallList;
	
	public PixMindBox2DInitialization( PixMindScene2DInitialization scene2D, PixMindGame game, int nColors){
	/** BOX2D SETTINGS **/
		this.game = game;
		//set up camera for the debugRenderer		
		camera = new OrthographicCamera(PixMindGame.w
				* PixMindGame.WORLD_TO_BOX, PixMindGame.h
				* PixMindGame.WORLD_TO_BOX);		
		camera.translate(PixMindGame.w / 2 * PixMindGame.WORLD_TO_BOX,
				PixMindGame.h / 2 * PixMindGame.WORLD_TO_BOX);
		
		// Box2d code
		world = new World(new Vector2(0, -10f), true);
	
		//PixGuyInitialization
		
		pixGuy = new PixMindPixGuyInitialization(scene2D, game, this);
		
		platformList = new ArrayList<StaticPlatformActor>();
		activatorList = new ArrayList<PlatformActivatorActor>();
		wallList = new ArrayList<StaticWallActor>();
		
		actColors = new ActiveColors(scene2D.getStageGui(), nColors);
		
		contactListener = new Box2DWorldContactListener(game, this, actColors);
		

		this.getWorld().setContactListener(contactListener);
	}

	
	public void addActivatedColor(Color color){
		actColors.addNewActiveColor(actColors.getActiveColorByColor(color));
	}
	public OrthographicCamera getCamera() {
		return camera;
	}

	// for to change controller in the option menu
	public PixGuyController getPixGuyController(){
		return pixGuy.getController();
	}
	
	public void setPixGuyController(PixGuyController newController){
		pixGuy.setController(newController);
	}

	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}


	public World getWorld() {
		return world;
	}


	public void setWorld(World world) {
		this.world = world;
	}


	public PixMindPixGuyInitialization getPixGuy() {
		return pixGuy;
	}


	public void setPixGuy(PixMindPixGuyInitialization pixGuy) {
		this.pixGuy = pixGuy;
	}
	
	public void setPixGuyPosition(float pixGuyBeginsX, float pixGuyBeginsY){
		pixGuy.setPixGuyPosition(pixGuyBeginsX, pixGuyBeginsY);
	}


	public ArrayList<StaticPlatformActor> getPlatformList() {
		return platformList;
	}
	
	public ArrayList<StaticWallActor> getWallList() {
		return wallList;
	}


	public void setPlatformList(ArrayList<StaticPlatformActor> platformList) {
		this.platformList = platformList;
	}


	public ArrayList<PlatformActivatorActor> getActivatorList() {
		return activatorList;
	}


	public void setActivatorList(ArrayList<PlatformActivatorActor> activatorList) {
		this.activatorList = activatorList;
	}
	public void resetLists(){
		platformList.clear();
		activatorList.clear();
	}


	public Box2DWorldContactListener getContactListener() {
		return contactListener;
	}


	public void setContactListener(Box2DWorldContactListener contactListener) {
		this.contactListener = contactListener;
	}
	
	public void setCameraBeginsY(float cameraBeginsY){
		contactListener.setLastPlatformHeight(cameraBeginsY);
		contactListener.setAnteriorHeight(cameraBeginsY);
		
		
	}

	
}
