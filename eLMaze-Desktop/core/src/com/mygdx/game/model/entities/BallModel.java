package com.mygdx.game.model.entities;

public class BallModel extends EntityModel {
	
	private int playerNum;

	public BallModel(float x, float y, int playerNum) {
		super(x, y);
		this.playerNum = playerNum;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
}
