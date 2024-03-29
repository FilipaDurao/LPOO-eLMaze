package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;

/**
 * Represents the Main Menu View
 */
public class MainMenuView extends MenuView {

	private Button playButton;
    private Button instructionsButton;
    private Button creditsButton;
    private Button exitButton;
    private Image title;
	
    /**
     * Creates the Main menu
     * 
     * @param game Reference to the Game object
     */
	public MainMenuView(ELMaze game) {
		super(game, TYPE.MAIN);
		
		Gdx.input.setInputProcessor(stage);
		
		createPlayButton();
		createInstructionsButton();
		createCreditsButton();
		createExitButton();
		
		addButtonListeners();
		
		title = ImageFactory.makeImage("eLMazeTitleBig.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*3/4,SCREEN_WIDTH*65/100);
		stage.addActor(title);
	}

    /**
	 * Loads all assets needed for the menu
	 */
	protected void loadAssets() {
		this.game.getAssetManager().load( "eLMazeTitleBig.png" , Texture.class);
        this.game.getAssetManager().load( "menuBackground.jpg" , Texture.class);
        this.game.getAssetManager().load( "playButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "playButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "creditsButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "creditsButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "instructionsButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "instructionsButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "exitButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "exitButtonDown.png" , Texture.class);

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
	 * Creates the Play Button
	 */
	private void createPlayButton() {
		playButton = ButtonFactory.makeButton(game.getAssetManager().get("playButtonUp.png", Texture.class),
											  game.getAssetManager().get("playButtonDown.png", Texture.class), 
											  SCREEN_WIDTH/4, 
											  SCREEN_HEIGHT*3.5f/9, 
											  (int)(SCREEN_WIDTH*4/10), 
											  (int)(SCREEN_HEIGHT/6));

		stage.addActor(playButton);
	}
	
	/**
	 * Creates the Instructions Button
	 */
	private void createInstructionsButton() {
		instructionsButton = ButtonFactory.makeButton(game.getAssetManager().get("instructionsButtonUp.png", Texture.class),
													  game.getAssetManager().get("instructionsButtonDown.png", Texture.class), 
													  SCREEN_WIDTH/4, 
													  SCREEN_HEIGHT/6, 
													  (int)(SCREEN_WIDTH*4/10), 
													  (int)(SCREEN_HEIGHT/6));
		
		stage.addActor(instructionsButton);
	}
	
	/**
	 * Creates the Credits Button
	 */
	private void createCreditsButton() {
		creditsButton = ButtonFactory.makeButton(game.getAssetManager().get("creditsButtonUp.png", Texture.class),
											  	 game.getAssetManager().get("creditsButtonDown.png", Texture.class), 
											  	 SCREEN_WIDTH*3/4, 
											  	 SCREEN_HEIGHT*3.5f/9, 
											 	 (int)(SCREEN_WIDTH*4/10), 
												 (int)(SCREEN_HEIGHT/6));
		
		stage.addActor(creditsButton);
	}
	
	/**
	 * Creates the Exit Button
	 */
	private void createExitButton() {
		exitButton = ButtonFactory.makeButton(game.getAssetManager().get("exitButtonUp.png", Texture.class),
			  	 							  game.getAssetManager().get("exitButtonDown.png", Texture.class), 
			  	 							  SCREEN_WIDTH*3/4, 
			  	 							  SCREEN_HEIGHT/6, 
			  	 							  (int)(SCREEN_WIDTH*4/10), 
											  (int)(SCREEN_HEIGHT/6));
		
		stage.addActor(exitButton);
	}
	
	/**
	 * Adds all the Button listeners
	 */
    private void addButtonListeners() {
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.NUMPLAYERCHOICE));
            }
        });

        instructionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.INSTRUCTIONS));
            }
        });

        creditsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.CREDITS));
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
                Gdx.app.exit();
            }
        });
    }

}
