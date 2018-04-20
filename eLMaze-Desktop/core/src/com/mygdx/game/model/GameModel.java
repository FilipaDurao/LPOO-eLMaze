package com.mygdx.game.model;

import java.util.ArrayList;

import com.mygdx.game.controller.GameController;
import com.mygdx.game.model.entities.BallModel;
import com.mygdx.game.model.entities.ButtonModel;
import com.mygdx.game.model.entities.DoorModel;
import com.mygdx.game.model.entities.EntityModel;
import com.mygdx.game.model.entities.ExitModel;
import com.mygdx.game.model.entities.WallModel;

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
		ball = new BallModel(GameController.MAP_WIDTH/2, GameController.MAP_HEIGHT/2 + 2f, 0.5f, 0);
		exit = new ExitModel(3, GameController.MAP_HEIGHT - 2f, 0.5f);
		
		createButtons();
		createDoors();
		createWalls();
	}
	
	private void createButtons() {
		buttons.add(new ButtonModel(2, 2));		
	}
	
	private void createDoors() {
		doors.add(new DoorModel(0.5f, GameController.MAP_HEIGHT/2 - 0.15f, 1.5f, 0.3f));
	}
	
	private void createWalls() {
		walls.add(new WallModel(0, 0, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, GameController.MAP_HEIGHT - 0.5f, GameController.MAP_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, GameController.MAP_HEIGHT));	
		walls.add(new WallModel(GameController.MAP_WIDTH - 0.5f, 0, 0.5f, GameController.MAP_HEIGHT));			
		walls.add(new WallModel(2, GameController.MAP_HEIGHT/2 - 0.25f, GameController.MAP_WIDTH - 4, 0.5f));
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
