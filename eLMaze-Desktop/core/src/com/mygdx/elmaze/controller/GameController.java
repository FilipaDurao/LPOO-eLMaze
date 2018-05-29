package com.mygdx.elmaze.controller;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elmaze.controller.levels.Level;
import com.mygdx.elmaze.controller.levels.MultiPlayerLevel;
import com.mygdx.elmaze.controller.levels.SinglePlayerLevel;
import com.mygdx.elmaze.model.GameModel;
import com.mygdx.elmaze.model.levels.LevelModel;
import com.mygdx.elmaze.model.levels.MultiPlayerLevelModel;
import com.mygdx.elmaze.model.levels.SinglePlayerLevelModel;

/**
 * Game main controller Singleton class
 */
public class GameController {
	
	private static GameController instance;
	
	/** Game Controller Status */
	public enum STATUS { NOT_RUNNING , RUNNING , DISCONNECT };
	
	private final LinkedList<Level> levels = new LinkedList<Level>();
	private boolean isSinglePlayer = true;
	private STATUS status = STATUS.NOT_RUNNING;
	
	/**
	 * @return Singleton's class instance
	 */
	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	private GameController() {}
	
	/**
	 * @return Returns the physical World class instance of the current running level
	 */
	public World getWorld() {
		return levels.getFirst().getWorld();
	}
	
	/**
	 * Updates the current level controller 
	 * 
	 * @param delta Time since last update
	 */
    public void update(float delta) {
    	if (!levels.isEmpty()) {
        	levels.getFirst().update(delta);
    	}
    }

    /**
     * Advances to next game level
     */
	public void advanceLevel() {
		levels.removeFirst();
		
		if (levels.isEmpty()) {
    		this.stopGame();
		}
	}
	
	/**
	 * Initiates the controller in single player mode
	 */
	public void setSinglePlayerMode() {
		isSinglePlayer = true;
		levels.clear();
		
		for (LevelModel levelModel : GameModel.getInstance().getLevels()) {
			levels.add(new SinglePlayerLevel((SinglePlayerLevelModel) levelModel));
		}
	}

	/**
	 * Initiates the controller in multi player mode
	 */
	public void setMultiPlayerMode() {
		isSinglePlayer = false;
		levels.clear();
		
		for (LevelModel levelModel : GameModel.getInstance().getLevels()) {
			levels.add(new MultiPlayerLevel((MultiPlayerLevelModel) levelModel));
		}
	}

	
	/**
	 * Updates the player(s) ball(s)
	 * 
	 * @param connectionID Player identification number of the player moving the ball
	 * @param forceVector Force to apply to the ball
	 * @param wake Force wake status
	 */
	public void updateBall(int playerID, Vector2 forceVector, boolean wake) {
		if (levels.isEmpty()) {
			return;
		}
		
		if (isSinglePlayer) {
			((SinglePlayerLevel) levels.getFirst()).getBallBody().applyForceToCenter(forceVector, wake);
		}
		else {
			if (playerID == 0) {
				((MultiPlayerLevel) levels.getFirst()).getBall1Body().applyForceToCenter(forceVector, wake);
			}
			else {
				((MultiPlayerLevel) levels.getFirst()).getBall2Body().applyForceToCenter(forceVector, wake);
			}
		}
	}
	
	/**
	 * @return Returns the Controller current status
	 */
	public STATUS getStatus() {
		return status;
	}
	
	/**
	 * Triggers a client disconnect event, thus setting the Controller status to DISCONNECT
	 */
	public void triggerClientDC() {
		status = STATUS.DISCONNECT;
	}
	
	/**
	 * Triggers a game start event, thus setting the Controller status to RUNNING
	 */
	public void startGame() {
		status = STATUS.RUNNING;
	}
	
	/**
	 * Triggers a game stop event, thus setting the Controller status to NOT_RUNNING
	 */
	public void stopGame() {
		status = STATUS.NOT_RUNNING;
	}
}
