package com.mygdx.elmaze.view.menus;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.NetworkManager;
import com.mygdx.elmaze.view.entities.BallView;

/**
 * Represents the Multiplayer Mobile menu view
 */
public class MPMobileMenuView extends MenuView {

	private Button frontArrowButton1;
    private Button backArrowButton1;
    private Button frontArrowButton2;
    private Button backArrowButton2;
    private Button playButton;
    private Button backButton;
    private Image title1;
    private Image title2;
    private Image gameCodeTitle;
    private Image gameCodeBar;
    private Image errorMessage;
    private ArrayList<String> balls = new ArrayList<String>(5);
    private ArrayList<String> symbolFileNames = new ArrayList<String>();
    private Integer currentBallSpriteIndex1;
    private Integer currentBallSpriteIndex2;
    private Image ballImage1;
    private Image ballImage2;
	
    /**
     * Creates the multiplayer Mobile menu
     * 
     * @param game Reference to the Game object
     */
	public MPMobileMenuView(ELMaze game) {
		super(game, TYPE.MPMOBILE);
		
		Gdx.input.setInputProcessor(stage);
		currentBallSpriteIndex1 = 0;
		currentBallSpriteIndex2 = 4;
		
		fillSpritesArray();
		
		createBallImages();
		
		createFrontArrowButton1();
		createBackArrowButton1();
		createFrontArrowButton2();
		createBackArrowButton2();
		createBackAndPlayButtons();
		createErrorMessage();
		setUpTitles();
		setupSymbolNames();
		createKeyCode();
		
		addButtonListeners();
	}

    /**
	 * Loads all assets needed for the menu
	 */
	protected void loadAssets() {
		this.game.getAssetManager().load( "player1Title.png" , Texture.class);
		this.game.getAssetManager().load( "player2Title.png" , Texture.class);
		this.game.getAssetManager().load( "menuBackground.jpg" , Texture.class);
        this.game.getAssetManager().load( "arrowButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "arrowButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "backspaceButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "backspaceButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "backButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "backButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "playButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "playButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "gameCodeTitle.png" , Texture.class);
        this.game.getAssetManager().load( "gameCodeBar.png" , Texture.class);
        this.game.getAssetManager().load( "ball.png" , Texture.class);
        this.game.getAssetManager().load( "jade_ball.png" , Texture.class);
        this.game.getAssetManager().load( "obsidian_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ocean_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ruby_ball.png" , Texture.class);
        this.game.getAssetManager().load( "empty.png" , Texture.class);
        this.game.getAssetManager().load( "notAllPlayersConnectedError.png" , Texture.class);
        loadSymbolAssets();
        
        this.game.getAssetManager().finishLoading();
	}
	
