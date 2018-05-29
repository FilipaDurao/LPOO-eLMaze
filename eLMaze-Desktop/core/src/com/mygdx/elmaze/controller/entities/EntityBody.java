package com.mygdx.elmaze.controller.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elmaze.model.entities.EntityModel;

/**
 * Game physical object. Acts as middle-ware between the game logic and libGDX body class objects
 */
public abstract class EntityBody {
	
	protected final Body body;

	/**
	 * @param world Physical world that the body belongs to
	 * @param model Model representing the object's data
	 * @param bodyType Definition of the type of physical body
	 */
	public EntityBody(World world, EntityModel model, BodyDef.BodyType bodyType) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(model.getPosition());
		
		body = world.createBody(bodyDef);
		body.setUserData(model);
	}

	/**
	 * @return Body X axis position
	 */
	public float getX() {
		return body.getPosition().x;
	}

	/**
	 * @return Body Y axis position
	 */
	public float getY() {
		return body.getPosition().y;
	}

	/**
	 * @return Body model data
	 */
	public Object getUserData() {
		return body.getUserData();
	}
	
	/**
	 * Aplies a force to the body
	 * 
	 * @param force
	 * @param wake
	 */
	public void applyForceToCenter(Vector2 force, boolean wake) {
		body.applyForceToCenter(force, wake);
	}
}
