package com.mygdx.elmaze.model.entities;

public class BallModel extends EntityModel {
	
	private int playerNum;
	private float radius;

	public BallModel(float x, float y, float radius, int playerNum) {
		super(x, y);
		this.playerNum = playerNum;
		this.radius = radius;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
}
