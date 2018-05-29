package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;

/**
 * Represents a Multiplayer Level Model
 */
public abstract class MultiPlayerLevelModel extends LevelModel {

	protected BallModel ball1;
	protected BallModel ball2;
	
	/**
	 *  Creates a multiplayer Level Model
	 */
	public MultiPlayerLevelModel() {
		super();
	}

	/**
	 * @return Returns the first player's Ball of the multiplayer Level
	 */
	public BallModel getBall1() {
		return ball1;
	}
	
	/**
	 * @return Returns the second player's Ball of the multiplayer Level
	 */
	public BallModel getBall2() {
		return ball2;
	}
	
	/**
	 *  Creates the two Balls of a multiplayer Level
	 */
	protected abstract void createBalls();

}
