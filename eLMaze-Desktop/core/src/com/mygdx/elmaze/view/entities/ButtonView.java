package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.view.GameView;

public class ButtonView extends EntityView {

	public ButtonView(ELMaze game, EntityModel model) {
		super(game, model);
	}

	@Override
	public void createSprite(ELMaze game, EntityModel model) {
        Texture texture = (Texture) (((ButtonModel) model).isPressed() ? 
        		game.getAssetManager().get("pressed_button.png") :
        		game.getAssetManager().get("button.png"));

        sprite = new Sprite(texture, 
				texture.getWidth(), 
				texture.getHeight());

		sprite.setSize(
			((ButtonModel)model).getRadius()*2 / GameView.PIXEL_TO_METER, 
			((ButtonModel)model).getRadius()*2 / GameView.PIXEL_TO_METER
		);
	}

}
