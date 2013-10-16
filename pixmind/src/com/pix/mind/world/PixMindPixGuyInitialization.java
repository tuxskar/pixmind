package com.pix.mind.world;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.pix.mind.actors.PixGuyActor;
import com.pix.mind.box2d.bodies.PixGuy;
import com.pix.mind.controllers.ArrowController;
import com.pix.mind.controllers.PixGuyController;

public class PixMindPixGuyInitialization {

	private PixGuy pixGuy;
	private PixGuyController controller;
	private Image pixGuySkin;

	public PixMindPixGuyInitialization(PixMindScene2DInitialization scene2D,
			PixMindBox2DInitialization box2D) {
		// main character initialization
		pixGuy = new PixGuy(box2D.getWorld(), 0.35f, 0.35f);
		pixGuySkin = new PixGuyActor(pixGuy);
		controller = new ArrowController(pixGuy, scene2D.getStageGui());
		pixGuy.setController(controller);
		scene2D.getGroupStage().addActor(pixGuySkin);
		
	}

	public PixGuy getPixGuy() {
		return pixGuy;
	}

	public void setPixGuy(PixGuy pixGuy) {
		this.pixGuy = pixGuy;
	}

	public PixGuyController getController() {
		return controller;
	}

	public void setController(PixGuyController controller) {
		this.controller = controller;
	}

	public Image getPixGuySkin() {
		return pixGuySkin;
	}

	public void setPixGuySkin(Image pixGuySkin) {
		this.pixGuySkin = pixGuySkin;
	}
	public void setPixGuyPosition(float pixGuyBeginsX, float pixGuyBeginsY){
		
		pixGuy.setPixGuyPosition(pixGuyBeginsX, pixGuyBeginsY);
	}
	
	

}
