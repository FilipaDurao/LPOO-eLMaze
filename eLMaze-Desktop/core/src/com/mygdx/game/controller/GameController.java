package com.mygdx.game.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class GameController {
	
	private static GameController instance;
	
	private final World world;
	
	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	private GameController() {
		world = new World(new Vector2(0, 0), true);
	}

}
