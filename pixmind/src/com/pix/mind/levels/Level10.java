package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level10 extends PixMindLevel {

	public String levelTitle = "LevelTwo";
	PixMindGame game;
	private static final int nActiveColors = 1;

	public Level10(PixMindGame game) {
		super(game, 1333, 750, 110, 5f, 1.6f, nActiveColors);
		this.game = game;
		levelNumber = 10;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		super.show();
		super.setNextLevel(game.getLevel11());
		super.setActiveLevel(this);
		// CREANDO EL NIVEL

		// platform Actors and Activator Actors List

		// Creating All Static Platforms

		// Box2D platforms
		/*
		 * StaticPlatform sPlatform = new StaticPlatform(box2D.getWorld(), 8, 5,
		 * 1f, 0.1f); StaticPlatform s2Platform = new
		 * StaticPlatform(box2D.getWorld(), 3, 2, 1, 0.1f); StaticPlatform
		 * s3Platform = new StaticPlatform(box2D.getWorld(), 5, 3, 1, 0.1f);
		 * StaticPlatform s4Platform = new StaticPlatform(box2D.getWorld(), 6,
		 * 4, 1, 0.1f);
		 *//*
			 * StaticPlatform s5Platform = new StaticPlatform(box2D.getWorld(),
			 * 10, 3f, 1, 0.1f); StaticPlatform s6Platform = new
			 * StaticPlatform(box2D.getWorld(), 7, 2f, 1, 0.1f);
			 */
		/*StaticPlatform s7Platform = new StaticPlatform(box2D.getWorld(), 4.5f,
				0.05f, 1, 0.1f);
		StaticPlatform s8Platform = new StaticPlatform(box2D.getWorld(), 1f,
				0.05f, 1, 0.1f);*/
				
		float x1= 5;
		float x2=6.5f;
		float x3=8f;
		float w = 0.1f;
		float h = 0.1f;
		float y1 = 1, y2=2, y3=3, y4=4, y5=5;
		StaticPlatform s11Platform = new StaticPlatform(box2D.getWorld(), x1,
				y1, w, h);
		StaticPlatform s12Platform = new StaticPlatform(box2D.getWorld(), x1,
				y2, w, h);
		StaticPlatform s13Platform = new StaticPlatform(box2D.getWorld(), x1,
				y3, w, h);
		StaticPlatform s14Platform = new StaticPlatform(box2D.getWorld(), x1,
				y4, w, h);

		StaticPlatform s15Platform = new StaticPlatform(box2D.getWorld(), x1,
				y5, w, h);
		StaticPlatform s21Platform = new StaticPlatform(box2D.getWorld(), x2,
				y1, w, h);
		StaticPlatform s22Platform = new StaticPlatform(box2D.getWorld(), x2,
			y2, w, h);
		StaticPlatform s23Platform = new StaticPlatform(box2D.getWorld(), x2,
				y3, w, h);
		StaticPlatform s24Platform = new StaticPlatform(box2D.getWorld(), x2,
				 y4, w, h);
		StaticPlatform s25Platform = new StaticPlatform(box2D.getWorld(), x2,
				y5, w, h);
		StaticPlatform s31Platform = new StaticPlatform(box2D.getWorld(), x3,
				y1, w, h);
		StaticPlatform s32Platform = new StaticPlatform(box2D.getWorld(), x3,
				y2, w, h);
		StaticPlatform s33Platform = new StaticPlatform(box2D.getWorld(), x3,
			y3, w, h);
		StaticPlatform s34Platform = new StaticPlatform(box2D.getWorld(), x3,
				y4, w, h);
		StaticPlatform s35Platform = new StaticPlatform(box2D.getWorld(), x3,
				y5, w, h);

		// Actor Platforms
		/*
		 * StaticPlatformActor s1Skin = new StaticPlatformActor(sPlatform,
		 * Color.RED, false); StaticPlatformActor s2Skin = new
		 * StaticPlatformActor(s2Platform, Color.BLUE, true);
		 * StaticPlatformActor s3Skin = new StaticPlatformActor(s3Platform,
		 * Color.GREEN, false); StaticPlatformActor s4Skin = new
		 * StaticPlatformActor(s4Platform, Color.BLACK, true);
		 *//*
			 * StaticPlatformActor s5Skin = new StaticPlatformActor(s5Platform,
			 * Color.MAGENTA, false); StaticPlatformActor s6Skin = new
			 * StaticPlatformActor(s6Platform, Color.BLUE, false);
			 */
/*		StaticPlatformActor s7Skin = new StaticPlatformActor(s7Platform,
				Color.BLACK, false);
		StaticPlatformActor s8Skin = new StaticPlatformActor(s8Platform,
				Color.BLACK, true);*/

		StaticPlatformActor s11Skin = new StaticPlatformActor(s11Platform,
				Color.BLACK, true);
		StaticPlatformActor s12Skin = new StaticPlatformActor(s12Platform,
				Color.GREEN, false);
		StaticPlatformActor s13Skin = new StaticPlatformActor(s13Platform,
				Color.ORANGE, false);
		StaticPlatformActor s14Skin = new StaticPlatformActor(s14Platform,
				Color.RED, false);
		StaticPlatformActor s15Skin = new StaticPlatformActor(s15Platform,
				Color.RED, false);
		StaticPlatformActor s21Skin = new StaticPlatformActor(s21Platform,
				Color.BLUE, false);
		StaticPlatformActor s22Skin = new StaticPlatformActor(s22Platform,
				Color.RED, false);
		StaticPlatformActor s23Skin = new StaticPlatformActor(s23Platform,
				Color.RED, false);
		StaticPlatformActor s24Skin = new StaticPlatformActor(s24Platform,
				Color.BLUE, false);
		StaticPlatformActor s25Skin = new StaticPlatformActor(s25Platform,
				Color.ORANGE, false);
		StaticPlatformActor s31Skin = new StaticPlatformActor(s31Platform,
				Color.ORANGE, false);
		StaticPlatformActor s32Skin = new StaticPlatformActor(s32Platform,
				Color.GREEN, false);
		StaticPlatformActor s33Skin = new StaticPlatformActor(s33Platform,
				Color.RED, false);
		StaticPlatformActor s34Skin = new StaticPlatformActor(s34Platform,
				Color.BLUE, false);
		StaticPlatformActor s35Skin = new StaticPlatformActor(s35Platform,
				Color.ORANGE, false);

		// Add platforms to Stage

		/*
		 * scene2D.getGroupStage().addActor(s1Skin);
		 * scene2D.getGroupStage().addActor(s2Skin);
		 * scene2D.getGroupStage().addActor(s3Skin);
		 * scene2D.getGroupStage().addActor(s4Skin);
		 *//*
			 * scene2D.getGroupStage().addActor(s5Skin);
			 * scene2D.getGroupStage().addActor(s6Skin);
			 */
		/*scene2D.getGroupStage().addActor(s7Skin);
		scene2D.getGroupStage().addActor(s8Skin);
*/
		scene2D.getGroupStage().addActor(s11Skin);
		scene2D.getGroupStage().addActor(s12Skin);
		scene2D.getGroupStage().addActor(s13Skin);
		scene2D.getGroupStage().addActor(s14Skin);
		scene2D.getGroupStage().addActor(s15Skin);
		scene2D.getGroupStage().addActor(s21Skin);
		scene2D.getGroupStage().addActor(s22Skin);
		scene2D.getGroupStage().addActor(s23Skin);
		scene2D.getGroupStage().addActor(s24Skin);
		scene2D.getGroupStage().addActor(s25Skin);
		scene2D.getGroupStage().addActor(s31Skin);
		scene2D.getGroupStage().addActor(s32Skin);
		scene2D.getGroupStage().addActor(s33Skin);
		scene2D.getGroupStage().addActor(s34Skin);
		scene2D.getGroupStage().addActor(s35Skin);

		// Add to platform list

		/*
		 * box2D.getPlatformList().add(s1Skin);
		 * box2D.getPlatformList().add(s2Skin);
		 * box2D.getPlatformList().add(s3Skin);
		 * box2D.getPlatformList().add(s4Skin);
		 *//*
			 * box2D.getPlatformList().add(s5Skin);
			 * box2D.getPlatformList().add(s6Skin);
			 */
		/*box2D.getPlatformList().add(s7Skin);
		box2D.getPlatformList().add(s8Skin);*/
		
	box2D.getPlatformList().add(s11Skin);
	box2D.getPlatformList().add(s12Skin);
	box2D.getPlatformList().add(s13Skin);
	box2D.getPlatformList().add(s14Skin);
	box2D.getPlatformList().add(s15Skin);
	box2D.getPlatformList().add(s21Skin);
	box2D.getPlatformList().add(s22Skin);
	box2D.getPlatformList().add(s23Skin);
	box2D.getPlatformList().add(s24Skin);
	box2D.getPlatformList().add(s25Skin);
	box2D.getPlatformList().add(s31Skin);
	box2D.getPlatformList().add(s32Skin);
	box2D.getPlatformList().add(s33Skin);
	box2D.getPlatformList().add(s34Skin);
	box2D.getPlatformList().add(s35Skin);
	


		// Creating All Activator

		// Box2D Activator

		/*
		 * PlatformActivator pActivator = new
		 * PlatformActivator(box2D.getWorld(), 0, 5, 0.2f);
		 *//*
			 * PlatformActivator p2Activator = new
			 * PlatformActivator(box2D.getWorld(), 10, 4.7f, 0.2f);
			 * PlatformActivator p3Activator = new
			 * PlatformActivator(box2D.getWorld(), 8.5f, 3.7f, 0.2f);
			 * PlatformActivator p4Activator = new
			 * PlatformActivator(box2D.getWorld(), 5.5f, 2.7f, 0.2f);
			 */
		PlatformActivator p2Activator = new PlatformActivator(box2D.getWorld(),
				6.5f, 7f, 0.2f);
		PlatformActivator p5Activator = new PlatformActivator(box2D.getWorld(),
				9f,4.5f, 0.2f);
PlatformActivator p6Activator = new PlatformActivator(box2D.getWorld(),
				5.2f,2.5f, 0.2f);
				
PlatformActivator p7Activator = new PlatformActivator(box2D.getWorld(),
				5.7f,2.5f, 0.2f);
				
PlatformActivator p8Activator = new PlatformActivator(box2D.getWorld(),
				4,2.5f, 0.2f);
PlatformActivator p9Activator = new PlatformActivator(box2D.getWorld(),
				7.8f,4.7f, 0.2f);
PlatformActivator p10Activator = new PlatformActivator(box2D.getWorld(),
				7.2f,4.1f, 0.2f);


		// Actor Activator

		/*
		 * PlatformActivatorActor a1Skin = new
		 * PlatformActivatorActor(pActivator, Color.RED, false);
		 *//*
			 * PlatformActivatorActor a2Skin = new
			 * PlatformActivatorActor(p2Activator, Color.BLACK, true);
			 * PlatformActivatorActor a3Skin = new
			 * PlatformActivatorActor(p3Activator, Color.MAGENTA, false);
			 * PlatformActivatorActor a4Skin = new
			 * PlatformActivatorActor(p4Activator, Color.BLUE, false);
			 */
		PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator,
				Color.BLACK, true);
		PlatformActivatorActor a5Skin = new PlatformActivatorActor(p5Activator,
				Color.BLUE, false);
	PlatformActivatorActor a6Skin = new PlatformActivatorActor(p6Activator,
				Color.RED, false);
				
				
				
		PlatformActivatorActor a7Skin = new PlatformActivatorActor(p7Activator,
				Color.BLUE, false);
				PlatformActivatorActor a8Skin = new PlatformActivatorActor(p8Activator,
				Color.GREEN, false);
				PlatformActivatorActor a9Skin = new PlatformActivatorActor(p9Activator,
				Color.ORANGE, false);
				PlatformActivatorActor a10Skin = new PlatformActivatorActor(p10Activator,
				Color.RED, false);
		
						
				

		// Add activators to Stage

		/*
		 * scene2D.getGroupStage().addActor(a1Skin);
		 *//*
			 * scene2D.getGroupStage().addActor(a2Skin);
			 * scene2D.getGroupStage().addActor(a3Skin);
			 * scene2D.getGroupStage().addActor(a4Skin);
			 */
		scene2D.getGroupStage().addActor(a2Skin);
		scene2D.getGroupStage().addActor(a5Skin);
scene2D.getGroupStage().addActor(a6Skin);
scene2D.getGroupStage().addActor(a7Skin);
scene2D.getGroupStage().addActor(a8Skin);
scene2D.getGroupStage().addActor(a9Skin);
scene2D.getGroupStage().addActor(a10Skin);



		// Add to activator list

		/*
		 * box2D.getActivatorList().add(a1Skin);
		 *//*
			 * box2D.getActivatorList().add(a2Skin);
			 * box2D.getActivatorList().add(a3Skin);
			 * box2D.getActivatorList().add(a4Skin);
			 */
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
