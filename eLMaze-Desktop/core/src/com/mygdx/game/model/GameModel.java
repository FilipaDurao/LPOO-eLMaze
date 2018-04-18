package com.mygdx.game.model;

import java.util.ArrayList;

import com.mygdx.game.controller.GameController;
import com.mygdx.game.model.entities.BallModel;
import com.mygdx.game.model.entities.ButtonModel;
import com.mygdx.game.model.entities.DoorModel;
import com.mygdx.game.model.entities.EntityModel;

public class GameModel {
	
	private static GameModel instance;
	
	private BallModel ball;
	private ArrayList<DoorModel> doors = new ArrayList<DoorModel>();
	private ArrayList<ButtonModel> buttons = new ArrayList<ButtonModel>();
	private ArrayList<EntityModel> walls = new ArrayList<EntityModel>();
	private EntityModel exit;

	public static GameModel getInstance() {
		if (instance == null) {
			instance = new GameModel();
		}
		return instance;
	}
	
	private GameModel() {
		ball = new BallModel(GameController.MAP_WIDTH/2, GameController.MAP_HEIGHT/2, 0);
		exit = new EntityModel(3, 3);
		
		createButtons();
		createDoors();
		createWalls();
	}
	
	private void createButtons() {
		buttons.add(new ButtonModel(2, 2));		
	}
	
	private void createDoors() {
		doors.add(new DoorModel(1, 1));
	}
	
	private void createWalls() {
		walls.add(new EntityModel(2.5f, 2.5f));		
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
	
	public EntityModel getExit() {
		return exit;
	}
	
	public ArrayList<EntityModel> getWalls() {
		return walls;
	}
}
