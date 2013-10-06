package com.pix.mind.actors;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.PlatformActivator;


public class PlatformActivatorActor extends Image {
	
	private PlatformActivator platformActivator;
	private boolean active = true;
	private float radius;
	
	
	public PlatformActivatorActor(PlatformActivator activator, Color color, boolean active){
		super(PixMindGame.getSkin().getDrawable("circle"));
		
		platformActivator = activator;
		this.radius = platformActivator.getRadius()*PixMindGame.BOX_TO_WORLD;
		this.setPosition(platformActivator.getPosX()-radius, platformActivator.getPosY()-radius);
		this.setSize(radius*2, radius*2);
		this.setColor(color);
		if (!active){
			this.setColor(color.r, color.g, color.b, 0.1f);	
			this.active = false;
		}
		
		//shapeRenderer.setProjectionMatrix(this.getStage().getCamera().combined);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
	
	}

	
	
}