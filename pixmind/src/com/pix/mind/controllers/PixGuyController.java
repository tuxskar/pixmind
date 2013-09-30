package com.pix.mind.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.pix.mind.box2d.bodies.PixGuy;

public class PixGuyController {
	PixGuy pixGuy;
	
	public PixGuyController(PixGuy pixGuy){
		this.pixGuy = pixGuy;
	}
	
	public void movements(){
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			pixGuy.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			pixGuy.moveRight(Gdx.graphics.getDeltaTime());
		}
	}
}
