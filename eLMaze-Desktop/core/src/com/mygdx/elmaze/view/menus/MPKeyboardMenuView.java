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

public class MPKeyboardMenuView extends MenuView {

	private Button frontArrowButton1;
    private Button backArrowButton1;
    private Button frontArrowButton2;
    private Button backArrowButton2;
    private Button playButton;
    private Button backButton;
    private Image title1;
    private Image title2;
    private ArrayList<String> balls = new ArrayList<String>(5);
    private Integer currentBallSpriteIndex1;
    private Integer currentBallSpriteIndex2;
    private Image ballImage1;
    private Image ballImage2;
	
	public MPKeyboardMenuView(ELMaze game) {
		super(game, TYPE.MPKEYBOARD);
		
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
		
		addButtonListeners();
		
		setUpTitles();
	
	}

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
        this.game.getAssetManager().load( "ball.png" , Texture.class);
        this.game.getAssetManager().load( "jade_ball.png" , Texture.class);
        this.game.getAssetManager().load( "obsidian_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ocean_ball.png" , Texture.class);
        this.game.getAssetManager().load( "ruby_ball.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
	}
	
	@Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }
	
	private void setUpTitles() {
		title1 = ImageFactory.makeImage("player1Title.png", SCREEN_WIDTH/4, SCREEN_HEIGHT*80/100,SCREEN_WIDTH*40/100);
		stage.addActor(title1);
		
		title2 = ImageFactory.makeImage("player2Title.png", SCREEN_WIDTH*3/4, SCREEN_HEIGHT*80/100,SCREEN_WIDTH*40/100);
		stage.addActor(title2);
	}
	
	private void fillSpritesArray() {
		balls.add("ball.png");
		balls.add("jade_ball.png");
		balls.add("obsidian_ball.png");
		balls.add("ocean_ball.png");
		balls.add("ruby_ball.png");
	}
	
	private void createBallImages(){
		ballImage1 = ImageFactory.makeImage("ball.png", SCREEN_WIDTH*24/100, SCREEN_HEIGHT*55/100, SCREEN_WIDTH*12/100);
		stage.addActor(ballImage1);
		
		ballImage2 = ImageFactory.makeImage("ruby_ball.png", SCREEN_WIDTH*76/100, SCREEN_HEIGHT*55/100, SCREEN_WIDTH*12/100);
		stage.addActor(ballImage2);
	}
	
	private void createFrontArrowButton1() {
		frontArrowButton1 = ButtonFactory.makeButton(game.getAssetManager().get("arrowButtonUp.png", Texture.class),
											  game.getAssetManager().get("arrowButtonDown.png", Texture.class), 
											  SCREEN_WIDTH*38/100, 
											  SCREEN_HEIGHT*55/100, 
											  (int)(SCREEN_WIDTH*5/100), 
											  (int)(SCREEN_WIDTH*5/100));

		stage.addActor(frontArrowButton1);
	}
	
	private void createBackArrowButton1() {
		backArrowButton1 = ButtonFactory.makeButton(game.getAssetManager().get("backspaceButtonUp.png", Texture.class),
													  game.getAssetManager().get("backspaceButtonDown.png", Texture.class), 
													  SCREEN_WIDTH*10/100, 
													  SCREEN_HEIGHT*55/100, 
													  (int)(SCREEN_WIDTH*5/100), 
													  (int)(SCREEN_WIDTH*5/100));
		
		stage.addActor(backArrowButton1);
	}
	
	private void createFrontArrowButton2() {
		frontArrowButton2 = ButtonFactory.makeButton(game.getAssetManager().get("arrowButtonUp.png", Texture.class),
											  game.getAssetManager().get("arrowButtonDown.png", Texture.class), 
											  SCREEN_WIDTH*90/100, 
											  SCREEN_HEIGHT*55/100, 
											  (int)(SCREEN_WIDTH*5/100), 
											  (int)(SCREEN_WIDTH*5/100));

		stage.addActor(frontArrowButton2);
	}
	
	private void createBackArrowButton2() {
		backArrowButton2 = ButtonFactory.makeButton(game.getAssetManager().get("backspaceButtonUp.png", Texture.class),
													  game.getAssetManager().get("backspaceButtonDown.png", Texture.class), 
													  SCREEN_WIDTH*62/100, 
													  SCREEN_HEIGHT*55/100, 
													  (int)(SCREEN_WIDTH*5/100), 
													  (int)(SCREEN_WIDTH*5/100));
		
		stage.addActor(backArrowButton2);
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
    	frontArrowButton1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
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
            	BallView.setPlayer1SpriteName(balls.get(currentBallSpriteIndex1));
            	BallView.setPlayer2SpriteName(balls.get(currentBallSpriteIndex2));
            	game.startGame();
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
