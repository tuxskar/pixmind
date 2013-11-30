package com.pix.mind.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.pix.mind.BodyEditorLoader;
import com.pix.mind.PixMindGame;

public class MainMenuScreen implements Screen {
	private Drawable[] candiesDrawables = new Drawable[4] ; 
	
	static final float candySize = 0.2f;
	private PixMindGame game;
	Stage mainMenuStage;
	Image playImageS2D, optionsImageS2D, exitImageS2D, titleImageS2D, backgroundImage, background;
	World world;
	Image sweet, mind, sweetes;
	private OrthographicCamera camera;
	private Box2DDebugRenderer debugRenderer;
	private ArrayList<Body> candies;
	public MainMenuScreen(PixMindGame game) {
		super();
		this.game = game;
		
	}
	float time =  0;
	float randomTime = 0;
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		Gdx.gl.glClearColor(1, 1, 1, 1); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		// we only need to draw and not to act because we always want to show exactly the same, and anything modify it along the time
		mainMenuStage.act();
		mainMenuStage.draw();
		world.step(delta,  6, 2);
		
		//debugRenderer.render(world, camera.combined);
		for(Body b : candies){
			Image im = (Image)b.getFixtureList().get(0).getUserData();
			im.setPosition((b.getPosition().x - candySize)*PixMindGame.BOX_TO_WORLD, (b.getPosition().y-candySize)*PixMindGame.BOX_TO_WORLD);					
			im.setRotation(-45+(float) (b.getAngle()*360/(2*Math.PI)));
		}
		time = time + delta;
		if(time >0.7f  && randomTime ==0){
			randomTime = (float) Math.random();			
		}
		if(time>0.7f && randomTime!=0){
			float randomPosition = (float) Math.random()*PixMindGame.w*PixMindGame.WORLD_TO_BOX;		
			float randomRotation = (float) Math.random()*90;	
			float randomCandy = (float) Math.random()*4;		
		//	System.out.print(randomCandy+ " - ");
		//	System.out.println((int) randomCandy);
			
			generateCandy(world,randomPosition,6.8f,randomRotation, candiesDrawables[(int) randomCandy]);
			time=0;
			randomTime = 0;
		}
		
		//remove candy if its out of screen
		for(int i = 0; i<candies.size();i++){
			if(candies.get(i).getFixtureList().get(0).getBody().getPosition().y < 0){
				Image image = 	(Image) candies.get(i).getFixtureList().get(0).getUserData();
				image.remove();				
				world.destroyBody(candies.get(i));
				candies.remove(i);
				
			}
		/*	Image im = (Image)b.getFixtureList().get(0).getUserData();
			im.setPosition((b.getPosition().x - 0.2f)*PixMindGame.BOX_TO_WORLD, (b.getPosition().y-0.2f)*PixMindGame.BOX_TO_WORLD);					
			im.setRotation((float) (b.getAngle()*360/(2*Math.PI)));*/
		}
		
	//	System.out.print("size: " + candies.size());
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

		// creating actors (image)
		mainMenuStage = new Stage(PixMindGame.w, PixMindGame.h, true);
		
		Gdx.input.setInputProcessor(mainMenuStage);
		
		// for to catch BACK Android button events
		Gdx.input.setCatchBackKey(true);
		//to move according to the resolutuion, we create a group to put inside all menu elements
		Group menuGroup = new Group(); //to move according to the resolutuion
		background = new Image(PixMindGame.getSkin().getDrawable("emptyscreen"));
		background.setColor(Color.valueOf("ff8000AA"));
		
