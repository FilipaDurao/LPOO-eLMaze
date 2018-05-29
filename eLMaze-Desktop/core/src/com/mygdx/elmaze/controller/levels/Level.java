package com.mygdx.elmaze.controller.levels;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.elmaze.controller.CollisionListener;
import com.mygdx.elmaze.controller.entities.ButtonBody;
import com.mygdx.elmaze.controller.entities.DoorBody;
import com.mygdx.elmaze.controller.entities.ExitBody;
import com.mygdx.elmaze.controller.entities.WallBody;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.model.entities.WallModel;
import com.mygdx.elmaze.model.levels.LevelModel;

/**
 * Game level controller
 */
public abstract class Level {
	
	protected final World world;
	
	/**
	 * Initializes a Level controller and its physical world (libGDX)
	 * 
	 * @param levelModel Level model containing the physical world objects models
	 */
	public Level(LevelModel levelModel) {
		world = new World(new Vector2(0, 0), true);
		
		new ExitBody(world, levelModel.getExit());
		
		for (WallModel wallModel : levelModel.getWalls()) {
			new WallBody(world, wallModel);
		}
		
		for (DoorModel doorModel : levelModel.getDoors()) {
			new DoorBody(world, doorModel);
		}
		
		for (ButtonModel buttonModel : levelModel.getButtons()) {
			new ButtonBody(world, buttonModel);
		}
		
		world.setContactListener(CollisionListener.getInstance());
	}
	
	/**
	 * Updates the level controller physical world
	 * 
	 * @param delta Time since last update
	 */
	public void update(float delta) {
    	world.step(delta, 6, 2);
    	
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);

        for (Body body : bodies) {
            ((EntityModel) body.getUserData()).setPosition(body.getPosition().x, body.getPosition().y);
            checkOpenDoor(body);
        }
    }
    
	/**
	 * Verifies if a door was opened
	 * 
	 * @param body Physical body of a world object
	 */
    private void checkOpenDoor(Body body) {
    	if (body.getUserData() instanceof DoorModel) {
        	DoorModel door = (DoorModel) body.getUserData();
        	if (door.isOpen()) {
        		world.destroyBody(body);
        	}
        }
    }
    
    /**
     * @return Level controller physical world
     */
    public World getWorld() {
		return world;
	}
	
}
