package com.mygdx.elmaze.controller;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elmaze.controller.entities.BallBody;
import com.mygdx.elmaze.controller.levels.Level;
import com.mygdx.elmaze.controller.levels.SinglePlayerLevel;
import com.mygdx.elmaze.model.GameModel;
import com.mygdx.elmaze.model.levels.SinglePlayerLevelModel;

public class GameController {
	
	private static GameController instance;
	
	public static final int MAP_WIDTH = 20;
	public static final int MAP_HEIGHT = MAP_WIDTH * Gdx.graphics.getHeight() / Gdx.graphics.getWidth();
	private static final LinkedList<Level> levels = new LinkedList<Level>();
	
	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	private GameController() {
		levels.add(new SinglePlayerLevel((SinglePlayerLevelModel) GameModel.getInstance().getLevelByIndex(0)));
		levels.add(new SinglePlayerLevel((SinglePlayerLevelModel) GameModel.getInstance().getLevelByIndex(1)));
	}
	
	public World getWorld() {
		return levels.getFirst().getWorld();
	}
	
	public BallBody getBallBody() {	// TODO REMOVE THIS
		return ((SinglePlayerLevel) levels.getFirst()).getBallBody();
	}
	
    public void update(float delta) {
    	levels.getFirst().update(delta);
    }

	public void advanceLevel() {
		levels.removeFirst();
		
		if (levels.isEmpty()) {
			System.out.println("You win! :D");
    		Gdx.app.exit();
		}
	}
}
