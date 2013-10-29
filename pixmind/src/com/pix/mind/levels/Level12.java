package com.pix.mind.levels;

import java.util.Iterator;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.actors.StaticWallActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level12 extends PixMindLevel {

	
	/* JUAN: LEVEL 12*/
	public String levelTitle = "LevelTwelve";
	PixMindGame game;
	private static final int nActiveColors = 3;
	public Level12(PixMindGame game) {
		super(game,1280, 1024, 250, 1.0f, 3.0f, nActiveColors);
		this.game = game;
		levelNumber = 12;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		super.show();
		super.setNextLevel(game.getLevel13());
		super.setActiveLevel(this);
		// CREANDO EL NIVEL

		// platform Actors and Activator Actors List and statics walls
		
		// Creating All Statics Walls
		
			scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 3.9f, 5.6f, 0.04f, 2.0f));
			scene2D.getGroupStage().addActor(new StaticWallActor(box2D.getWorld(), 8.1f, 5.6f, 0.04f, 2.0f));
		
		// Creating All Statics Platforms

			// Box2D platforms
		
				// plataforma INIT
				StaticPlatform sPInit = new StaticPlatform(box2D.getWorld(), 1.0f, 2.5f,
						0.8f, 0.11f);
		
				// plataforma END
				StaticPlatform sPEnd = new StaticPlatform(box2D.getWorld(), 6.0f, 3.5f,
						0.8f, 0.11f);
				
				
				
				// plataforma fija 1
				StaticPlatform sPFix1 = new StaticPlatform(box2D.getWorld(), -1.0f, 3.7f, 
						0.4f, 0.1f);
				
				// plataforma fija 2
				StaticPlatform sPFix2 = new StaticPlatform(box2D.getWorld(), 1.0f, 4.7f, 
						0.4f, 0.1f);
				
				// plataforma fija 3
				StaticPlatform sPFix3 = new StaticPlatform(box2D.getWorld(), 2.8f, 5.5f, 
						0.4f, 0.1f);
				
				// plataforma fija 4
				StaticPlatform sPFix4 = new StaticPlatform(box2D.getWorld(), 1.0f, 6.7f, 
						0.4f, 0.1f);
				
				// plataforma fija 5
				StaticPlatform sPFix5 = new StaticPlatform(box2D.getWorld(), 2.8f, 7.5f, 
						0.4f, 0.1f);
				
				
				
				// plataforma sP11 (color 1, aparicion 1)
				StaticPlatform sP11 = new StaticPlatform(box2D.getWorld(), 6.0f, 7.5f, 
						2.0f, 0.12f);
				
				// plataforma sP21 (color 2, aparicion 1)
				StaticPlatform sP21 = new StaticPlatform(box2D.getWorld(), 6.0f, 5.5f, 
						2.0f, 0.12f);
				
				// plataforma sP31 (color 3, aparicion 1)
				StaticPlatform sP31 = new StaticPlatform(box2D.getWorld(), 6.0f, 6.5f, 
						2.0f, 0.12f);
				
				
				
				// plataforma fija 6
				StaticPlatform sPFix6 = new StaticPlatform(box2D.getWorld(), 11.0f, 2.9f, 
						0.4f, 0.08f);
				
				// plataforma fija 7
				StaticPlatform sPFix7 = new StaticPlatform(box2D.getWorld(), 11.0f, 2.1f, 
						0.8f, 0.1f);
				
				
				
				// plataforma fija 8
				StaticPlatform sPFix8 = new StaticPlatform(box2D.getWorld(), 1.6f, 1.3f,
						0.4f, 0.08f);
				
				// plataforma fija 9
				StaticPlatform sPFix9 = new StaticPlatform(box2D.getWorld(), 3.2f, 0.3f,
						0.4f, 0.08f);
				
				// plataforma fija 10
				StaticPlatform sPFix10 = new StaticPlatform(box2D.getWorld(), 5.2f, 0.3f,
						0.4f, 0.08f);
				
				// plataforma fija 11
				StaticPlatform sPFix11 = new StaticPlatform(box2D.getWorld(), 7.2f, 0.3f,
						0.4f, 0.08f);
				
				// plataforma fija 12
				StaticPlatform sPFix12 = new StaticPlatform(box2D.getWorld(), 9.2f, 0.3f,
						0.4f, 0.08f);
			
			// Actor Platforms
				
				StaticPlatformActor sPInitSkin = new StaticPlatformActor(sPInit,
						Color.BLACK, true);
				StaticPlatformActor sPEndSkin = new StaticPlatformActor(sPEnd,
						Color.BLACK, true);
				
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
				
				StaticPlatformActor sP11Skin = new StaticPlatformActor(sP11,
						Color.BLUE, false);
				StaticPlatformActor sP21Skin = new StaticPlatformActor(sP21,
						Color.RED, true);
				StaticPlatformActor sP31Skin = new StaticPlatformActor(sP31,
						Color.ORANGE, false);
				
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
	
			// Add platforms to Stage
				
				scene2D.getGroupStage().addActor(sPInitSkin);
				scene2D.getGroupStage().addActor(sPEndSkin);
				
				scene2D.getGroupStage().addActor(sPFix1Skin);
				scene2D.getGroupStage().addActor(sPFix2Skin);
				scene2D.getGroupStage().addActor(sPFix3Skin);
				scene2D.getGroupStage().addActor(sPFix4Skin);
				scene2D.getGroupStage().addActor(sPFix5Skin);
				
				scene2D.getGroupStage().addActor(sP11Skin);
				scene2D.getGroupStage().addActor(sP21Skin);
				scene2D.getGroupStage().addActor(sP31Skin);
				
				scene2D.getGroupStage().addActor(sPFix6Skin);
				scene2D.getGroupStage().addActor(sPFix7Skin);
				
				scene2D.getGroupStage().addActor(sPFix8Skin);
				scene2D.getGroupStage().addActor(sPFix9Skin);
				scene2D.getGroupStage().addActor(sPFix10Skin);
				scene2D.getGroupStage().addActor(sPFix11Skin);
				scene2D.getGroupStage().addActor(sPFix12Skin);
	
			// Add to platform list
				
				box2D.getPlatformList().add(sPInitSkin);
				box2D.getPlatformList().add(sPEndSkin);
				
				box2D.getPlatformList().add(sPFix1Skin);
				box2D.getPlatformList().add(sPFix2Skin);
				box2D.getPlatformList().add(sPFix3Skin);
				box2D.getPlatformList().add(sPFix4Skin);
				box2D.getPlatformList().add(sPFix5Skin);
				
				box2D.getPlatformList().add(sP11Skin);
				box2D.getPlatformList().add(sP21Skin);
				box2D.getPlatformList().add(sP31Skin);
				
				box2D.getPlatformList().add(sPFix6Skin);
				box2D.getPlatformList().add(sPFix7Skin);
				
				box2D.getPlatformList().add(sPFix8Skin);
				box2D.getPlatformList().add(sPFix9Skin);
				box2D.getPlatformList().add(sPFix10Skin);
				box2D.getPlatformList().add(sPFix11Skin);
				box2D.getPlatformList().add(sPFix12Skin);

		
		
		// Creating All Activators

			// Box2D Activator
				
				// activador 1

				// activador 1.1 (activador de plataforma 1, aparicion 1)
				PlatformActivator pA11 = new PlatformActivator(box2D.getWorld(), -1.0f, 7.8f, 0.25f);
				
				
				// activador 2
				
				// activador 2.1 (activador de plataforma 2, aparicion 1)
				PlatformActivator pA21 = new PlatformActivator(box2D.getWorld(), 10.2f, 5.4f, 0.2f);
				
				
				// activador 3
				
