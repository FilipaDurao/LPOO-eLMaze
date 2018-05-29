package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

/**
 * Represents the third multiplayer level Model
 */
public class MPLevel3Model extends MultiPlayerLevelModel {

	/**
	 *  Creates the third multiplayer Level
	 */
	public MPLevel3Model() {
		createBalls();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	/**
	 *  Creates the Balls of the third multiplayer Level
	 */
	@Override
	protected void createBalls() {
		ball1 = new BallModel(1.5f, LEVEL_HEIGHT/2+0.5f, 0.5f, 0);
		ball2 = new BallModel(LEVEL_WIDTH-1.5f, LEVEL_HEIGHT/2+0.5f, 0.5f, 1);
	}

	/**
	 *  Creates the Doors and the Buttons of the third multiplayer Level
	 */
	@Override
	protected void createButtonsDoors() {
		DoorModel door1 = new DoorModel(LEVEL_WIDTH/2-1f, LEVEL_HEIGHT - 3f, 2.0f, 0.3f);
		doors.add(door1);
		
		buttons.add(new ButtonModel(4.5f, 3.25f, 0.7f));
		buttons.add(new ButtonModel(4.5f, LEVEL_HEIGHT - 3.25f, 0.7f));
		buttons.add(new ButtonModel(LEVEL_WIDTH - 4.5f, 3.25f, 0.7f, door1));
		buttons.add(new ButtonModel(LEVEL_WIDTH - 4.5f, LEVEL_HEIGHT - 3.25f, 0.7f));
	}

	/**
	 *  Creates the Walls of the third multiplayer Level
	 */
	@Override
	protected void createWalls() {
		walls.add(new WallModel(0, 0, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, LEVEL_HEIGHT - 0.5f, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, LEVEL_HEIGHT));	
		walls.add(new WallModel(LEVEL_WIDTH - 0.5f, 0, 0.5f, LEVEL_HEIGHT));	
		walls.add(new WallModel(LEVEL_WIDTH/2 - 1.5f, LEVEL_HEIGHT/2+1.5f, 0.5f, LEVEL_HEIGHT/2-1f));
		walls.add(new WallModel(LEVEL_WIDTH/2 - 1.5f, 0.5f, 0.5f, LEVEL_HEIGHT/2-1f));	
		walls.add(new WallModel(LEVEL_WIDTH/2 + 1f, LEVEL_HEIGHT/2+1.5f, 0.5f, LEVEL_HEIGHT/2-1f));
		walls.add(new WallModel(LEVEL_WIDTH/2 + 1f, 0.5f, 0.5f, LEVEL_HEIGHT/2-1f));
		walls.add(new WallModel(0.5f, LEVEL_HEIGHT/2-1f, 3.35f, 0.5f));
		walls.add(new WallModel(0.5f, LEVEL_HEIGHT/2+1.5f, 3.35f, 0.5f));
		walls.add(new WallModel(5.15f, LEVEL_HEIGHT/2-1f, 3.35f, 0.5f));
		walls.add(new WallModel(5.15f, LEVEL_HEIGHT/2+1.5f, 3.35f, 0.5f));
		walls.add(new WallModel(LEVEL_WIDTH - 8.5f, LEVEL_HEIGHT/2-1f, 3.35f, 0.5f));
		walls.add(new WallModel(LEVEL_WIDTH - 8.5f, LEVEL_HEIGHT/2+1.5f, 3.35f, 0.5f));
		walls.add(new WallModel(LEVEL_WIDTH - 3.85f, LEVEL_HEIGHT/2-1f, 3.35f, 0.5f));
		walls.add(new WallModel(LEVEL_WIDTH - 3.85f, LEVEL_HEIGHT/2+1.5f, 3.35f, 0.5f));

	}

	/**
	 *  Creates the Exit of the third multiplayer Level
	 */
	@Override
	protected void createExit() {
		exit = new ExitModel(LEVEL_WIDTH/2, LEVEL_HEIGHT - 1.5f, 0.6f);
	}

}
