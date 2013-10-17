package com.pix.mind.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pix.mind.PixMindGame;

public class ActiveColors {
	public ArrayList<ActiveColor> colors;
	private final static int COLORMARGIN = 10;
	private int nActivated;

	public ActiveColors(Stage guiStage, int nColors) {
		colors = new ArrayList<ActiveColor>(nColors);
		for (int i = 1; i <= nColors; i++) {
			ActiveColor actColor = new ActiveColor(Color.CLEAR);
			guiStage.addActor(actColor);
			actColor.setPosition(PixMindGame.w - actColor.getWidth() * i
					- COLORMARGIN * i, PixMindGame.h - actColor.getHeight()
					- COLORMARGIN);
			colors.add(actColor);
			nActivated = 0;
		}
	}

	public void newActive(Color color) {
		for (int i = colors.size() - 1; i > 0; i--) {
			colors.get(i).setColor(colors.get(i - 1).getColor());
		}
		colors.get(0).setColor(color);
		nActivated++;
	}

	public int alreadyActive(Color color) {
		for (ActiveColor actColor : colors) {
			if (actColor.getColor().equals(color)) {
				return colors.indexOf(actColor);
			}
		}
		return -1;
	}

	public void deActivate(Color color) {
		int indexActivate = alreadyActive(color);
		if (indexActivate != -1) {
			for(int i=indexActivate; i<colors.size()-1;i++){
				colors.get(i).setColor(colors.get(i+1).getColor());
			}
			colors.get(colors.size()-1).setColor(Color.CLEAR);
			nActivated--;
		}
	}
	
	public int getMaxColors(){
		return colors.size();
	}
	
	public Color deActivateOlderColors(){
		Color color = colors.get(colors.size()-1).getColor().cpy();
		colors.get(colors.size()-1).setColor(Color.CLEAR);
		nActivated--;
		return color;
	}
	
	public int getNActivesColors(){
		return nActivated;
	}
}
