package com.pix.mind.levels;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.ActiveColor;
import com.pix.mind.actors.ActiveColors;
import com.pix.mind.actors.PixGuyActor;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PixGuy;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.controllers.ArrowController;
import com.pix.mind.controllers.PixGuyController;

public class FirstLevel implements Screen {
	private OrthographicCamera camera;
	private World world;
	private PixGuy pixGuy;
	private Box2DDebugRenderer debugRenderer;
	private PixMindGame game;
	private Image pixGuySkin;
	private Stage stage;
	private Stage stageGui;
	private ArrayList<StaticPlatformActor> platformList; 
	private ArrayList<PlatformActivatorActor> activatorList; 
	private ActiveColors actColors;
	public String levelTitle = "First Level";
	private PixGuyController controller;	
	private boolean mapActive= false;
	private boolean showingMap = false;
	private boolean hidingMap = false;
	private Image zoomInActor, zoomOutActor;
	private Group groupStage;
	// adjust this value to show the entire Level
	// the zoom is pointing to 0,0 stage coordinate
	
	
	//needed for the camera to point to the center when zoom in
	//aspect ratio and levelSize needs to be 1.3 ALWAYS(minimum resolution device)
	public float levelSizeHeight =1000;
	public float levelSizeWidth = 1333;

	
	public float zoom =PixMindGame.h/ levelSizeHeight;  
	
	
	//smooth camera following
	//this point is the first platform + its half height
	private float lastPlatformHeight = 210;
	protected float anteriorHeight=210;
	
	
	private boolean colliding = false;
	public FirstLevel(PixMindGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

	//	debugRenderer.render(world, camera.combined);
		stage.draw();
		stageGui.draw();
		
	//	System.out.println(colliding + " " +pixGuy.body.getLinearVelocity().y);
		
		
		if(pixGuy.body.getLinearVelocity().y > 0){
			pixGuy.body.getFixtureList().get(0).setSensor(true);
		}else{
			if(!colliding)
			pixGuy.body.getFixtureList().get(0).setSensor(false);
		}
			
		if(!mapActive){	
			
		
		
		if(lastPlatformHeight>pixGuy.getPosY()){
			
				lastPlatformHeight = pixGuy.getPosY();
				stage.getCamera().position.x = pixGuy.getPosX();
				stage.getCamera().position.y = lastPlatformHeight;		
				camera.position.x = pixGuy.getPosX() * PixMindGame.WORLD_TO_BOX;
				camera.position.y = lastPlatformHeight * PixMindGame.WORLD_TO_BOX;		
				camera.update();
				
				
		}else{
	
			if(lastPlatformHeight>anteriorHeight){
			anteriorHeight += 3f;
			if(anteriorHeight>=lastPlatformHeight){
				anteriorHeight = lastPlatformHeight;
			}
			}
			
			stage.getCamera().position.x = pixGuy.getPosX();
			stage.getCamera().position.y =anteriorHeight;		
			camera.position.x = pixGuy.getPosX() * PixMindGame.WORLD_TO_BOX;
			camera.position.y = anteriorHeight * PixMindGame.WORLD_TO_BOX;		
			camera.update();
		}
		
		world.step(delta, 6, 2);
		
		
		pixGuy.setActualPosition();
	
		}
		stage.act();
	System.out.println(groupStage.getX()+  " - " +groupStage.getY()+ " zoom " + groupStage.getScaleX());
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		// float w = Gdx.graphics.getWidth();
		// float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(PixMindGame.w
				* PixMindGame.WORLD_TO_BOX, PixMindGame.h
				* PixMindGame.WORLD_TO_BOX);
		camera.translate(PixMindGame.w / 2 * PixMindGame.WORLD_TO_BOX,
				PixMindGame.h / 2 * PixMindGame.WORLD_TO_BOX);
		// Box2d code
		world = new World(new Vector2(0, -10f), true);
	
		debugRenderer = new Box2DDebugRenderer();

		
		platformList = new ArrayList<StaticPlatformActor>();
		activatorList = new ArrayList<PlatformActivatorActor>();
		
