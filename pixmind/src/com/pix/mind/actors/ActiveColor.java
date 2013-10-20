package com.pix.mind.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;

public class ActiveColor extends Image {
	public Color c;
	public ActiveColor(Color color) {
		super(PixMindGame.getSkin().getDrawable("icecream"));
        float radius = 20;
        this.setSize(radius * 2, radius * 2);
        this.setColor(color);
//		super(PixMindGame.getSkin().getDrawable(PixMindGame.candyColorToTexture.get(color)));
//		float radius = 20;
//		this.setSize(radius * 2, radius * 2);
//		this.c= color;
//		if (color.equals(Color.CLEAR))
//			this.setColor(Color.CLEAR);
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
//	@Override
//	public Color getColor() {
//		return c;
//	}
	
//	@Override
//	public void setColor(Color color) {
//		System.out.println("quiero algo");
//	}
}
