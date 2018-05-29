package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

/**
 * Represents the first multiplayer level Model
 */
public class MPLevel1Model extends MultiPlayerLevelModel {

	/**
	 * @brief Creates the first multiplayer Level
	 */
	public MPLevel1Model() {
		createBalls();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	/**
	 * @brief Creates the Balls of the first multiplayer Level
	 */
	@Override
	protected void createBalls() {
		ball1 = new BallModel(1.5f, 1.5f, 0.5f, 0);
		ball2 = new BallModel(LEVEL_WIDTH - 1.5f, 1.5f, 0.5f, 1);
	}

	/**
	 * @brief Creates the Doors and Buttons of the first multiplayer Level
	 */
	@Override
	protected void createButtonsDoors() {
		DoorModel door1 = new DoorModel(0.5f, LEVEL_HEIGHT/2 - 0.15f, 3.0f, 0.3f);
		DoorModel door2 = new DoorModel(LEVEL_WIDTH-3.5f, LEVEL_HEIGHT/2 - 0.15f, 3.0f, 0.3f);
		doors.add(door1);
		doors.add(door2);
		
		buttons.add(new ButtonModel(LEVEL_WIDTH - 1.5f, LEVEL_HEIGHT - 1.5f, 0.7f, doors.get(0)));
		buttons.add(new ButtonModel(LEVEL_WIDTH/2 - 1.2f, LEVEL_HEIGHT/2 - 1.2f, 0.7f, doors.get(1)));
	}

	/**
	 * @brief Creates the Walls of the first multiplayer Level
	 */
	@Override
	protected void createWalls() {
		walls.add(new WallModel(0, 0, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, LEVEL_HEIGHT - 0.5f, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, LEVEL_HEIGHT));	
		walls.add(new WallModel(LEVEL_WIDTH - 0.5f, 0, 0.5f, LEVEL_HEIGHT));		
		walls.add(new WallModel(LEVEL_WIDTH/2 - 0.25f, 0, 0.5f, LEVEL_HEIGHT));		
		walls.add(new WallModel(3.5f, LEVEL_HEIGHT/2 - 0.25f, LEVEL_WIDTH/2-3.75f, 0.5f));		
		walls.add(new WallModel(LEVEL_WIDTH/2 + 0.25f, LEVEL_HEIGHT/2 - 0.25f, LEVEL_WIDTH/2-3.75f, 0.5f));
	}

	/**
	 * @brief Creates the Exit of the first multiplayer Level
	 */
	@Override
	protected void createExit() {
		exit = new ExitModel(1.5f, LEVEL_HEIGHT - 1.5f, 0.6f);
	}

}
