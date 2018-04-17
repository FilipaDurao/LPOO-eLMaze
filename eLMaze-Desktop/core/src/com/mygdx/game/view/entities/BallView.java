package com.mygdx.game.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.ELMaze;

public class BallView extends EntityView {

	public BallView(ELMaze game) {
		super(game);
	}

	@Override
	public Sprite createSprite(ELMaze game) {
        Texture texture = game.getAssetManager().get("ball.png");

        return new Sprite(texture, texture.getWidth(), texture.getHeight());
	}

}
