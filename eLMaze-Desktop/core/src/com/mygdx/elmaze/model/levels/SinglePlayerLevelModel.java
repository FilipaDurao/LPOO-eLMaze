package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;

public abstract class SinglePlayerLevelModel extends LevelModel {

	protected BallModel ball;
	
	/**
	 * @brief Creates a singleplayer Level Model
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
	 * @brief Creates the Ball of a singleplayer Level
	 */
	protected abstract void createBall();

}
