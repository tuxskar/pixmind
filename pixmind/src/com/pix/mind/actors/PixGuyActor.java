package com.pix.mind.actors;


import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.PixGuy;

public class PixGuyActor extends Image {
	private PixGuy pixGuy;
	public PixGuyActor(PixGuy pixGuy){
		
		super( PixMindGame.getSkin().getDrawable("box"));
	
		//Texture r = PixMindGame.getSkin().getRegion("box").getTexture();
		
		this.pixGuy = pixGuy;
		this.setSize(pixGuy.pixWidth, pixGuy.pixHeight);
		this.setPosition(pixGuy.getPosX(), pixGuy.getPosY());
		this.setColor(0, 0, 0,1);
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setPosition(pixGuy.getPosX(), pixGuy.getPosY());
	}
}
