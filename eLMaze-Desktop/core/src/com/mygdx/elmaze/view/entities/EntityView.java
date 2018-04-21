package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.view.GameView;

public abstract class EntityView {
	
	Sprite sprite;

	public EntityView(ELMaze game, EntityModel model) {
		createSprite(game, model);
	}
	
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
    
    public void update(EntityModel model) {
        sprite.setCenter(model.getX() / GameView.PIXEL_TO_METER, model.getY() / GameView.PIXEL_TO_METER);
    }
	
	public abstract void createSprite(ELMaze game, EntityModel model);
}
