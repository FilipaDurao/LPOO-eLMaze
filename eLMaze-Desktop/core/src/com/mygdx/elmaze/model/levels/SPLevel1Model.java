package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

public class SPLevel1Model extends SinglePlayerLevelModel {

	public SPLevel1Model() {
		createBall();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	@Override
	protected void createBall() {
		ball = new BallModel(2.05f, GameController.MAP_HEIGHT - 2.05f, 0.5f, 0);
	}

	@Override
	protected void createButtonsDoors() {}

	@Override
	protected void createWalls() {
		walls.add(new WallModel(0, 0, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, GameController.MAP_HEIGHT - 0.5f, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, GameController.MAP_HEIGHT));	
		walls.add(new WallModel(GameController.MAP_WIDTH - 0.5f, 0, 0.5f, GameController.MAP_HEIGHT));			
		walls.add(new WallModel(0.5f, (GameController.MAP_HEIGHT-0.25f)*1/4, GameController.MAP_WIDTH - 3.5f, 0.5f));			
		walls.add(new WallModel(0.5f, (GameController.MAP_HEIGHT-0.25f)*2/4, GameController.MAP_WIDTH - 3.5f, 0.5f));			
		walls.add(new WallModel(0.5f, (GameController.MAP_HEIGHT-0.25f)*3/4, GameController.MAP_WIDTH - 3.5f, 0.5f));
	}

	@Override
	protected void createExit() {
		exit = new ExitModel(2.05f, (GameController.MAP_HEIGHT-0.25f)*3/8 + 0.25f, 0.6f);
	}

}
