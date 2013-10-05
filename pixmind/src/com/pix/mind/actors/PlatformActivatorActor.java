package com.pix.mind.actors;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.PlatformActivator;


public class PlatformActivatorActor extends Actor {
	
	private PlatformActivator platformActivator;
	private boolean active = true;
	private float radius;
	
	ShapeRenderer shapeRenderer;
	public PlatformActivatorActor(PlatformActivator activator, Color color, boolean active){
		//super(new Texture(Gdx.files.internal("data/textures/pixel.png")));
		
		platformActivator = activator;
		this.radius = platformActivator.getActivatorRadius();
		this.setPosition(platformActivator.getPosX(), platformActivator.getPosY());
		this.setColor(color);
		if (!active){
			this.setColor(color.r, color.g, color.b, 0.1f);	
			this.active = false;
		}
		shapeRenderer = new ShapeRenderer();
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
		shapeRenderer.setProjectionMatrix(this.getStage().getCamera().combined);
		batch.end();
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(this.getColor().r,this.getColor().g,this.getColor().b,1);
		shapeRenderer.circle(this.getX(),this.getY(),radius*PixMindGame.BOX_TO_WORLD);
		shapeRenderer.end();
		batch.begin();
	}

	
	
}
