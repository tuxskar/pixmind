package com.pix.mind.actors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pix.mind.PixMindGame;

public class ActiveColors {

	private Stage stageGui;
	
	public int nColors;
	public ArrayList<ActiveColor> activeColorActors;

	public ActiveColors(Stage stageGui, int nColors) {
		// TODO Auto-generated constructor stub
		this.nColors = nColors;
		this.stageGui = stageGui;
		
		activeColorActors = new ArrayList<ActiveColor>();
		activeColorActors.add( new ActiveColor(Color.BLUE, stageGui));
		activeColorActors.add(new ActiveColor(Color.GREEN, stageGui));
		activeColorActors.add( new ActiveColor(Color.MAGENTA, stageGui));
		activeColorActors.add( new ActiveColor(Color.RED, stageGui));
		activeColorActors.add(new ActiveColor(Color.YELLOW, stageGui));	
	}
	
	public  ActiveColor getActiveColorByColor(Color color){
		ActiveColor activeColor=null;
		for(int i =0; i< activeColorActors.size();i++){
			if(activeColorActors.get(i).c.equals(color)){
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
	public void shiftToRightAll(){
		for(int i =0; i< activeColorActors.size();i++){
			if(activeColorActors.get(i).position!=0) 
				activeColorActors.get(i).moveActorAt(activeColorActors.get(i).position-1);			
		}		
	}
	public void shiftToLeftFrom(int position){
		for(int i =0; i< activeColorActors.size();i++){			
			if(activeColorActors.get(i).position!=0 && activeColorActors.get(i).position < position)
			activeColorActors.get(i).moveActorAt(activeColorActors.get(i).position+1);		
	}
	}
	public void removeActiveColor(ActiveColor activeColor){			
		int position = activeColor.position;
		activeColor.moveActorAt(0);
		shiftToLeftFrom(position);	
	}
	public void showArray(){		
		System.out.println(activeColorActors.toString());
	}

	

	/*
	 * private ArrayList<ActiveColor> colors; private final static int
	 * COLORMARGIN = 10; private int nActivated; // private Stage guiStage; //
	 * private HashMap<Color, ActiveColor> colorToTexture;
	 * 
	 * public ActiveColors(Stage guiStage, int nColors) { // this.guiStage =
	 * guiStage; // colorToTexture = new HashMap<Color, ActiveColor>(); //
	 * colorToTexture.put(Color.BLUE, new ActiveColor(Color.BLUE)); //
	 * colorToTexture.put(Color.CLEAR, new ActiveColor(Color.CLEAR)); //
	 * colorToTexture.put(Color.GREEN, new ActiveColor(Color.GREEN)); //
	 * colorToTexture.put(Color.RED, new ActiveColor(Color.RED)); //
	 * colorToTexture.put(Color.YELLOW, new ActiveColor(Color.YELLOW)); //
	 * colorToTexture.put(Color.BLACK, new ActiveColor(Color.BLACK));
	 * 
	 * colors = new ArrayList<ActiveColor>(nColors); for (int i = 1; i <=
	 * nColors; i++) { ActiveColor actColor = new ActiveColor(Color.CLEAR);
	 * guiStage.addActor(actColor); actColor.setPosition(PixMindGame.w -
	 * actColor.getWidth() * i - COLORMARGIN * i, PixMindGame.h -
	 * actColor.getHeight() - COLORMARGIN); colors.add(actColor); nActivated =
	 * 0; } }
	 * 
	 * public void newActive(Color color) { for (int i = colors.size() - 1; i >
	 * 0; i--) { colors.get(i).setColor(colors.get(i - 1).getColor()); }
	 * colors.get(0).setColor(color); nActivated++; // for (int i =
	 * colors.size() - 1; i > 0; i--) { // Color preColor =
	 * colors.get(i-1).getColor(); //
	 * colors.get(i).setDrawable(PixMindGame.getSkin
	 * ().getDrawable(PixMindGame.candyColorToTexture.get(preColor))); // } //
	 * colors.get(0).setDrawable(PixMindGame.getSkin().getDrawable(PixMindGame.
	 * candyColorToTexture.get(color))); // nActivated++; }
	 * 
	 * public int alreadyActive(Color color) { for (ActiveColor actColor :
	 * colors) { if (actColor.getColor().equals(color)) { return
	 * colors.indexOf(actColor); } } return -1; // for (ActiveColor actColor :
	 * colors) { // if (actColor.getColor().equals(color)) { // return
	 * colors.indexOf(actColor); // } // } // return -1; }
	 * 
	 * public void deActivate(Color color) { int indexActivate =
	 * alreadyActive(color); if (indexActivate != -1) { for(int i=indexActivate;
	 * i<colors.size()-1;i++){
	 * colors.get(i).setColor(colors.get(i+1).getColor()); }
	 * colors.get(colors.size()-1).setColor(Color.CLEAR); nActivated--; } // int
	 * indexActivate = alreadyActive(color); // if (indexActivate != -1) { //
	 * for (int i = indexActivate; i < colors.size() - 1; i++) { //
	 * colors.get(i).setDrawable(PixMindGame.getSkin().getDrawable(PixMindGame.
	 * candyColorToTexture.get(colors.get(i + 1).getColor()))); // } //
	 * colors.get(colors.size() -
	 * 1).setDrawable(PixMindGame.getSkin().getDrawable
	 * (PixMindGame.candyColorToTexture.get(Color.CLEAR))); // nActivated--; //
	 * } }
	 * 
	 * public int getMaxColors() { return colors.size(); }
	 * 
	 * public Color deActivateOlderColors() { Color color =
	 * colors.get(colors.size()-1).getColor().cpy();
	 * colors.get(colors.size()-1).setColor(Color.CLEAR); nActivated--; return
	 * color; // Color color = colors.get(colors.size() - 1).getColor().cpy();
	 * // colors.get(colors.size() -
	 * 1).setDrawable(PixMindGame.getSkin().getDrawable
	 * (PixMindGame.candyColorToTexture.get(Color.CLEAR))); // nActivated--; //
	 * return color; }
	 * 
	 * public int getNActivesColors() { return nActivated; }
	 */
}
