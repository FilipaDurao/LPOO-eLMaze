package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

public class InstructionsView extends MenuView {

    private Image instructions;
    private Button backButton;
    private Button nextArrowButton;
    private Button previousArrowButton;
    private int instructionsSlide = 0;
	
	public InstructionsView(ELMaze game) {
		super(game, TYPE.INSTRUCTIONS);
        
        instructions = ImageFactory.makeImage("desktopInstructions1.png", SCREEN_WIDTH/2, SCREEN_HEIGHT/2, SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.addActor(instructions);
        
		createBackButton();
		createNextArrowButton();
		createPreviousArrowButton();
        addButtonListeners();
	}

	@Override
	protected void loadAssets() {
		this.game.getAssetManager().load( "desktopInstructions1.png" , Texture.class);
		this.game.getAssetManager().load( "desktopInstructions2.jpg" , Texture.class);
        this.game.getAssetManager().load( "backButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "backButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "previousArrowButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "previousArrowButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "nextArrowButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "nextArrowButtonDown.png" , Texture.class);

        this.game.getAssetManager().finishLoading();
		
	}
    
    @Override
    public void render(float delta) {
    	
    	instructions.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    	
    	if(instructionsSlide == 0) {
			instructions.setDrawable(new TextureRegionDrawable(new TextureRegion(
					game.getAssetManager().get("desktopInstructions1.png", Texture.class))));
		}
		
		else {
			instructions.setDrawable(new TextureRegionDrawable(new TextureRegion(
					game.getAssetManager().get("desktopInstructions2.jpg", Texture.class))));
		}
    	
        stage.act(delta);
        stage.draw();
    }

	private void createBackButton() {
		backButton = ButtonFactory.makeButton(game.getAssetManager().get("backButtonUp.png", Texture.class),
			  	 							  game.getAssetManager().get("backButtonDown.png", Texture.class), 
			  	 							  SCREEN_WIDTH/2, 
			  	 							  SCREEN_HEIGHT/8, 
			  	 							  (int)(SCREEN_WIDTH*30/100), 
											  (int)(SCREEN_HEIGHT*12/100));
		
		stage.addActor(backButton);
	}
	
	private void createNextArrowButton(){
		nextArrowButton = ButtonFactory.makeButton(game.getAssetManager().get("nextArrowButtonUp.png", Texture.class),
												   game.getAssetManager().get("nextArrowButtonDown.png", Texture.class),
												   SCREEN_WIDTH*97/100, 
												   SCREEN_HEIGHT/3, 
												   (int)(SCREEN_WIDTH*4/100), 
												   (int)(SCREEN_HEIGHT*8/100));

		stage.addActor(nextArrowButton);
	}
	
	private void createPreviousArrowButton(){
		previousArrowButton = ButtonFactory.makeButton(game.getAssetManager().get("previousArrowButtonUp.png", Texture.class),
													   game.getAssetManager().get("previousArrowButtonDown.png", Texture.class), 
													   SCREEN_WIDTH*3/100, 
													   SCREEN_HEIGHT/3, 
													   (int)(SCREEN_WIDTH*4/100), 
													   (int)(SCREEN_HEIGHT*8/100));

		stage.addActor(previousArrowButton);
	}
	
	
	private void addButtonListeners() {
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
        
        nextArrowButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	instructionsSlide = 1;
            }
        });
        
       previousArrowButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	instructionsSlide = 0;
            }
        });
	}
	
}
