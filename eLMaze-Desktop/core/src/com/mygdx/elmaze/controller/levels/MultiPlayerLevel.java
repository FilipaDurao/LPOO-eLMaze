package com.mygdx.elmaze.controller.levels;

import com.mygdx.elmaze.controller.entities.BallBody;
import com.mygdx.elmaze.model.levels.MultiPlayerLevelModel;

public class MultiPlayerLevel extends Level {

	private final BallBody ball1Body;
	private final BallBody ball2Body;
	
	public MultiPlayerLevel(MultiPlayerLevelModel levelModel) {
		super(levelModel);
		
		// Ball
		ball1Body = new BallBody(world, levelModel.getBall1());
		ball2Body = new BallBody(world, levelModel.getBall2());
	}
	
	public BallBody getBall1Body() {
		return ball1Body;
	}
	
	public BallBody getBall2Body() {
		return ball2Body;
	}

}
