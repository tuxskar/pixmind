package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.actors.StaticWallActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level18 extends PixMindLevel {

	

	public String levelTitle = "LevelEighteen";
	PixMindGame game;
	private static final int nActiveColors = 2;
	public Level18(PixMindGame game) {
		super(game, 800, 1100, 800, 3.5f, 11.0f, nActiveColors);
		this.game = game;
		levelNumber = 18;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		super.show();
		super.setNextLevel(game.getLevel19());
		super.setActiveLevel(this);
		// CREANDO EL NIVEL
		
					// platform Actors and Activator Actors List
						
						// Creating All Statics Platforms

							// Box2D platforms
								
								
								// plataforma fija 1
								StaticPlatform sPFix1 = new StaticPlatform(box2D.getWorld(), 2.6f, 6.0f, 
										1.4f, 0.12f);
								
								// plataforma fija 2
								StaticPlatform sPFix2 = new StaticPlatform(box2D.getWorld(), 6.1f, 6.0f, 
										1.15f, 0.12f);

								
								
								// plataforma sP11 (color 1, aparicion 1)
								StaticPlatform sP11 = new StaticPlatform(box2D.getWorld(), 4.5f, 1.0f, 
										0.8f, 0.12f);
								
								
								
								// plataforma sP21 (color 2, aparicion 1)
								StaticPlatform sP21 = new StaticPlatform(box2D.getWorld(), 4.5f, 6.0f, 
										0.3f, 0.12f);
								
								// plataforma sP22 (color 2, aparicion 2)
								StaticPlatform sP22 = new StaticPlatform(box2D.getWorld(), 2.5f, 1.0f, 
										0.2f, 0.12f);
								
								
								
								// plataforma sP31 (color 3, aparicion 1)
								StaticPlatform sP31 = new StaticPlatform(box2D.getWorld(), 1.8f, 2.2f, 
										0.6f, 0.12f);
								
							
							// Actor Platforms
								
								StaticPlatformActor sPFix1Skin = new StaticPlatformActor(sPFix1,
										Color.BLACK, true);
								StaticPlatformActor sPFix2Skin = new StaticPlatformActor(sPFix2,
										Color.BLACK, true);

								
								StaticPlatformActor sP11Skin = new StaticPlatformActor(sP11,
										Color.BLUE, false);
								StaticPlatformActor sP21Skin = new StaticPlatformActor(sP21,
										Color.RED, false);
								StaticPlatformActor sP22Skin = new StaticPlatformActor(sP22,
										Color.RED, false);
								StaticPlatformActor sP31Skin = new StaticPlatformActor(sP31,
										Color.ORANGE, false);

					
							// Add platforms to Stage
								
								scene2D.getGroupStage().addActor(sPFix1Skin);
								scene2D.getGroupStage().addActor(sPFix2Skin);
								
								scene2D.getGroupStage().addActor(sP11Skin);
								scene2D.getGroupStage().addActor(sP21Skin);
								scene2D.getGroupStage().addActor(sP22Skin);
								scene2D.getGroupStage().addActor(sP31Skin);

								
							// Add to platform list
								
								box2D.getPlatformList().add(sPFix1Skin);
								box2D.getPlatformList().add(sPFix2Skin);
								
								box2D.getPlatformList().add(sP11Skin);
								box2D.getPlatformList().add(sP21Skin);
								box2D.getPlatformList().add(sP22Skin);
								box2D.getPlatformList().add(sP31Skin);
						
						
						// Creating All Activators

							// Box2D Activator
								
								// activador 1

								// activador 1.1 (activador de plataforma 1, aparicion 1)
								PlatformActivator pA11 = new PlatformActivator(box2D.getWorld(), 3.7f, 9.0f, 0.2f);
								// activador 1.2 (activador de plataforma 1, aparicion 2)
								PlatformActivator pA12 = new PlatformActivator(box2D.getWorld(), 5.0f, 2.8f, 0.2f);
								
								
								// activador 2
								
								// activador 2.1 (activador de plataforma 2, aparicion 1)
								PlatformActivator pA21 = new PlatformActivator(box2D.getWorld(), 4.2f, 7.0f, 0.2f);
								// activador 2.2 (activador de plataforma 2, aparicion 2)
								PlatformActivator pA22 = new PlatformActivator(box2D.getWorld(), 4.3f, 4.6f, 0.2f);
								// activador 2.3 (activador de plataforma 2, aparicion 3)
								PlatformActivator pA23 = new PlatformActivator(box2D.getWorld(), 2.5f, 1.2f, 0.2f);
								
								
								// activador 3
								
								// activador 3.1 (activador de plataforma 3, aparicion 1)
								PlatformActivator pA31 = new PlatformActivator(box2D.getWorld(), 5.1f, 7.5f, 0.2f);
								// activador 3.2 (activador de plataforma 3, aparicion 2)
								PlatformActivator pA32 = new PlatformActivator(box2D.getWorld(), 1.8f, 2.4f, 0.2f);
								
								
								// activador FIN DE FASE 12
								PlatformActivator pAEnd = new PlatformActivator(box2D.getWorld(), 3.0f, 3.6f, 0.3f);
			
					
							// Actor Activator
								
								PlatformActivatorActor pA11Skin = new PlatformActivatorActor(pA11,
										Color.BLUE, false);
								PlatformActivatorActor pA12Skin = new PlatformActivatorActor(pA12,
										Color.BLUE, false);
								
								PlatformActivatorActor pA21Skin = new PlatformActivatorActor(pA21,
										Color.RED, false);
								PlatformActivatorActor pA22Skin = new PlatformActivatorActor(pA22,
										Color.RED, false);
								PlatformActivatorActor pA23Skin = new PlatformActivatorActor(pA23,
										Color.RED, false);
								
								PlatformActivatorActor pA31Skin = new PlatformActivatorActor(pA31,
										Color.ORANGE, false);
								PlatformActivatorActor pA32Skin = new PlatformActivatorActor(pA32,
										Color.ORANGE, false);

								PlatformActivatorActor pAEndSkin = new PlatformActivatorActor(pAEnd,
										Color.BLACK, true);

					
							// Add activators to Stage
								
								scene2D.getGroupStage().addActor(pA11Skin);
								scene2D.getGroupStage().addActor(pA12Skin);
								
								scene2D.getGroupStage().addActor(pA21Skin);
								scene2D.getGroupStage().addActor(pA22Skin);
								scene2D.getGroupStage().addActor(pA23Skin);
								
								scene2D.getGroupStage().addActor(pA31Skin);
								scene2D.getGroupStage().addActor(pA32Skin);
								
								scene2D.getGroupStage().addActor(pAEndSkin);
					
							// Add to activator list
								
								box2D.getActivatorList().add(pA11Skin);
								box2D.getActivatorList().add(pA12Skin);
								
								box2D.getActivatorList().add(pA21Skin);
								box2D.getActivatorList().add(pA22Skin);
								box2D.getActivatorList().add(pA23Skin);
								
								box2D.getActivatorList().add(pA31Skin);
								box2D.getActivatorList().add(pA32Skin);
								
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
