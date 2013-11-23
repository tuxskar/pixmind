package com.pix.mind.levels;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.pix.mind.PixMindGame;
import com.pix.mind.actors.PlatformActivatorActor;
import com.pix.mind.actors.StaticPlatformActor;
import com.pix.mind.box2d.bodies.PlatformActivator;
import com.pix.mind.box2d.bodies.StaticPlatform;
import com.pix.mind.world.PixMindWorldRenderer;

public class Level01 extends PixMindLevel {
 
    public String levelTitle = "LevelOne";

    PixMindGame game;
    private static final int nActiveColors = 1;
    public Level01(PixMindGame game) {
            super(game, 640, 480, 10, 1.7f, 2, nActiveColors);
            this.game = game;
            levelNumber = 1;
            // TODO Auto-generated constructor stub
    }

    @Override
    public void show() {
            // TODO Auto-generated method stub

            super.show();
            super.setNextLevel(game.getLevel02());
            super.setActiveLevel(this);
            // CREANDO EL NIVEL

            // platform Actors and Activator Actors List

            // Creating All Static Platforms

            // Box2D platforms
            StaticPlatform sPlatform = new StaticPlatform(box2D.getWorld(), 1.7f, 0.1f,
                            1f, 0.1f);
            StaticPlatform s2Platform = new StaticPlatform(box2D.getWorld(), 4.7f, 0.1f,
                            1, 0.1f);

            // Actor Platforms
            StaticPlatformActor s1Skin = new StaticPlatformActor(sPlatform,
                            Color.BLACK, true);
            StaticPlatformActor s2Skin = new StaticPlatformActor(s2Platform,
                            Color.RED, false);
            
            // Add platforms to Stage

            scene2D.getGroupStage().addActor(s1Skin);
            scene2D.getGroupStage().addActor(s2Skin);
    

            // Add to platform list

            box2D.getPlatformList().add(s1Skin);
            box2D.getPlatformList().add(s2Skin);
            

            // Creating All Activator

            // Box2D Activator

            PlatformActivator pActivator = new PlatformActivator(box2D.getWorld(),
                            0.7f, 1.9f, 0.2f);
            PlatformActivator p2Activator = new PlatformActivator(box2D.getWorld(),
                            5, 1.9f, 0.2f);

            // Actor Activator

            PlatformActivatorActor a1Skin = new PlatformActivatorActor(pActivator,
                            Color.RED, false);
            PlatformActivatorActor a2Skin = new PlatformActivatorActor(p2Activator,
                            Color.BLACK, true);

            // Add activators to Stage
            
            
            scene2D.getGroupStage().addActor(a1Skin);
            scene2D.getGroupStage().addActor(a2Skin);
            // Add to activator list

            box2D.getActivatorList().add(a1Skin);
            box2D.getActivatorList().add(a2Skin);
            
            // add to stage the group of actors

            // Active colors

            // Rendering the game
            //box2D.addActivatedColor(Color.BLUE);
            worldRenderer = new PixMindWorldRenderer(scene2D, box2D, gui);
            tutorialInitialization();
          //  gui.getMenuInGame().setActive(true);
    }
    float time =0;
    int tutoState =0;
    @Override
    public void render(float delta) {
		super.render(delta);
		stageTutorial.act();
    	stageTutorial.draw();
    
    	
    	//System.out.println("y " + box2D.getPixGuy().getPixGuySkin().getY());
    	time = time +delta;    
        if(box2D.getPixGuy().getPixGuySkin().getY() > 75 && box2D.getPixGuy().getPixGuySkin().getY() < 85 && tutoState ==0){
            	 showFirstStep();
            	 this.worldRenderer.render = false;	
        }
        if(box2D.getPixGuy().getPixGuySkin().getY() > 75 && box2D.getPixGuy().getPixGuySkin().getY() < 85 && tutoState ==1){
       	 showSecondStep();
       	 this.worldRenderer.render = false;	
   }  
        if(gui.getMapZoom().touchedOnce & tutoState ==2){
        	time=0;
        	tutoState++;
        }
        
        if(box2D.getPixGuy().getPixGuySkin().getY() > 75 && box2D.getPixGuy().getPixGuySkin().getY() < 85 &&  tutoState ==3 ){
          	 showThirdStep();
          	 this.worldRenderer.render = false;	
      }  

    }
    private void showThirdStep() {
	Gdx.input.setInputProcessor(stageTutorial);
    	
		// TODO Auto-generated method stub
	bubble1.getColor().a = 0;
	bubble2.getColor().a = 0;
	bubble3.getColor().a = 0;   	
	bubble4.getColor().a = 0;
      	bubble1.addAction(Actions.sequence(Actions.fadeIn( 0.3f)));
    	bubble2.addAction(Actions.sequence(Actions.fadeIn(0.6f)));	
    	bubble3.addAction(Actions.sequence(Actions.fadeIn(0.9f)));	
    	bubble4.addAction(Actions.sequence(Actions.fadeIn(1.2f)));	
    	
    	stageTutorial.addActor(bubble1);
    	stageTutorial.addActor(bubble2);
    	stageTutorial.addActor(bubble3);
    	stageTutorial.addActor(bubble4);
    	
    	bubble1.setPosition(40 + PixMindGame.w/2, 250 +  box2D.getPixGuy().getPixGuySkin().getY());
    	bubble2.setPosition(45 + PixMindGame.w/2, 265 +  box2D.getPixGuy().getPixGuySkin().getY());
    	bubble3.setPosition(55 + PixMindGame.w/2,285 + box2D.getPixGuy().getPixGuySkin().getY());
    	bubble4.setPosition(65 + PixMindGame.w/2, 260 + box2D.getPixGuy().getPixGuySkin().getY());
    
    
    	l.setPosition(90 + PixMindGame.w/2,  350 +  box2D.getPixGuy().getPixGuySkin().getY());
    	l1.setPosition(72 + PixMindGame.w/2, 330 +  box2D.getPixGuy().getPixGuySkin().getY());
    	l2.setPosition(116 + PixMindGame.w/2,  300 +  box2D.getPixGuy().getPixGuySkin().getY());
    	
    	l.setText("I activate the transparent");
    	l1.setText(" platforms getting the candies");
    	l2.setText("Tap to continue");
    
    	stageTutorial.addActor(l);
    	stageTutorial.addActor(l1);
    	stageTutorial.addActor(l2);
		
	}

