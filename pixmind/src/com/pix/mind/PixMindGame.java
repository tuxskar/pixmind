package com.pix.mind;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.pix.mind.levels.FirstLevel;
import com.pix.mind.levels.LevelOne;
import com.pix.mind.levels.LevelThree;
import com.pix.mind.levels.LevelTwo;
import com.pix.mind.levels.SecondLevel;
import com.pix.mind.screens.LevelSelector1Screen;
import com.pix.mind.screens.LevelSelector2Screen;
import com.pix.mind.screens.MainMenuScreen;
import com.pix.mind.screens.SplashScreen;

public class PixMindGame extends Game {
	private MainMenuScreen mainMenu;
	private LevelOne levelOne;
	private LevelTwo levelTwo;
	private LevelThree levelThree;
	private FirstLevel firstLevel;
	private SecondLevel secondLevel;
	private SplashScreen splashScreen;
	private LevelSelector1Screen levelSelector1Screen;
	private LevelSelector2Screen levelSelector2Screen;
	
	public static final float WORLD_TO_BOX = 0.01f;
	public static final float BOX_TO_WORLD = 100f;
	public static float h = 480; 		
	public static float w = 800;

	private AssetManager assetManager;
	private static Skin skin;
	private static Music music;
	private static Sound boing;
	private static Sound gettingActivator;
	private static Sound winning;
	private static Sound losing;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		w = h * Gdx.graphics.getWidth()/Gdx.graphics.getHeight();	
		assetManager = new AssetManager();	
		mainMenu = new MainMenuScreen(this);
		levelOne = new LevelOne(this);
		levelTwo = new LevelTwo(this);
		levelThree = new LevelThree(this);
		splashScreen = new SplashScreen(this);
		
		levelSelector1Screen = new LevelSelector1Screen(this);
		levelSelector2Screen = new LevelSelector2Screen(this);
//		this.setScreen(getMainMenuScreen());
		this.setScreen(getSplashScreen());
	}
	

	public void changeLevel(Screen screen){	
		this.setScreen(screen);
	}
	
	// GETTERs & SETTERs
	

	public AssetManager getAssetManager() {
		return assetManager;
	}

	// skin getters & setters
	
	public static Skin getSkin() {
		return skin;
	}

	public static void setSkin(Skin skin) {
		PixMindGame.skin = skin;
	}
	
	
	
	// levels and other screens getters & setters
	
	public SplashScreen getSplashScreen() {
		return splashScreen;
	}
	
	public LevelOne getLevelOne() {
		return levelOne;
	}
	
	public MainMenuScreen getMainMenuScreen() {
		return mainMenu;
	}

	public LevelTwo getLevelTwo() {
		return levelTwo;
	}

	public void setLevelTwo(LevelTwo levelTwo) {
		this.levelTwo = levelTwo;
	}

	public void setLevelOne(LevelOne levelOne) {
		this.levelOne = levelOne;
	}

	public LevelThree getLevelThree() {
		return levelThree;
	}

	public void setLevelThree(LevelThree levelThree) {
		this.levelThree = levelThree;
	}


	public static Music getMusic() {
		return music;
	}


	public static void setMusic(Music music) {
		PixMindGame.music = music;
	}


	public LevelSelector1Screen getLevelSelector1Screen() {
		return levelSelector1Screen;
	}


	public void setLevelSelector1Screen(LevelSelector1Screen levelSelector1Screen) {
		this.levelSelector1Screen = levelSelector1Screen;
	}


	public LevelSelector2Screen getLevelSelector2Screen() {
		return levelSelector2Screen;
	}


	public void setLevelSelector2Screen(LevelSelector2Screen levelSelector2Screen) {
		this.levelSelector2Screen = levelSelector2Screen;
	}


	public static Sound getBoing() {
		return boing;
	}


	public static void setBoing(Sound boing) {
		PixMindGame.boing = boing;
	}


	public static Sound getGettingActivator() {
		return gettingActivator;
	}


	public static void setGettingActivator(Sound gettingActivator) {
		PixMindGame.gettingActivator = gettingActivator;
	}


	public static Sound getWinning() {
		return winning;
	}


	public static void setWinning(Sound winning) {
		PixMindGame.winning = winning;
	}


	public static Sound getLosing() {
		return losing;
	}


	public static void setLosing(Sound losing) {
		PixMindGame.losing = losing;
	}


	
	
}
