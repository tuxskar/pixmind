package com.pix.mind.world;

import com.pix.mind.PixMindGame;
import com.pix.mind.actors.ActiveColors;
import com.pix.mind.actors.MapZoom;
import com.pix.mind.actors.MenuInGame;

public class PixMindGuiInitialization {
	
	ActiveColors actColors;
	int nColors;
	PixMindScene2DInitialization  scene2D;
	private MapZoom mapZoom;
	private MenuInGame menuInGame;
	private PixMindGame  game;
	public PixMindGuiInitialization(PixMindScene2DInitialization scene2D, PixMindBox2DInitialization box2D, PixMindGame game) {
		
		this.scene2D= scene2D;		
		mapZoom = new MapZoom( box2D,scene2D);
		menuInGame = new MenuInGame(scene2D.getStageGui(), game);
		box2D.getContactListener().setGui(this);
		this.game = game;
	}

	public ActiveColors getActColors() {
		return actColors;
	}

	public void setActColors(ActiveColors actColors) {
		this.actColors = actColors;
	}

	public MapZoom getMapZoom() {
		return mapZoom;
	}

	public void setMapZoom(MapZoom mapZoom) {
		this.mapZoom = mapZoom;
	}

	public MenuInGame getMenuInGame() {
		return menuInGame;
	}

	public void setMenuInGame(MenuInGame menuInGame) {
		this.menuInGame = menuInGame;
	}
	
	
	
	

}
