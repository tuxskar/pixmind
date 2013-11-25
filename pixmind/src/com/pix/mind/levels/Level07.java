package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.actors.StaticWallActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level07 extends PixMindLevel {

	

	public String levelTitle = "LevelTwo";
	PixMindGame game;
	private static final int nActiveColors = 1;
	public Level07(PixMindGame game) {
		super(game, 1533, 1200, 910, 1, 10f, nActiveColors);
		this.game = game;
		levelNumber = 7;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		super.show();
		super.setNextLevel(game.getLevel08());
		super.setActiveLevel(this);
		// CREANDO EL NIVEL

		// platform Actors and Activator Actors List

		// Creating All Static Platforms

		// Box2D platforms
		/*StaticPlatform sPlatform = new StaticPlatform(box2D.getWorld(), 8, 5,
				1f, 0.1f);
		StaticPlatform s2Platform = new StaticPlatform(box2D.getWorld(), 3, 2,
				1, 0.1f);
		StaticPlatform s3Platform = new StaticPlatform(box2D.getWorld(), 5, 3,
				1, 0.1f);
		StaticPlatform s4Platform = new StaticPlatform(box2D.getWorld(), 6, 4,
				1, 0.1f);
		*//*StaticPlatform s5Platform = new StaticPlatform(box2D.getWorld(), 10, 3f,
				1, 0.1f);
		StaticPlatform s6Platform = new StaticPlatform(box2D.getWorld(), 7, 2f,
				1, 0.1f);*/
	
		
		StaticPlatform s7Platform = new StaticPlatform(box2D.getWorld(), 4f,
				0.05f, 1, 0.1f);
		StaticPlatform s8Platform = new StaticPlatform(box2D.getWorld(), 1f, 9f,
				1, 0.1f);
		
		StaticPlatform s1Platform = new StaticPlatform(box2D.getWorld(), 6.5f, 1.3f,
				1, 0.1f);
		
	//	StaticPlatform s2Platform = new StaticPlatform(box2D.getWorld(), 8f, 1.5f,
	//			3, 0.1f);
		
		
		// Actor Platforms
		/*StaticPlatformActor s1Skin = new StaticPlatformActor(sPlatform,
				Color.RED, false);
		StaticPlatformActor s2Skin = new StaticPlatformActor(s2Platform,
				Color.BLUE, true);
		StaticPlatformActor s3Skin = new StaticPlatformActor(s3Platform,
				Color.GREEN, false);
		StaticPlatformActor s4Skin = new StaticPlatformActor(s4Platform,
				Color.BLACK, true);
		*//*StaticPlatformActor s5Skin = new StaticPlatformActor(s5Platform,
				Color.MAGENTA, false);
		StaticPlatformActor s6Skin = new StaticPlatformActor(s6Platform,
				Color.BLUE, false);*/
		StaticPlatformActor s7Skin = new StaticPlatformActor(s7Platform,
				Color.RED, false);
		StaticPlatformActor s8Skin = new StaticPlatformActor(s8Platform,
				Color.BLACK, true);
		StaticPlatformActor s1Skin = new StaticPlatformActor(s1Platform,
				Color.RED, false);
	//	StaticPlatformActor s2Skin = new StaticPlatformActor(s2Platform,
	//			Color.BLACK, true);

		// Add platforms to Stage

		/*scene2D.getGroupStage().addActor(s1Skin);
		scene2D.getGroupStage().addActor(s2Skin);
		scene2D.getGroupStage().addActor(s3Skin);
		scene2D.getGroupStage().addActor(s4Skin);
		*//*scene2D.getGroupStage().addActor(s5Skin);
		scene2D.getGroupStage().addActor(s6Skin);*/
		scene2D.getGroupStage().addActor(s7Skin);
		scene2D.getGroupStage().addActor(s8Skin);
		scene2D.getGroupStage().addActor(s1Skin);
		//scene2D.getGroupStage().addActor(s2Skin);
		// Add to platform list

	/*	box2D.getPlatformList().add(s1Skin);
		box2D.getPlatformList().add(s2Skin);
		box2D.getPlatformList().add(s3Skin);
		box2D.getPlatformList().add(s4Skin);
		*//*box2D.getPlatformList().add(s5Skin);
		box2D.getPlatformList().add(s6Skin);*/
		box2D.getPlatformList().add(s7Skin);
		box2D.getPlatformList().add(s8Skin);
		box2D.getPlatformList().add(s1Skin);
		//box2D.getPlatformList().add(s2Skin);
		// Creating All Activator

		// Box2D Activator

		/*PlatformActivator pActivator = new PlatformActivator(box2D.getWorld(),
				0, 5, 0.2f);
		*//*PlatformActivator p2Activator = new PlatformActivator(box2D.getWorld(),
				10, 4.7f, 0.2f);
		PlatformActivator p3Activator = new PlatformActivator(box2D.getWorld(),
				8.5f, 3.7f, 0.2f);
		PlatformActivator p4Activator = new PlatformActivator(box2D.getWorld(),
				5.5f, 2.7f, 0.2f);*/
		PlatformActivator p2Activator = new PlatformActivator(box2D.getWorld(),
				6.5f, 2.4f, 0.2f);
		PlatformActivator p5Activator = new PlatformActivator(box2D.getWorld(),
				1.7f,7f, 0.2f);
		
		PlatformActivator p6Activator = new PlatformActivator(box2D.getWorld(),
				5f,1.3f, 0.2f);
		PlatformActivator p7Activator = new PlatformActivator(box2D.getWorld(),
				4.7f,0.5f, 0.2f);
		PlatformActivator p8Activator = new PlatformActivator(box2D.getWorld(),
				3.7f,1.0f, 0.2f);
		PlatformActivator p9Activator = new PlatformActivator(box2D.getWorld(),
				4.4f,1.3f, 0.2f);
		PlatformActivator p10Activator = new PlatformActivator(box2D.getWorld(),
				5.6f,1.8f, 0.2f);
		// Actor Activator

		/*PlatformActivatorActor a1Skin = new PlatformActivatorActor(pActivator,
				Color.RED, false);
		*//*PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator,
				Color.BLACK, true);
		PlatformActivatorActor a3Skin = new PlatformActivatorActor(p3Activator,
				Color.MAGENTA, false);
		PlatformActivatorActor a4Skin = new PlatformActivatorActor(p4Activator,
				Color.BLUE, false);*/
		PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator,
				Color.BLACK, true);
		PlatformActivatorActor a5Skin = new PlatformActivatorActor(p5Activator,
				Color.RED, false);

		PlatformActivatorActor a6Skin = new PlatformActivatorActor(p6Activator,
				Color.RED, false);	
		PlatformActivatorActor a7Skin = new PlatformActivatorActor(p7Activator,
						Color.RED, false);	
		PlatformActivatorActor a8Skin = new PlatformActivatorActor(p8Activator,
								Color.RED, false);
		PlatformActivatorActor a9Skin = new PlatformActivatorActor(p9Activator,
				Color.RED, false);
		PlatformActivatorActor a10Skin = new PlatformActivatorActor(p10Activator,
				Color.RED, false);
		// Add activators to Stage

		/*scene2D.getGroupStage().addActor(a1Skin);
		*//*scene2D.getGroupStage().addActor(a2Skin);
		scene2D.getGroupStage().addActor(a3Skin);
		scene2D.getGroupStage().addActor(a4Skin);*/
		scene2D.getGroupStage().addActor(a2Skin);
		scene2D.getGroupStage().addActor(a5Skin);
		scene2D.getGroupStage().addActor(a6Skin);
		scene2D.getGroupStage().addActor(a7Skin);
		scene2D.getGroupStage().addActor(a8Skin);
		scene2D.getGroupStage().addActor(a9Skin);
		scene2D.getGroupStage().addActor(a10Skin);
		// Add to activator list

	/*	box2D.getActivatorList().add(a1Skin);
		*//*box2D.getActivatorList().add(a2Skin);
		box2D.getActivatorList().add(a3Skin);
		box2D.getActivatorList().add(a4Skin);*/
		box2D.getActivatorList().add(a2Skin);
		box2D.getActivatorList().add(a5Skin);
		box2D.getActivatorList().add(a6Skin);
		box2D.getActivatorList().add(a7Skin);
		box2D.getActivatorList().add(a8Skin);
		box2D.getActivatorList().add(a9Skin);
		box2D.getActivatorList().add(a10Skin);
		// add to stage the group of actors

		// Active colors

		// Rendering the game
//		box2D.addActivatedColor(Color.BLUE);
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
