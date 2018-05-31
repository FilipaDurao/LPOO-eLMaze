package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.ELMaze.PLATFORM;
import com.mygdx.elmaze.ELMaze.PLAY_MODE;

/**
 * Represents the Platform choice menu view
 */
public class PlatformChoiceMenuView extends MenuView {

	private Button phoneButton;
    private Button keyboardButton;
    private Image errorMessage;
    private Image title;
	
    /**
     * Creates the platform choice menu
     * 
     * @param game Reference to the Game object
     */
	public PlatformChoiceMenuView(ELMaze game) {
		super(game, TYPE.PLATFORMCHOICE);
		
		Gdx.input.setInputProcessor(stage);
		
		createPhoneButton();
		createKeyboardButton();
		createErrorMessage();
		
		addButtonListeners();
		
		title = ImageFactory.makeImage("platformChoiceTitle.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*4.5f/7,SCREEN_WIDTH*70/100);
		stage.addActor(title);
	}

    /**
	 * Loads all assets needed for the menu
	 */
	protected void loadAssets() {
		this.game.getAssetManager().load( "platformChoiceTitle.png" , Texture.class);
		this.game.getAssetManager().load( "menuBackground.jpg" , Texture.class);
        this.game.getAssetManager().load( "phoneButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "phoneButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "keyboardButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "keyboardButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "serverCreationError.png" , Texture.class);
        this.game.getAssetManager().load( "empty.png" , Texture.class);
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
	 * Creates the error message to present on the screen
	 */
	private void createErrorMessage() {
		errorMessage = ImageFactory.makeImage("empty.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*1/20, SCREEN_WIDTH*50/100, SCREEN_HEIGHT*7/100);
		stage.addActor(errorMessage);
	}
	
	/**
	 * Creates the "Phone" Button
	 */
	private void createPhoneButton() {
		phoneButton = ButtonFactory.makeButton(game.getAssetManager().get("phoneButtonUp.png", Texture.class),
											  game.getAssetManager().get("phoneButtonDown.png", Texture.class), 
											  SCREEN_WIDTH/4, 
											  SCREEN_HEIGHT*2/9, 
											  (int)(SCREEN_WIDTH*4/10), 
											  (int)(SCREEN_HEIGHT/6));

		stage.addActor(phoneButton);
	}
	
	/**
	 * Creates the "Keyboard" Button
	 */
	private void createKeyboardButton() {
		keyboardButton = ButtonFactory.makeButton(game.getAssetManager().get("keyboardButtonUp.png", Texture.class),
													  game.getAssetManager().get("keyboardButtonDown.png", Texture.class), 
													  SCREEN_WIDTH*3/4, 
													  SCREEN_HEIGHT*2/9, 
													  (int)(SCREEN_WIDTH*4/10), 
													  (int)(SCREEN_HEIGHT/6));
		
		stage.addActor(keyboardButton);
	}
	
	/**
	 * Adds all the Button listeners
	 */
    private void addButtonListeners() {
    	phoneButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	game.setPlatform(PLATFORM.PHONE);
            	
            	// Try to start the server
        		if(!game.startServer()) {
            		errorMessage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            				game.getAssetManager().get("serverCreationError.png", Texture.class))));
            		return;
        		} else {
            		errorMessage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            				game.getAssetManager().get("empty.png", Texture.class))));
        		}
            	
            	if(game.getPlayMode() == PLAY_MODE.SINGLEPLAYER) {
            		game.activateMenu(MenuFactory.makeMenu(game, TYPE.SPMOBILE));
            	}
            	else {
            		game.activateMenu(MenuFactory.makeMenu(game, TYPE.MPMOBILE));
            	}
            }
        });

    	keyboardButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	game.setPlatform(PLATFORM.KEYBOARD);

        		errorMessage.setDrawable(new TextureRegionDrawable(new TextureRegion(
        				game.getAssetManager().get("empty.png", Texture.class))));
            	
            	if(game.getPlayMode() == PLAY_MODE.SINGLEPLAYER) {
            		game.activateMenu(MenuFactory.makeMenu(game, TYPE.SPKEYBOARD));
            	}
            	else {
            		game.activateMenu(MenuFactory.makeMenu(game, TYPE.MPKEYBOARD));
            	}
            }
        });
    }
    
}
