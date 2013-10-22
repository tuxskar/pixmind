package com.pix.mind.levels;

import com.badlogic.gdx.graphics.Color;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level05 extends PixMindLevel {
    public String levelTitle = "LevelTwo";
    PixMindGame game;
    private static final int nActiveColors = 1;
    public Level05(PixMindGame game) {
        super(game, 640, 480, 1600, 1, 16, nActiveColors);
        this.game = game;
        levelNumber = 5;
    }

    @Override
    public void show() {

        super.show();
        super.setNextLevel(game.getLevel06());
        super.setActiveLevel(this);
        // platform Actors and Activator Actors List

        // Creating All Static Platforms
        float wallW = 0.25f;
        float wallH = 10;
        float platW = 1f;
        float platH = 0.1f;

        // Box2D platforms
        // Walls
        StaticPlatform s1Plat = new StaticPlatform(box2D.getWorld(), 0, 10, wallW, wallH);
        StaticPlatform s2Plat = new StaticPlatform(box2D.getWorld(), 4.5f, 15, wallW, wallH);
        StaticPlatform s3Plat = new StaticPlatform(box2D.getWorld(), 8, 10, wallW, wallH);

        // Normal StaticPlatforms
        StaticPlatform s4Plat = new StaticPlatform(box2D.getWorld(), 1.25f, 15, platW, platH);
        StaticPlatform s5Plat = new StaticPlatform(box2D.getWorld(), 3.25f, 15, platW, platH);

        // Actor Platforms
        StaticPlatformActor s1Skin = new StaticPlatformActor(s1Plat, Color.BLACK, true);
        StaticPlatformActor s2Skin = new StaticPlatformActor(s2Plat, Color.BLACK, true);
        StaticPlatformActor s3Skin = new StaticPlatformActor(s3Plat, Color.BLACK, true);
        StaticPlatformActor s4Skin = new StaticPlatformActor(s4Plat, Color.BLACK, true);
        StaticPlatformActor s5Skin = new StaticPlatformActor(s5Plat, Color.BLUE, true);

        // Add platforms to Stage
        scene2D.getGroupStage().addActor(s1Skin);
        scene2D.getGroupStage().addActor(s2Skin);
        scene2D.getGroupStage().addActor(s3Skin);
        scene2D.getGroupStage().addActor(s4Skin);
        scene2D.getGroupStage().addActor(s5Skin);

        // Add to platform list
        box2D.getPlatformList().add(s1Skin);
        box2D.getPlatformList().add(s2Skin);
        box2D.getPlatformList().add(s3Skin);
        box2D.getPlatformList().add(s4Skin);
        box2D.getPlatformList().add(s5Skin);

        // Creating All Activator

        // Box2D Activator
        float ARad = 0.2f;
        PlatformActivator p1Activator = new PlatformActivator(box2D.getWorld(), 6, 15, ARad);
        PlatformActivator p2Activator = new PlatformActivator(box2D.getWorld(), 3, 16, ARad);

        // Actor Activator
        PlatformActivatorActor a1Skin = new PlatformActivatorActor(p1Activator, Color.BLACK, true);
        PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator, Color.BLUE, true);

        // Add activators to Stage
        scene2D.getGroupStage().addActor(a1Skin);
        scene2D.getGroupStage().addActor(a2Skin);

        // Add to activator list
        box2D.getActivatorList().add(a1Skin);
        box2D.getActivatorList().add(a2Skin);

        // add to stage the group of actors

        // Active colors

        // Rendering the game
        box2D.addActivatedColor(Color.BLUE);
        worldRenderer = new PixMindWorldRenderer(scene2D, box2D, gui);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
    }
}
