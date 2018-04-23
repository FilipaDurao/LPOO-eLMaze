package com.mygdx.elmaze.model;

import java.util.ArrayList;

import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

public class GameModel {
	
	private static GameModel instance;
	
	private BallModel ball;
	private ArrayList<DoorModel> doors = new ArrayList<DoorModel>();
	private ArrayList<ButtonModel> buttons = new ArrayList<ButtonModel>();
	private ArrayList<WallModel> walls = new ArrayList<WallModel>();
	private ExitModel exit;

	public static GameModel getInstance() {
		if (instance == null) {
			instance = new GameModel();
		}
		return instance;
	}
	
	private GameModel() {
		ball = new BallModel(2.05f, 2.05f, 0.5f, 0);
		exit = new ExitModel(GameController.MAP_WIDTH - 2.05f, GameController.MAP_HEIGHT - 2.05f, 0.6f);
		
		createButtonsDoors();
		createWalls();
	}
	
	private void createButtonsDoors() {
		DoorModel door1 = new DoorModel(GameController.MAP_WIDTH-3.0f, GameController.MAP_HEIGHT*2/4+0.45f, 2.5f, 0.3f);
		doors.add(door1);	
		
		buttons.add(new ButtonModel(2.05f, 5.65f, 0.7f, doors.get(0)));
	}
	
	private void createWalls() {
		walls.add(new WallModel(0, 0, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, GameController.MAP_HEIGHT - 0.5f, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, GameController.MAP_HEIGHT));	
		walls.add(new WallModel(GameController.MAP_WIDTH - 0.5f, 0, 0.5f, GameController.MAP_HEIGHT));			
		walls.add(new WallModel(0.5f, (GameController.MAP_HEIGHT-0.25f)*1/4, GameController.MAP_WIDTH - 3.5f, 0.5f));			
		walls.add(new WallModel(0.5f, (GameController.MAP_HEIGHT-0.25f)*2/4, GameController.MAP_WIDTH - 3.5f, 0.5f));			
		walls.add(new WallModel(3.0f, (GameController.MAP_HEIGHT-0.25f)*3/4, GameController.MAP_WIDTH - 3.5f, 0.5f));
	}

	public BallModel getBall() {
		return ball;
	}

	public ArrayList<DoorModel> getDoors() {
		return doors;
	}

	public ArrayList<ButtonModel> getButtons() {
		return buttons;
	}
	
	public ExitModel getExit() {
		return exit;
	}
	
	public ArrayList<WallModel> getWalls() {
		return walls;
	}
}
