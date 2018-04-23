package com.mygdx.elmaze.controller.levels;

import com.mygdx.elmaze.controller.CollisionListener;
import com.mygdx.elmaze.controller.entities.BallBody;
import com.mygdx.elmaze.controller.entities.ButtonBody;
import com.mygdx.elmaze.controller.entities.DoorBody;
import com.mygdx.elmaze.controller.entities.ExitBody;
import com.mygdx.elmaze.controller.entities.WallBody;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.WallModel;
import com.mygdx.elmaze.model.levels.SinglePlayerLevelModel;

public class SinglePlayerLevel extends Level {
	
	protected BallBody ballBody;

	public SinglePlayerLevel(SinglePlayerLevelModel levelModel) {
		super();
		
		// Ball
		ballBody = new BallBody(world, levelModel.getBall());
		
		// Exit
		new ExitBody(world, levelModel.getExit());
		
		// Walls
		for (WallModel wallModel : levelModel.getWalls()) {
			new WallBody(world, wallModel);
		}
		
		// Doors
		for (DoorModel doorModel : levelModel.getDoors()) {
			new DoorBody(world, doorModel);
		}
		
		// Buttons
		for (ButtonModel buttonModel : levelModel.getButtons()) {
			new ButtonBody(world, buttonModel);
		}
		
		world.setContactListener(CollisionListener.getInstance());
	}
	
	public BallBody getBallBody() {
		return ballBody;
	}

}