		// comment to be commited
		//float posX = 2f, posY = 2f, width = 1f, heigth = 0.2f;
		StaticPlatform sPlatform = new StaticPlatform(world, 8,5,1f,0.1f);
		StaticPlatform s2Platform = new StaticPlatform(world,3, 2,1,0.1f);
		StaticPlatform s3Platform = new StaticPlatform(world, 5, 3,1,0.1f);
		StaticPlatform s4Platform = new StaticPlatform(world, 6,4,1,0.1f);
		StaticPlatform s5Platform = new StaticPlatform(world, 1,1f,1,0.1f);
		StaticPlatform s6Platform = new StaticPlatform(world, 2,3,1,0.1f);
		StaticPlatform s7Platform = new StaticPlatform(world, 1.5f,4.2f,1,0.1f);
		StaticPlatform s8Platform = new StaticPlatform(world, -15f,0,30,0.1f);		
		
		
 //s
		PlatformActivator pActivator = new PlatformActivator(world, 0, 5, 0.1f);
		PlatformActivator p2Activator = new PlatformActivator(world, 8, 6, 0.1f);
		PlatformActivator p3Activator= new PlatformActivator(world, 0, 2, 0.1f);
		PlatformActivator p4Activator= new PlatformActivator(world, 2, 5, 0.1f);
		PlatformActivator p5Activator= new PlatformActivator(world, levelSizeWidth*PixMindGame.WORLD_TO_BOX,levelSizeHeight*PixMindGame.WORLD_TO_BOX, 0.1f);

		StaticPlatformActor s1Skin = new StaticPlatformActor(sPlatform,
				Color.RED, false);
		StaticPlatformActor s2Skin = new StaticPlatformActor(s2Platform,
				Color.BLUE, true);
		StaticPlatformActor s3Skin = new StaticPlatformActor(s3Platform,
				Color.GREEN, false);
		StaticPlatformActor s4Skin = new StaticPlatformActor(s4Platform,
				Color.BLACK, true);
		StaticPlatformActor s5Skin = new StaticPlatformActor(s5Platform,
				Color.RED, false);
		StaticPlatformActor s6Skin = new StaticPlatformActor(s6Platform,
				Color.BLACK, true);
		StaticPlatformActor s7Skin = new StaticPlatformActor(s7Platform,
				Color.BLACK, true);
		StaticPlatformActor s8Skin = new StaticPlatformActor(s8Platform,
				Color.BLACK, true);
	
		platformList.add(s1Skin);
		platformList.add(s2Skin);
		platformList.add(s3Skin);
		platformList.add(s4Skin);
		platformList.add(s5Skin);
		platformList.add(s6Skin);
		platformList.add(s7Skin);
		platformList.add(s8Skin);
		
