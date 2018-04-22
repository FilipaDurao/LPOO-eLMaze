package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.view.GameView;

public class ButtonView extends EntityView {
	
	private final Texture unpressedTexture;
	private final Texture pressedTexture;

	public ButtonView(ELMaze game, EntityModel model) {
		super(game, model);
		
        unpressedTexture = game.getAssetManager().get("button.png");
        pressedTexture = game.getAssetManager().get("pressed_button.png");		
	}
	
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
