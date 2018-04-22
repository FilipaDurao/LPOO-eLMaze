package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.view.GameView;

public class DoorView extends EntityView {

	public DoorView(ELMaze game, EntityModel model) {
		super(game, model);
	}

	@Override
	public void update(EntityModel model) {}
	
	@Override
	public void createSprite(ELMaze game, EntityModel model) {
        Texture texture = game.getAssetManager().get("door.png");
		DoorModel door = (DoorModel) model;

        sprite = new Sprite(texture, 
        					texture.getWidth(), 
        					texture.getHeight());
        
        sprite.setSize(
    			door.getWidth()/GameView.PIXEL_TO_METER, 
    			door.getHeight()/GameView.PIXEL_TO_METER
    	);
        
        sprite.setCenter(
        		(door.getX() + door.getWidth()/2) / GameView.PIXEL_TO_METER, 
        		(door.getY() + door.getHeight()/2) / GameView.PIXEL_TO_METER
        );
	}

}
