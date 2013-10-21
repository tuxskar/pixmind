package com.pix.mind.actors;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.PixMindGame;

public class ActiveColors {

	private final static int COLORMARGIN = 10;
	public int nColors;
	public ArrayList<ActiveColor> activeColorActors;

	public ActiveColors(Stage stageGui, int nColors) {
		this.nColors = nColors;

		activeColorActors = new ArrayList<ActiveColor>();
		activeColorActors.add(new ActiveColor(Color.BLUE, stageGui));
		activeColorActors.add(new ActiveColor(Color.GREEN, stageGui));
		activeColorActors.add(new ActiveColor(Color.MAGENTA, stageGui));
		activeColorActors.add(new ActiveColor(Color.RED, stageGui));
		activeColorActors.add(new ActiveColor(Color.YELLOW, stageGui));

		for (int i = 1; i <= nColors; i++) {
			Image image = new Image(PixMindGame.getSkin().getDrawable(
					PixMindGame.candyColorToTexture.get(Color.CLEAR)));
			image.setSize(60, 60);
			image.setPosition(
					PixMindGame.w - activeColorActors.get(0).getWidth() * i
							- COLORMARGIN * i, PixMindGame.h
							- activeColorActors.get(0).getHeight()
							- COLORMARGIN);
			stageGui.addActor(image);
		}
	}

	public ActiveColor getActiveColorByColor(Color color) {
		ActiveColor activeColor = null;
		for (int i = 0; i < activeColorActors.size(); i++) {
			if (activeColorActors.get(i).c.equals(color)) {
				activeColor = activeColorActors.get(i);
				break;
			}
		}
		return activeColor;
	}

	public void addNewActiveColor(ActiveColor activeColor) {
		shiftToRightAll();
		activeColor.moveActorAt(nColors);
	}

	public void shiftToRightAll() {
		for (int i = 0; i < activeColorActors.size(); i++) {
			if (activeColorActors.get(i).position != 0)
				activeColorActors.get(i).moveActorAt(
						activeColorActors.get(i).position - 1);
		}
	}

	public void shiftToLeftFrom(int position) {
		for (int i = 0; i < activeColorActors.size(); i++) {
			if (activeColorActors.get(i).position != 0
					&& activeColorActors.get(i).position < position)
				activeColorActors.get(i).moveActorAt(
						activeColorActors.get(i).position + 1);
		}
	}

	public void removeActiveColor(ActiveColor activeColor) {
		int position = activeColor.position;
		activeColor.moveActorAt(0);
		shiftToLeftFrom(position);
	}

	public void showArray() {
		System.out.println(activeColorActors.toString());
	}
}
