package com.mygdx.elmaze.controller.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.EntityModel;

public class BallBody extends EntityBody {
	
	public BallBody(World world, EntityModel model) {
		super(world, model, BodyDef.BodyType.DynamicBody);

        CircleShape circle = new CircleShape();
        circle.setRadius( 
        		((BallModel) model).getRadius() 
        );
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = .5f;
        fixtureDef.friction = .5f;
        fixtureDef.restitution = .3f;
        
        body.createFixture(fixtureDef);
        
        circle.dispose();
	}

}
