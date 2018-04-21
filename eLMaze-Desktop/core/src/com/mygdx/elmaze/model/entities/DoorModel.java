package com.mygdx.elmaze.model.entities;

public class DoorModel extends EntityModel {

	private boolean isOpen;	
	private float width;
	private float height;
	
	
	public DoorModel(float x, float y, float width, float height) {
		super(x, y);
		this.isOpen = false;
		this.width = width;
		this.height = height;
	}

	public boolean isOpen() {
		return isOpen;
	}
	
	public boolean isClosed() {
		return !isOpen;
	}

	public void open() {
		this.isOpen = true;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	
}