	private void showSecondStep() {
    	Gdx.input.setInputProcessor(stageTutorial);
    	
    	
		// TODO Auto-generated method stub
    	
    	bubble1.getColor().a = 0;
    	bubble2.getColor().a = 0;
    	bubble3.getColor().a = 0;   	
    	bubble4.getColor().a = 0;
    	
      	bubble1.addAction(Actions.sequence(Actions.fadeIn( 0.3f)));
    	bubble2.addAction(Actions.sequence(Actions.fadeIn(0.6f)));	
    	bubble3.addAction(Actions.sequence(Actions.fadeIn(0.9f)));	
    	bubble4.addAction(Actions.sequence(Actions.fadeIn(1.2f)));	
    	
    	stageTutorial.addActor(bubble1);
    	stageTutorial.addActor(bubble2);
    	stageTutorial.addActor(bubble3);
    	stageTutorial.addActor(bubble4);
    	
    	bubble1.setPosition(40 + PixMindGame.w/2, 250 +  box2D.getPixGuy().getPixGuySkin().getY());
    	bubble2.setPosition(45 + PixMindGame.w/2, 265 +  box2D.getPixGuy().getPixGuySkin().getY());
    	bubble3.setPosition(55 + PixMindGame.w/2,285 + box2D.getPixGuy().getPixGuySkin().getY());
    	bubble4.setPosition(65 + PixMindGame.w/2, 260 + box2D.getPixGuy().getPixGuySkin().getY());
    
    
    	l.setPosition(87 + PixMindGame.w/2,  350 +  box2D.getPixGuy().getPixGuySkin().getY());
    	l1.setPosition(105 + PixMindGame.w/2,  330 +  box2D.getPixGuy().getPixGuySkin().getY());
    	l2.setPosition(116 + PixMindGame.w/2,  300 +  box2D.getPixGuy().getPixGuySkin().getY());
    	
    	l.setText("Touch the zoom button to");
    	l1.setText("see the entire screen");
    	l2.setText("Tap to continue");
    	stageTutorial.addActor(l);
    	stageTutorial.addActor(l1);
    	stageTutorial.addActor(l2);
	}
	LabelStyle ls;
    Label l, l1,l2;
    Stage stageTutorial;
    Image bubble1, bubble2, bubble3, bubble4;
    
