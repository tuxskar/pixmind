package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.actors.StaticWallActor;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level08 extends PixMindLevel {
	public String levelTitle = "LevelEigth";
	PixMindGame game;
	private static final int nActiveColors = 1;
	public Level08(PixMindGame game) {
		super(game,640, 480, 50, 1, 1, nActiveColors);
		this.game = game;
		levelNumber = 8;
	}

	@Override
	public void show() {
		super.show();
		super.setNextLevel(game.getLevel09());
		super.setActiveLevel(this);

		// platform Actors and Activator Actors List
		// Creating All Static Platforms
		float wallW = 0.1f;
		float wallH = 10;
		float platW = 1f;
		float platH = 0.1f;

		// Active colors
		// Box2D platforms
		// Add to platform list
		// Walls
		scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 0, 0, wallW, wallH));
		scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 8, 0, wallW, wallH));


		// Normal StaticPlatforms
		box2D.getPlatformList().add(
                new StaticPlatformActor(box2D.getWorld(), 1 + wallW / 2, 6, platW - wallW / 2, platH, Color.BLACK, true));

		// Creating All Activator
		// Box2D Activator adding to activator list
		box2D.getActivatorList().add(
            new PlatformActivatorActor(box2D.getWorld(), 6.5f, 5, Color.BLACK, true));

		// Add activators to Stage
		for (PlatformActivatorActor Sskin : box2D.getActivatorList()) {
			scene2D.getGroupStage().addActor(Sskin);
		}

		// Add platforms to Stage
		for (StaticPlatformActor Sskin : box2D.getPlatformList()) {
			scene2D.getGroupStage().addActor(Sskin);
		}


		// Rendering the game
//		box2D.addActivatedColor(Color.BLUE);
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
