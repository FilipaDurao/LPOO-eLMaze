package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;

public abstract class MultiPlayerLevelModel extends LevelModel {

	protected BallModel ball1;
	protected BallModel ball2;
	
	public MultiPlayerLevelModel() {
		super();
	}

	public BallModel getBall1() {
		return ball1;
	}
	
	public BallModel getBall2() {
		return ball2;
	}
	
	protected abstract void createBalls();

}
