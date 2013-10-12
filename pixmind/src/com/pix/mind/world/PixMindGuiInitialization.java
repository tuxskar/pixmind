package com.pix.mind.world;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.actors.ActiveColor;
import com.pix.mind.actors.ActiveColors;
import com.pix.mind.actors.MapZoom;

public class PixMindGuiInitialization {
	
	ActiveColors actColors;
	int nColors;
	PixMindScene2DInitialization  scene2D;
	private MapZoom mapZoom;
	 
	public PixMindGuiInitialization(PixMindScene2DInitialization scene2D, PixMindBox2DInitialization box2D) {
		
		this.scene2D= scene2D;		
		mapZoom = new MapZoom(box2D);
		
	}

	public ActiveColors getActColors() {
		return actColors;
	}

	public void setActColors(ActiveColors actColors) {
		this.actColors = actColors;
	}
	
	public void setMaxColorGui(int nColors){
		actColors = new ActiveColors(scene2D.getStageGui(), nColors);
		for (ActiveColor actColor : actColors.colors) {
			scene2D.getStageGui().addActor(actColor);
		}
		actColors.newActive(Color.BLUE);
		this.nColors =nColors; 
	}

	public MapZoom getMapZoom() {
		return mapZoom;
	}

	public void setMapZoom(MapZoom mapZoom) {
		this.mapZoom = mapZoom;
	}
	
	
	
	

}
