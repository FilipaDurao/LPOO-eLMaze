package com.mygdx.game.model.entities;

public class EntityModel {
	
	private float x;
	private float y;
	
	public EntityModel(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}	
	
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
