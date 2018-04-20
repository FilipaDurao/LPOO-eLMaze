package com.mygdx.game.controller.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.model.entities.EntityModel;
import com.mygdx.game.model.entities.ExitModel;

public class ExitBody extends EntityBody {

	public ExitBody(World world, EntityModel model) {
		super(world, model, BodyDef.BodyType.KinematicBody);

        CircleShape circle = new CircleShape();
        circle.setRadius( 
        		((ExitModel) model).getRadius() 
        );
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = 0;
        fixtureDef.friction = 0;
        fixtureDef.restitution = 0;
        
        body.createFixture(fixtureDef);
        
        circle.dispose();
	}
	
}
