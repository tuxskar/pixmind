package com.pix.mind.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;

public class ActiveColor extends Image {
	public Color color;
	public ActiveColor(Color color) {
		super(PixMindGame.getSkin().getDrawable(PixMindGame.candyColorToTexture.get(color)));
		float radius = 20;
		this.setSize(radius * 2, radius * 2);
		this.color = color;
//		if (color.equals(Color.CLEAR))
//			this.setColor(Color.CLEAR);
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	@Override
	public Color getColor() {
		return color;
	}
}
