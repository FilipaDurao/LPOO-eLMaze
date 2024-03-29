package com.mygdx.elmaze.model.entities;

/**
 * Represents a BallModel
 */
public class BallModel extends EntityModel {
	
	private int playerNum;
	private float radius;

	/**
	 * @param x The Ball's x position
	 * @param y The Ball's y position
	 * @param radius The Ball's radius
	 * @param playerNum The number of the player that controls the Ball
	 */
	public BallModel(float x, float y, float radius, int playerNum) {
		super(x, y);
		this.playerNum = playerNum;
		this.radius = radius;
	}

	/**
	 * @return Returns the number of the player that controls the Ball
	 */
	public int getPlayerNum() {
		return playerNum;
	}

	/**
	 *  Sets the number of the player that controls the Ball
	 * 
	 * @param playerNum The number to set as the player number of the Ball
	 */
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	/**
	 * @return Sets the Ball's radius
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 *  Sets the radius of the Ball
	 * 
	 * @param radius The value to set as the Ball's radius
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}
}