	/**
	 * Loads all the symbols to use in the key code
	 */
	private void loadSymbolAssets() {
		this.game.getAssetManager().load("alphaSymbol.png", Texture.class);
		this.game.getAssetManager().load("betaSymbol.png", Texture.class);
		this.game.getAssetManager().load("chiSymbol.png", Texture.class);
		this.game.getAssetManager().load("deltaSymbol.png", Texture.class);
		this.game.getAssetManager().load("epsilonSymbol.png", Texture.class);
		this.game.getAssetManager().load("etaSymbol.png", Texture.class);
		this.game.getAssetManager().load("gamaSymbol.png", Texture.class);
		this.game.getAssetManager().load("lambdaSymbol.png", Texture.class);
		this.game.getAssetManager().load("muSymbol.png", Texture.class);
		this.game.getAssetManager().load("omegaSymbol.png", Texture.class);
		this.game.getAssetManager().load("phiSymbol.png", Texture.class);
		this.game.getAssetManager().load("piSymbol.png", Texture.class);
		this.game.getAssetManager().load("psiSymbol.png", Texture.class);;
		this.game.getAssetManager().load("rhoSymbol.png", Texture.class);
		this.game.getAssetManager().load("sigmaSymbol.png", Texture.class);
		this.game.getAssetManager().load("tauSymbol.png", Texture.class);
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
	 * Set up the names of the symbols used for the key code
	 */
	private void setupSymbolNames() {
		symbolFileNames.add("alphaSymbol.png");
	    symbolFileNames.add("betaSymbol.png");
	    symbolFileNames.add("chiSymbol.png");
	    symbolFileNames.add("deltaSymbol.png");
	    symbolFileNames.add("epsilonSymbol.png");
	    symbolFileNames.add("etaSymbol.png");
	    symbolFileNames.add("gamaSymbol.png");
	    symbolFileNames.add("lambdaSymbol.png");
	    symbolFileNames.add("muSymbol.png");
	    symbolFileNames.add("omegaSymbol.png");
	    symbolFileNames.add("phiSymbol.png");
	    symbolFileNames.add("piSymbol.png");
	    symbolFileNames.add("psiSymbol.png");
	    symbolFileNames.add("rhoSymbol.png");
	    symbolFileNames.add("sigmaSymbol.png");
	    symbolFileNames.add("tauSymbol.png");
	}
	
	/**
	 * Creates the key Code based on the parsed IP
	 */
	private void createKeyCode() {
		int symbolSize = (int)(SCREEN_WIDTH*3.5/100);
		LinkedList<Integer> parsedIP = NetworkManager.getInstance().getParsedIP();
		for (int i=0 ; i<parsedIP.size() ; i++) {
			stage.addActor(ImageFactory.makeImage(symbolFileNames.get(parsedIP.get(i)), (int)(SCREEN_WIDTH*31.5/100+1.4*i*symbolSize+symbolSize/2), 
					SCREEN_HEIGHT*42/100, symbolSize, symbolSize));
		}
	}
	
	/**
	 * Sets up the text titles in the screen
	 */
	private void setUpTitles() {
		title1 = ImageFactory.makeImage("player1Title.png", SCREEN_WIDTH/4, SCREEN_HEIGHT*9/10,SCREEN_WIDTH/3);
		stage.addActor(title1);
		
		title2 = ImageFactory.makeImage("player2Title.png", SCREEN_WIDTH*3/4, SCREEN_HEIGHT*9/10,SCREEN_WIDTH/3);
		stage.addActor(title2);
		
		gameCodeTitle = ImageFactory.makeImage("gameCodeTitle.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*55/100,SCREEN_WIDTH*35/100);
		stage.addActor(gameCodeTitle);
		
		gameCodeBar = ImageFactory.makeImage("gameCodeBar.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*42/100, SCREEN_WIDTH*42/100, SCREEN_WIDTH*5/100);
		stage.addActor(gameCodeBar);
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
	private void createBallImages(){
		ballImage1 = ImageFactory.makeImage("ball.png", SCREEN_WIDTH*24/100, SCREEN_HEIGHT*3/4, SCREEN_WIDTH*8/100);
		stage.addActor(ballImage1);
		
		ballImage2 = ImageFactory.makeImage("ruby_ball.png", SCREEN_WIDTH*76/100, SCREEN_HEIGHT*3/4, SCREEN_WIDTH*8/100);
		stage.addActor(ballImage2);
	}
	
	/**
	 * Creates the Error message to present on the screen
	 */
	private void createErrorMessage() {
		errorMessage = ImageFactory.makeImage("empty.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*1/20, SCREEN_WIDTH*53/100, SCREEN_HEIGHT*4/100);
		stage.addActor(errorMessage);
	}
	
    /**
     * Creates the "Next Arrow 1" Button
     */
	private void createFrontArrowButton1() {
		frontArrowButton1 = ButtonFactory.makeButton(game.getAssetManager().get("arrowButtonUp.png", Texture.class),
											  game.getAssetManager().get("arrowButtonDown.png", Texture.class), 
											  SCREEN_WIDTH*35/100, 
											  SCREEN_HEIGHT*75/100, 
											  (int)(SCREEN_WIDTH*5/100), 
											  (int)(SCREEN_WIDTH*5/100));

		stage.addActor(frontArrowButton1);
	}
	
    /**
     * Creates the "Back Arrow 1" Button
     */
	private void createBackArrowButton1() {
		backArrowButton1 = ButtonFactory.makeButton(game.getAssetManager().get("backspaceButtonUp.png", Texture.class),
													  game.getAssetManager().get("backspaceButtonDown.png", Texture.class), 
													  SCREEN_WIDTH*13/100, 
													  SCREEN_HEIGHT*75/100, 
													  (int)(SCREEN_WIDTH*5/100), 
													  (int)(SCREEN_WIDTH*5/100));
		
		stage.addActor(backArrowButton1);
	}
	
    /**
     * Creates the "Next Arrow 2" Button
     */
	private void createFrontArrowButton2() {
		frontArrowButton2 = ButtonFactory.makeButton(game.getAssetManager().get("arrowButtonUp.png", Texture.class),
											  game.getAssetManager().get("arrowButtonDown.png", Texture.class), 
											  SCREEN_WIDTH*87/100, 
											  SCREEN_HEIGHT*75/100, 
											  (int)(SCREEN_WIDTH*5/100), 
											  (int)(SCREEN_WIDTH*5/100));

		stage.addActor(frontArrowButton2);
	}
	
    /**
     * Creates the "Back Arrow 2" Button
     */
	private void createBackArrowButton2() {
		backArrowButton2 = ButtonFactory.makeButton(game.getAssetManager().get("backspaceButtonUp.png", Texture.class),
													  game.getAssetManager().get("backspaceButtonDown.png", Texture.class), 
													  SCREEN_WIDTH*65/100, 
													  SCREEN_HEIGHT*75/100, 
													  (int)(SCREEN_WIDTH*5/100), 
													  (int)(SCREEN_WIDTH*5/100));
		
		stage.addActor(backArrowButton2);
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
    	frontArrowButton1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	currentBallSpriteIndex1 = (currentBallSpriteIndex1+1)%balls.size();
            	
            	if(currentBallSpriteIndex1 == currentBallSpriteIndex2) {
            		currentBallSpriteIndex1 = (currentBallSpriteIndex1+1)%balls.size();
            	}
            	
            	ballImage1.setDrawable(new TextureRegionDrawable(new TextureRegion(
            			(Texture) game.getAssetManager().get(balls.get(currentBallSpriteIndex1)))));
            }
        });

    	backArrowButton1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	currentBallSpriteIndex1 = currentBallSpriteIndex1 == 0 ? balls.size()-1 : currentBallSpriteIndex1 - 1;
            	
            	if(currentBallSpriteIndex1 == currentBallSpriteIndex2) {
            		currentBallSpriteIndex1 = currentBallSpriteIndex1 == 0 ? balls.size()-1 : currentBallSpriteIndex1 - 1;
            	}
            	
            	ballImage1.setDrawable(new TextureRegionDrawable(new TextureRegion(
            			(Texture) game.getAssetManager().get(balls.get(currentBallSpriteIndex1)))));
            }
        });
    	
