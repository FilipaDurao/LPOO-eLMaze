package com.mygdx.game.model.entities;

public class ExitModel extends EntityModel {

	private float radius;

	public ExitModel(float x, float y, float radius) {
		super(x, y);
		this.radius = radius;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
	
}
