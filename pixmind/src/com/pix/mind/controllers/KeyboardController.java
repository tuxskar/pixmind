package com.pix.mind.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.PixGuy;

public class KeyboardController extends PixGuyController {
	
	boolean movingLeft = false;
	boolean movingRight = false;
	
	public KeyboardController(PixGuy pixGuy, Stage stage) {
		super(pixGuy);
		
		
		stage.addListener(new InputListener(){

			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				// TODO Auto-generated method stub
				
				if (keycode == Keys.LEFT) {
					movingLeft = true;
					movingRight = false;
				}
				if (keycode == Keys.RIGHT) {
					movingRight = true;
					movingLeft = false;
				}
				
				
				
				
				return true;
			}

			@Override
			public boolean keyUp(InputEvent event, int keycode) {
				// TODO Auto-generated method stub
				
				if (keycode == Keys.LEFT) {
					
					movingRight = true;
					movingLeft = false;
					
				}
				if (keycode == Keys.RIGHT) {
					movingLeft = true;
					movingRight = false;
				}
				
				if (!Gdx.input.isKeyPressed(Keys.RIGHT)&& !Gdx.input.isKeyPressed(Keys.LEFT)) {
					movingRight = false;
					movingLeft = false;
				}				
				return true;
			}

		
		
			
			
		});
	}

	public void movements() {
		if (movingLeft) {
			pixGuy.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if (movingRight) {
			pixGuy.moveRight(Gdx.graphics.getDeltaTime());
		}
		
		if(!movingLeft&&!movingRight){
			// if it is not touched, set horizontal velocity to 0 to
			// eliminate inercy.
			pixGuy.body.setLinearVelocity(0,
					pixGuy.body.getLinearVelocity().y);
		}
	}

}
