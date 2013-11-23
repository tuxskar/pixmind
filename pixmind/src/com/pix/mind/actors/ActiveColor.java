package com.pix.mind.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;

public class ActiveColor extends Image{
	private final static int COLORMARGIN = 10;
	public Color c;
	public int position; 
	public ActiveColor(Color color, Stage stageGui) {
		super(PixMindGame.getSkin().getDrawable(PixMindGame.candyColorToTexture.get(color)));
        this.c = color;
        this.position = 0; 
        moveActorAt(position);
        stageGui.addActor(this);
	}
	
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}

	public void moveActorAt(int position) {
		this.position = position;
		this.setPosition(PixMindGame.w - this.getWidth()
				* position - COLORMARGIN * position, PixMindGame.h
				- this.getHeight() - COLORMARGIN);
	}

	@Override
	public String toString() {
		return PixMindGame.candyColorToTexture.get(c) + " posicion " + position;
	}
}