//				// activador 3.1 (activador de plataforma 3, aparicion 1)
//				PlatformActivator pA31 = new PlatformActivator(box2D.getWorld(), 6.0f, 8.3f, 0.15f);
				// activador 3.2 (activador de plataforma 3, aparicion 2)
				PlatformActivator pA32 = new PlatformActivator(box2D.getWorld(), 5.5f, 8.5f, 0.15f);
				// activador 3.3 (activador de plataforma 3, aparicion 3)
				PlatformActivator pA33 = new PlatformActivator(box2D.getWorld(), 9.6f, 5.2f, 0.15f);
				// activador 3.4 (activador de plataforma 3, aparicion 4)
				PlatformActivator pA34 = new PlatformActivator(box2D.getWorld(), 11.0f, 3.5f, 0.15f);
				
				
				// activador FIN DE FASE 12
				PlatformActivator pAEnd = new PlatformActivator(box2D.getWorld(), 6.0f, 4.5f, 0.35f);
	
			// Actor Activator
				
				PlatformActivatorActor pA11Skin = new PlatformActivatorActor(pA11,
						Color.BLUE, false);
				PlatformActivatorActor pA21Skin = new PlatformActivatorActor(pA21,
						Color.RED, true);
				
//				PlatformActivatorActor pA31Skin = new PlatformActivatorActor(pA31,
//						Color.ORANGE, false);
				PlatformActivatorActor pA32Skin = new PlatformActivatorActor(pA32,
						Color.ORANGE, false);
				PlatformActivatorActor pA33Skin = new PlatformActivatorActor(pA33,
						Color.ORANGE, false);
				PlatformActivatorActor pA34Skin = new PlatformActivatorActor(pA34,
						Color.ORANGE, false);
				
				PlatformActivatorActor pAEndSkin = new PlatformActivatorActor(pAEnd,
						Color.BLACK, true);
	
			// Add activators to Stage
				
				scene2D.getGroupStage().addActor(pA11Skin);
				scene2D.getGroupStage().addActor(pA21Skin);
				
//				scene2D.getGroupStage().addActor(pA31Skin);
				scene2D.getGroupStage().addActor(pA32Skin);
				scene2D.getGroupStage().addActor(pA33Skin);
				scene2D.getGroupStage().addActor(pA34Skin);
				
				scene2D.getGroupStage().addActor(pAEndSkin);
	
			// Add to activator list
				
				box2D.getActivatorList().add(pA11Skin);
				box2D.getActivatorList().add(pA21Skin);
				
//				box2D.getActivatorList().add(pA31Skin);
				box2D.getActivatorList().add(pA32Skin);
				box2D.getActivatorList().add(pA33Skin);
				box2D.getActivatorList().add(pA34Skin);
				
				box2D.getActivatorList().add(pAEndSkin);
		
		

		// add to stage the group of actors

		// Active colors

		// Rendering the game
		// para empezar el nivel como si ya hubiesemos pulsado el activador de la plataforma de color rojo
		box2D.addActivatedColor(Color.RED);
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
