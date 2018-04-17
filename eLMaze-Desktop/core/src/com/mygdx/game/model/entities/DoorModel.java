package com.mygdx.game.model.entities;

public class DoorModel extends EntityModel {

	private boolean isOpen;
	
	public DoorModel(float x, float y) {
		super(x, y);
		this.isOpen = false;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
}
