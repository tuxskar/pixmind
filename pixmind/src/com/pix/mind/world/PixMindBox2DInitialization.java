package com.pix.mind.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PixGuyActor;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PixGuy;
import com.pix.mind.controllers.ArrowController;
import com.pix.mind.controllers.PixGuyController;

public class PixMindBox2DInitialization {
	private OrthographicCamera camera;
	private World world;
	private Box2DWorldContactListener contactListener;
	
	private PixMindPixGuyInitialization pixGuy;
	 ArrayList<StaticPlatformActor> platformList;
	 ArrayList<PlatformActivatorActor> activatorList;
	
	public PixMindBox2DInitialization( PixMindScene2DInitialization scene2D, PixMindGame game){
	/** BOX2D SETTINGS **/
		
		//set up camera for the debugRenderer		
		camera = new OrthographicCamera(PixMindGame.w
				* PixMindGame.WORLD_TO_BOX, PixMindGame.h
				* PixMindGame.WORLD_TO_BOX);		
		camera.translate(PixMindGame.w / 2 * PixMindGame.WORLD_TO_BOX,
				PixMindGame.h / 2 * PixMindGame.WORLD_TO_BOX);
		
		// Box2d code
		world = new World(new Vector2(0, -10f), true);
	
		//PixGuyInitialization
		
		pixGuy = new PixMindPixGuyInitialization(scene2D, this);
		
		platformList = new ArrayList<StaticPlatformActor>();
		activatorList = new ArrayList<PlatformActivatorActor>();
		
		contactListener = new Box2DWorldContactListener(game, this);
		

		this.getWorld().setContactListener(contactListener);
	}


	public OrthographicCamera getCamera() {
		return camera;
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
