package com.pix.mind.world;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.ActiveColors;
import com.pix.mind.actors.PixGuyActor;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PixGuy;

public class Box2DWorldContactListener implements ContactListener {
	PixMindGame game;
	private ArrayList<StaticPlatformActor> platformList;
	private ArrayList<PlatformActivatorActor> activatorList;
	private boolean colliding = false;
	private ActiveColors actColors;
	private float lastPlatformHeight;
	private float anteriorHeight;
	private Screen nextLevel;
	private int maxColors;
	private PixMindGuiInitialization gui;

	public Box2DWorldContactListener(PixMindGame game,
			PixMindBox2DInitialization box2D, ActiveColors actColors) {
		this.game = game;
		this.platformList = box2D.getPlatformList();
		this.activatorList = box2D.getActivatorList();
		this.actColors = actColors;
		maxColors = this.actColors.getMaxColors();
	}

	@Override
	public void beginContact(Contact contact) {
		// TODO Auto-generated method stub
		Fixture fixGuy = null;
		Fixture fixPlatform = null;
		Fixture fixActivator = null;
		// get fixture fixguy
		if (contact.getFixtureA().getUserData() instanceof PixGuyActor) {
			fixGuy = contact.getFixtureA();
			// fixPlatform = contact.getFixtureB();
		} else {
			// fixPlatform = contact.getFixtureA();
			fixGuy = contact.getFixtureB();
		}

		// get fixture Platform
		if (contact.getFixtureA().getUserData() instanceof StaticPlatformActor
				|| contact.getFixtureB().getUserData() instanceof StaticPlatformActor) {

			if (contact.getFixtureA().getUserData() instanceof StaticPlatformActor) {
				fixPlatform = contact.getFixtureA();

			} else {

				fixPlatform = contact.getFixtureB();
			}
		}

		// get fixture PlatformActivator
		if (contact.getFixtureA().getUserData() instanceof PlatformActivatorActor
				|| contact.getFixtureB().getUserData() instanceof PlatformActivatorActor) {

			if (contact.getFixtureA().getUserData() instanceof PlatformActivatorActor) {
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
					//making the level change to the next level (but first, game transition to an InterLevelScreen)
					//game.changeLevel(nextLevel);
					gui.getMenuInGame().showWin();
				}

				// get all platform of the same color and change state
				for (StaticPlatformActor sp : platformList) {
					if (platformActivatorActor.color.equals(sp.color))
						sp.setActive(false);
				}
				// get all activator of the same color and change state
				for (PlatformActivatorActor sp : activatorList) {
					if (platformActivatorActor.color.equals(sp.color)) {
						sp.setActive(false);
						actColors.deActivate(sp.color);
						System.out.println("Deactivating the color: "
								+ sp.color);
					}
				}
			} else {
				// It should activate the platforms and activators taking care
				// about the activator maximum number
				// platformActivatorActor.setActive(true);
				// get all platform of the same color and change state
				if (nActivatedColors >= maxColors) {
					// deactivate the older color
					Color toDeactivate = actColors.deActivateOlderColors();
					// get all platform of the same color and change state
					for (StaticPlatformActor sp : platformList) {
						if (toDeactivate.equals(sp.color))
							sp.setActive(false);
					}
					// get all activator of the same color and change state
					for (PlatformActivatorActor sp : activatorList) {
						if (toDeactivate.equals(sp.color)) {
							sp.setActive(false);
							System.out.println("Deactivating the color: "
									+ sp.color);
						}
					}
					System.out.println("estoy dentro");
				}
				for (StaticPlatformActor sp : platformList) {
					if (platformActivatorActor.color.equals(sp.color))
						sp.setActive(true);
				}
				for (PlatformActivatorActor sp : activatorList) {
					if (platformActivatorActor.color.equals(sp.color)) {
						sp.setActive(true);
						if (actColors.alreadyActive(sp.color) == -1) {
							actColors.newActive(sp.color);
						}
						System.out.println("Activating the color: " + sp.color);
					}
				}

			}
			nActivatedColors = actColors.getNActivesColors();
			System.out.println("final Activated: " + nActivatedColors
					+ " MaxColors: " + maxColors);
		}

		// jump only if collide with a platform and its not sensor
		if (fixPlatform != null && !fixPlatform.isSensor()) {
			// only jump if bottom position of pixguy is equal or above of top
			// position of the platform

			StaticPlatformActor platformActor = (StaticPlatformActor) fixPlatform
					.getUserData();
			// opoppo

			float topPosPlatform = fixPlatform.getBody().getPosition().y
					+ platformActor.getHeight() * PixMindGame.WORLD_TO_BOX / 2;
			float bottomPosGuy = fixGuy.getBody().getPosition().y
					- PixGuy.pixHeight * PixMindGame.WORLD_TO_BOX / 2;

			// System.out.println(topPosPlatform);
			// System.out.println(bottomPosGuy);
			if (bottomPosGuy >= topPosPlatform) {
				// if(anteriorHeight>lastPlatformHeight)

				anteriorHeight = lastPlatformHeight;
				lastPlatformHeight = (fixPlatform.getBody().getPosition().y + platformActor
						.getHeight() * PixMindGame.WORLD_TO_BOX / 2)
						* PixMindGame.BOX_TO_WORLD;
				if (lastPlatformHeight < anteriorHeight) {
					anteriorHeight = lastPlatformHeight;
				}
				fixGuy.getBody().setLinearVelocity(
						fixGuy.getBody().getLinearVelocity().x, 0);
				fixGuy.getBody().applyLinearImpulse(new Vector2(0, 0.65f),
						fixGuy.getBody().getWorldCenter(), true);
				// animation

				PixGuyActor pixguyActor = (PixGuyActor) fixGuy.getUserData();
				if (pixguyActor.getActions().size != 0)
					pixguyActor.removeAction(pixguyActor.getActions().get(0));
				Interpolation interpolation = Interpolation.linear;
				pixguyActor.addAction(Actions.sequence(
						Actions.scaleTo(1.2f, 0.8f, 0.25f, interpolation),
						Actions.scaleTo(1f, 1f, 0.25f, interpolation),
						Actions.scaleTo(0.8f, 1.2f, 0.25f, interpolation),
						Actions.scaleTo(1, 1, 0.25f, interpolation)));
			}

		}

		colliding = true;
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub
		colliding = false;
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

	public Screen getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(Screen nextLevel) {
		this.nextLevel = nextLevel;
	}

	public PixMindGuiInitialization getGui() {
		return gui;
	}

	public void setGui(PixMindGuiInitialization gui) {
		this.gui = gui;
	}
}
