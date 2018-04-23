package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;

public abstract class SinglePlayerLevelModel extends LevelModel {

	protected BallModel ball;
	
	public SinglePlayerLevelModel() {
		super();
	}

	public BallModel getBall() {
		return ball;
	}
	
	protected abstract void createBall();

}
