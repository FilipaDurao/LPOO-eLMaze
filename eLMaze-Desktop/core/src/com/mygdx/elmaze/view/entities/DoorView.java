package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.view.GameView;

/**
 * Represents a Door View
 */
public class DoorView extends EntityView {

	/**
	 * Creates a Door View
	 * 
	 * @param game Reference to the Game object
	 * @param model The Model of the Ball that this view represents
	 */
	public DoorView(ELMaze game, EntityModel model) {
		super(game, model);
	}

	/**
     * Positions the sprite on the location of the respective model
     * 
     * @param model The model associated with the view
	 */
	@Override
	public void update(EntityModel model) {}
	
	/**
     * Creates the sprite associated with the model
     * 
     * @param game Reference to the Game object
     * @param model The Entity Model associated with the View
	 */
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
