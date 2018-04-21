package com.mygdx.game.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.ELMaze;
import com.mygdx.game.model.entities.DoorModel;
import com.mygdx.game.model.entities.EntityModel;
import com.mygdx.game.view.GameView;

public class DoorView extends EntityView {

	public DoorView(ELMaze game, EntityModel model) {
		super(game, model);
	}

	@Override
	public void update(EntityModel model) {	
		DoorModel door = (DoorModel) model;
		
        sprite.setCenter(
        		(door.getX() + door.getWidth()/2) / GameView.PIXEL_TO_METER, 
        		(door.getY() + door.getHeight()/2) / GameView.PIXEL_TO_METER
        );
    }
	
	@Override
	public void createSprite(ELMaze game, EntityModel model) {
        Texture texture = game.getAssetManager().get("door.png");

        sprite = new Sprite(texture, 
        					texture.getWidth(), 
        					texture.getHeight());
        
        sprite.setSize(
    			((DoorModel)model).getWidth()/GameView.PIXEL_TO_METER, 
    			((DoorModel)model).getHeight()/GameView.PIXEL_TO_METER
    		);
	}

}
