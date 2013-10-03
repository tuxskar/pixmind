package com.pix.mind.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.pix.mind.box2d.bodies.PixGuy;

public class KeyboardController extends PixGuyController {

	public KeyboardController(PixGuy pixGuy) {
		super(pixGuy);
	}

	public void movements() {
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			pixGuy.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			pixGuy.moveRight(Gdx.graphics.getDeltaTime());
		}
	}

}
