package com.mygdx.elmaze.controller.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elmaze.model.entities.EntityModel;

public abstract class EntityBody {
	
	protected final Body body;

	public EntityBody(World world, EntityModel model, BodyDef.BodyType bodyType) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(model.getPosition());
		
		body = world.createBody(bodyDef);
		body.setUserData(model);
	}

	public float getX() {
		return body.getPosition().x;
	}
	
	public float getY() {
		return body.getPosition().y;
	}
	
	public Object getUserData() {
		return body.getUserData();
	}
	
	public void applyForceToCenter(Vector2 force, boolean wake) {
		body.applyForceToCenter(force, wake);
	}
}
