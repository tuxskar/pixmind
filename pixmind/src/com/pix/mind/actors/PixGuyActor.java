package com.pix.mind.actors;


import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.PixGuy;

public class PixGuyActor extends Image {
	private PixGuy pixGuy;
	public PixGuyActor(PixGuy pixGuy){
		
		super( PixMindGame.getSkin().getDrawable("pixguy8"));

		//Texture r = PixMindGame.getSkin().getRegion("box").getTexture();
		
		this.pixGuy = pixGuy;
		this.setSize(pixGuy.pixWidth, pixGuy.pixHeight);
		this.setPosition(pixGuy.getPosX(), pixGuy.getPosY());
		this.setOrigin(pixGuy.pixWidth/2,pixGuy.pixHeight/2);
		pixGuy.fixture.setUserData(this);
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setPosition(pixGuy.getPosX(), pixGuy.getPosY());
	}
}
