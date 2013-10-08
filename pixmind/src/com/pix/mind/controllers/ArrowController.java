package com.pix.mind.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.PixGuy;

public class ArrowController extends PixGuyController {
	private Stage stage;
	boolean ultimo;
	public ArrowController(final PixGuy pixGuy, final Stage stage) {
		super(pixGuy);
		this.stage = stage;
		Drawable arrowTexture =	 PixMindGame.getSkin().getDrawable("leftArrow");
		
		Image leftArrow = new Image(arrowTexture);
		Image rightArrow = new Image(arrowTexture);
		float arrowWidth = PixMindGame.getSkin().getAtlas().findRegion("leftArrow").originalWidth;
		float arrowHeight =PixMindGame.getSkin().getAtlas().findRegion("leftArrow").originalHeight;
		leftArrow.setSize(arrowWidth, arrowHeight);
		rightArrow.setSize(arrowWidth, arrowHeight);
		rightArrow.setOrigin(arrowWidth / 2, arrowHeight/2);
		rightArrow.rotate(180);
		leftArrow.setPosition(arrowWidth / 10, arrowHeight / 10);
		rightArrow.setPosition(
				stage.getWidth() - arrowWidth / 10 - arrowWidth,
				arrowHeight / 10);
		this.stage.addActor(leftArrow);
		this.stage.addActor(rightArrow);
		
	}

	@Override
	public void movements() {
		
		
		if (Gdx.input.isTouched()) {
			
		//	System.out.println("x: " + Gdx.input.getX() + " y: "
	//				+ Gdx.input.getY());
			if (Gdx.input.getY() >  stage.getHeight() * 3 / 4) {
				if (Gdx.input.getX() <  stage.getWidth() / 6 ) {
				
					pixGuy.moveLeft(Gdx.graphics.getDeltaTime());
					
				}
				if (Gdx.input.getX() >  stage.getWidth() - stage.getWidth() / 6) {
					
					pixGuy.moveRight(Gdx.graphics.getDeltaTime());
					
				}
			}
			
		}else{//if it is not touched, set horizontal velocity to 0 to eliminate inercy.
			
			pixGuy.body.setLinearVelocity(0,pixGuy.body.getLinearVelocity().y);
			
		}
		
	}
}
