package com.pix.mind.box2d;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.ActiveColors;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PixGuy;

public class Box2DWorldContactListener implements ContactListener{
	PixMindGame game;
	private ArrayList<StaticPlatformActor> platformList; 
	private ArrayList<PlatformActivatorActor> activatorList;
	private boolean colliding = false;
	private ActiveColors actColors;
	private float lastPlatformHeight;
	private float anteriorHeight;
	
	
	public Box2DWorldContactListener(PixMindGame game, ArrayList<StaticPlatformActor> platformList, ArrayList<PlatformActivatorActor> activatorList,  ActiveColors actColors,float lastPlatformHeight, float anteriorHeight){
		this.game = game;
		this.platformList = platformList;
		this.activatorList = activatorList;
		this.actColors = actColors;
		this.lastPlatformHeight = lastPlatformHeight;
		this.anteriorHeight = anteriorHeight;
	}
	@Override
	public void beginContact(Contact contact) {
		// TODO Auto-generated method stub
		Fixture fixGuy= null;
		Fixture fixPlatform = null;
		Fixture fixActivator = null;
		//get fixture fixguy
		if (contact.getFixtureA().getUserData().equals(PixGuy.PIX_ID)) {
			fixGuy = contact.getFixtureA();
			// fixPlatform = contact.getFixtureB();
		} else {
			// fixPlatform = contact.getFixtureA();
			fixGuy = contact.getFixtureB();
		}
		
		//get fixture Platform
		if (contact.getFixtureA().getUserData()
				instanceof StaticPlatformActor
				|| contact.getFixtureB().getUserData()
						instanceof StaticPlatformActor ) {

			if (contact.getFixtureA().getUserData()
					instanceof StaticPlatformActor) {
				fixPlatform = contact.getFixtureA();
			
			} else {
				
				fixPlatform = contact.getFixtureB();
			}
		}
		
		
		
		//get fixture PlatformActivator
		if (contact.getFixtureA().getUserData()
				instanceof PlatformActivatorActor
				|| contact.getFixtureB().getUserData()
						instanceof PlatformActivatorActor) {

			if (contact.getFixtureA().getUserData()
					instanceof PlatformActivatorActor) {
				fixActivator = contact.getFixtureA();
			
			} else {
				
				fixActivator = contact.getFixtureB();
			}
			
		}
		
		
		//collision with a Activator
		if(fixActivator!=null){
			PlatformActivatorActor platformActivatorActor = (PlatformActivatorActor) fixActivator.getUserData();
			if(platformActivatorActor.isActive()){
				//if activator is black go to next level
				if(platformActivatorActor.color.equals(Color.BLACK)){
//					game.changeLevel(game.getSecondLevel());
					game.changeLevel(game.getFirstLevel());
				}
					
				//get all platform of the same color and  change state
				
				for(StaticPlatformActor sp : platformList){
					if(platformActivatorActor.color.equals(sp.color))
					sp.setActive(false);
				}
				//get all activator of the same color and change state 
				for(PlatformActivatorActor sp : activatorList){
					if(platformActivatorActor.color.equals(sp.color)){
					sp.setActive(false);
					actColors.deActivate(sp.color);
					}
				}
			}else{
				//platformActivatorActor.setActive(true);
				//get all platform of the same color and  change state  
				for(StaticPlatformActor sp : platformList){
					if(platformActivatorActor.color.equals(sp.color))
					sp.setActive(true);
				}	
				for(PlatformActivatorActor sp : activatorList){
					if(platformActivatorActor.color.equals(sp.color)){
						sp.setActive(true);	
						actColors.newActive(sp.color);
					}
				}
			}				
		}
		

		//jump only if collide with a platform and its not sensor
		if(fixPlatform!=null && !fixPlatform.isSensor()){
		//only jump if bottom position of pixguy is equal or above of top position of the platform
			
			StaticPlatformActor platformActor =  (StaticPlatformActor) fixPlatform.getUserData();					
			//opoppo
			
			float topPosPlatform = fixPlatform.getBody().getPosition().y + platformActor.getHeight()*PixMindGame.WORLD_TO_BOX/2;
			float bottomPosGuy = fixGuy.getBody().getPosition().y-PixGuy.pixHeight*PixMindGame.WORLD_TO_BOX/2;

		//	System.out.println(topPosPlatform);
			//System.out.println(bottomPosGuy);
			if(bottomPosGuy>=topPosPlatform )
			{
			//if(anteriorHeight>lastPlatformHeight)
			
			anteriorHeight = lastPlatformHeight;
			lastPlatformHeight = (fixPlatform.getBody().getPosition().y+ platformActor.getHeight()*PixMindGame.WORLD_TO_BOX/2)*PixMindGame.BOX_TO_WORLD;						
			if(lastPlatformHeight<	anteriorHeight ){
				anteriorHeight = lastPlatformHeight;
			}
			fixGuy.getBody().setLinearVelocity(fixGuy.getBody().getLinearVelocity().x , 0);
			fixGuy.getBody().applyLinearImpulse(new Vector2(0, 0.2f),
			fixGuy.getBody().getWorldCenter(), true);
			}
		}
	System.out.println("contanto");
		colliding = true ;
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub
		colliding= false;
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
					
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}
	public boolean isColliding() {
		return colliding;
	}
	public float getLastPlatformHeight() {
		return lastPlatformHeight;
	}
	public void setLastPlatformHeight(float lastPlatformHeight) {
		this.lastPlatformHeight = lastPlatformHeight;
	}
	public float getAnteriorHeight() {
		return anteriorHeight;
	}
	public void setAnteriorHeight(float anteriorHeight) {
		this.anteriorHeight = anteriorHeight;
	}


	
	
	
	
	
	
	

}