    private void showFirstStep() {
    	//delete pixguy actions
    	/*if(box2D.getPixGuy().getPixGuySkin().getActions().size>0){
    		box2D.getPixGuy().getPixGuySkin().removeAction(box2D.getPixGuy().getPixGuySkin().getActions().get(0));    		
    	}*/
    	
    	Gdx.input.setInputProcessor(stageTutorial);    
    	bubble1.getColor().a = 0;
    	bubble2.getColor().a = 0;
    	bubble3.getColor().a = 0;   	
    	bubble4.getColor().a = 0;
    	bubble1.addAction(Actions.sequence(Actions.fadeIn( 0.3f)));
    	bubble2.addAction(Actions.sequence(Actions.fadeIn(0.6f)));	
    	bubble3.addAction(Actions.sequence(Actions.fadeIn(0.9f)));	
    	bubble4.addAction(Actions.sequence(Actions.fadeIn(1.2f)));	
    
    	bubble1.setPosition(40 + PixMindGame.w/2, 250 +  box2D.getPixGuy().getPixGuySkin().getY());
    	bubble2.setPosition(45 + PixMindGame.w/2, 265 +  box2D.getPixGuy().getPixGuySkin().getY());
    	bubble3.setPosition(55 + PixMindGame.w/2,285 + box2D.getPixGuy().getPixGuySkin().getY());
    	bubble4.setPosition(65 + PixMindGame.w/2, 260 + box2D.getPixGuy().getPixGuySkin().getY());
    
    
    	l.setPosition(116 + PixMindGame.w/2, 350 +  box2D.getPixGuy().getPixGuySkin().getY());
    	l1.setPosition(90 + PixMindGame.w/2, 330 +  box2D.getPixGuy().getPixGuySkin().getY());
    	l2.setPosition(116 + PixMindGame.w/2, 300 +  box2D.getPixGuy().getPixGuySkin().getY());
    	
    	stageTutorial.addActor(bubble1);
    	stageTutorial.addActor(bubble2);
    	stageTutorial.addActor(bubble3);
    	stageTutorial.addActor(bubble4);
    	stageTutorial.addActor(l);
    	stageTutorial.addActor(l1);
    	stageTutorial.addActor(l2);
    		}
    private void tutorialInitialization(){
    	stageTutorial =  new Stage(PixMindGame.w, PixMindGame.h, true);	
    	ls = new LabelStyle(new BitmapFont(), Color.BLACK);
    	 l = new Label("To pass the level", ls);
    	l1 = new Label("I need to get the lollipop!!", ls);
    	l2 = new Label("Tap to Continue", ls);
    	
    	stageTutorial.addListener(new listener());
    	bubble1 = new Image(PixMindGame.getSkin().getDrawable("bubble1"));
    	bubble2 = new Image(PixMindGame.getSkin().getDrawable("bubble2"));
    	bubble3 = new Image(PixMindGame.getSkin().getDrawable("bubble3"));
    	bubble4 = new Image(PixMindGame.getSkin().getDrawable("bubble4"));
    
    
    	
    		
    	
    	
    }

    class listener extends InputListener{

		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			// TODO Auto-generated method stub
			System.out.println("poepe");
			Level01.this.worldRenderer.render = true;	
			Gdx.input.setInputProcessor(scene2D.getStageGui());
			l.remove();
			l1.remove();
			l2.remove();
			tutoState++;	
			bubble1.remove();
			bubble1.clear();
			bubble2.remove();
			bubble2.clear();
			bubble3.remove();			
			bubble3.clear();
			bubble4.remove();
			bubble4.clear();
			time=0;
			return super.touchDown(event, x, y, pointer, button);
			
		}

    	
		


    	
    }
	/*
     * (non-Javadoc)
     * 
     * @see com.pix.mind.levels.PixMindLevel#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
            // TODO Auto-generated method stub
            super.resize(width, height);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.pix.mind.levels.PixMindLevel#hide()
     */
    @Override
    public void hide() {
            // TODO Auto-generated method stub
            super.hide();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.pix.mind.levels.PixMindLevel#pause()
     */
    @Override
    public void pause() {
            // TODO Auto-generated method stub
            super.pause();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.pix.mind.levels.PixMindLevel#resume()
     */
    @Override
    public void resume() {
            // TODO Auto-generated method stub
            super.resume();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.pix.mind.levels.PixMindLevel#dispose()
     */
    @Override
    public void dispose() {
            // TODO Auto-generated method stub
    }

}
