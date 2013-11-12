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
		super(game, 2600, 1600, 1200, 3.0f, 13.0f, nActiveColors);
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
			
			/* 09 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 14.0f, 12.8f, 0.03f, 1.0f));
			
			/* 10 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 18.6f, 7.65f, 0.03f, 1.5f));
			
			/* 11 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 18.8f, 5.7f, 0.03f, 0.17f));
			
			/* 12 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 10.1f, 7.6f, 0.03f, 0.3f));


		// Creating All Static Platforms

			// Box2D platforms
		
				//FIXED
				
					// plataforma fija 1
					StaticPlatform sPFix1 = new StaticPlatform(box2D.getWorld(), 5.0f, 6.95f, 
						0.033f, 0.01f);
					
					// plataforma fija 2
					StaticPlatform sPFix2 = new StaticPlatform(box2D.getWorld(), 7.0f, 6.95f, 
						0.033f, 0.01f);
					
					// plataforma fija 3
					StaticPlatform sPFix3 = new StaticPlatform(box2D.getWorld(), 8.0f, 7.35f, 
						0.033f, 0.01f);
					
					// plataforma fija 4
					StaticPlatform sPFix4 = new StaticPlatform(box2D.getWorld(), 7.0f, 8.71f, 
						0.033f, 0.01f);
					
					// plataforma fija 5
					StaticPlatform sPFix5 = new StaticPlatform(box2D.getWorld(), 8.0f, 9.71f, 
						0.033f, 0.01f);
					
					// plataforma fija 6
					StaticPlatform sPFix6 = new StaticPlatform(box2D.getWorld(), 8.6f, 9.71f, 
						0.033f, 0.01f);
					
					// plataforma fija 7
					StaticPlatform sPFix7 = new StaticPlatform(box2D.getWorld(), 14.7f, 9.8f, 
							2.35f, 0.11f);
					
					// plataforma fija 8
					StaticPlatform sPFix8 = new StaticPlatform(box2D.getWorld(), 18.2f, 3.6f, 
						0.8f, 0.07f);
					
					// plataforma fija 9
					StaticPlatform sPFix9 = new StaticPlatform(box2D.getWorld(), 18.65f, 7.0f, 
						0.05f, 0.05f);
					
					// plataforma fija 10
					StaticPlatform sPFix10 = new StaticPlatform(box2D.getWorld(), 18.65f, 8.0f, 
						0.05f, 0.05f);
					
					// plataforma fija 11
					StaticPlatform sPFix11 = new StaticPlatform(box2D.getWorld(), 9.6f, 7.8f, 
						0.03f, 0.1f);
					
					// plataforma fija 12
					StaticPlatform sPFix12 = new StaticPlatform(box2D.getWorld(), 18.6f, 9.15f, 
						0.032f, 0.01f);
					
					// plataforma fija 13
					StaticPlatform sPFix13 = new StaticPlatform(box2D.getWorld(), 10.1f, 7.8f, 
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
					StaticPlatform sP21 = new StaticPlatform(box2D.getWorld(), 11.9f, 10.9f, 
							1.0f, 0.11f);
					
					// plataforma sP22 (color 2, aparicion 2)
					StaticPlatform sP22 = new StaticPlatform(box2D.getWorld(), 21.6f, 9.8f, 
							1.0f, 0.11f);
					
					// plataforma sP23 (color 2, aparicion 3)
					StaticPlatform sP23 = new StaticPlatform(box2D.getWorld(), 19.3f, 4.75f, 
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
					StaticPlatform sP41 = new StaticPlatform(box2D.getWorld(), 12.6f, 11.7f, 
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
				StaticPlatformActor sPFix12Skin = new StaticPlatformActor(sPFix12,
						Color.BLACK, true);
				StaticPlatformActor sPFix13Skin = new StaticPlatformActor(sPFix13,
						Color.BLACK, true);
				
				
				StaticPlatformActor sP11Skin = new StaticPlatformActor(sP11,
						Color.BLUE, false);
				StaticPlatformActor sP12Skin = new StaticPlatformActor(sP12,
						Color.BLUE, false);
				
				
				StaticPlatformActor sP21Skin = new StaticPlatformActor(sP21,
						Color.ORANGE, false);
				StaticPlatformActor sP22Skin = new StaticPlatformActor(sP22,
						Color.ORANGE, false);
				StaticPlatformActor sP23Skin = new StaticPlatformActor(sP23,
						Color.ORANGE, false);
				
				
				StaticPlatformActor sP31Skin = new StaticPlatformActor(sP31,
						Color.RED, false);
				StaticPlatformActor sP32Skin = new StaticPlatformActor(sP32,
						Color.RED, false);
				
				
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
				scene2D.getGroupStage().addActor(sPFix12Skin);
				scene2D.getGroupStage().addActor(sPFix13Skin);
				
				
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
				box2D.getPlatformList().add(sPFix12Skin);
				box2D.getPlatformList().add(sPFix13Skin);
				
				
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
				
				// activador 1.X (activador de plataforma 1, apariciones de la 1 a la 7)
				PlatformActivator pA11 = new PlatformActivator(box2D.getWorld(),  5.5f, 6.4f, 0.13f);
				
				
				// activador 2.X (activador de plataforma 2, apariciones de la 1 a la 3)
				PlatformActivator pA21 = new PlatformActivator(box2D.getWorld(), 18.0f, 4.5f, 0.2f);
				
				PlatformActivator pA22 = new PlatformActivator(box2D.getWorld(), 18.95f, 6.0f, 0.11f);
				
				PlatformActivator pA23 = new PlatformActivator(box2D.getWorld(), 19.9f, 6.0f, 0.11f);
				
				
				// activador 3.X (activador de plataforma 3, apariciones 1 y 2)
				PlatformActivator pA31 = new PlatformActivator(box2D.getWorld(), 3.0f, 9.5f, 0.35f);
				
				PlatformActivator pA32 = new PlatformActivator(box2D.getWorld(), 4.5f, 8.8f, 0.2f);
				
				PlatformActivator pA33 = new PlatformActivator(box2D.getWorld(), 5.46f, 6.77f, 0.185f);
				
				PlatformActivator pA34 = new PlatformActivator(box2D.getWorld(), 8.40f, 10.4f, 0.2f);
				
				PlatformActivator pA35 = new PlatformActivator(box2D.getWorld(), 9.3f, 7.6f, 0.20f);
				
				PlatformActivator pA36 = new PlatformActivator(box2D.getWorld(), 9.85f, 7.5f, 0.15f);
				
				PlatformActivator pA37 = new PlatformActivator(box2D.getWorld(), 17.6f, 7.0f, 0.30f);
				
				PlatformActivator pA38 = new PlatformActivator(box2D.getWorld(), 19.55f, 6.7f, 0.20f);
				
				PlatformActivator pA39 = new PlatformActivator(box2D.getWorld(), 10.4f, 7.6f, 0.20f);
				
				
				// activador 4.X (activador de plataforma 4, apariciones 1 y 2)
				PlatformActivator pA41 = new PlatformActivator(box2D.getWorld(), 12.9f, 12.5f, 0.25f);
				
				// activador FIN DE FASE 23
				PlatformActivator pAEnd = new PlatformActivator(box2D.getWorld(), 25.5f, 10.8f, 1.0f);
	
				
	
			// Actor Activator
				
				PlatformActivatorActor pA11Skin = new PlatformActivatorActor(pA11,
						Color.BLUE, false);
				
				PlatformActivatorActor pA21Skin = new PlatformActivatorActor(pA21,
						Color.ORANGE, false);
				PlatformActivatorActor pA22Skin = new PlatformActivatorActor(pA22,
						Color.ORANGE, false);
				PlatformActivatorActor pA23Skin = new PlatformActivatorActor(pA23,
						Color.ORANGE, false);
				
				PlatformActivatorActor pA31Skin = new PlatformActivatorActor(pA31,
						Color.RED, false);
				PlatformActivatorActor pA32Skin = new PlatformActivatorActor(pA32,
						Color.RED, false);
				PlatformActivatorActor pA33Skin = new PlatformActivatorActor(pA33,
						Color.RED, false);
				PlatformActivatorActor pA34Skin = new PlatformActivatorActor(pA34,
						Color.RED, false);
				PlatformActivatorActor pA35Skin = new PlatformActivatorActor(pA35,
						Color.RED, false);
				PlatformActivatorActor pA36Skin = new PlatformActivatorActor(pA36,
						Color.RED, false);
				PlatformActivatorActor pA37Skin = new PlatformActivatorActor(pA37,
						Color.RED, false);
				PlatformActivatorActor pA38Skin = new PlatformActivatorActor(pA38,
						Color.RED, false);
				PlatformActivatorActor pA39Skin = new PlatformActivatorActor(pA39,
						Color.RED, false);
				
				PlatformActivatorActor pA41Skin = new PlatformActivatorActor(pA41,
						Color.GREEN, false);
				
				PlatformActivatorActor pAEndSkin = new PlatformActivatorActor(pAEnd,
						Color.BLACK, true);
	
	
				
			// Add activators to Stage
				
				scene2D.getGroupStage().addActor(pA11Skin);
				
				scene2D.getGroupStage().addActor(pA21Skin);
				scene2D.getGroupStage().addActor(pA22Skin);
				scene2D.getGroupStage().addActor(pA23Skin);
				
				scene2D.getGroupStage().addActor(pA31Skin);
				scene2D.getGroupStage().addActor(pA32Skin);
				scene2D.getGroupStage().addActor(pA33Skin);
				scene2D.getGroupStage().addActor(pA34Skin);
				scene2D.getGroupStage().addActor(pA35Skin);
				scene2D.getGroupStage().addActor(pA36Skin);
				scene2D.getGroupStage().addActor(pA37Skin);
				scene2D.getGroupStage().addActor(pA38Skin);
				scene2D.getGroupStage().addActor(pA39Skin);
				
				scene2D.getGroupStage().addActor(pA41Skin);
				
				scene2D.getGroupStage().addActor(pAEndSkin);
	
				
	
			// Add to activator list
				
				box2D.getActivatorList().add(pA11Skin);
				
				box2D.getActivatorList().add(pA21Skin);
				box2D.getActivatorList().add(pA22Skin);
				box2D.getActivatorList().add(pA23Skin);
				
				box2D.getActivatorList().add(pA31Skin);
				box2D.getActivatorList().add(pA32Skin);
				box2D.getActivatorList().add(pA33Skin);
				box2D.getActivatorList().add(pA34Skin);
				box2D.getActivatorList().add(pA35Skin);
				box2D.getActivatorList().add(pA36Skin);
				box2D.getActivatorList().add(pA37Skin);
				box2D.getActivatorList().add(pA38Skin);
				box2D.getActivatorList().add(pA39Skin);
				
				box2D.getActivatorList().add(pA41Skin);
				
				box2D.getActivatorList().add(pAEndSkin);
				
				


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
