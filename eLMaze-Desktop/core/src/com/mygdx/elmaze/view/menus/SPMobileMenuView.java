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
import com.mygdx.elmaze.networking.NetworkManager;
import com.mygdx.elmaze.view.entities.BallView;

public class SPMobileMenuView extends MenuView {

	private Button frontArrowButton;
    private Button backArrowButton;
    private Button playButton;
    private Button backButton;
    private Image title;
    private Image gameCodeTitle;
    private Image gameCodeBar;
    private Image errorMessage;
    private ArrayList<String> balls = new ArrayList<String>(5);
    private Integer currentBallSpriteIndex;
    private Image ballImage;
	
	public SPMobileMenuView(ELMaze game) {
		super(game, TYPE.SPMOBILE);
		
		Gdx.input.setInputProcessor(stage);
		currentBallSpriteIndex = 0;
		
		fillSpritesArray();
		
		createBallImage();
		createFrontArrowButton();
		createBackArrowButton();
		createBackAndPlayButtons();
		createErrorMessage();
		
		addButtonListeners();
		
		setUpTitles();
	}

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
        this.game.getAssetManager().load( "gameCodeTitle.png" , Texture.class);
        this.game.getAssetManager().load( "gameCodeBar.png" , Texture.class);
        this.game.getAssetManager().load( "ball.png" , Texture.class);
        this.game.getAssetManager().load( "jade_ball.png" , Texture.class);
        this.game.getAssetManager().load( "obsidian_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ocean_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ruby_ball.png" , Texture.class);
        this.game.getAssetManager().load( "empty.png" , Texture.class);
        this.game.getAssetManager().load( "playerNotConnectedError.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
	}
	
	@Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }
	
	private void setUpTitles() {
		title = ImageFactory.makeImage("player1Title.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*9/10,SCREEN_WIDTH/3);
		stage.addActor(title);
		
		gameCodeTitle = ImageFactory.makeImage("gameCodeTitle.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*55/100,SCREEN_WIDTH*40/100);
		stage.addActor(gameCodeTitle);
		
		gameCodeBar = ImageFactory.makeImage("gameCodeBar.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*42/100,SCREEN_WIDTH*75/100);
		stage.addActor(gameCodeBar);
	}
	
	private void fillSpritesArray() {
		balls.add("ball.png");
		balls.add("jade_ball.png");
		balls.add("obsidian_ball.png");
		balls.add("ocean_ball.png");
		balls.add("ruby_ball.png");
	}
	
	private void createBallImage() {
		ballImage = ImageFactory.makeImage("ball.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*3/4, SCREEN_WIDTH*12/100);
		stage.addActor(ballImage);
	}
	
	private void createErrorMessage() {
		errorMessage = ImageFactory.makeImage("empty.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*1/20, SCREEN_WIDTH*45/100, SCREEN_HEIGHT*4/100);
		stage.addActor(errorMessage);
	}
	
	private void createFrontArrowButton() {
		frontArrowButton = ButtonFactory.makeButton(game.getAssetManager().get("arrowButtonUp.png", Texture.class),
											  game.getAssetManager().get("arrowButtonDown.png", Texture.class), 
											  SCREEN_WIDTH*65/100, 
											  SCREEN_HEIGHT*75/100, 
											  (int)(SCREEN_WIDTH*5/100), 
											  (int)(SCREEN_WIDTH*5/100));

		stage.addActor(frontArrowButton);
	}
	
	private void createBackArrowButton() {
		backArrowButton = ButtonFactory.makeButton(game.getAssetManager().get("backspaceButtonUp.png", Texture.class),
													  game.getAssetManager().get("backspaceButtonDown.png", Texture.class), 
													  SCREEN_WIDTH*35/100, 
													  SCREEN_HEIGHT*75/100, 
													  (int)(SCREEN_WIDTH*5/100), 
													  (int)(SCREEN_WIDTH*5/100));
		
		stage.addActor(backArrowButton);
	}
	
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
	
    private void addButtonListeners() {
    	frontArrowButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	currentBallSpriteIndex = (currentBallSpriteIndex+1)%balls.size();
            	ballImage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            			(Texture) game.getAssetManager().get(balls.get(currentBallSpriteIndex)))));
            }
        });

    	backArrowButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	currentBallSpriteIndex = currentBallSpriteIndex == 0 ? balls.size()-1 : currentBallSpriteIndex-1;
            	ballImage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            			(Texture) game.getAssetManager().get(balls.get(currentBallSpriteIndex)))));
            }
        });
    	
    	playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	if (NetworkManager.getInstance().getSocketManager().getNumConnections() != 1) {
            		errorMessage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            				game.getAssetManager().get("playerNotConnectedError.png", Texture.class))));
            	} else {
            		errorMessage.setDrawable(new TextureRegionDrawable(new TextureRegion(
            				game.getAssetManager().get("empty.png", Texture.class))));
                	BallView.setPlayer1SpriteName(balls.get(currentBallSpriteIndex));
                	game.startGame();
            	}
            }
        });
    	
    	backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	game.activateMenu(MenuFactory.makeMenu(game, TYPE.PLATFORMCHOICE));
            }
        });
    }

}
