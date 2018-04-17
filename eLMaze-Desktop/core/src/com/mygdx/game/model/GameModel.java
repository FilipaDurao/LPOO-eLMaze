package com.mygdx.game.model;

import java.util.ArrayList;

import com.mygdx.game.model.entities.BallModel;
import com.mygdx.game.model.entities.ButtonModel;
import com.mygdx.game.model.entities.DoorModel;

public class GameModel {
	
	private final BallModel ball;
	private final ArrayList<DoorModel> doors = new ArrayList<DoorModel>();
	private final ArrayList<ButtonModel> buttons = new ArrayList<ButtonModel>();

	public GameModel() {
		ball = new BallModel(0, 0, 0); 
		doors.add(new DoorModel(1,1));
		buttons.add(new ButtonModel(2,2));
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
}
