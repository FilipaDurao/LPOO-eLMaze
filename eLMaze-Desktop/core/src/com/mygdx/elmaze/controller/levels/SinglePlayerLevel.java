package com.mygdx.elmaze.controller.levels;

import com.mygdx.elmaze.controller.entities.BallBody;
import com.mygdx.elmaze.model.levels.SinglePlayerLevelModel;

/**
 * Game Singleplayer level controller
 */
public class SinglePlayerLevel extends Level {
	
	private final BallBody ballBody;

	/**
	 * @param levelModel Singleplayer Level model containing the physical world objects models
	 */
	public SinglePlayerLevel(SinglePlayerLevelModel levelModel) {
		super(levelModel);
		
		ballBody = new BallBody(world, levelModel.getBall());
	}
	
	/**
	 * @return Player physical body object
	 */
	public BallBody getBallBody() {
		return ballBody;
	}

}
