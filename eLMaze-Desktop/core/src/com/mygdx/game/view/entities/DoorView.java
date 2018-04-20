package com.mygdx.game.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.ELMaze;
import com.mygdx.game.model.entities.EntityModel;

public class DoorView extends EntityView {

	public DoorView(ELMaze game, EntityModel model) {
		super(game, model);
	}

	@Override
	public void createSprite(ELMaze game, EntityModel model) {
        Texture texture = game.getAssetManager().get("wall.png");

        sprite = new Sprite(texture, texture.getWidth(), texture.getHeight());
	}

}
