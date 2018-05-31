package com.mygdx.elmaze.view.menus;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.view.entities.BallView;

/**
 * Represents the Singleplayer Keyboard menu view
 */
public class SPKeyboardMenuView extends MenuView {

	private Button frontArrowButton;
    private Button backArrowButton;
    private Button playButton;
    private Button backButton;
    private Image title;
    private ArrayList<String> balls = new ArrayList<String>(5);
    private Integer currentBallSpriteIndex;
    private Image ballImage;
	
    /**
     * Creates the singleplayer Keyboard menu
     * 
     * @param game Reference to the Game object
     */
	public SPKeyboardMenuView(ELMaze game) {
		super(game, TYPE.SPKEYBOARD);
		
		Gdx.input.setInputProcessor(stage);
		currentBallSpriteIndex = 0;
		
		fillSpritesArray();
		
		createBallImage();
		createFrontArrowButton();
		createBackArrowButton();
		createBackAndPlayButtons();
		
		addButtonListeners();
		
		setUpTitle();
	
	}

    /**
	 * Loads all assets needed for the menu
	 */
	protected void loadAssets() {
		this.game.getAssetManager().load( "player1Title.png" , Texture.class);
		this.game.getAssetManager().load( "menuBackground.jpg" , Texture.class);
        this.game.getAssetManager().load( "arrowButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "arrowButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "backspaceButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "backspaceButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "backButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "backButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "playButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "playButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "ball.png" , Texture.class);
        this.game.getAssetManager().load( "jade_ball.png" , Texture.class);
        this.game.getAssetManager().load( "obsidian_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ocean_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ruby_ball.png" , Texture.class);
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
	 * Sets up the text title in the screen
	 */
	private void setUpTitle() {
		title = ImageFactory.makeImage("player1Title.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*85/100,SCREEN_WIDTH/2);
		stage.addActor(title);
	}
	
	/**
	 * Fills the array of Ball sprites
	 */
	private void fillSpritesArray() {
		balls.add("ball.png");
		balls.add("jade_ball.png");
		balls.add("obsidian_ball.png");
		balls.add("ocean_ball.png");
		balls.add("ruby_ball.png");
	}
	
	/**
	 * Creates the Ball images present on the screen
	 */
	private void createBallImage(){
		ballImage = ImageFactory.makeImage("ball.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*60/100, SCREEN_WIDTH*15/100);
		stage.addActor(ballImage);
	}
	
    /**
     * Creates the "Next Arrow" Button
     */
	private void createFrontArrowButton() {
		frontArrowButton = ButtonFactory.makeButton(game.getAssetManager().get("arrowButtonUp.png", Texture.class),
											  game.getAssetManager().get("arrowButtonDown.png", Texture.class), 
											  SCREEN_WIDTH*67/100, 
											  SCREEN_HEIGHT*60/100, 
											  (int)(SCREEN_WIDTH*7/100), 
											  (int)(SCREEN_WIDTH*7/100));

		stage.addActor(frontArrowButton);
	}
	
    /**
     * Creates the "Back Arrow" Button
     */
	private void createBackArrowButton() {
		backArrowButton = ButtonFactory.makeButton(game.getAssetManager().get("backspaceButtonUp.png", Texture.class),
													  game.getAssetManager().get("backspaceButtonDown.png", Texture.class), 
													  SCREEN_WIDTH*32/100, 
													  SCREEN_HEIGHT*60/100, 
													  (int)(SCREEN_WIDTH*7/100), 
													  (int)(SCREEN_WIDTH*7/100));
		
		stage.addActor(backArrowButton);
	}
	
	/**
	 * Creates the Play and Back Buttons
	 */
	private void createBackAndPlayButtons() {
		playButton = ButtonFactory.makeButton(game.getAssetManager().get("playButtonUp.png", Texture.class),
				  game.getAssetManager().get("playButtonDown.png", Texture.class), 
				  SCREEN_WIDTH*70/100, 
				  SCREEN_HEIGHT*20/100, 
				  (int)(SCREEN_WIDTH*30/100), 
				  (int)(SCREEN_HEIGHT*14/100));

		stage.addActor(playButton);

		backButton = ButtonFactory.makeButton(game.getAssetManager().get("backButtonUp.png", Texture.class),
				  game.getAssetManager().get("backButtonDown.png", Texture.class), 
				  SCREEN_WIDTH*30/100, 
				  SCREEN_HEIGHT*20/100, 
				  (int)(SCREEN_WIDTH*30/100), 
				  (int)(SCREEN_HEIGHT*14/100));
		
		stage.addActor(backButton);
	}
	
	/**
	 * Adds all the Button listeners
	 */
    private void addButtonListeners() {
    	frontArrowButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	currentBallSpriteIndex = (currentBallSpriteIndex+1)%balls.size();
            	ballImage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            			(Texture) game.getAssetManager().get(balls.get(currentBallSpriteIndex)))));
            }
        });

    	backArrowButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	currentBallSpriteIndex = currentBallSpriteIndex == 0 ? balls.size()-1 : currentBallSpriteIndex-1;
            	ballImage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            			(Texture) game.getAssetManager().get(balls.get(currentBallSpriteIndex)))));
            }
        });
    	
    	playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	BallView.setPlayer1SpriteName(balls.get(currentBallSpriteIndex));
            	game.startGame();
            }
        });
    	
    	backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	game.activateMenu(MenuFactory.makeMenu(game, TYPE.PLATFORMCHOICE));
            }
        });
    }


}
