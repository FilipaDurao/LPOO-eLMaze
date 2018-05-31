package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.ELMaze.PLATFORM;
import com.mygdx.elmaze.networking.NetworkManager;

/**
 * Represents the Winning view menu
 */
public class WinningMenuView extends MenuView {

	private Image winText;
    private Button backButton;
	
    /**
     * Creates the winning view menu
     * 
     * @param game Reference to the Game object
     */
	public WinningMenuView(ELMaze game) {
		super(game, TYPE.WIN);
        
		winText = ImageFactory.makeImage("bigYouWon.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*65/100, SCREEN_WIDTH*92/100);
        stage.addActor(winText);
        
		createBackButton();
        addButtonListeners();
	}

    /**
	 * Loads all assets needed for the menu
	 */
	@Override
	protected void loadAssets() {
		this.game.getAssetManager().load( "bigYouWon.png" , Texture.class);
        this.game.getAssetManager().load( "exitButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "exitButtonDown.png" , Texture.class);
		this.game.getAssetManager().load( "menuBackground.jpg" , Texture.class);

        this.game.getAssetManager().finishLoading();
		
	}
    
	/**
	 * Renders the menu on the screen
	 * 
	 * @param delta Time since last render
	 */
    @Override
    public void render(float delta) {    	
        stage.act(delta);
        stage.draw();
    }

    /**
     * Creates the "Back" Button
     */
	private void createBackButton() {
		backButton = ButtonFactory.makeButton(game.getAssetManager().get("exitButtonUp.png", Texture.class),
			  	 							  game.getAssetManager().get("exitButtonDown.png", Texture.class), 
			  	 							  SCREEN_WIDTH/2, 
			  	 							  SCREEN_HEIGHT/8, 
			  	 							  (int)(SCREEN_WIDTH*30/100), 
											  (int)(SCREEN_HEIGHT*12/100));
		
		stage.addActor(backButton);
	}
	
	/**
	 * Adds all the Button listeners
	 */
	private void addButtonListeners() {
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	if (game.getPlatform() == PLATFORM.PHONE) {
                    NetworkManager.getInstance().getSocketManager().closeConnections();
            	}
                Gdx.app.exit();
            }
        });
	}

}
