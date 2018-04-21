package com.mygdx.elmaze.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.elmaze.controller.entities.BallBody;
import com.mygdx.elmaze.controller.entities.DoorBody;
import com.mygdx.elmaze.controller.entities.ExitBody;
import com.mygdx.elmaze.controller.entities.WallBody;
import com.mygdx.elmaze.model.GameModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.model.entities.WallModel;

public class GameController {
	
	private static GameController instance;
	
	private BallBody ballBody;

	
	public static final int MAP_WIDTH = 20;
	public static final int MAP_HEIGHT = MAP_WIDTH * Gdx.graphics.getHeight() / Gdx.graphics.getWidth();
	
	private final World world;
	
	public static GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		return instance;
	}

	private GameController() {
		world = new World(new Vector2(0, 0), true);

		ballBody = new BallBody(world, GameModel.getInstance().getBall());
		
		for (WallModel wallModel : GameModel.getInstance().getWalls()) {
			new WallBody(world, wallModel);
		}
		
		new ExitBody(world, GameModel.getInstance().getExit());
		
		for (DoorModel doorModel : GameModel.getInstance().getDoors()) {
			new DoorBody(world, doorModel);
		}
	}
	
	public World getWorld() {
		return world;
	}
	
	public BallBody getBallBody() {
		return ballBody;
	}
	
    public void update(float delta) {
    	world.step(delta, 6, 2);
    	
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);

        for (Body body : bodies) {
            ((EntityModel) body.getUserData()).setPosition(body.getPosition().x, body.getPosition().y);
        }
    }

}
