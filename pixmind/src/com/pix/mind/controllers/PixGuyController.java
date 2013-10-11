package com.pix.mind.controllers;

import com.pix.mind.box2d.bodies.PixGuy;

public abstract class PixGuyController {
	PixGuy pixGuy;
	boolean active = true;
	public PixGuyController(PixGuy pixGuy){
		this.pixGuy = pixGuy;
	}
	
	public abstract void movements();

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
