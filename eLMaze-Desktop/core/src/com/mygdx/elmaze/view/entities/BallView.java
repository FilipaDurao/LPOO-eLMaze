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
	 * Creates a Ball View
	 * 
	 * @param game Reference to the Game object
	 * @param model The Model of the Ball that this view represents
	 */
	public BallView(ELMaze game, BallModel model) {
		super(game, model);
	}

	/**
	 * Creates the Sprite
	 * 
	 * @param game Reference to the Game object
	 * @param model The model to which to apply the sprite
	 */
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
	
	/**
	 * Sets the first player's Ball Sprite
	 * 
	 * @param spriteName The name of the Sprite
	 */
	public static void setPlayer1SpriteName(String spriteName) {
		player1SpriteName = spriteName;
	}
	
	/**
	 * Sets the second player's Ball Sprite
	 * 
	 * @param spriteName The name of the Sprite
	 */
	public static void setPlayer2SpriteName(String spriteName) {
		player2SpriteName = spriteName;
	}

}