		//backgroundImage = new Image(PixMindGame.getSkin().getDrawable("personaje fondo"));
		playImageS2D = new Image(PixMindGame.getSkin().getDrawable("play no selec"));
		optionsImageS2D = new Image(PixMindGame.getSkin().getDrawable("options no selec"));
		exitImageS2D = new Image(PixMindGame.getSkin().getDrawable("exit no selec"));
		//titleImageS2D = new Image(PixMindGame.getSkin().getDrawable("sweetmind"));
		sweet = new Image(PixMindGame.getSkin().getDrawable("sweet"));
		mind = new Image(PixMindGame.getSkin().getDrawable("mind"));
		sweetes = new Image(PixMindGame.getSkin().getDrawable("caramelos1"));
		
		
		// adding actor listeners
		playImageS2D.addListener(new ActorGestureListener(){
			boolean selected = true;
			public void touchDown (InputEvent event, float x, float y, int pointer, int button) {			
				playImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("play selec"));
				selected = true;
	         }
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				if(selected){ 
				System.out.println("PLAY TOUCHED");
				if(PixMindGame.infoFx)
					PixMindGame.getMenuClick().play(0.3f);		
	               game.changeLevel(game.getLevelSelector1Screen());
				}
			}
	
			@Override
			public void pan(InputEvent event, float x, float y, float deltaX,
					float deltaY) {
				// TODO Auto-generated method stub
				   System.out.println("x " + x + " y " + y);
				   System.out.println("x " + playImageS2D.getWidth() + " y "+ playImageS2D.getHeight());
				   if(x<0 || x>playImageS2D.getWidth() || y<0 || y>playImageS2D.getHeight()){
						   playImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("play no selec"));
					   selected= false;
					   }						   
			}
			
		});
		
		optionsImageS2D.addListener(new ActorGestureListener(){
			boolean selected = true;
			public void touchDown (InputEvent event, float x, float y, int pointer, int button) {			
				optionsImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("options selec"));
				selected = true;
	         }
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				if(selected){ 
				System.out.println("PLAY TOUCHED");
				if(PixMindGame.infoFx)
					PixMindGame.getMenuClick().play(0.3f);		
	               game.changeLevel(game.getOptionsMenuScreen());
				}
			}
	
			@Override
			public void pan(InputEvent event, float x, float y, float deltaX,
					float deltaY) {
				// TODO Auto-generated method stub
				   System.out.println("x " + x + " y " + y);
				   System.out.println("x " + playImageS2D.getWidth() + " y "+ playImageS2D.getHeight());
				   if(x<0 || x>optionsImageS2D.getWidth() || y<0 || y>optionsImageS2D.getHeight()){
					   optionsImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("options no selec"));
					   selected= false;
					   }						   
			}
			
		});
		
		exitImageS2D.addListener(new ActorGestureListener(){
			boolean selected = true;
			public void touchDown (InputEvent event, float x, float y, int pointer, int button) {			
				exitImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("exit selec"));
				selected = true;
	         }
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				if(selected){ 
				System.out.println("PLAY TOUCHED");
				if(PixMindGame.infoFx)
					PixMindGame.getMenuClick().play(0.3f);		
	            Gdx.app.exit();
				}
			}
	
			@Override
			public void pan(InputEvent event, float x, float y, float deltaX,
					float deltaY) {
				// TODO Auto-generated method stub
				   System.out.println("x " + x + " y " + y);
				   System.out.println("x " + playImageS2D.getWidth() + " y "+ playImageS2D.getHeight());
				   if(x<0 || x>exitImageS2D.getWidth() || y<0 || y>exitImageS2D.getHeight()){
					   exitImageS2D.setDrawable(PixMindGame.getSkin().getDrawable("exit no selec"));
					   selected= false;
					   }						   
			}
			
		});
		
		
		// setting actors positions
		playImageS2D.setPosition((PixMindGame.w/2)-playImageS2D.getWidth()/2-200, 330);
		optionsImageS2D.setPosition((PixMindGame.w/2)-optionsImageS2D.getWidth()/2, 330);
		exitImageS2D.setPosition((PixMindGame.w/2)-exitImageS2D.getWidth()/2+200, 330);
	//	titleImageS2D.setPosition((PixMindGame.w/2)-titleImageS2D.getWidth()/2, 350);
		background.setPosition((PixMindGame.w/2)-background.getWidth()/2, 0);
		//backgroundImage.setPosition(PixMindGame.w-backgroundImage.getWidth(), 0);
		playImageS2D.setScale(0.9f);
		optionsImageS2D.setScale(0.9f);
		exitImageS2D.setScale(0.9f);
		
		
	/*	Interpolation interpolation = Interpolation.linear;
		playImageS2D.setOrigin(playImageS2D.getWidth()/2, playImageS2D.getHeight()/2);
		//playImageS2D.setRotation(-1);
		playImageS2D.setScale(0.9f);
		playImageS2D.addAction(Actions.forever(Actions.sequence(
				Actions.scaleBy(0.05f, -0.05f, 1f, interpolation),			
				Actions.scaleBy(-0.05f, 0.05f, 1f, interpolation))));
		optionsImageS2D.setOrigin(optionsImageS2D.getWidth()/2, optionsImageS2D.getHeight()/2);
		//optionsImageS2D.setRotation(-1);
		optionsImageS2D.setScale(0.9f);
		optionsImageS2D.addAction(Actions.forever(Actions.sequence(
				Actions.scaleBy(0.05f, -0.05f, 1f, interpolation),			
				Actions.scaleBy(-0.05f, 0.05f, 1f, interpolation))));
		exitImageS2D.setOrigin(exitImageS2D.getWidth()/2, exitImageS2D.getHeight()/2);
		//exitImageS2D.setRotation(-1);
		exitImageS2D.setScale(0.9f);
		exitImageS2D.addAction(Actions.forever(Actions.sequence(
				Actions.scaleBy(0.05f, -0.05f, 1f, interpolation),			
				Actions.scaleBy(-0.05f, 0.05f, 1f, interpolation))));*/

		// adding actors to the stage (to an stage group)
		mainMenuStage.addActor(background);
	//	mainMenuStage.addActor(backgroundImage);
		mainMenuStage.addActor(playImageS2D);
		mainMenuStage.addActor(optionsImageS2D);
		mainMenuStage.addActor(exitImageS2D);
		//mainMenuStage.addActor(titleImageS2D);
		//mainMenuStage.addActor(sweet);
		//mainMenuStage.addActor(mind);
	//	mainMenuStage.addActor(sweetes);

	
		
		//menuGroup.setPosition(-(854-PixMindGame.w)/2, 0);
	
			// loading and playing main menu music loop
		PixMindGame.getMusic().setLooping(true);
		PixMindGame.getMusic().setVolume(0.7f);
		if (PixMindGame.infoMusic)
			PixMindGame.getMusic().play();
		/*if ( PixMindGame.getMusic().isPlaying() && game.getMusicState().equalsIgnoreCase("off") )
			PixMindGame.getMusic().stop();*/
		
		/*Preferences oP = Gdx.app.getPreferences("OptionsPrefs");
		boolean musicOn = oP.getBoolean("mus");
		if ( musicOn && !PixMindGame.getMusic().isPlaying() )
			PixMindGame.getMusic().play();
		if ( !musicOn && PixMindGame.getMusic().isPlaying() )
			PixMindGame.getMusic().stop();
		*/
	//	mainMenuStage.addActor(menuGroup);
		
		
		//animacion
		candies = new ArrayList<Body>();
		debugRenderer = new Box2DDebugRenderer();
		world = new World(new Vector2(0, -6f), true);
		
		
		camera = new OrthographicCamera(PixMindGame.w
				* PixMindGame.WORLD_TO_BOX, PixMindGame.h
				* PixMindGame.WORLD_TO_BOX);
		camera.translate(PixMindGame.w / 2 * PixMindGame.WORLD_TO_BOX,
				PixMindGame.h / 2 * PixMindGame.WORLD_TO_BOX);
	
	/*	generatePlatform(world,  +PixMindGame.w* PixMindGame.WORLD_TO_BOX*0.22f,  3, PixMindGame.w / 4.4f* PixMindGame.WORLD_TO_BOX,  0.1f,  - (float)Math.PI/5.4f);
		generatePlatform(world,  PixMindGame.w* PixMindGame.WORLD_TO_BOX-PixMindGame.w* PixMindGame.WORLD_TO_BOX*0.22f,  3,   PixMindGame.w / 4.4f* PixMindGame.WORLD_TO_BOX,0.1f,   (float)Math.PI/5.4f);
		generatePlatform(world, PixMindGame.w* PixMindGame.WORLD_TO_BOX/2,  0.1f,  1.5f, 0.1f,  0);
       */
		//generateCandy(world,2,4,10, PixMindGame.getSkin().getDrawable("redcandy"));
		generateSweet(world, (PixMindGame.w/2)-(sweet.getWidth())-20,110, sweet);
		generateMind(world, (PixMindGame.w/2)+50,110, mind);
		//generatePlatform(world, 3,0.3f,0.589f*4,0.138f*4,0);
		sweetes.setPosition((PixMindGame.w/2)-sweetes.getWidth()/2, 0);
		mainMenuStage.addActor(sweetes);
		
		
	//	titleImageS2D.setZIndex(200);
		exitImageS2D.setZIndex(200);
		optionsImageS2D.setZIndex(200);
		playImageS2D.setZIndex(200);
		
		camera.update();
		
		candiesDrawables[0] = PixMindGame.getSkin().getDrawable("redcandy");
		candiesDrawables[1] = PixMindGame.getSkin().getDrawable("bluecandy");
		candiesDrawables[2] = PixMindGame.getSkin().getDrawable("greencandy");
		candiesDrawables[3] = PixMindGame.getSkin().getDrawable("orangecandy");
		
	}
	
	private void generateSweet(World world, float x, float y, Image image) {
		
		
		// 0. Create a loader for the file saved from the editor.
	    BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal("gfx/sweet"));
	 
	    // 1. Create a BodyDef, as usual.
	    BodyDef bd = new BodyDef();
	    bd.position.set(x*PixMindGame.WORLD_TO_BOX, y*PixMindGame.WORLD_TO_BOX);
	    bd.type = BodyType.StaticBody;
	 
	    // 2. Create a FixtureDef, as usual.
	    FixtureDef fd = new FixtureDef();
	    fd.density = 1;
	    fd.friction = 0.9f;
	    fd.restitution = 0.6f;
	 
	    // 3. Create a Body, as usual.
	    Body  bottleModel = world.createBody(bd);
	 
	    // 4. Create the body fixture automatically by using the loader.
	    loader.attachFixture(bottleModel, "sweet", fd, 2.85f);
	    image.setPosition(x, y);
	    mainMenuStage.addActor(image);
	}
	private void generateMind(World world, float x, float y, Image image) {
		
		
		// 0. Create a loader for the file saved from the editor.
	    BodyEditorLoader loader = new BodyEditorLoader(Gdx.files.internal("gfx/sweet"));
	 
	    // 1. Create a BodyDef, as usual.
	    BodyDef bd = new BodyDef();
	    bd.position.set(x*PixMindGame.WORLD_TO_BOX, y*PixMindGame.WORLD_TO_BOX);
	    bd.type = BodyType.StaticBody;
	 
	    // 2. Create a FixtureDef, as usual.
	    FixtureDef fd = new FixtureDef();
	    fd.density = 1;
	    fd.friction = 0.9f;
	    fd.restitution = 0.6f;
	 
	    // 3. Create a Body, as usual.
	    Body  bottleModel = world.createBody(bd);
	 
	    // 4. Create the body fixture automatically by using the loader.
	    loader.attachFixture(bottleModel, "mind", fd, 2.35f);
	    image.setPosition(x, y);
	    mainMenuStage.addActor(image);
	}

	private void generateCandy(World world, float x, float y, float rotation, Drawable image) {
	
		BodyDef bodyDef = new BodyDef();
		//bodyDef.fixedRotation = true;
		// We set our body to dynamic, for something like ground which doesn't
		// move we would set it to StaticBody
		bodyDef.type = BodyType.DynamicBody;
	
		// Set our body's starting position in the world
		//setPosition(x, y);
		bodyDef.position.set(x,y);
		//bodyDef.angle = (float) (Math.PI/7);
		// Create our body in the world using our body definition
		Body body = world.createBody(bodyDef);

		
		// Create a polygon shape
	
		// Set the polygon shape as a box which is twice the size of our view
		// port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		// groundBox.setAsBox(camera.viewportWidth, 10.0f);
		Shape groundBox;
		if(image.equals( PixMindGame.getSkin().getDrawable("bluecandy"))){
			groundBox = new PolygonShape();
			PolygonShape s = (PolygonShape) groundBox;
			s.setAsBox(candySize,candySize/2.2f);
		}else if (image.equals( PixMindGame.getSkin().getDrawable("greencandy"))){
			groundBox = new CircleShape();
			groundBox.setRadius(candySize/1.7f);
			
		}else{
			groundBox = new CircleShape();
			groundBox.setRadius(candySize);
		}
		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = groundBox;
		fixtureDef.density = 1f;
		fixtureDef.friction = 0.9f;	
		fixtureDef.restitution = 0.6f; // Make it bounce a little bit
		// Create our fixture and attach it to the body
		Fixture fixture = body.createFixture(fixtureDef);
		

		Image candyImage = new Image(image);
	
		candyImage.setSize(candySize * PixMindGame.BOX_TO_WORLD
				* 2, candySize * PixMindGame.BOX_TO_WORLD
				* 2);
		candyImage.setOrigin(candySize* PixMindGame.BOX_TO_WORLD, candySize * PixMindGame.BOX_TO_WORLD);
		candyImage.setPosition((body.getPosition().x - candySize)*PixMindGame.BOX_TO_WORLD, (body.getPosition().y-candySize)*PixMindGame.BOX_TO_WORLD);					
		
		candyImage.setRotation((float) (body.getAngle()*360/(2*Math.PI)));

		
		mainMenuStage.addActor(candyImage);
		fixture.setUserData(candyImage);
		
		candies.add(body);
		
		groundBox.dispose();
		
		
		
	}

	public void generatePlatform(World world, float x, float y, float width, float height, float rotation){
		BodyDef groundBodyDef =new BodyDef();  
		// Set its world position
		groundBodyDef.type = BodyType.StaticBody;
		groundBodyDef.position.set(new Vector2(x, y));  
		groundBodyDef.angle = rotation;
		// Create a body from the defintion and add it to the world
		Body groundBody = world.createBody(groundBodyDef);  

		// Create a polygon shape
		PolygonShape groundBox = new PolygonShape();  
		// Set the polygon shape as a box which is twice the size of our view port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		//	groundBox.setAsBox(camera.viewportWidth, 10.0f);
		groundBox.setAsBox(width, height);
		// Create a fixture definition to apply our shape to
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = groundBox;
		fixtureDef.density = 0.5f; 
		
		//fixtureDef.isSensor = true; //dont collide phisically but register collide information
	
		fixtureDef.friction = 0.4f;
		//fixtureDef.restitution = 0.6f; // Make it bounce a little bit
		// Create our fixture and attach it to the body
		Fixture fixture = groundBody.createFixture(fixtureDef);
	
		
		Image platformImage = new Image(PixMindGame.getSkin().getDrawable("caramelos1"));
	
		platformImage.setSize(width * PixMindGame.BOX_TO_WORLD
				* 2, height * PixMindGame.BOX_TO_WORLD
				* 2);
		platformImage.setPosition(x * PixMindGame.BOX_TO_WORLD - width*PixMindGame.BOX_TO_WORLD, y * PixMindGame.BOX_TO_WORLD-height*PixMindGame.BOX_TO_WORLD);
		platformImage.setOrigin(width * PixMindGame.BOX_TO_WORLD,  height * PixMindGame.BOX_TO_WORLD);
		platformImage.rotate((float) (360*rotation/(2*Math.PI)));
		mainMenuStage.addActor(platformImage);
		

		groundBox.dispose();
		
	
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
		mainMenuStage.dispose();		
	   	world.dispose();
	   	candies.clear();
	   	
	}

}
