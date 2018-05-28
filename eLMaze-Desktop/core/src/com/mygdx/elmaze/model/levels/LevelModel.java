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

	/**
	 * @return Returns the Level's Door Models
	 */
	public ArrayList<DoorModel> getDoors() {
		return doors;
	}

	/**
	 * @return Returns the Level's Button Models
	 */
	public ArrayList<ButtonModel> getButtons() {
		return buttons;
	}

	/**
	 * @return Returns the Level's Wall Models
	 */
	public ArrayList<WallModel> getWalls() {
		return walls;
	}

	/**
	 * @return Returns the Level's Exit Model
	 */
	public ExitModel getExit() {
		return exit;
	}
	
	/**
	 * @brief Creates the Doors and the Buttons of the Level
	 */
	protected abstract void createButtonsDoors();
	
	/**
	 * @brief Creates the Walls of the Level
	 */
	protected abstract void createWalls();
	
	/**
	 * @brief Creates the Exit of the Level
	 */
	protected abstract void createExit();

}
