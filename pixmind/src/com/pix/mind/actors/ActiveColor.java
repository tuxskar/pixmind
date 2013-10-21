package com.pix.mind.actors;

import java.util.Comparator;

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
       // float radius = 20;
       // this.setSize(radius * 2, radius * 2);
    //    this.setColor(color);
        this.c = color;
//		super(PixMindGame.getSkin().getDrawable(PixMindGame.candyColorToTexture.get(color)));
//		float radius = 20;
//		this.setSize(radius * 2, radius * 2);
//		this.c= color;
//		if (color.equals(Color.CLEAR))
//			this.setColor(Color.CLEAR);
        this.position = 0; 
        moveActorAt(position);
        stageGui.addActor(this);
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
//	@Override
//	public Color getColor() {
//		return c;
//	}

	

	public void moveActorAt(int position) {
		this.position = position;
		this.setPosition(PixMindGame.w - this.getWidth()
				* position - COLORMARGIN * position, PixMindGame.h
				- this.getHeight() - COLORMARGIN);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return PixMindGame.candyColorToTexture.get(c) + " posicion " + position;
	}
	

	
	
//	@Override
//	public void setColor(Color color) {
//		System.out.println("quiero algo");
//	}
}
