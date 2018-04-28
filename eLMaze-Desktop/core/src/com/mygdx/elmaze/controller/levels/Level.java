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

public abstract class Level {
	
	protected final World world;
	
	public Level(LevelModel levelModel) {
		world = new World(new Vector2(0, 0), true);
		
		// Exit
		new ExitBody(world, levelModel.getExit());
		
		// Walls
		for (WallModel wallModel : levelModel.getWalls()) {
			new WallBody(world, wallModel);
		}
		
		// Doors
		for (DoorModel doorModel : levelModel.getDoors()) {
			new DoorBody(world, doorModel);
		}
		
		// Buttons
		for (ButtonModel buttonModel : levelModel.getButtons()) {
			new ButtonBody(world, buttonModel);
		}
		
		world.setContactListener(CollisionListener.getInstance());
	}
	
	public void update(float delta) {
    	world.step(delta, 6, 2);
    	
        Array<Body> bodies = new Array<Body>();
        world.getBodies(bodies);

        for (Body body : bodies) {
            ((EntityModel) body.getUserData()).setPosition(body.getPosition().x, body.getPosition().y);
            checkOpenDoor(body);
        }
    }
    
    private void checkOpenDoor(Body body) {
    	if (body.getUserData() instanceof DoorModel) {
        	DoorModel door = (DoorModel) body.getUserData();
        	if (door.isOpen()) {
        		world.destroyBody(body);
        	}
        }
    }
    
    public World getWorld() {
		return world;
	}
	
}
