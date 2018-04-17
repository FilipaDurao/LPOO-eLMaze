package com.mygdx.game.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.ELMaze;

public class WallView extends EntityView {

	public WallView(ELMaze game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Sprite createSprite(ELMaze game) {
        Texture texture = game.getAssetManager().get("wall.png");

        return new Sprite(texture, texture.getWidth(), texture.getHeight());
	}

}
