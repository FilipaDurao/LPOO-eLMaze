package com.mygdx.elmaze.controller.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.model.entities.ExitModel;

/**
 * Physical world exit body
 */
public class ExitBody extends EntityBody {

	/**
	 * @param world World the exit body belongs to
	 * @param model Model representing the exit's data
	 */
	public ExitBody(World world, EntityModel model) {
		super(world, model, BodyDef.BodyType.StaticBody);

        CircleShape circle = new CircleShape();
        circle.setRadius( 
        	((ExitModel) model).getRadius()/1000
        );
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.isSensor = true;
        
        body.createFixture(fixtureDef);
        
        circle.dispose();
	}
	
}
