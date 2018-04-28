package com.mygdx.elmaze.controller.levels;

import com.mygdx.elmaze.controller.entities.BallBody;
import com.mygdx.elmaze.model.levels.SinglePlayerLevelModel;

public class SinglePlayerLevel extends Level {
	
	private final BallBody ballBody;

	public SinglePlayerLevel(SinglePlayerLevelModel levelModel) {
		super(levelModel);
		
		// Ball
		ballBody = new BallBody(world, levelModel.getBall());
	}
	
	public BallBody getBallBody() {
		return ballBody;
	}

}
