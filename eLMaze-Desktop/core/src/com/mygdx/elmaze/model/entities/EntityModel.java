package com.mygdx.elmaze.model.entities;

import com.badlogic.gdx.math.Vector2;

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
	
	public void setPosition(Vector2 position) {
		this.x = position.x;
		this.y = position.y;
	}
	
	public Vector2 getPosition() {
		return new Vector2(x, y);
	}
}
