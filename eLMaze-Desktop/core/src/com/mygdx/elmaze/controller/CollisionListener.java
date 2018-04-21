package com.mygdx.elmaze.controller;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ExitModel;

public class CollisionListener implements ContactListener {
	
	@Override
	public void beginContact(Contact contact) {
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();
        
        if (bodyA.getUserData() instanceof BallModel &&
        	bodyB.getUserData() instanceof ExitModel ) {
        	
        	GameController.getInstance().setBallNearExit(true);
        }
	}

	@Override
	public void endContact(Contact contact) {
		Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();
        
        if (bodyA.getUserData() instanceof BallModel &&
        	bodyB.getUserData() instanceof ExitModel ) {
        	
        	GameController.getInstance().setBallNearExit(false);
        }
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {}

}
