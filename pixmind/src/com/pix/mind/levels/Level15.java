package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level15 extends PixMindLevel {

	
	/* JUAN: LEVEL 15*/
	public String levelTitle = "LevelFifteen";
	PixMindGame game;
	private static final int nActiveColors = 1;
	public Level15(PixMindGame game) {
		super(game, 1280, 1024, 480, 4.2f, 5.0f, nActiveColors);
		this.game = game;
		levelNumber = 15;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		super.show();
		super.setNextLevel(game.getLevel16());
		super.setActiveLevel(this);
		// CREANDO EL NIVEL

		// Creating All STATIC PLATFORMS

			// Box2D platforms

				// plataforma INIT
				StaticPlatform sPInit = new StaticPlatform(box2D.getWorld(), 4.0f,
						4.7f, 1.5f, 0.1f);

				// plataforma fija 1
				StaticPlatform sPFix1 = new StaticPlatform(box2D.getWorld(), 3.0f,
						5.9f, 0.4f, 0.1f);

				// plataforma fija 2
				StaticPlatform sPFix2 = new StaticPlatform(box2D.getWorld(), 2.2f,
						7.0f, 0.4f, 0.1f);
				
				// plataforma sP11 (color 1, aparicion 1)
				StaticPlatform sP11 = new StaticPlatform(box2D.getWorld(), 0.2f, 
						2.4f, 1.0f, 0.1f);
				
				// plataforma sP21 (color 2, aparicion 1)
				StaticPlatform sP21 = new StaticPlatform(box2D.getWorld(), 2.8f, 
						1.5f, 1.0f, 0.1f);
				
				// plataforma sP12 (color 1, aparicion 2)
				StaticPlatform sP12 = new StaticPlatform(box2D.getWorld(), 5.1f, 
						2.5f, 1.8f, 0.1f);
				
				// plataforma sP22 (color 2, aparicion 2)
				StaticPlatform sP22 = new StaticPlatform(box2D.getWorld(), 8.5f, 
						3.4f, 1.5f, 0.1f);
				
				// plataforma fija 3
				StaticPlatform sPFix3 = new StaticPlatform(box2D.getWorld(), 10.2f,
						4.8f, 1.1f, 0.1f);
				
				// plataforma sP13 (color 1, aparicion 3)
				StaticPlatform sP13 = new StaticPlatform(box2D.getWorld(), 9.5f, 
						5.8f, 1.1f, 0.1f);
				
				// plataforma sP23 (color 2, aparicion 3)
				StaticPlatform sP23 = new StaticPlatform(box2D.getWorld(), 8.0f, 
						7.0f, 0.9f, 0.1f);

			// Actor Platforms
				StaticPlatformActor sPInitSkin = new StaticPlatformActor(sPInit,
						Color.BLACK, true);
				StaticPlatformActor sPFix1Skin = new StaticPlatformActor(sPFix1,
						Color.BLACK, true);
				StaticPlatformActor sPFix2Skin = new StaticPlatformActor(sPFix2,
						Color.BLACK, true);
				StaticPlatformActor sP11Skin = new StaticPlatformActor(sP11,
						Color.BLUE, false);
				StaticPlatformActor sP12Skin = new StaticPlatformActor(sP12,
						Color.BLUE, false);
				StaticPlatformActor sP21Skin = new StaticPlatformActor(sP21, 
						Color.RED, false);
				StaticPlatformActor sP22Skin = new StaticPlatformActor(sP22, 
						Color.RED, false);
				StaticPlatformActor sPFix3Skin = new StaticPlatformActor(sPFix3,
						Color.BLACK, true);
				StaticPlatformActor sP13Skin = new StaticPlatformActor(sP13,
						Color.BLUE, false);
				StaticPlatformActor sP23Skin = new StaticPlatformActor(sP23, 
						Color.RED, false);
				
			// Add platforms to Stage
				scene2D.getGroupStage().addActor(sPInitSkin);
				scene2D.getGroupStage().addActor(sPFix1Skin);
				scene2D.getGroupStage().addActor(sPFix2Skin);
				scene2D.getGroupStage().addActor(sP11Skin);
				scene2D.getGroupStage().addActor(sP12Skin);
				scene2D.getGroupStage().addActor(sP21Skin);
				scene2D.getGroupStage().addActor(sP22Skin);
				scene2D.getGroupStage().addActor(sPFix3Skin);
				scene2D.getGroupStage().addActor(sP13Skin);
				scene2D.getGroupStage().addActor(sP23Skin);

		// Add to platform list
				box2D.getPlatformList().add(sPInitSkin);
				box2D.getPlatformList().add(sPFix1Skin);
				box2D.getPlatformList().add(sPFix2Skin);
				box2D.getPlatformList().add(sP11Skin);
				box2D.getPlatformList().add(sP12Skin);
				box2D.getPlatformList().add(sP21Skin);
				box2D.getPlatformList().add(sP22Skin);
				box2D.getPlatformList().add(sPFix3Skin);
				box2D.getPlatformList().add(sP13Skin);
				box2D.getPlatformList().add(sP23Skin);
				

		// Creating All ACTIVATORS

			// Box2D Activator
				
				// activador 1

				// activador 1.1 (activador de plataforma 1, aparicion 1)
				PlatformActivator pA11 = new PlatformActivator(box2D.getWorld(), 1.0f,
						7.5f, 0.2f);
				// activador 1.2 (activador de plataforma 1, aparicion 2)
				PlatformActivator pA12 = new PlatformActivator(box2D.getWorld(), 0.5f,
						6.5f, 0.2f);
				// activador 1.3 (activador de plataforma 1, aparicion 3)
				PlatformActivator pA13 = new PlatformActivator(box2D.getWorld(), 0.2f,
						5.5f, 0.2f);
				// activador 1.4 (activador de plataforma 1, aparicion 4)
				PlatformActivator pA14 = new PlatformActivator(box2D.getWorld(), 3.8f,
						3.5f, 0.2f);
				// activador 1.5 (activador de plataforma 1, aparicion 5)
				PlatformActivator pA15 = new PlatformActivator(box2D.getWorld(), 11.2f,
						6.1f, 0.2f);
				
				// activador 2
		
				// activador 2.1 (activador de plataforma 2, aparicion 1)
				PlatformActivator pA21 = new PlatformActivator(box2D.getWorld(), 2.5f,
						3.2f, 0.2f);
				// activador 2.2 (activador de plataforma 2, aparicion 2)
				PlatformActivator pA22 = new PlatformActivator(box2D.getWorld(), 0.5f,
						3.8f, 0.2f);
				// activador 2.3 (activador de plataforma 2, aparicion 3)
				PlatformActivator pA23 = new PlatformActivator(box2D.getWorld(), 5.6f,
						4.1f, 0.2f);
				// activador 2.4 (activador de plataforma 2, aparicion 4)
				PlatformActivator pA24 = new PlatformActivator(box2D.getWorld(), 6.6f,
						3.4f, 0.2f);
				// activador 2.5 (activador de plataforma 2, aparicion 5)
				PlatformActivator pA25 = new PlatformActivator(box2D.getWorld(), 8.8f,
						6.5f, 0.2f);
		
				// activador FIN DE FASE 3
				PlatformActivator pAEnd = new PlatformActivator(box2D.getWorld(), 7.0f,
						8.0f, 0.3f);

			// Actor Activator
				PlatformActivatorActor pA11Skin = new PlatformActivatorActor(pA11,
						Color.BLUE, false);
				PlatformActivatorActor pA12Skin = new PlatformActivatorActor(pA12,
						Color.BLUE, false);
				PlatformActivatorActor pA13Skin = new PlatformActivatorActor(pA13,
						Color.BLUE, false);
				PlatformActivatorActor pA14Skin = new PlatformActivatorActor(pA14,
						Color.BLUE, false);
				PlatformActivatorActor pA15Skin = new PlatformActivatorActor(pA15,
						Color.BLUE, false);
				
				PlatformActivatorActor pA21Skin = new PlatformActivatorActor(pA21,
						Color.RED, false);
				PlatformActivatorActor pA22Skin = new PlatformActivatorActor(pA22,
						Color.RED, false);
				PlatformActivatorActor pA23Skin = new PlatformActivatorActor(pA23,
						Color.RED, false);
				PlatformActivatorActor pA24Skin = new PlatformActivatorActor(pA24,
						Color.RED, false);
				PlatformActivatorActor pA25Skin = new PlatformActivatorActor(pA25,
						Color.RED, false);
				
				PlatformActivatorActor pAEndSkin = new PlatformActivatorActor(pAEnd,
						Color.BLACK, true);

			// Add activators to Stage
				scene2D.getGroupStage().addActor(pA11Skin);
				scene2D.getGroupStage().addActor(pA12Skin);
				scene2D.getGroupStage().addActor(pA13Skin);
				scene2D.getGroupStage().addActor(pA14Skin);
				scene2D.getGroupStage().addActor(pA15Skin);
				
				scene2D.getGroupStage().addActor(pA21Skin);
				scene2D.getGroupStage().addActor(pA22Skin);
				scene2D.getGroupStage().addActor(pA23Skin);
				scene2D.getGroupStage().addActor(pA24Skin);
				scene2D.getGroupStage().addActor(pA25Skin);
				
				scene2D.getGroupStage().addActor(pAEndSkin);

			// Add to activator list
				box2D.getActivatorList().add(pA11Skin);
				box2D.getActivatorList().add(pA12Skin);
				box2D.getActivatorList().add(pA13Skin);
				box2D.getActivatorList().add(pA14Skin);
				box2D.getActivatorList().add(pA15Skin);
				
				box2D.getActivatorList().add(pA21Skin);
				box2D.getActivatorList().add(pA22Skin);
				box2D.getActivatorList().add(pA23Skin);
				box2D.getActivatorList().add(pA24Skin);
				box2D.getActivatorList().add(pA25Skin);
				
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
