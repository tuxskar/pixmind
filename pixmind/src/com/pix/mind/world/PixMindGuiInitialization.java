package com.pix.mind.world;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.actors.ActiveColor;
import com.pix.mind.actors.ActiveColors;
import com.pix.mind.actors.MapZoom;

public class PixMindGuiInitialization {
	
	ActiveColors actColors;
	
	
	public PixMindGuiInitialization(PixMindScene2DInitialization scene2D, int nColors){
		
		actColors = new ActiveColors(scene2D.getStageGui(), nColors);
		for (ActiveColor actColor : actColors.colors) {
			scene2D.getStageGui().addActor(actColor);
		}
		actColors.newActive(Color.BLUE);
		
	}

	public ActiveColors getActColors() {
		return actColors;
	}

	public void setActColors(ActiveColors actColors) {
		this.actColors = actColors;
	}
	
	
	
	

}
