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
		ball = new BallModel(1.65f, 1.65f, 0.5f, 0);
		exit = new ExitModel(GameController.MAP_WIDTH - 1.65f, GameController.MAP_HEIGHT - 1.65f, 0.6f);
		
		createButtons();
		createDoors();
		createWalls();
	}
	
	private void createButtons() {
		//buttons.add(new ButtonModel(2, 2));		
	}
	
	private void createDoors() {
		//doors.add(new DoorModel(0.5f, GameController.MAP_HEIGHT/1.35f - 0.15f, 1.5f, 0.3f));
	}
	
	private void createWalls() {
		walls.add(new WallModel(0, 0, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, GameController.MAP_HEIGHT - 0.5f, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, GameController.MAP_HEIGHT));	
		walls.add(new WallModel(GameController.MAP_WIDTH - 0.5f, 0, 0.5f, GameController.MAP_HEIGHT));			
		walls.add(new WallModel(0.5f, (GameController.MAP_HEIGHT-0.25f)*1/5, GameController.MAP_WIDTH - 3, 0.5f));			
		walls.add(new WallModel(2.5f, (GameController.MAP_HEIGHT-0.25f)*2/5, GameController.MAP_WIDTH - 3, 0.5f));			
		walls.add(new WallModel(0.5f, (GameController.MAP_HEIGHT-0.25f)*3/5, GameController.MAP_WIDTH - 3, 0.5f));			
		walls.add(new WallModel(2.5f, (GameController.MAP_HEIGHT-0.25f)*4/5, GameController.MAP_WIDTH - 3, 0.5f));
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
