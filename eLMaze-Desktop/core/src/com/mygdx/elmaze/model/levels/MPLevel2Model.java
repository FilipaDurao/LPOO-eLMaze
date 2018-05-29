package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

/**
 * Represents the second multiplayer level Model
 */
public class MPLevel2Model extends MultiPlayerLevelModel {

	/**
	 *  Creates the second multiplayer Level
	 */
	public MPLevel2Model() {
		createBalls();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	/**
	 *  Creates the Balls of the second multiplayer Level
	 */
	@Override
	protected void createBalls() {
		ball1 = new BallModel(LEVEL_WIDTH-3.5f, 1.4f, 0.5f, 0);
		ball2 = new BallModel(1.5f, LEVEL_HEIGHT-1.5f, 0.5f, 1);
	}

	/**
	 *  Creates the Buttons and the Doors of the second multiplayer Level
	 */
	@Override
	protected void createButtonsDoors() {
		DoorModel door1 = new DoorModel(LEVEL_WIDTH-2.5f, 0.5f, 0.3f, 1.9f);
		DoorModel door2 = new DoorModel(2.5f, LEVEL_HEIGHT-2.5f, 0.3f, 2f);
		doors.add(door1);
		doors.add(door2);

		buttons.add(new ButtonModel(1.5f, 1.4f, 0.7f, doors.get(0)));
		buttons.add(new ButtonModel(LEVEL_WIDTH-1.5f, LEVEL_HEIGHT-1.5f, 0.7f, doors.get(1)));
	}

	/**
	 *  Creates the Walls of the second multiplayer Level
	 */
	@Override
	protected void createWalls() {
		walls.add(new WallModel(0, 0, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, LEVEL_HEIGHT - 0.5f, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, LEVEL_HEIGHT));	
		walls.add(new WallModel(LEVEL_WIDTH/2-0.25f, 0.5f, 0.5f, LEVEL_HEIGHT-1));
		walls.add(new WallModel(LEVEL_WIDTH - 0.5f, 0, 0.5f, LEVEL_HEIGHT));
		walls.add(new WallModel(0.5f, 2.4f, 7.2f, 0.5f));	
		walls.add(new WallModel(2.55f, 4.8f, 7.2f, 0.5f));
		walls.add(new WallModel(0.5f, 7.2f, 7.2f, 0.5f));
		walls.add(new WallModel(2.55f, 9.6f, 7.2f, 0.5f));	
		walls.add(new WallModel(0.5f, 12f, 7.2f, 0.5f));
		walls.add(new WallModel(12.3f, 2.4f, 7.2f, 0.5f));	
		walls.add(new WallModel(10.25f, 4.8f, 7.2f, 0.5f));
		walls.add(new WallModel(12.3f, 7.2f, 7.2f, 0.5f));
		walls.add(new WallModel(10.25f, 9.6f, 7.2f, 0.5f));	
		walls.add(new WallModel(12.3f, 12f, 7.2f, 0.5f));	
	}

	/**
	 *  Creates the Exit of the second multiplayer Level
	 */
	@Override
	protected void createExit() {
		exit = new ExitModel(LEVEL_WIDTH-1.3f, 1.3f, 0.5f);
	}

}
