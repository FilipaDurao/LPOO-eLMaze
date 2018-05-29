package com.mygdx.elmaze.controller.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.EntityModel;

/**
 * Physical world button body
 */
public class ButtonBody extends EntityBody {

	/**
	 * @param world World the button body belongs to
	 * @param model Model representing the button's data
	 */
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
