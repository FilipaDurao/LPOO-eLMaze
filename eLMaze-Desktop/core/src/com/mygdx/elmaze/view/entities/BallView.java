package com.mygdx.elmaze.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.view.GameView;

/**
 * Represents a Ball View
 */
public class BallView extends EntityView {
	
	private static String player1SpriteName;
	private static String player2SpriteName;

	/**
	 * Creates a BallView
	 * 
	 * @param game 
	 * @param model
	 */
	public BallView(ELMaze game, BallModel model) {
		super(game, model);
	}

	@Override
	public void createSprite(ELMaze game, EntityModel model) {
        Texture texture = game.getAssetManager().get(
        		((BallModel) model).getPlayerNum() == 0 ? player1SpriteName : player2SpriteName
        );
        
        sprite = new Sprite(texture, 
        		texture.getWidth(), 
        		texture.getHeight());
        
		sprite.setSize(
			((BallModel)model).getRadius()*2 / GameView.PIXEL_TO_METER, 
			((BallModel)model).getRadius()*2 / GameView.PIXEL_TO_METER
		);
	}
	
	public static void setPlayer1SpriteName(String spriteName) {
		player1SpriteName = spriteName;
	}
	
	public static void setPlayer2SpriteName(String spriteName) {
		player2SpriteName = spriteName;
	}

}
