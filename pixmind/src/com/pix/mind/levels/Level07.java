package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level07 extends PixMindLevel {
	public String levelTitle = "Level08";
	PixMindGame game;
	private static final int nActiveColors = 2;
	public Level07(PixMindGame game) {
        super(game, 1280, 1024, 600, -2, 6, nActiveColors);
		this.game = game;
		levelNumber = 7;
	}

	@Override
	public void show() {
		super.show();
		super.setNextLevel(game.getLevel08());
		super.setActiveLevel(this);

		// platform Actors and Activator Actors List
		// Creating All Static Platforms
		float platW = 1f;
		float platH = 0.1f;
        float deltaX = -3f;

		// Active colors
		// Box2D platforms
		// Add to platform list
		// Black StaticPlatforms
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 2 + deltaX, 5, platW, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 5 + deltaX, 6, platW, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 8 + deltaX, 7, platW, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 11 + deltaX, 8, platW, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 8 + deltaX, 5, platW, platH, Color.BLACK, true));

		// Black StaticPlatforms
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 5 + deltaX, 4, platW, platH, Color.BLUE, false));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 11+ deltaX, 4, platW, platH, Color.ORANGE, false));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 14+ deltaX, 5, platW, platH, Color.RED, false));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 17+ deltaX, 6, platW, platH, Color.BLUE, false));

		// Creating All Activator
		// Box2D Activator adding to activator list
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 18 + deltaX, 7, Color.BLACK, true));
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 8 + deltaX, 8, Color.BLUE, false));
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 5 + deltaX, 5, Color.ORANGE, false));
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 11 + deltaX, 5, Color.RED, false));

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
