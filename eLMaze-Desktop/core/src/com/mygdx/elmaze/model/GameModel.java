package com.mygdx.elmaze.model;

import java.util.LinkedList;

import com.mygdx.elmaze.model.levels.LevelModel;
import com.mygdx.elmaze.model.levels.MPLevel1Model;
import com.mygdx.elmaze.model.levels.MPLevel2Model;
import com.mygdx.elmaze.model.levels.SPLevel1Model;
import com.mygdx.elmaze.model.levels.SPLevel2Model;
import com.mygdx.elmaze.model.levels.SPLevel3Model;
import com.mygdx.elmaze.model.levels.SPLevel4Model;

public class GameModel {
	
	private static GameModel instance;
	
	private final LinkedList<LevelModel> levels = new LinkedList<LevelModel>();
	private int currentLevelIndex = 0;

	public static GameModel getInstance() {
		if (instance == null) {
			instance = new GameModel();
		}
		return instance;
	}
	
	private GameModel() {}

	public LevelModel getCurrentLevel() {
		return levels.get(currentLevelIndex);
	}
	
	public LinkedList<LevelModel> getLevels() {
		return levels;
	}
	
	public void advanceLevel() {
		if (currentLevelIndex < levels.size()-1) {
			currentLevelIndex++;
		}
	}
	
	public void setSinglePlayerMode() {
		levels.clear();
		levels.add(new SPLevel1Model());
		levels.add(new SPLevel2Model());
		levels.add(new SPLevel3Model());
		levels.add(new SPLevel4Model());
	}
	
	public void setMultiPlayerMode() {
		levels.clear();
		levels.add(new MPLevel1Model());
		levels.add(new MPLevel2Model());
	}
	
}
