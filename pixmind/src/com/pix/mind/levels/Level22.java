package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.actors.StaticWallActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level22 extends PixMindLevel {

	

	public String levelTitle = "LevelTwentytwo";
	PixMindGame game;
	private static final int nActiveColors = 2;
	public Level22(PixMindGame game) {
		super(game, 2000, 1300, 950, 2.0f, 10.0f, nActiveColors);
		this.game = game;
		levelNumber = 22;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		super.show();
		super.setNextLevel(game.getLevel23());
		super.setActiveLevel(this);
		// CREANDO EL NIVEL

				// platform Actors and Activator Actors List
				
				// Creating All Statics Walls
				
					/* 01 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 5.3f, 6.6f, 0.03f, 0.35f));
					
					/* 02 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 6.0f, 6.6f, 0.03f, 0.35f));
					
					/* 03 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 6.6f, 6.6f, 0.03f, 0.35f));
					
					/* 04 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 6.3f, 8.4f, 0.03f, 0.30f));
					
					/* 05 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 5.5f, 8.4f, 0.03f, 0.30f));
					
					/* 06 */ scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 4.7f, 10.4f, 0.03f, 2.3f));
				

				// Creating All Static Platforms

					// Box2D platforms
				
						//FIXED
						
							// plataforma fija 1
							StaticPlatform sPFix1 = new StaticPlatform(box2D.getWorld(), 5.3f, 6.95f, 
								0.033f, 0.01f);
							
							// plataforma fija 2
							StaticPlatform sPFix2 = new StaticPlatform(box2D.getWorld(), 6.0f, 6.95f, 
								0.033f, 0.01f);
							
							// plataforma fija 3
							StaticPlatform sPFix3 = new StaticPlatform(box2D.getWorld(), 6.6f, 6.95f, 
								0.033f, 0.01f);
							
							// plataforma fija 4
							StaticPlatform sPFix4 = new StaticPlatform(box2D.getWorld(), 6.3f, 8.7f, 
								0.033f, 0.01f);
							
							// plataforma fija 5
							StaticPlatform sPFix5 = new StaticPlatform(box2D.getWorld(), 5.5f, 8.7f, 
								0.033f, 0.01f);
							
							// plataforma fija 6
							StaticPlatform sPFix6 = new StaticPlatform(box2D.getWorld(), 3.9f, 7.3f, 
								0.5f, 0.1f);
							
							// plataforma fija 7
							StaticPlatform sPFix7 = new StaticPlatform(box2D.getWorld(), 8.0f, 6.2f, 
								0.5f, 0.1f);
							
							// plataforma fija 8
							StaticPlatform sPFix8 = new StaticPlatform(box2D.getWorld(), 5.9f, 8.2f, 
								0.25f, 0.06f);
							
							// plataforma fija 9
							StaticPlatform sPFix9 = new StaticPlatform(box2D.getWorld(), 5.1f, 8.2f, 
								0.25f, 0.06f);
							
							
						//COLOR 1
							
							// plataforma sP11 (color 1, aparicion 1)
							StaticPlatform sP11 = new StaticPlatform(box2D.getWorld(), 3.6f, 9.7f, 
									0.6f, 0.11f);
							
							
						//COLOR 3
							
							// plataforma sP31 (color 3, aparicion 1)
							StaticPlatform sP31 = new StaticPlatform(box2D.getWorld(), 8.0f, 6.0f, 
									7.0f, 0.11f);
							
							// plataforma sP32 (color 3, aparicion 1)
							StaticPlatform sP32 = new StaticPlatform(box2D.getWorld(), 3.6f, 10.9f, 
									0.6f, 0.11f);
							
							
						//COLOR 4
							
							// plataforma sP41 (color 2, aparicion 1)
							StaticPlatform sP41 = new StaticPlatform(box2D.getWorld(), 7.0f, 5.0f, 
									5.0f, 0.11f);
							
							// plataforma sP42 (color 2, aparicion 2)
							StaticPlatform sP42 = new StaticPlatform(box2D.getWorld(), 3.6f, 8.5f, 
									0.6f, 0.11f);
						

						
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
						
						StaticPlatformActor sP11Skin = new StaticPlatformActor(sP11,
								Color.BLUE, false);
						
						StaticPlatformActor sP31Skin = new StaticPlatformActor(sP31,
								Color.RED, false);
						StaticPlatformActor sP32Skin = new StaticPlatformActor(sP32,
								Color.RED, false);
						
						StaticPlatformActor sP41Skin = new StaticPlatformActor(sP41,
								Color.GREEN, false);
						StaticPlatformActor sP42Skin = new StaticPlatformActor(sP42,
								Color.GREEN, false);

						
			
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
										
						scene2D.getGroupStage().addActor(sP11Skin);
						
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
						
						box2D.getPlatformList().add(sP11Skin);
						
						box2D.getPlatformList().add(sP31Skin);
						box2D.getPlatformList().add(sP32Skin);
						
						box2D.getPlatformList().add(sP41Skin);
						box2D.getPlatformList().add(sP42Skin);



						
						
						
				// Creating All Activator

					// Box2D Activator
						
						// activador 1.X (activador de plataforma 1, apariciones de la 1 a la 7)
						PlatformActivator pA11 = new PlatformActivator(box2D.getWorld(),  14.0f, 7.0f, 0.3f);
						
						
						// activador 3.X (activador de plataforma 3, apariciones 1 y 2)
						PlatformActivator pA31 = new PlatformActivator(box2D.getWorld(), 3.8f, 10.3f, 0.2f);
						
						
						// activador 4.X (activador de plataforma 4, apariciones 1 y 2)
						PlatformActivator pA41 = new PlatformActivator(box2D.getWorld(), 2.0f, 9.0f, 0.2f);
		
						PlatformActivator pA42 = new PlatformActivator(box2D.getWorld(), 4.4f, 6.7f, 0.2f);
						
						PlatformActivator pA43 = new PlatformActivator(box2D.getWorld(), 5.6f, 6.7f, 0.2f);
						
						PlatformActivator pA44 = new PlatformActivator(box2D.getWorld(), 6.4f, 6.7f, 0.2f);
						
						PlatformActivator pA45 = new PlatformActivator(box2D.getWorld(), 7.7f, 7.8f, 0.2f);
						
						// activador FIN DE FASE 23
						PlatformActivator pAEnd = new PlatformActivator(box2D.getWorld(),  3.6f, 12.5f, 0.5f);
			
						
			
					// Actor Activator
						
						PlatformActivatorActor pA11Skin = new PlatformActivatorActor(pA11,
								Color.BLUE, false);
						
						PlatformActivatorActor pA31Skin = new PlatformActivatorActor(pA31,
								Color.RED, false);
						
						PlatformActivatorActor pA41Skin = new PlatformActivatorActor(pA41,
								Color.GREEN, false);
						PlatformActivatorActor pA42Skin = new PlatformActivatorActor(pA42,
								Color.GREEN, false);
						PlatformActivatorActor pA43Skin = new PlatformActivatorActor(pA43,
								Color.GREEN, false);
						PlatformActivatorActor pA44Skin = new PlatformActivatorActor(pA44,
								Color.GREEN, false);
						PlatformActivatorActor pA45Skin = new PlatformActivatorActor(pA45,
								Color.GREEN, false);
						
						PlatformActivatorActor pAEndSkin = new PlatformActivatorActor(pAEnd,
								Color.BLACK, true);
			
			
						
					// Add activators to Stage
						
						scene2D.getGroupStage().addActor(pA11Skin);
						
						scene2D.getGroupStage().addActor(pA31Skin);
						
						scene2D.getGroupStage().addActor(pA41Skin);
						scene2D.getGroupStage().addActor(pA42Skin);
						scene2D.getGroupStage().addActor(pA43Skin);
						scene2D.getGroupStage().addActor(pA44Skin);
						scene2D.getGroupStage().addActor(pA45Skin);
						
						scene2D.getGroupStage().addActor(pAEndSkin);
			
						
			
					// Add to activator list
						
						box2D.getActivatorList().add(pA11Skin);
						
						box2D.getActivatorList().add(pA31Skin);
						
						box2D.getActivatorList().add(pA41Skin);
						box2D.getActivatorList().add(pA42Skin);
						box2D.getActivatorList().add(pA43Skin);
						box2D.getActivatorList().add(pA44Skin);
						box2D.getActivatorList().add(pA45Skin);
						
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
