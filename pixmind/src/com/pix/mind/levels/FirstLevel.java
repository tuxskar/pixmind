package com.pix.mind.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pix.mind.PixMindGame;
import com.pix.mind.box2d.bodies.PixGuy;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.controllers.PixGuyController;

public class FirstLevel implements Screen {
	private OrthographicCamera camera;
	private World world;
	private PixGuy pixGuy;
	private Box2DDebugRenderer debugRenderer; 
	private PixMindGame game;
	
	public FirstLevel(PixMindGame game){
		this.game = game;
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		debugRenderer.render(world, camera.combined);
		
//	pixGuy.moveLeft(delta);
	pixGuy.setActualPosition();
		world.step(delta, 6, 2);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(w * PixMindGame.WORLD_TO_BOX, h * PixMindGame.WORLD_TO_BOX);
		
		// Box2d code
		world = new World(new Vector2(0, -10), true);
		debugRenderer = new Box2DDebugRenderer();
		
		// comment to be commited
		float posX = 0, posY = 0, width=1, heigth=0.2f;
		StaticPlatform sPlatform = new StaticPlatform(world, posX, posY, width, heigth);
		
		Stage stage = new Stage();
		
		posY = 1;
		width = 0.1f;
		heigth = 0.1f;
		// main character initialization
		pixGuy = new PixGuy(world, posX, posY, width, heigth);
		PixGuyController controller = new PixGuyController(pixGuy);
		pixGuy.setController(controller);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
