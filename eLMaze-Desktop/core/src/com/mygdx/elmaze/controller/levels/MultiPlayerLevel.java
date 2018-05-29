package com.mygdx.elmaze.controller.levels;

import com.mygdx.elmaze.controller.entities.BallBody;
import com.mygdx.elmaze.model.levels.MultiPlayerLevelModel;

/**
 * Game Multiplayer level controller
 */
public class MultiPlayerLevel extends Level {

	private final BallBody ball1Body;
	private final BallBody ball2Body;
	
	/**
	 * @param levelModel Multiplayer Level model containing the physical world objects models
	 */
	public MultiPlayerLevel(MultiPlayerLevelModel levelModel) {
		super(levelModel);
		
		ball1Body = new BallBody(world, levelModel.getBall1());
		ball2Body = new BallBody(world, levelModel.getBall2());
	}
	
	/**
	 * @return Player one physical body object
	 */
	public BallBody getBall1Body() {
		return ball1Body;
	}

	/**
	 * @return Player two physical body object
	 */
	public BallBody getBall2Body() {
		return ball2Body;
	}

}
