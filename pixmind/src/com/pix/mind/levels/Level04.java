package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level04 extends PixMindLevel {

	public String levelTitle = "LevelTwo";
	PixMindGame game;
	private static final int nActiveColors = 1;

	public Level04(PixMindGame game) {
		super(game,1000 , 750, 500, 1, 5, nActiveColors);
		this.game = game;
		levelNumber = 4;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		super.show();
		super.setNextLevel(game.getLevel05());
		super.setActiveLevel(this);

		// CREANDO EL NIVEL

		// platform Actors and Activator Actors List

		// Creating All Static Platforms

		// Box2D platforms
		StaticPlatform sPlatform = new StaticPlatform(box2D.getWorld(), 1f,
				3.5f, 1f, 0.1f);
		StaticPlatform s2Platform = new StaticPlatform(box2D.getWorld(), 9f,
				3.5f, 1, 0.1f);
		StaticPlatform s3Platform = new StaticPlatform(box2D.getWorld(), 4f,
				4.5f, 1, 0.1f);
		// Actor Platforms
		StaticPlatformActor s1Skin = new StaticPlatformActor(sPlatform,
				Color.BLACK, true);
		StaticPlatformActor s2Skin = new StaticPlatformActor(s2Platform,
				Color.RED, false);
		StaticPlatformActor s3Skin = new StaticPlatformActor(s2Platform,
				Color.RED, false);
		// Add platforms to Stage

		scene2D.getGroupStage().addActor(s1Skin);
		scene2D.getGroupStage().addActor(s2Skin);
		scene2D.getGroupStage().addActor(s3Skin);

		// Add to platform list

		box2D.getPlatformList().add(s1Skin);
		box2D.getPlatformList().add(s2Skin);
		box2D.getPlatformList().add(s3Skin);
		// Creating All Activator

		// Box2D Activator

		PlatformActivator pActivator = new PlatformActivator(box2D.getWorld(),
				0.7f, 1.5f, 0.2f);
		PlatformActivator p2Activator = new PlatformActivator(box2D.getWorld(),
				9, 5.3f, 0.2f);

		// Actor Activator

		PlatformActivatorActor a1Skin = new PlatformActivatorActor(pActivator,
				Color.RED, false);
		PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator,
				Color.BLACK, true);

		// Add activators to Stage

		scene2D.getGroupStage().addActor(a1Skin);
		scene2D.getGroupStage().addActor(a2Skin);
		// Add to activator list

		box2D.getActivatorList().add(a1Skin);
		box2D.getActivatorList().add(a2Skin);

		// add to stage the group of actors

		// Active colors

		// Rendering the game
		// box2D.addActivatedColor(Color.BLUE);
		worldRenderer = new PixMindWorldRenderer(scene2D, box2D, gui);

	}

	@Override
	public void render(float delta) {
		super.render(delta);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pix.mind.levels.PixMindLevel#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pix.mind.levels.PixMindLevel#hide()
	 */
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		super.hide();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pix.mind.levels.PixMindLevel#pause()
	 */
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pix.mind.levels.PixMindLevel#resume()
	 */
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		super.resume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pix.mind.levels.PixMindLevel#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
}
