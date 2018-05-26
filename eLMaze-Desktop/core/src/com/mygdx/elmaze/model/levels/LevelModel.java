package com.mygdx.elmaze.model.levels;

import java.util.ArrayList;

import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

public abstract class LevelModel {
	
	protected ArrayList<DoorModel> doors = new ArrayList<DoorModel>();
	protected ArrayList<ButtonModel> buttons = new ArrayList<ButtonModel>();
	protected ArrayList<WallModel> walls = new ArrayList<WallModel>();
	protected ExitModel exit;

	public LevelModel() {}

	public ArrayList<DoorModel> getDoors() {
		return doors;
	}

	public ArrayList<ButtonModel> getButtons() {
		return buttons;
	}

	public ArrayList<WallModel> getWalls() {
		return walls;
	}

	public ExitModel getExit() {
		return exit;
	}
	
	protected abstract void createButtonsDoors();
	
	protected abstract void createWalls();
	
	protected abstract void createExit();

}
