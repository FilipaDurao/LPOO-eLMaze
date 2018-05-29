package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

/**
 * Represents the first singleplayer Level Model
 */
public class SPLevel1Model extends SinglePlayerLevelModel {

	/**
	 *  Creates the first singleplayer Level 
	 */
	public SPLevel1Model() {
		createBall();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	/**
	 *  Creates the Ball of the first singleplayer Level
	 */
	@Override
	protected void createBall() {
		ball = new BallModel(2.05f, LEVEL_HEIGHT - 2.05f, 0.5f, 0);
	}

	/**
	 *  Creates the Buttons and Doors of the second singleplayer Level
	 */
	@Override
	protected void createButtonsDoors() {}

	/**
	 *  Creates the Walls of the first singleplayer Level
	 */
	@Override
	protected void createWalls() {
		walls.add(new WallModel(0, 0, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, LEVEL_HEIGHT - 0.5f, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, LEVEL_HEIGHT));	
		walls.add(new WallModel(LEVEL_WIDTH - 0.5f, 0, 0.5f, LEVEL_HEIGHT));			
		walls.add(new WallModel(0.5f, (LEVEL_HEIGHT-0.25f)*1/4, LEVEL_WIDTH - 3.5f, 0.5f));			
		walls.add(new WallModel(0.5f, (LEVEL_HEIGHT-0.25f)*2/4, LEVEL_WIDTH - 3.5f, 0.5f));			
		walls.add(new WallModel(0.5f, (LEVEL_HEIGHT-0.25f)*3/4, LEVEL_WIDTH - 3.5f, 0.5f));
	}

	/**
	 *  Creates the Exit of the first singleplayer Level
	 */
	@Override
	protected void createExit() {
		exit = new ExitModel(2.05f, (LEVEL_HEIGHT-0.25f)*3/8 + 0.25f, 0.6f);
	}

}
