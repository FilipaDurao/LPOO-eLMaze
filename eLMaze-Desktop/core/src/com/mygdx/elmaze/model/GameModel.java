package com.mygdx.elmaze.model;

import java.util.LinkedList;

import com.mygdx.elmaze.model.levels.LevelModel;
import com.mygdx.elmaze.model.levels.MPLevel1Model;
import com.mygdx.elmaze.model.levels.MPLevel3Model;
import com.mygdx.elmaze.model.levels.MPLevel2Model;
import com.mygdx.elmaze.model.levels.SPLevel1Model;
import com.mygdx.elmaze.model.levels.SPLevel2Model;
import com.mygdx.elmaze.model.levels.SPLevel3Model;
import com.mygdx.elmaze.model.levels.SPLevel4Model;

/**
 * Singleton Class representing a GameModel
 */
public class GameModel {
	
	private static GameModel instance;
	
	private final LinkedList<LevelModel> levels = new LinkedList<LevelModel>();
	private int currentLevelIndex = 0;

	/**
	 * @return GameModel instance
	 */
	public static GameModel getInstance() {
		if (instance == null) {
			instance = new GameModel();
		}
		return instance;
	}
	
	/**
	 * Creates a GameModel 
	 */
	private GameModel() {}

	/**
	 * @return Returns the current Level being played
	 */
	public LevelModel getCurrentLevel() {
		return levels.get(currentLevelIndex);
	}
	
	/**
	 * @return Returns all the Levels of the Game
	 */
	public LinkedList<LevelModel> getLevels() {
		return levels;
	}
	
	/**
	 * Advances the Game to the next Level
	 */
	public void advanceLevel() {
		if (currentLevelIndex < levels.size()-1) {
			currentLevelIndex++;
		}
	}
	
	/**
	 * Fills the Levels list with the sigleplayer Levels
	 */
	public void setSinglePlayerMode() {
		levels.clear();
		levels.add(new SPLevel1Model());
		levels.add(new SPLevel2Model());
		//levels.add(new SPLevel3Model());
		//levels.add(new SPLevel4Model());
	}
	
	/**
	 * Fills the Levels list with the multiplayer Levels
	 */
	public void setMultiPlayerMode() {
		levels.clear();
		levels.add(new MPLevel1Model());
		levels.add(new MPLevel2Model());
		levels.add(new MPLevel3Model());
	}
	
}
