package com.mygdx.game.controller.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.model.entities.DoorModel;
import com.mygdx.game.model.entities.EntityModel;
import com.mygdx.game.model.entities.WallModel;

public class DoorBody extends EntityBody {

	public DoorBody(World world, EntityModel model) {
		super(world, model, BodyDef.BodyType.StaticBody);

        PolygonShape rectangle = new PolygonShape();
        rectangle.set( new float[] {
        	0, 0,
        	0, ((DoorModel) model).getHeight(),
        	((DoorModel) model).getWidth(), ((DoorModel) model).getHeight(),
        	((DoorModel) model).getWidth(), 0
        });
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = rectangle;
        fixtureDef.density = .5f;
        fixtureDef.friction = .5f;
        fixtureDef.restitution = .5f;
        
        body.createFixture(fixtureDef);
        
        rectangle.dispose();
	}
	
}
