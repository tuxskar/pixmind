package com.pix.mind.screens;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.pix.mind.PixMindGame;
import com.pix.mind.levels.PixMindLevel;
import com.pix.mind.screens.LevelSelector1Screen.Listener;

public class LevelSelector2Screen implements Screen{

	private PixMindGame game;
	private Stage levelStage;
	private Image backgroundImage;
	Map<Integer, PixMindLevel> mapa;
	public LevelSelector2Screen(PixMindGame game) {
		super();
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
		
		levelStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
				levelStage = new Stage(PixMindGame.w, PixMindGame.h, true);

				Gdx.input.setInputProcessor(levelStage);
				Gdx.input.setCatchBackKey(true);
				Group levelGroup = new Group(); // to move according to the resolutuion

				backgroundImage = new Image(PixMindGame.getSkin().getDrawable(
						"emptyscreen"));

				levelGroup.addActor(backgroundImage);

				int pantalla = 13; 
				
				mapa =  new HashMap<Integer, PixMindLevel>();
				mapa.put(13, game.getLevelOne());
				mapa.put(14, game.getLevelTwo());
				mapa.put(15, game.getLevelThree());
				mapa.put(16, game.getLevelOne());
				mapa.put(17, game.getLevelOne());
				mapa.put(18, game.getLevelOne());
				mapa.put(19, game.getLevelOne());
				mapa.put(20, game.getLevelOne());
				mapa.put(21, game.getLevelOne());
				mapa.put(22, game.getLevelOne());
				mapa.put(23, game.getLevelOne());
				mapa.put(24, game.getLevelOne());
				
				
				BitmapFont font = new BitmapFont();
				font.setScale(3);
				// frame must be square...
				
				float frameSize = 80;

				float horizontalMargin = (640 - frameSize * 4) / 5;
				float verticalMargin = (480 - frameSize * 3) / 4;

				Vector2 posicionFrame = new Vector2(107, 480 - verticalMargin
						- frameSize);

				for (int fila = 1; fila <= 3; fila++) {
					for (int columna = 1; columna <= 4; columna++) {
						Image im = new Image(PixMindGame.getSkin().getDrawable(
								"levelframe"));
								
						im.addListener(new Listener(pantalla));
						
								
						im.setSize(frameSize, frameSize);
						posicionFrame.add(horizontalMargin, 0);
						im.setPosition(posicionFrame.x, posicionFrame.y);
						levelGroup.addActor(im);
						posicionFrame.add(frameSize, 0);
						LabelStyle style = new LabelStyle(font, Color.BLACK) ; 
						Label label = new Label(String.valueOf(pantalla), style);		
						label.setTouchable(Touchable.disabled);	
						label.setPosition(posicionFrame.x-frameSize/2 - label.getWidth()/2, posicionFrame.y);
						levelGroup.addActor(label);				
						pantalla ++;
					}
					posicionFrame.set(107, 480 - (verticalMargin + frameSize)
							* (fila + 1));
				}

				levelGroup.setPosition(-(854 - PixMindGame.w) / 2, 0);
				levelStage.addActor(levelGroup);
				
				
				
				Image next = new Image(PixMindGame.getSkin().getDrawable("arrow"));
				next.addListener(new ActorGestureListener(){

					@Override
					public void touchDown(InputEvent event, float x, float y,
							int pointer, int button) {
						// TODO Auto-generated method stub
						super.touchDown(event, x, y, pointer, button);
						  PixMindGame.getMenuClick().play(0.3f);
						game.changeLevel(game.getLevelSelector1Screen());
					}
					
					
					
				});
				
				next.setOrigin(next.getWidth()/2, next.getHeight()/2);
				//next.rotate(180);
				
				next.setPosition(0+10, 10);
				levelStage.addActor(next);
				
				levelStage.addListener(new InputListener(){

					@Override
					public boolean keyDown(InputEvent event, int keycode) {
						// TODO Auto-generated method stub
						
						if(keycode == Keys.BACK){
						    PixMindGame.getMenuClick().play(0.3f);
							game.changeLevel(game.getMainMenuScreen());
						}
						return true;
					}
					
					
				});
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	class Listener  extends  ActorGestureListener{
		int pantalla;
		public Listener(int pantalla){
		this.pantalla = pantalla;
		}
		@Override
		public void touchDown(InputEvent event, float x, float y, int pointer,
				int button) {
			// TODO Auto-generated method stub
			super.touchDown(event, x, y, pointer, button);
		    PixMindGame.getMenuClick().play(0.3f);
			game.changeLevel(mapa.get(pantalla));
			
		}
		
		
		}


}
