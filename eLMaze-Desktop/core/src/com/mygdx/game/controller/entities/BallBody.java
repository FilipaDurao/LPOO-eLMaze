package com.mygdx.game.controller.entities;

import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.model.entities.EntityModel;

public class BallBody extends EntityBody {

	public BallBody(World world, EntityModel model) {
		super(world, model, false);

        CircleShape circle = new CircleShape();
        circle.setRadius(0.22f);
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = .5f;
        fixtureDef.friction = .5f;
        fixtureDef.restitution = .5f;
        
        body.createFixture(fixtureDef);
        
        circle.dispose();
	}

}
