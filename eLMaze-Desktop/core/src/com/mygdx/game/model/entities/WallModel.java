package com.mygdx.game.model.entities;

public class WallModel extends EntityModel {
	
	private float width;
	private float height;
	
	public WallModel(float x, float y, float width, float height) {
		super(x, y);
		this.width = width;
		this.height = height;
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
	
	public void resize(float width, float height) {
		this.width = width;
		this.height = height;
	}
}
