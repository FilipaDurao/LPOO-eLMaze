package com.mygdx.game.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ELMaze;

public abstract class EntityView {
	
	Sprite sprite;

	public EntityView(ELMaze game) {
		sprite = createSprite(game);
	}
	
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
	
	public abstract Sprite createSprite(ELMaze game);
}
