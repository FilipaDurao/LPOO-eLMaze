package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.view.GameView;

public class ExitView extends EntityView {

	public ExitView(ELMaze game, EntityModel model) {
		super(game, model);
	}

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
	}

}
