package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level06 extends PixMindLevel {

	
	/* JUAN: LEVEL 6*/
	public String levelTitle = "LevelSix";
	PixMindGame game;
	private static final int nActiveColors = 2;
	public Level06(PixMindGame game) {
		super(game, 1200, 900, 600, 4.5f, 6.2f, nActiveColors);
		this.game = game;
		levelNumber = 6;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		super.show();
		super.setNextLevel(game.getLevel07());
		super.setActiveLevel(this);
		// CREANDO EL NIVEL

		// Creating All STATIC PLATFORMS

			// Box2D platforms
		
				// plataforma INIT
				StaticPlatform sPInit = new StaticPlatform(box2D.getWorld(), 4.5f, 5.7f,
						0.7f, 0.1f);
				
				// plataforma fija 1
				StaticPlatform sPFix1 = new StaticPlatform(box2D.getWorld(), 2.5f, 3.7f,
						1.0f, 0.1f);
				
				// plataforma fija 2
				StaticPlatform sPFix2 = new StaticPlatform(box2D.getWorld(), 6.5f, 3.7f,
						1.0f, 0.1f);
				
				// plataforma fija 3
				StaticPlatform sPFix3 = new StaticPlatform(box2D.getWorld(), 4.5f, 1.7f,
						3.0f, 0.1f);
				
				// plataforma sP11 (color 1, aparicion 1)
				StaticPlatform sP11 = new StaticPlatform(box2D.getWorld(), 0.7f, 2.6f,
						1.0f, 0.1f);
					
				// plataforma sP21 (color 2, aparicion 1)
				StaticPlatform sP21 = new StaticPlatform(box2D.getWorld(), 9.3f, 2.6f,
						1.0f, 0.1f);
				
				// plataforma fija 6
				StaticPlatform sPFix6 = new StaticPlatform(box2D.getWorld(), 10.5f, 3.7f,
						1.0f, 0.1f);
				
				// plataforma sP31 (color 3, aparicion 1)
				StaticPlatform sP31 = new StaticPlatform(box2D.getWorld(), 9.3f, 5.0f,
						1.0f, 0.1f);
				
				// plataforma fija 4
				StaticPlatform sPFix4 = new StaticPlatform(box2D.getWorld(), 7.6f, 6.3f,
						0.2f, 0.08f);
				
				// plataforma fija 5
				StaticPlatform sPFix5 = new StaticPlatform(box2D.getWorld(), 6.6f, 7.5f,
						0.2f, 0.08f);
				
					

			// Actor Platforms
				StaticPlatformActor sPInitSkin = new StaticPlatformActor(sPInit,
						Color.BLACK, true);
				StaticPlatformActor sPFix1Skin = new StaticPlatformActor(sPFix1,
						Color.BLACK, true);
				StaticPlatformActor sPFix2Skin = new StaticPlatformActor(sPFix2,
						Color.BLACK, true);
				StaticPlatformActor sPFix3Skin = new StaticPlatformActor(sPFix3,
						Color.BLACK, true);
				StaticPlatformActor sP11Skin = new StaticPlatformActor(sP11,
						Color.BLUE, false);
				StaticPlatformActor sP21Skin = new StaticPlatformActor(sP21,
						Color.RED, false);
				StaticPlatformActor sPFix6Skin = new StaticPlatformActor(sPFix6,
						Color.BLACK, true);
				StaticPlatformActor sP31Skin = new StaticPlatformActor(sP31,
						Color.GREEN, false);
				StaticPlatformActor sPFix4Skin = new StaticPlatformActor(sPFix4,
						Color.BLACK, true);
				StaticPlatformActor sPFix5Skin = new StaticPlatformActor(sPFix5,
						Color.BLACK, true);

			// Add platforms to Stage
				scene2D.getGroupStage().addActor(sPInitSkin);
				scene2D.getGroupStage().addActor(sPFix1Skin);
				scene2D.getGroupStage().addActor(sPFix2Skin);
				scene2D.getGroupStage().addActor(sPFix3Skin);
				scene2D.getGroupStage().addActor(sP11Skin);
				scene2D.getGroupStage().addActor(sP21Skin);
				scene2D.getGroupStage().addActor(sPFix6Skin);
				scene2D.getGroupStage().addActor(sP31Skin);
				scene2D.getGroupStage().addActor(sPFix4Skin);
				scene2D.getGroupStage().addActor(sPFix5Skin);

			// Add to platform list
				box2D.getPlatformList().add(sPInitSkin);
				box2D.getPlatformList().add(sPFix1Skin);
				box2D.getPlatformList().add(sPFix2Skin);
				box2D.getPlatformList().add(sPFix3Skin);
				box2D.getPlatformList().add(sP11Skin);
				box2D.getPlatformList().add(sP21Skin);
				box2D.getPlatformList().add(sPFix6Skin);
				box2D.getPlatformList().add(sP31Skin);
				box2D.getPlatformList().add(sPFix4Skin);
				box2D.getPlatformList().add(sPFix5Skin);

		
		// Creating All ACTIVATORS

			// Box2D Activator
			
				// activador 1.1 (activador de plataforma 1, aparicion 1)
				PlatformActivator pA11 = new PlatformActivator(box2D.getWorld(),
							5.5f, 2.4f, 0.2f);
				
				// activador 2.1 (activador de plataforma 2, aparicion 1)
				PlatformActivator pA21 = new PlatformActivator(box2D.getWorld(),
							0.5f, 3.8f, 0.2f);
				
				// activador 3.1 (activador de plataforma 3, aparicion 1)
				PlatformActivator pA31 = new PlatformActivator(box2D.getWorld(),
							3.5f, 2.4f, 0.2f);
				
				// activador FIN DE FASE 3
				PlatformActivator pAEnd = new PlatformActivator(box2D.getWorld(),
						5.0f, 8.0f, 0.3f);

			// Actor Activator
				PlatformActivatorActor pA11Skin = new PlatformActivatorActor(pA11,
						Color.BLUE, false);
				PlatformActivatorActor pA21Skin = new PlatformActivatorActor(pA21,
						Color.RED, false);
				PlatformActivatorActor pA31Skin = new PlatformActivatorActor(pA31,
						Color.GREEN, false);
				PlatformActivatorActor pAEndSkin = new PlatformActivatorActor(pAEnd,
						Color.BLACK, true);

			// Add activators to Stage
				scene2D.getGroupStage().addActor(pA11Skin);
				scene2D.getGroupStage().addActor(pA21Skin);
				scene2D.getGroupStage().addActor(pA31Skin);
				scene2D.getGroupStage().addActor(pAEndSkin);

			// Add to activator list
				box2D.getActivatorList().add(pA11Skin);
				box2D.getActivatorList().add(pA21Skin);
				box2D.getActivatorList().add(pA31Skin);
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
