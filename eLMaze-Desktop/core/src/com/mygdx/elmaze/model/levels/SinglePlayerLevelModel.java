package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;

/**
 * Represents a Singleplayer Level Model
 */
public abstract class SinglePlayerLevelModel extends LevelModel {

	protected BallModel ball;
	
	/**
	 *  Creates a singleplayer Level Model
	 */
	public SinglePlayerLevelModel() {
		super();
	}

	/**
	 * @return Returns the Ball of the Level
	 */
	public BallModel getBall() {
		return ball;
	}
	
	/**
	 *  Creates the Ball of a singleplayer Level
	 */
	protected abstract void createBall();

}
