package com.pix.mind.actors;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pix.mind.PixMindGame;

public class ActiveColors {
	public ArrayList<ActiveColor> colors;
	private final static int COLORMARGIN = 10;
	private int nActivated;
	private Stage guiStage;
	private HashMap<Color, ActiveColor> colorToTexture;

	public ActiveColors(Stage guiStage, int nColors) {
		this.guiStage = guiStage;
		colorToTexture = new HashMap<Color, ActiveColor>();
		colorToTexture.put(Color.BLUE, new ActiveColor(Color.BLUE));
		colorToTexture.put(Color.CLEAR, new ActiveColor(Color.CLEAR));
		colorToTexture.put(Color.GREEN, new ActiveColor(Color.GREEN));
		colorToTexture.put(Color.RED, new ActiveColor(Color.RED));
		colorToTexture.put(Color.YELLOW, new ActiveColor(Color.YELLOW));
		colorToTexture.put(Color.BLACK, new ActiveColor(Color.BLACK));

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
		ActiveColor actColor;
		for (int i = colors.size() - 1; i > 0; i--) {
			colorToTexture.get(colors.get(i - 1).getColor()).remove();
			actColor = colorToTexture.get(color);
			actColor.setPosition(PixMindGame.w - actColor.getWidth() * i
					- COLORMARGIN * i, PixMindGame.h - actColor.getHeight()
					- COLORMARGIN);
			guiStage.addActor(actColor);
			colors.set(i, colorToTexture.get(colors.get(i - 1).getColor()));
		}
		colorToTexture.get(colors.get(0).getColor()).remove();
		actColor = colorToTexture.get(color);
		colors.set(0, actColor);
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
//		int indexActivate = alreadyActive(color);
//		if (indexActivate != -1) {
//			for (int i = indexActivate; i < colors.size() - 1; i++) {
//				colors.get(i).setColor(colors.get(i + 1).getColor());
//			}
//			colors.get(colors.size() - 1).setColor(Color.CLEAR);
//			nActivated--;
//		}
	}

	public int getMaxColors() {
		return colors.size();
	}

	public Color deActivateOlderColors() {
		Color color = colors.get(colors.size() - 1).getColor().cpy();
//		colors.get(colors.size() - 1).setColor(Color.CLEAR);
		nActivated--;
		return color;
	}

	public int getNActivesColors() {
		return nActivated;
	}
}
