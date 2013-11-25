package com.pix.mind.actors;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.PlatformActivator;


public class PlatformActivatorActor extends Group {
	
	private PlatformActivator platformActivator;
	private boolean active = true;
	private float radius;
	public Color color;
	Image platformActivatorImage;
	Image frame;
	
	
	public PlatformActivatorActor(PlatformActivator activator, Color color, boolean active){
		//super(PixMindGame.getSkin().getDrawable(PixMindGame.candyColorToTexture.get(color)));
		platformActivatorImage = new Image(PixMindGame.getSkin().getDrawable(PixMindGame.candyColorToTexture.get(color)));
		this.addActor(platformActivatorImage);
		frame = new Image(PixMindGame.getSkin().getPatch("frame"));
		if(!color.equals(Color.BLACK))
		this.addActor(frame);
		
		platformActivator = activator;
		initialize(color, active);
	}
	
	public PlatformActivatorActor(World world, float posX, float posY, Color color, boolean active){

		//super(PixMindGame.getSkin().getDrawable(PixMindGame.candyColorToTexture.get(color)));
		
		platformActivatorImage = new Image(PixMindGame.getSkin().getDrawable(PixMindGame.candyColorToTexture.get(color)));
		this.addActor(platformActivatorImage);
		frame = new Image(PixMindGame.getSkin().getPatch("frame"));
		if(!color.equals(Color.BLACK))
		this.addActor(frame);
	
		
		platformActivator = new PlatformActivator(world, posX, posY, 0.2f);		

		initialize(color, active);
	}
	
	private void initialize(Color color, boolean active){
		this.radius = platformActivator.getRadius()*PixMindGame.BOX_TO_WORLD;
		platformActivatorImage.setPosition(platformActivator.getPosX()-radius, platformActivator.getPosY()-radius);
		platformActivatorImage.setSize(radius*2, radius*2);
		frame.setSize(radius*3, radius*3);
		frame.setPosition(platformActivator.getPosX()-frame.getWidth()/2, platformActivator.getPosY()-frame.getWidth()/2);
		frame.setColor(color);
		
		this.color = color;	
		
		platformActivator.fixture.setUserData(this);

		this.setActive(active);

	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		if (active) {
			
			platformActivatorImage.setColor(255,255,255, 1);
			frame.setColor(Color.CLEAR);
			
			this.active = true;
		} else {
			

			platformActivatorImage.setColor(255,255,255, PixMindGame.delta);
			frame.setColor(color.r, color.g, color.b,1f);

			this.active = false;
		}
	}

	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
	
	}

	
	
}
