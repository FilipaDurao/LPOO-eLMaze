package com.mygdx.elmaze.controller.levels;

import com.mygdx.elmaze.controller.CollisionListener;
import com.mygdx.elmaze.controller.entities.BallBody;
import com.mygdx.elmaze.controller.entities.ButtonBody;
import com.mygdx.elmaze.controller.entities.DoorBody;
import com.mygdx.elmaze.controller.entities.ExitBody;
import com.mygdx.elmaze.controller.entities.WallBody;
import com.mygdx.elmaze.model.GameModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.WallModel;

public class SPLevel1 extends SinglePlayerLevel {

	public SPLevel1() {
		super();
		
		ballBody = new BallBody(world, GameModel.getInstance().getBall());
		
		for (WallModel wallModel : GameModel.getInstance().getWalls()) {
			new WallBody(world, wallModel);
		}
		
		new ExitBody(world, GameModel.getInstance().getExit());
		
		for (DoorModel doorModel : GameModel.getInstance().getDoors()) {
			new DoorBody(world, doorModel);
		}
		
		for (ButtonModel buttonModel : GameModel.getInstance().getButtons()) {
			new ButtonBody(world, buttonModel);
		}
		
		world.setContactListener(CollisionListener.getInstance());
	}

}
