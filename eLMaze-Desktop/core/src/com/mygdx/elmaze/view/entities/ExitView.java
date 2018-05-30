package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.view.GameView;

/**
 * Represents an Exit View
 */
public class ExitView extends EntityView {

	/**
	 * Creates a Exit View
	 * 
	 * @param game Reference to the Game object
	 * @param model The Model of the Ball that this view represents
	 */
	public ExitView(ELMaze game, EntityModel model) {
		super(game, model);
	}
	
    /**
     * Positions the sprite on the location of the respective model
     * 
     * @param model The model associated with the view
     */
	@Override
	public void update(EntityModel model) {}

	@Override
	public void createSprite(ELMaze game, EntityModel model) {
        Texture texture = game.getAssetManager().get("exit.png");

        sprite = new Sprite(texture, 
        					texture.getWidth(), 
        					texture.getHeight());
        
        sprite.setSize(
    			((ExitModel)model).getRadius()*2 / GameView.PIXEL_TO_METER, 
    			((ExitModel)model).getRadius()*2 / GameView.PIXEL_TO_METER
    	);
        
        sprite.setCenter(model.getX() / GameView.PIXEL_TO_METER, model.getY() / GameView.PIXEL_TO_METER);
	}

}
