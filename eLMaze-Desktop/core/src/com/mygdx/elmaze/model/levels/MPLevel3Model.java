package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

public class MPLevel3Model extends MultiPlayerLevelModel {

	/**
	 * @brief Creates the third multiplayer Level
	 */
	public MPLevel3Model() {
		createBalls();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	/**
	 * @brief Creates the Balls of the third multiplayer Level
	 */
	@Override
	protected void createBalls() {
		ball1 = new BallModel(1.5f, GameController.MAP_HEIGHT/2+0.5f, 0.5f, 0);
		ball2 = new BallModel(GameController.MAP_WIDTH-1.5f, GameController.MAP_HEIGHT/2+0.5f, 0.5f, 1);
	}

	/**
	 * @brief Creates the Doors and the Buttons of the third multiplayer Level
	 */
	@Override
	protected void createButtonsDoors() {
		DoorModel door1 = new DoorModel(GameController.MAP_WIDTH/2-1f, GameController.MAP_HEIGHT - 3f, 2.0f, 0.3f);
		doors.add(door1);
		
		buttons.add(new ButtonModel(4.5f, 3.25f, 0.7f));
		buttons.add(new ButtonModel(4.5f, GameController.MAP_HEIGHT - 3.25f, 0.7f));
		buttons.add(new ButtonModel(GameController.MAP_WIDTH - 4.5f, 3.25f, 0.7f, door1));
		buttons.add(new ButtonModel(GameController.MAP_WIDTH - 4.5f, GameController.MAP_HEIGHT - 3.25f, 0.7f));
	}

	/**
	 * @brief Creates the Walls of the third multiplayer Level
	 */
	@Override
	protected void createWalls() {
		walls.add(new WallModel(0, 0, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, GameController.MAP_HEIGHT - 0.5f, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, GameController.MAP_HEIGHT));	
		walls.add(new WallModel(GameController.MAP_WIDTH - 0.5f, 0, 0.5f, GameController.MAP_HEIGHT));	
		walls.add(new WallModel(GameController.MAP_WIDTH/2 - 1.5f, GameController.MAP_HEIGHT/2+1.5f, 0.5f, GameController.MAP_HEIGHT/2-1f));
		walls.add(new WallModel(GameController.MAP_WIDTH/2 - 1.5f, 0.5f, 0.5f, GameController.MAP_HEIGHT/2-1f));	
		walls.add(new WallModel(GameController.MAP_WIDTH/2 + 1f, GameController.MAP_HEIGHT/2+1.5f, 0.5f, GameController.MAP_HEIGHT/2-1f));
		walls.add(new WallModel(GameController.MAP_WIDTH/2 + 1f, 0.5f, 0.5f, GameController.MAP_HEIGHT/2-1f));
		walls.add(new WallModel(0.5f, GameController.MAP_HEIGHT/2-1f, 3.35f, 0.5f));
		walls.add(new WallModel(0.5f, GameController.MAP_HEIGHT/2+1.5f, 3.35f, 0.5f));
		walls.add(new WallModel(5.15f, GameController.MAP_HEIGHT/2-1f, 3.35f, 0.5f));
		walls.add(new WallModel(5.15f, GameController.MAP_HEIGHT/2+1.5f, 3.35f, 0.5f));
		walls.add(new WallModel(GameController.MAP_WIDTH - 8.5f, GameController.MAP_HEIGHT/2-1f, 3.35f, 0.5f));
		walls.add(new WallModel(GameController.MAP_WIDTH - 8.5f, GameController.MAP_HEIGHT/2+1.5f, 3.35f, 0.5f));
		walls.add(new WallModel(GameController.MAP_WIDTH - 3.85f, GameController.MAP_HEIGHT/2-1f, 3.35f, 0.5f));
		walls.add(new WallModel(GameController.MAP_WIDTH - 3.85f, GameController.MAP_HEIGHT/2+1.5f, 3.35f, 0.5f));

	}

	/**
	 * @brief Creates the Exit of the third multiplayer Level
	 */
	@Override
	protected void createExit() {
		exit = new ExitModel(GameController.MAP_WIDTH/2, GameController.MAP_HEIGHT - 1.5f, 0.6f);
	}

}
