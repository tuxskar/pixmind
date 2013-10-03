package com.pix.mind.controllers;

import com.badlogic.gdx.Gdx;
import com.pix.mind.box2d.bodies.PixGuy;

public class AccController extends PixGuyController {
	
	public AccController(PixGuy pixGuy) {
		super(pixGuy);
	}

	public void movements(){
		if(Gdx.input.getAccelerometerY() < 1){
			pixGuy.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.getAccelerometerY() > -1){
			this.pixGuy.moveRight(Gdx.graphics.getDeltaTime());
		}
	}
}
