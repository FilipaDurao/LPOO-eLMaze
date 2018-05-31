package com.mygdx.elmaze.controller;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.mygdx.elmaze.model.GameModel;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;
import com.mygdx.elmaze.view.GameView;

/**
 * Singleton Class that listens for collisions (contact listener) for that game's physical worlds, acting as an observer
 */
public class CollisionListener implements ContactListener {
	
	private static CollisionListener instance;
	
	/**
	 * @return Singleton's class instance
	 */
	public static CollisionListener getInstance() {
		if (instance == null) {
			instance = new CollisionListener();
		}
		
		return instance;
	}
	
	private CollisionListener() {}
	
	/**
	 * Verifies the start of a collision between two bodies
	 * 
	 * @param contact Information regarding the collision
	 */
	@Override
	public void beginContact(Contact contact) {
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();
        
        
        checkBallExitCollision(bodyA, bodyB);
        checkBallWallCollision(bodyA, bodyB);
        checkBallButtonCollision(bodyA, bodyB);
        checkBallDoorCollision(bodyA, bodyB);
        checkBallBallCollision(bodyA, bodyB);
	}

	@Override
	public void endContact(Contact contact) {}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {}
	
	/**
	 * Verifies a collision between a ball and an exit
	 * 
	 * @param bodyA first body
	 * @param bodyB second body
	 */
	private void checkBallExitCollision(Body bodyA, Body bodyB) {
        if ((bodyA.getUserData() instanceof BallModel && bodyB.getUserData() instanceof ExitModel) || 
        	(bodyA.getUserData() instanceof ExitModel && bodyB.getUserData() instanceof BallModel)) {

        	GameView.getInstance().playBallExitCollisionSound();
        	GameController.getInstance().advanceLevel();
        	GameModel.getInstance().advanceLevel();
        }
	}
	
	/**
	 * Verifies a collision between a ball and a wall
	 * 
	 * @param bodyA first body
	 * @param bodyB second body
	 */
	private void checkBallWallCollision(Body bodyA, Body bodyB) {
		if ((bodyA.getUserData() instanceof BallModel && bodyB.getUserData() instanceof WallModel) ||
        	(bodyA.getUserData() instanceof WallModel && bodyB.getUserData() instanceof BallModel)) {
        	
        	GameView.getInstance().playBallWallCollisionSound();
        }
	}
	
	/**
	 * Verifies a collision between a ball and a door
	 * 
	 * @param bodyA first body
	 * @param bodyB second body
	 */
	private void checkBallDoorCollision(Body bodyA, Body bodyB) {
		if ((bodyA.getUserData() instanceof BallModel && bodyB.getUserData() instanceof DoorModel) ||
        	(bodyA.getUserData() instanceof DoorModel && bodyB.getUserData() instanceof BallModel)) {
        	
        	GameView.getInstance().playBallDoorCollisionSound();
        }
	}
	
	/**
	 * Verifies a collision between two balls
	 * 
	 * @param bodyA first body
	 * @param bodyB second body
	 */
	private void checkBallBallCollision(Body bodyA, Body bodyB) {
		if (bodyA.getUserData() instanceof BallModel && bodyB.getUserData() instanceof BallModel) {
        	GameView.getInstance().playBallBallCollisionSound();
        }
	}
	
	/**
	 * Verifies a collision between a ball and a button
	 * 
	 * @param bodyA first body
	 * @param bodyB second body
	 */
	private void checkBallButtonCollision(Body bodyA, Body bodyB) {
		if ((bodyA.getUserData() instanceof BallModel && bodyB.getUserData() instanceof ButtonModel) ||
        	(bodyA.getUserData() instanceof ButtonModel && bodyB.getUserData() instanceof BallModel)) {
        	
        	if (bodyA.getUserData() instanceof ButtonModel) {
        		if (!(((ButtonModel) bodyA.getUserData()).isPressed())) {
                	((ButtonModel) bodyA.getUserData()).press();
        			GameView.getInstance().playBallButtonCollisionSound();
        		}
        	} 
        	else {
        		if (!(((ButtonModel) bodyB.getUserData()).isPressed())) {
                	((ButtonModel) bodyB.getUserData()).press();
        			GameView.getInstance().playBallButtonCollisionSound();
        		}
        	}
        }
    }

}
