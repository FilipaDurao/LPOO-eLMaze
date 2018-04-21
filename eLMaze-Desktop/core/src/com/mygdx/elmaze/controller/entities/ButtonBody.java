package com.mygdx.elmaze.controller.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.EntityModel;

public class ButtonBody extends EntityBody {

	public ButtonBody(World world, EntityModel model) {
		super(world, model, BodyDef.BodyType.StaticBody);

        CircleShape circle = new CircleShape();
        circle.setRadius( 
        	((ButtonModel) model).getRadius()/100
        );
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.isSensor = true;
        
        body.createFixture(fixtureDef);
        
        circle.dispose();
	}

}
