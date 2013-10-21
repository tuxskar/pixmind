package com.pix.mind.controllers;

import com.badlogic.gdx.Gdx;
import com.pix.mind.box2d.bodies.PixGuy;

public class AccController extends PixGuyController {
	float limit = 0.5f;
	public AccController(PixGuy pixGuy) {
		super(pixGuy);
	}

	public void movements(){
		if(Gdx.input.getAccelerometerY() >=-limit && Gdx.input.getAccelerometerY() <=limit)
		{
			pixGuy.body.setLinearVelocity(0,
					pixGuy.body.getLinearVelocity().y);
		}else
		if(Gdx.input.getAccelerometerY() > limit){
			pixGuy.moveRight(Gdx.graphics.getDeltaTime());
		}else
		if(Gdx.input.getAccelerometerY() < -limit){
			
			pixGuy.moveLeft(Gdx.graphics.getDeltaTime());
		}
		//Gdx.app.log("acelertometro", String.valueOf(Gdx.input.getAccelerometerY()));
	}
}
