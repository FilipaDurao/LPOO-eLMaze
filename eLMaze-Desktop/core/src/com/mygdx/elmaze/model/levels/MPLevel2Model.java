package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

public class MPLevel2Model extends MultiPlayerLevelModel {

	public MPLevel2Model() {
		createBalls();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	@Override
	protected void createBalls() {
		ball1 = new BallModel(1.5f, GameController.MAP_HEIGHT/2+0.5f, 0.5f, 0);
		ball2 = new BallModel(GameController.MAP_WIDTH-1.5f, GameController.MAP_HEIGHT/2+0.5f, 0.5f, 0);
	}

	@Override
	protected void createButtonsDoors() {
		DoorModel door1 = new DoorModel(GameController.MAP_WIDTH/2-1f, GameController.MAP_HEIGHT - 3f, 2.0f, 0.3f);
		doors.add(door1);
		
		buttons.add(new ButtonModel(4.5f, 3.25f, 0.7f));
		buttons.add(new ButtonModel(4.5f, GameController.MAP_HEIGHT - 3.25f, 0.7f));
		buttons.add(new ButtonModel(GameController.MAP_WIDTH - 4.5f, 3.25f, 0.7f, door1));
		buttons.add(new ButtonModel(GameController.MAP_WIDTH - 4.5f, GameController.MAP_HEIGHT - 3.25f, 0.7f));
	}

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

	@Override
	protected void createExit() {
		exit = new ExitModel(GameController.MAP_WIDTH/2, GameController.MAP_HEIGHT - 1.5f, 0.6f);
	}

}
