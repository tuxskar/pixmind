package com.pix.mind.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.PixGuy;
import com.pix.mind.world.PixMindBox2DInitialization;

public class ArrowController extends PixGuyController {
	private Stage stage;
	boolean movingLeft = false;
	boolean movingRight = false;
	
	public ArrowController(final PixGuy pixGuy, final Stage stage) {
		super(pixGuy);
		this.stage = stage;
		Drawable arrowTexture = PixMindGame.getSkin().getDrawable("arrow");

		Image leftArrow = new Image(arrowTexture);
		Image rightArrow = new Image(PixMindGame.getSkin().getDrawable("arrow1"));
		float arrowWidth = 60;
		float arrowHeight = 60;
		float zoomMargin = 10;
		leftArrow.setSize(arrowWidth, arrowHeight);
		rightArrow.setSize(arrowWidth, arrowHeight);
		//rightArrow.setOrigin(arrowWidth / 2, arrowHeight / 2);
		//rightArrow.rotate(180);
		leftArrow.setPosition(zoomMargin, zoomMargin);
		rightArrow.setPosition(stage.getWidth() - zoomMargin - arrowWidth,
				zoomMargin);
		this.stage.addActor(leftArrow);
		this.stage.addActor(rightArrow);

		stage.addListener(new ActorGestureListener() {

			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				super.touchDown(event, x, y, pointer, button);
				

				if (y < 100) {
					if (x < 100) {
						movingLeft = true;
						movingRight = false;
					}
					if (x > PixMindGame.w - 100) {
						movingRight = true;
						movingLeft = false;
					}
				}
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				super.touchUp(event, x, y, pointer, button);

				int activeTouch = 0;
				for (int i = 0; i < 2; i++) {
					if (Gdx.app.getInput().isTouched(i))
						activeTouch++;
				}
				if (activeTouch == 1) {				
					if (y < 100) {
						if (x < 100) {							
							movingRight = true;
							movingLeft = false;
						}
						if (x > PixMindGame.w - 100) {							
							movingLeft = true;
							movingRight = false;
						}
					}				
				}								
				if (activeTouch == 0) {										
						movingLeft = false;
						movingRight = false;					
				}
			}

		});
	}

	@Override
	public void movements() {

		if (isActive() ) {

			if (movingLeft) {
				pixGuy.moveLeft(Gdx.graphics.getDeltaTime());
				
			}
			if (movingRight) {
				pixGuy.moveRight(Gdx.graphics.getDeltaTime());
			}
			if(!movingLeft && !movingRight){
				// if it is not touched, set horizontal velocity to 0 to
				// eliminate inercy.
				pixGuy.body.setLinearVelocity(0,
						pixGuy.body.getLinearVelocity().y);
			}

		}

	}

}
