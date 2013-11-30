package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.world.PixMindWorldRenderer;


public class Level17 extends PixMindLevel {
	
	
	/* JUAN: LEVEL 20*/
	public String levelTitle = "Level20";
	PixMindGame game;
	private static final int nActiveColors = 1;
	public Level17(PixMindGame game) {
        super(game, 1300, 1200, 600, 8, 5, nActiveColors);
		this.game = game;
		levelNumber = 17;
	}

	@Override
	public void show() {
		super.show();
		super.setNextLevel(game.getLevel18());
		super.setActiveLevel(this);

		// platform Actors and Activator Actors List
		// Creating All Static Platforms
		float platW = 1f;
		float platH = 0.1f;
        float deltaX = -5f;
        float deltaY = -2.5f;

		// Active colors
		// Box2D platforms
		// Add to platform list
		// Black StaticPlatforms
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 12 + deltaX, 6 + deltaY, platW, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 12 + deltaX, 5 + deltaY, platW/2, platH, Color.BLACK, true));
//		box2D.getPlatformList().add(
//                new StaticPlatformActor(box2D.getWorld(), 12 + deltaX, 4 + deltaY, platW/2, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 14 + deltaX, 7 + deltaY, platW/2, platH, Color.BLACK, true));
		
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 15 + deltaX, 8 + deltaY, platW, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 16 + deltaX, 9 + deltaY, platW, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 15 + deltaX, 10 + deltaY, platW, platH, Color.BLACK, true));
		
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 7 + deltaX, 9 + deltaY, platW, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 5 + deltaX, 10 + deltaY, platW, platH, Color.BLACK, true));

		// Coloured StaticPlatforms
        box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 12 + deltaX, 3.8f + deltaY, platW - 0.1f, platH, Color.BLUE, false));
        box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 13.5f + deltaX, 11 + deltaY, platW, platH, Color.ORANGE, false));
        box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 10 + deltaX, 8 + deltaY, platW, platH, Color.RED, false));
        box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 5 + deltaX, 11 + deltaY, platW/2, platH, Color.BLUE, false));

		// Creating All Activator
		// Box2D Activator adding to activator list
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 5.1f + deltaX, 13.0f + deltaY, Color.BLACK, true));
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 12 + deltaX, 5.5f + deltaY, Color.ORANGE, false));
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 10.8f + deltaX, 9.2f + deltaY, Color.RED, false));
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 11.1f + deltaX, 10.4f + deltaY, Color.RED, false));
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 12.3f + deltaX, 12 + deltaY, Color.RED, false));
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 6.5f + deltaX, 10 + deltaY, Color.BLUE, false));
		
		box2D.getActivatorList().add(
	            new PlatformActivatorActor(box2D.getWorld(), 14.0f + deltaX, 8.5f + deltaY, Color.BLUE, false));
		box2D.getActivatorList().add(
	            new PlatformActivatorActor(box2D.getWorld(), 15.0f + deltaX, 9.5f + deltaY, Color.BLUE, false));
		box2D.getActivatorList().add(
	            new PlatformActivatorActor(box2D.getWorld(), 16.5f + deltaX, 10.5f + deltaY, Color.BLUE, false));
		box2D.getActivatorList().add(
	            new PlatformActivatorActor(box2D.getWorld(), 11.3f + deltaX, 9.2f + deltaY, Color.BLUE, false));
		box2D.getActivatorList().add(
	            new PlatformActivatorActor(box2D.getWorld(),  5.2f + deltaX, 11.5f + deltaY, Color.BLUE, false));
		
		
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 12 + deltaX, 6.5f + deltaY, Color.BLUE, false));

		// Add activators to Stage
		for (PlatformActivatorActor Sskin : box2D.getActivatorList()) {
			scene2D.getGroupStage().addActor(Sskin);
		}

		// Add platforms to Stage
		for (StaticPlatformActor Sskin : box2D.getPlatformList()) {
			scene2D.getGroupStage().addActor(Sskin);
		}

		// Rendering the game
		worldRenderer = new PixMindWorldRenderer(scene2D, box2D, gui);
	}


	@Override
	public void render(float delta) {
		super.render(delta);

	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void hide() {
		super.hide();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void dispose() {
	}
}
