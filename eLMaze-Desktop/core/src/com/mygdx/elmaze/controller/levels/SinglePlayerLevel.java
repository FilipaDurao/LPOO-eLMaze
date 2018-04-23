package com.mygdx.elmaze.controller.levels;

import com.mygdx.elmaze.controller.entities.BallBody;

public class SinglePlayerLevel extends Level {
	
	protected BallBody ballBody;

	public SinglePlayerLevel() {
		super();
	}
	
	public BallBody getBallBody() {
		return ballBody;
	}

}
