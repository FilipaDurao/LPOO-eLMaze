package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.view.GameView;

/**
 * Represents a Button View
 */
public class ButtonView extends EntityView {
	
	private final Texture unpressedTexture;
	private final Texture pressedTexture;

	/**
	 * Creates a Button View
	 * 
	 * @param game Reference to the Game object
	 * @param model The Model of the Ball that this view represents
	 */
	public ButtonView(ELMaze game, EntityModel model) {
		super(game, model);
		
        unpressedTexture = game.getAssetManager().get("button.png");
        pressedTexture = game.getAssetManager().get("pressed_button.png");		
	}
	
	/**
     * Selects the correct sprite considering the button's state
     * Positions the sprite on the location of the respective model
     * 
     * @param model The model associated with the view
	 */
	@Override
	public void update(EntityModel model) {	
		ButtonModel button = (ButtonModel) model;
		
        if (button.isPressed()) {
        	sprite.setTexture(pressedTexture);
        }
        else {
        	sprite.setTexture(unpressedTexture);
        }
    }

	/**
	 * Creates the Sprite
	 * 
	 * @param game Reference to the Game object
	 * @param model The model to which to apply the sprite
	 */
	@Override
	public void createSprite(ELMaze game, EntityModel model) {
		Texture texture = game.getAssetManager().get("button.png");
		
        sprite = new Sprite(texture, 
        		texture.getWidth(), 
        		texture.getHeight());

		sprite.setSize(
			((ButtonModel)model).getRadius()*2 / GameView.PIXEL_TO_METER, 
			((ButtonModel)model).getRadius()*2 / GameView.PIXEL_TO_METER
		);
		
        sprite.setCenter(model.getX() / GameView.PIXEL_TO_METER, model.getY() / GameView.PIXEL_TO_METER);
	}

}
