package com.pix.mind.actors;

import java.util.concurrent.ArrayBlockingQueue;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pix.mind.PixMindGame;

public class ActiveColors {
	public ArrayBlockingQueue<ActiveColor> colors;
	private final static int COLORMARGIN = 10;
	
	public ActiveColors(Stage guiStage, int nColors) {
		colors = new ArrayBlockingQueue<ActiveColor>(nColors);
		for (int i = 1; i <= nColors; i++) {
			ActiveColor actColor = new ActiveColor(Color.BLACK);
			actColor.setPosition(PixMindGame.w - actColor.getWidth() * i - COLORMARGIN * i, PixMindGame.h - actColor.getHeight() - COLORMARGIN);
			colors.add(actColor);
		}
	}
}
