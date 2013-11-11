package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.actors.StaticWallActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;


public class Level23 extends PixMindLevel {

	
	/* JUAN: LEVEL 23*/
	public String levelTitle = "LevelTwentythree";
	PixMindGame game;
	private static final int nActiveColors = 4;
	public Level23(PixMindGame game) {
		super(game, 3600, 2600, 700, 3.0f, 8.0f, nActiveColors);
		this.game = game;
		levelNumber = 23;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		super.show();
		super.setNextLevel(game.getLevel24());
		super.setActiveLevel(this);
		// CREANDO EL NIVEL

		// platform Actors and Activator Actors List
		
		// Creating All Statics Walls
		
			/* 01 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 5.0f, 6.6f, 0.03f, 0.35f));
			
			/* 02 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 5.0f, 10.0f, 0.03f, 1.8f));
			
			/* 03 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 7.0f, 6.6f, 0.03f, 0.35f));
			
			/* 04 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 7.0f, 8.4f, 0.03f, 0.30f));
			
			/* 05 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 8.0f, 6.8f, 0.03f, 0.55f));
			
			/* 06 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 8.0f, 9.4f, 0.03f, 0.3f));
			
			/* 07 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 8.6f, 7.95f, 0.03f, 1.75f));
			
			/* 08 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 9.6f, 7.6f, 0.03f, 0.3f));
			
			/* 09 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 14.0f, 13.1f, 0.03f, 1.0f));
			
			/* 10 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 18.6f, 7.9f, 0.03f, 1.7f));
			
			/* 11 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 18.8f, 5.7f, 0.03f, 0.17f));


		// Creating All Static Platforms

			// Box2D platforms
		
				//FIXED
				
					// plataforma fija 1
					StaticPlatform sPFix1 = new StaticPlatform(box2D.getWorld(), 5.0f, 7.0f, 
						0.03f, 0.1f);
					
					// plataforma fija 2
					StaticPlatform sPFix2 = new StaticPlatform(box2D.getWorld(), 7.0f, 7.0f, 
						0.03f, 0.1f);
					
					// plataforma fija 3
					StaticPlatform sPFix3 = new StaticPlatform(box2D.getWorld(), 8.0f, 7.4f, 
						0.03f, 0.1f);
					
					// plataforma fija 4
					StaticPlatform sPFix4 = new StaticPlatform(box2D.getWorld(), 7.0f, 8.6f, 
						0.03f, 0.1f);
					
					// plataforma fija 5
					StaticPlatform sPFix5 = new StaticPlatform(box2D.getWorld(), 8.0f, 9.8f, 
						0.03f, 0.1f);
					
					// plataforma fija 6
					StaticPlatform sPFix6 = new StaticPlatform(box2D.getWorld(), 8.6f, 9.8f, 
						0.03f, 0.1f);
					
					// plataforma fija 7
					StaticPlatform sPFix7 = new StaticPlatform(box2D.getWorld(), 14.6f, 9.8f, 
							1.7f, 0.11f);
					
					// plataforma fija 8
					StaticPlatform sPFix8 = new StaticPlatform(box2D.getWorld(), 18.2f, 4.2f, 
						0.8f, 0.07f);
					
					// plataforma fija 9
					StaticPlatform sPFix9 = new StaticPlatform(box2D.getWorld(), 18.65f, 7.4f, 
						0.05f, 0.05f);
					
					// plataforma fija 10
					StaticPlatform sPFix10 = new StaticPlatform(box2D.getWorld(), 18.65f, 8.6f, 
						0.05f, 0.05f);
					
					// plataforma fija 11
					StaticPlatform sPFix11 = new StaticPlatform(box2D.getWorld(), 9.6f, 7.8f, 
						0.03f, 0.1f);
					
					
				//COLOR 1
					
					// plataforma sP11 (color 1, aparicion 1)
					StaticPlatform sP11 = new StaticPlatform(box2D.getWorld(), 10.8f, 9.8f, 
							1.5f, 0.11f);
					
					// plataforma sP12 (color 1, aparicion 2)
					StaticPlatform sP12 = new StaticPlatform(box2D.getWorld(), 18.6f, 9.8f, 
							1.5f, 0.11f);
					
				//COLOR 2
					
					// plataforma sP21 (color 2, aparicion 1)
					StaticPlatform sP21 = new StaticPlatform(box2D.getWorld(), 11.6f, 10.8f, 
							1.0f, 0.11f);
					
					// plataforma sP22 (color 2, aparicion 2)
					StaticPlatform sP22 = new StaticPlatform(box2D.getWorld(), 21.6f, 9.8f, 
							1.0f, 0.11f);
					
					// plataforma sP23 (color 2, aparicion 3)
					StaticPlatform sP23 = new StaticPlatform(box2D.getWorld(), 19.2f, 5.0f, 
							0.8f, 0.11f);
					
				//COLOR 3
					
					// plataforma sP31 (color 3, aparicion 1)
					StaticPlatform sP31 = new StaticPlatform(box2D.getWorld(), 8.0f, 6.0f, 
							6.0f, 0.12f);
					
					// plataforma sP32 (color 3, aparicion 2)
					StaticPlatform sP32 = new StaticPlatform(box2D.getWorld(), 19.7f, 6.0f, 
							6.0f, 0.12f);
					
				//COLOR 4
					
					// plataforma sP41 (color 4, aparicion 1)
					StaticPlatform sP41 = new StaticPlatform(box2D.getWorld(), 12.6f, 11.9f, 
							1.5f, 0.11f);
					
					// plataforma sP42 (color 4, aparicion 2)
					StaticPlatform sP42 = new StaticPlatform(box2D.getWorld(), 23.9f, 9.8f, 
							0.8f, 0.11f);
				

				
				
			// Actor Platforms
				
				StaticPlatformActor sPFix1Skin = new StaticPlatformActor(sPFix1,
						Color.BLACK, true);
				StaticPlatformActor sPFix2Skin = new StaticPlatformActor(sPFix2,
						Color.BLACK, true);
				StaticPlatformActor sPFix3Skin = new StaticPlatformActor(sPFix3,
						Color.BLACK, true);
				StaticPlatformActor sPFix4Skin = new StaticPlatformActor(sPFix4,
						Color.BLACK, true);
				StaticPlatformActor sPFix5Skin = new StaticPlatformActor(sPFix5,
						Color.BLACK, true);
				StaticPlatformActor sPFix6Skin = new StaticPlatformActor(sPFix6,
						Color.BLACK, true);
				StaticPlatformActor sPFix7Skin = new StaticPlatformActor(sPFix7,
						Color.BLACK, true);
				StaticPlatformActor sPFix8Skin = new StaticPlatformActor(sPFix8,
						Color.BLACK, true);
				StaticPlatformActor sPFix9Skin = new StaticPlatformActor(sPFix9,
						Color.BLACK, true);
				StaticPlatformActor sPFix10Skin = new StaticPlatformActor(sPFix10,
						Color.BLACK, true);
				StaticPlatformActor sPFix11Skin = new StaticPlatformActor(sPFix11,
						Color.BLACK, true);
				
				
				StaticPlatformActor sP11Skin = new StaticPlatformActor(sP11,
						Color.BLUE, true);
				StaticPlatformActor sP12Skin = new StaticPlatformActor(sP12,
						Color.BLUE, true);
				
				
				StaticPlatformActor sP21Skin = new StaticPlatformActor(sP21,
						Color.RED, true);
				StaticPlatformActor sP22Skin = new StaticPlatformActor(sP22,
						Color.RED, true);
				StaticPlatformActor sP23Skin = new StaticPlatformActor(sP23,
						Color.RED, true);
				
				
				StaticPlatformActor sP31Skin = new StaticPlatformActor(sP31,
						Color.RED, true);
				StaticPlatformActor sP32Skin = new StaticPlatformActor(sP32,
						Color.RED, true);
				
				
				StaticPlatformActor sP41Skin = new StaticPlatformActor(sP41,
						Color.GREEN, true);
				StaticPlatformActor sP42Skin = new StaticPlatformActor(sP42,
						Color.GREEN, true);

			
				
	
			// Add platforms to Stage
				
				scene2D.getGroupStage().addActor(sPFix1Skin);
				scene2D.getGroupStage().addActor(sPFix2Skin);
				scene2D.getGroupStage().addActor(sPFix3Skin);
				scene2D.getGroupStage().addActor(sPFix4Skin);
				scene2D.getGroupStage().addActor(sPFix5Skin);
				scene2D.getGroupStage().addActor(sPFix6Skin);
				scene2D.getGroupStage().addActor(sPFix7Skin);
				scene2D.getGroupStage().addActor(sPFix8Skin);
				scene2D.getGroupStage().addActor(sPFix9Skin);
				scene2D.getGroupStage().addActor(sPFix10Skin);
				scene2D.getGroupStage().addActor(sPFix11Skin);
				
				
				scene2D.getGroupStage().addActor(sP11Skin);
				scene2D.getGroupStage().addActor(sP12Skin);
				
				
				scene2D.getGroupStage().addActor(sP21Skin);
				scene2D.getGroupStage().addActor(sP22Skin);
				scene2D.getGroupStage().addActor(sP23Skin);

				
				scene2D.getGroupStage().addActor(sP31Skin);
				scene2D.getGroupStage().addActor(sP32Skin);
				
				
				scene2D.getGroupStage().addActor(sP41Skin);
				scene2D.getGroupStage().addActor(sP42Skin);
	
	
	
			// Add to platform list
				
				box2D.getPlatformList().add(sPFix1Skin);
				box2D.getPlatformList().add(sPFix2Skin);
				box2D.getPlatformList().add(sPFix3Skin);
				box2D.getPlatformList().add(sPFix4Skin);
				box2D.getPlatformList().add(sPFix5Skin);
				box2D.getPlatformList().add(sPFix6Skin);
				box2D.getPlatformList().add(sPFix7Skin);
				box2D.getPlatformList().add(sPFix8Skin);
				box2D.getPlatformList().add(sPFix9Skin);
				box2D.getPlatformList().add(sPFix10Skin);
				box2D.getPlatformList().add(sPFix11Skin);
				
				
				box2D.getPlatformList().add(sP11Skin);
				box2D.getPlatformList().add(sP12Skin);
			
				
				box2D.getPlatformList().add(sP21Skin);
				box2D.getPlatformList().add(sP22Skin);
				box2D.getPlatformList().add(sP23Skin);
				
				
				box2D.getPlatformList().add(sP31Skin);
				box2D.getPlatformList().add(sP32Skin);
				
				
				box2D.getPlatformList().add(sP41Skin);
				box2D.getPlatformList().add(sP42Skin);



				
				
				
				

		// Creating All Activator

			// Box2D Activator
	
	
			// Actor Activator
	
	
			// Add activators to Stage
	
	
			// Add to activator list
				
				
				


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