		PlatformActivatorActor a1Skin = new PlatformActivatorActor(pActivator,
				Color.RED, false);
		PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator,
				Color.BLACK, true);
		PlatformActivatorActor a3Skin = new PlatformActivatorActor(p3Activator,
				Color.GREEN, false);
		PlatformActivatorActor a4Skin = new PlatformActivatorActor(p4Activator,
				Color.BLUE, true);
		PlatformActivatorActor a5Skin = new PlatformActivatorActor(p5Activator,
				Color.BLUE, true);

		activatorList.add(a1Skin);
		activatorList.add(a2Skin);
		activatorList.add(a3Skin);
		activatorList.add(a4Skin);
		activatorList.add(a5Skin);
		
	
		// main character initialization
		pixGuy = new PixGuy(world, 4,4, 0.2f, 0.2f);
		stage = new Stage(PixMindGame.w, PixMindGame.h, true);
		
		stageGui = new Stage(PixMindGame.w, PixMindGame.h,
				true);
		stageGui.addListener(new ActorGestureListener(){

			@Override
			public void touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				System.out.println("x " + x + " y " + y);
				if(x<100 && y > 380 && !mapActive){
					
					showMap();
					
				}
				if(x<100 && y > 380  && mapActive ){
					
					hideMap();
					
				}			
				
			}
			
			
			
		});
		
		Gdx.input.setInputProcessor(stageGui);
		
		controller = new ArrowController(pixGuy, stageGui);
		pixGuy.setController(controller);
		pixGuySkin = new PixGuyActor(pixGuy);
		float zoomMargin = 10;
		zoomInActor = new Image (PixMindGame.getSkin().getDrawable("zoomin"));
		zoomOutActor = new Image (PixMindGame.getSkin().getDrawable("zoomout"));
		zoomInActor.setSize(60, 60);
		zoomInActor.setPosition(0+zoomMargin,PixMindGame.h -  zoomInActor.getHeight()-zoomMargin);
		zoomOutActor.setSize(60, 60);
		zoomOutActor.setPosition(0+zoomMargin, PixMindGame.h - zoomInActor.getHeight()-zoomMargin);
		
		stageGui.addActor(zoomInActor);		
		
		groupStage = new Group();
	
		
		groupStage.setOrigin( levelSizeWidth/2, levelSizeHeight/2);
		
		groupStage.addActor(pixGuySkin);
		groupStage.addActor(s1Skin);
		groupStage.addActor(s2Skin);
		groupStage.addActor(s3Skin);
		groupStage.addActor(s4Skin);
		groupStage.addActor(s5Skin);
		groupStage.addActor(s6Skin);
		groupStage.addActor(s7Skin);
		groupStage.addActor(s8Skin);
		
		groupStage.addActor(a1Skin);
		groupStage.addActor(a2Skin);
		groupStage.addActor(a3Skin);
		groupStage.addActor(a4Skin);
		groupStage.addActor(a5Skin);
		
		stage.addActor(groupStage);
		// Active colors
		int nColors = 3;
		actColors = new ActiveColors(stageGui, nColors);
		for(ActiveColor actColor : actColors.colors){
			stageGui.addActor(actColor);
		}
		actColors.newActive(Color.BLUE);
		
		camera.update();

		world.setContactListener(new ContactListener() {

			
			
			
			@Override
			public void beginContact(Contact contact) {
				// TODO Auto-generated method stub
				Fixture fixGuy= null;
				Fixture fixPlatform = null;
				Fixture fixActivator = null;
				//get fixture fixguy
				if (contact.getFixtureA().getUserData().equals(PixGuy.PIX_ID)) {
					fixGuy = contact.getFixtureA();
					// fixPlatform = contact.getFixtureB();
				} else {
					// fixPlatform = contact.getFixtureA();
					fixGuy = contact.getFixtureB();
				}
				
				//get fixture Platform
				if (contact.getFixtureA().getUserData()
						instanceof StaticPlatformActor
						|| contact.getFixtureB().getUserData()
								instanceof StaticPlatformActor ) {
		
					if (contact.getFixtureA().getUserData()
							instanceof StaticPlatformActor) {
						fixPlatform = contact.getFixtureA();
					
					} else {
						
						fixPlatform = contact.getFixtureB();
					}
				}
				
				
				
				//get fixture PlatformActivator
				if (contact.getFixtureA().getUserData()
						instanceof PlatformActivatorActor
						|| contact.getFixtureB().getUserData()
								instanceof PlatformActivatorActor) {
		
					if (contact.getFixtureA().getUserData()
							instanceof PlatformActivatorActor) {
						fixActivator = contact.getFixtureA();
					
					} else {
						
						fixActivator = contact.getFixtureB();
					}
					
				}
				
				
				//collision with a Activator
				if(fixActivator!=null){
					PlatformActivatorActor platformActivatorActor = (PlatformActivatorActor) fixActivator.getUserData();
					if(platformActivatorActor.isActive()){
						//if activator is black go to next level
						if(platformActivatorActor.color.equals(Color.BLACK)){
//							game.changeLevel(game.getSecondLevel());
							game.changeLevel(game.getFirstLevel());
						}
							
						//get all platform of the same color and  change state
						
						for(StaticPlatformActor sp : platformList){
							if(platformActivatorActor.color.equals(sp.color))
							sp.setActive(false);
						}
						//get all activator of the same color and change state 
						for(PlatformActivatorActor sp : activatorList){
							if(platformActivatorActor.color.equals(sp.color)){
							sp.setActive(false);
							actColors.deActivate(sp.color);
							}
						}
					}else{
						//platformActivatorActor.setActive(true);
						//get all platform of the same color and  change state  
						for(StaticPlatformActor sp : platformList){
							if(platformActivatorActor.color.equals(sp.color))
							sp.setActive(true);
						}	
						for(PlatformActivatorActor sp : activatorList){
							if(platformActivatorActor.color.equals(sp.color)){
								sp.setActive(true);	
								actColors.newActive(sp.color);
							}
						}
					}				
				}
				
		
				//jump only if collide with a platform and its not sensor
				if(fixPlatform!=null && !fixPlatform.isSensor()){
				//only jump if bottom position of pixguy is equal or above of top position of the platform
					
					StaticPlatformActor platformActor =  (StaticPlatformActor) fixPlatform.getUserData();					
					//opoppo
					
					float topPosPlatform = fixPlatform.getBody().getPosition().y + platformActor.getHeight()*PixMindGame.WORLD_TO_BOX/2;
					float bottomPosGuy = fixGuy.getBody().getPosition().y-PixGuy.pixHeight*PixMindGame.WORLD_TO_BOX/2;

				//	System.out.println(topPosPlatform);
					//System.out.println(bottomPosGuy);
					if(bottomPosGuy>=topPosPlatform )
					{
					//if(anteriorHeight>lastPlatformHeight)
					
					anteriorHeight = lastPlatformHeight;
					lastPlatformHeight = (fixPlatform.getBody().getPosition().y+ platformActor.getHeight()*PixMindGame.WORLD_TO_BOX/2)*PixMindGame.BOX_TO_WORLD;						
					if(lastPlatformHeight<	anteriorHeight ){
						anteriorHeight = lastPlatformHeight;
					}
					fixGuy.getBody().setLinearVelocity(fixGuy.getBody().getLinearVelocity().x , 0);
					fixGuy.getBody().applyLinearImpulse(new Vector2(0, 0.2f),
					fixGuy.getBody().getWorldCenter(), true);
					}
				}
			System.out.println("contanto");
				colliding = true ;
			}

			@Override
			public void endContact(Contact contact) {
				// TODO Auto-generated method stub
				colliding= false;
			}

			@Override
			public void preSolve(Contact contact, Manifold oldManifold) {
				// TODO Auto-generated method stub
							
			}

			@Override
			public void postSolve(Contact contact, ContactImpulse impulse) {
				// TODO Auto-generated method stub

			}

		});
	}

	
	protected void hideMap() {
		// TODO Auto-generated method stub
		if(showingMap==false && hidingMap == false){
			System.out.println("hiding MAP");
		hidingMap = true;			
		Action finalAction = new Action(){

			@Override
			public boolean act(float delta) {
				// TODO Auto-generated method stub
				mapActive = false;
				hidingMap = false;
				controller.setActive(true);
				zoomOutActor.remove();
				stageGui.addActor(zoomInActor);
				return true;
			}
			
		};
		
		groupStage.addAction(Actions.sequence(Actions.parallel(Actions.scaleTo(1, 1, 1,Interpolation.pow4), Actions.moveTo( 0,0, 1,Interpolation.pow4)),finalAction));	
			
			
		}
		
	}
	
	
	protected void showMap() {
		System.out.println("showing MAP");
		mapActive = true;
		showingMap = true;
		controller.setActive(false);
		Action finalAction = new Action(){

			@Override
			public boolean act(float delta) {
				// TODO Auto-generated method stub
				showingMap = false;	
				System.out.println("final action show");
				zoomInActor.remove();
				stageGui.addActor(zoomOutActor);
				return true;
			}			
		};		
		
		groupStage.addAction(Actions.sequence(Actions.parallel(Actions.scaleTo(zoom, zoom, 1,Interpolation.pow4), Actions.moveTo( -((levelSizeWidth/2)- pixGuySkin.getX()),  -((levelSizeHeight/2)- lastPlatformHeight), 1,Interpolation.pow4)),finalAction));	
	
		
		
	
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
		

	}

}
