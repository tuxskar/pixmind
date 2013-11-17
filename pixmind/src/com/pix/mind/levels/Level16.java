package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level16 extends PixMindLevel {
	public String levelTitle = "Level16";
	PixMindGame game;
	private static final int nActiveColors = 2;

	public Level16(PixMindGame game) {
		super(game, 700, 910, 900, 3, 6, nActiveColors);
		this.game = game;
		levelNumber = 16;
	}

	@Override
	public void show() {

		super.show();
		super.setNextLevel(game.getLevel14());
		super.setActiveLevel(this);
		// platform Actors and Activator Actors List
		// Creating All Static Platforms
		float platW = 1f;
		float platH = 0.1f;

        float deltaX = -2;
        float deltaY = -2;

		// Box2D platforms
		// Add to platform list
		// Walls
		//scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 0, wallH, wallW, wallH));
		//scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 4, wallH + wallH / 4, wallW, 3 * wallH / 4));
		//scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 8, wallH, wallW, wallH));

		// Normal (black) StaticPlatforms
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 7 + deltaX, 4f + deltaY, platW/2, platH, Color.BLACK, true));
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 3 + deltaX, 4f + deltaY, platW/2, platH, Color.BLACK, true));
        
        // Coloured StaticPlatforms
        // 3 center upper
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 5 + deltaX, 7 + deltaY, platW, platH, Color.BLUE, true));
        // 3 right
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 7 + deltaX, 6 + deltaY, platW, platH, Color.BLUE, true));
        // 3 center bottom
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 5f + deltaX, 3 + deltaY, platW, platH, Color.BLUE, true));
        // 1 center up
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 4f + deltaX, 8 + deltaY, platW/2, platH, Color.RED, false));
        // 1 right
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 9f + deltaX, 5 + deltaY, platW, platH, Color.RED, false));
        // 4 left
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 3 + deltaX, 6 + deltaY, platW, platH, Color.GREEN, true));
        // 2 left
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 1 + deltaX, 5 + deltaY, platW, platH, Color.ORANGE, false));

		// Box2D Activator adding to activator list
        // final activator
        box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 5f + deltaX,  6 + deltaY, Color.BLACK, true));
        //// 4 top
        //box2D.getActivatorList().add(
            //new PlatformActivatorActor(box2D.getWorld(), 5 + deltaX,  10 + deltaY, Color.GREEN, false));
        // 3 top
        box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 5 + deltaX, 10 + deltaY, Color.BLUE, true));
        // 3 right
        box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 9.5f + deltaX, 6 + deltaY, Color.BLUE, true));
        // 1 bottom
        box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 6 + deltaX, 4 + deltaY, Color.RED, false));
        // 2 left
        box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 0.5f + deltaX,  7 + deltaY, Color.ORANGE, false));

		// Add platforms to Stage
		for (StaticPlatformActor Sskin : box2D.getPlatformList()) {
			scene2D.getGroupStage().addActor(Sskin);
		}

		// Creating All Activator


		// Add activators to Stage
		for (PlatformActivatorActor Sskin : box2D.getActivatorList()) {
			scene2D.getGroupStage().addActor(Sskin);
		}
		// Active colors
		box2D.addActivatedColor(Color.GREEN);
		box2D.addActivatedColor(Color.BLUE);
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
