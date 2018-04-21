package com.mygdx.game.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.ELMaze;
import com.mygdx.game.model.entities.BallModel;
import com.mygdx.game.model.entities.EntityModel;
import com.mygdx.game.view.GameView;

public class BallView extends EntityView {

	public BallView(ELMaze game, BallModel model) {
		super(game, model);
	}

	@Override
	public void createSprite(ELMaze game, EntityModel model) {
        Texture texture = game.getAssetManager().get("ball.png");
        
        sprite = new Sprite(texture, 
        		texture.getWidth(), 
        		texture.getHeight());
        
		sprite.setSize(
			((BallModel)model).getRadius()*2 / GameView.PIXEL_TO_METER, 
			((BallModel)model).getRadius()*2 / GameView.PIXEL_TO_METER
		);
	}

}
