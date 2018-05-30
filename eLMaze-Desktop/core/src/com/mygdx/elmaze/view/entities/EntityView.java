package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.view.GameView;

/**
 * Represents an abstract Entity View
 */
public abstract class EntityView {
	
	Sprite sprite;

	/**
	 * Creates an Entity View
	 * 
	 * @param game Reference to the Game object
	 * @param model The model associated with the Entity View
	 */
	public EntityView(ELMaze game, EntityModel model) {
		createSprite(game, model);
	}
	
	/**
	 * Draws the sprite batch on the screen
	 * 
	 * @param batch The sprite batch to draw on the screen
	 */
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
    
    /**
     * Positions the sprite on the location of the respective model
     * 
     * @param model The model associated with the view
     */
    public void update(EntityModel model) {
        sprite.setCenter(model.getX() / GameView.PIXEL_TO_METER, model.getY() / GameView.PIXEL_TO_METER);
    }
	
    /**
     * Creates the sprite associated with the model
     * 
     * @param game Reference to the Game object
     * @param model The Entity Model associated with the View
     */
	public abstract void createSprite(ELMaze game, EntityModel model);
}
