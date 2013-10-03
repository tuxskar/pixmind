package com.pix.mind.controllers;

import com.pix.mind.box2d.bodies.PixGuy;

public abstract class PixGuyController {
	PixGuy pixGuy;
	
	public PixGuyController(PixGuy pixGuy){
		this.pixGuy = pixGuy;
	}
	
	public abstract void movements();
}