    	frontArrowButton2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	currentBallSpriteIndex2 = (currentBallSpriteIndex2+1)%balls.size();
            	
            	if(currentBallSpriteIndex2 == currentBallSpriteIndex1) {
            		currentBallSpriteIndex2 = (currentBallSpriteIndex2+1)%balls.size();
            	}
            	
            	ballImage2.setDrawable(new TextureRegionDrawable(new TextureRegion(
            			(Texture) game.getAssetManager().get(balls.get(currentBallSpriteIndex2)))));
            }
        });

    	backArrowButton2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	currentBallSpriteIndex2 = currentBallSpriteIndex2 == 0 ? balls.size()-1 : currentBallSpriteIndex2 - 1;
            	
            	if(currentBallSpriteIndex2 == currentBallSpriteIndex1) {
            		currentBallSpriteIndex2 = currentBallSpriteIndex2 == 0 ? balls.size()-1 : currentBallSpriteIndex2 - 1;
            	}
            	
            	ballImage2.setDrawable(new TextureRegionDrawable(new TextureRegion(
            			(Texture) game.getAssetManager().get(balls.get(currentBallSpriteIndex2)))));
            }
        });
    	
    	playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	if (NetworkManager.getInstance().getSocketManager().getNumConnections() != 2) {
            		errorMessage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            				game.getAssetManager().get("notAllPlayersConnectedError.png", Texture.class))));
            	} else {
            		errorMessage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            				game.getAssetManager().get("empty.png", Texture.class))));
                	BallView.setPlayer1SpriteName(balls.get(currentBallSpriteIndex1));
                	BallView.setPlayer2SpriteName(balls.get(currentBallSpriteIndex2));
                	game.startGame();
            	}
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
