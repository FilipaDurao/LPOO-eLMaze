package com.mygdx.elmaze.model.entities;

public class ButtonModel extends EntityModel {

	private boolean isPressed;
	private final DoorModel openableDoor;
	private float radius;
	
	public ButtonModel(float x, float y, float radius) {
		super(x, y);
		this.radius = radius;
		this.isPressed = false;
		this.openableDoor = null;
	}
	
	public ButtonModel(float x, float y, float radius, DoorModel openableDoor) {
		super(x, y);
		this.radius = radius;
		this.isPressed = false;
		this.openableDoor = openableDoor;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public void press() {
		this.isPressed = true;
		
		if (openableDoor != null) {
			openableDoor.open();
		}
	}
	
	public float getRadius() {
		return radius;
	}
	
	public void setRadius(float radius) {
		this.radius = radius;
	}
}
