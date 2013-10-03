package com.pix.mind.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.box2d.bodies.PixGuy;

public class ArrowController extends PixGuyController {
	private Stage stage;

	public ArrowController(PixGuy pixGuy, Stage stage) {
		super(pixGuy);
		this.stage = stage;
		Image leftArrow = new Image(new Texture(
				Gdx.files.internal("data/textures/OneBlackPixel.png")));
		Image rightArrow = new Image(new Texture(
				Gdx.files.internal("data/textures/OneBlackPixel.png")));
		// Image rightArrow = leftArrow;
		// rightArrow.rotate(180);
		// leftArrow.setPosition(leftArrow.getImageWidth()/10,
		// leftArrow.getHeight()/10);
		float arrowWidth = 30;
		float arrowHeight = 30;
		leftArrow.setSize(arrowWidth, arrowHeight);
		rightArrow.setSize(arrowWidth, arrowHeight);
		leftArrow.setPosition(arrowWidth / 10, arrowHeight / 10);
		rightArrow.setPosition(stage.getWidth() - arrowWidth - arrowWidth / 10,
				arrowHeight / 10);
		this.stage.addActor(leftArrow);
		this.stage.addActor(rightArrow);
	}

	@Override
	public void movements() {
		// TODO Auto-generated method stub
		if (Gdx.input.isTouched()) {
			System.out.println("x: "+Gdx.input.getX() + " y: "+Gdx.input.getY());
			if (Gdx.input.getY() > stage.getHeight() * 3 / 4) {
				if (Gdx.input.getX() < stage.getWidth() / 6) {
					pixGuy.moveLeft(Gdx.graphics.getDeltaTime());
				}
				if (Gdx.input.getX() > stage.getWidth() - stage.getWidth() / 6) {
					this.pixGuy.moveRight(Gdx.graphics.getDeltaTime());
				}
			}
		}
	}
}
