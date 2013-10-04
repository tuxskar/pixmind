package com.pix.mind.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.box2d.bodies.PixGuy;

public class PixGuyActor extends Image {
	private PixGuy pixGuy;
	public PixGuyActor(PixGuy pixGuy){
		super(new Texture(Gdx.files.internal("data/textures/pixel.png")));
		this.pixGuy = pixGuy;
		this.setSize(pixGuy.PixWidth, pixGuy.PixHeight);
		this.setPosition(pixGuy.getPosX(), pixGuy.getPosY());
		this.setColor(0, 0, 0.5f,1);
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setPosition(pixGuy.getPosX(), pixGuy.getPosY());
	}
}
