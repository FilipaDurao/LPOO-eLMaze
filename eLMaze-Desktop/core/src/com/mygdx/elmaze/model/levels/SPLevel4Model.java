package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

/**
 * Represents the fourth singleplayer Level Model
 */
public class SPLevel4Model extends SinglePlayerLevelModel {

	/**
	 *  Creates the fourth singleplayer Level
	 */
	public SPLevel4Model() {
		createBall();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	/**
	 *  Creates the Ball of the fourth singleplayer Level
	 */
	@Override
	protected void createBall() {
		ball = new BallModel(1.3f, 1.3f, 0.5f, 0);
	}

	/**
	 *  Creates the Buttons and the Door of the fourth singleplayer Level
	 */
	@Override
	protected void createButtonsDoors() {
		DoorModel door1 = new DoorModel(LEVEL_WIDTH - 2.3f, LEVEL_HEIGHT-2.7f, 1.8f, 0.3f);
		DoorModel door2 = new DoorModel(0.5f, LEVEL_HEIGHT-2.7f, 1.8f, 0.3f);
		doors.add(door1);
		doors.add(door2);
		
		buttons.add(new ButtonModel(LEVEL_WIDTH - 3.8f, LEVEL_HEIGHT - 1.4f, 0.7f, door1));
		buttons.add(new ButtonModel(LEVEL_WIDTH - 6.2f, LEVEL_HEIGHT - 3.9f, 0.7f, door2));
	}

	/**
	 *  Creates the Walls of the fourth singleplayer Level
	 */
	@Override
	protected void createWalls() {
		walls.add(new WallModel(0, 0, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, LEVEL_HEIGHT - 0.5f, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, LEVEL_HEIGHT));	
		walls.add(new WallModel(LEVEL_WIDTH - 0.5f, 0, 0.5f, LEVEL_HEIGHT));			
		walls.add(new WallModel(0.5f, 2.3f, LEVEL_WIDTH - 2.8f, 0.5f));	
		walls.add(new WallModel(LEVEL_WIDTH - 2.8f, 2.3f, 0.5f, LEVEL_HEIGHT-6.6f));	
		walls.add(new WallModel(LEVEL_WIDTH - 2.8f, LEVEL_HEIGHT-2.8f, 0.5f, 2.3f));	
		walls.add(new WallModel(2.3f, LEVEL_HEIGHT-2.8f, LEVEL_WIDTH-5.1f, 0.5f));
		walls.add(new WallModel(LEVEL_WIDTH - 5.1f, 4.6f, 0.5f, LEVEL_HEIGHT-7.4f));	
		walls.add(new WallModel(2.3f, 4.6f, LEVEL_WIDTH - 7.4f, 0.5f));
		walls.add(new WallModel(2.3f, 6.9f, 0.5f, LEVEL_HEIGHT-9.7f));	
		walls.add(new WallModel(2.8f, 6.9f, LEVEL_WIDTH - 9.7f, 0.5f));	
		walls.add(new WallModel(4.6f, 9.5f, LEVEL_WIDTH - 9.7f, 0.5f));
	}

	/**
	 *  Creates the Exit of the fourth singleplayer Level
	 */
	@Override
	protected void createExit() {
		exit = new ExitModel(LEVEL_WIDTH - 1.4f, LEVEL_HEIGHT - 1.4f, 0.6f);
	}

}
