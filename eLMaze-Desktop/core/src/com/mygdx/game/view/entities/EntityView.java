package com.mygdx.game.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ELMaze;
import com.mygdx.game.model.entities.EntityModel;
import com.mygdx.game.view.GameView;

public abstract class EntityView {
	
	Sprite sprite;

	public EntityView(ELMaze game) {
		sprite = createSprite(game);
	}
	
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
    
    public void update(EntityModel model) {
        sprite.setCenter(model.getX() / GameView.PIXEL_TO_METER, model.getY() / GameView.PIXEL_TO_METER);
    }
	
	public abstract Sprite createSprite(ELMaze game);
}
