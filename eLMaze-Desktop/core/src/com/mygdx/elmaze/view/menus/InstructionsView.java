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
	
	public InstructionsView(ELMaze game) {
		super(game, TYPE.INSTRUCTIONS);
        
        instructions = ImageFactory.makeImage("desktopInstructions1.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*65/100, 
        		SCREEN_WIDTH*92/100);
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
												   SCREEN_HEIGHT*37/100, 
												   (int)(SCREEN_WIDTH*4/100), 
												   (int)(SCREEN_HEIGHT*8/100));

		stage.addActor(nextArrowButton);
	}
	
	private void createPreviousArrowButton(){
		previousArrowButton = ButtonFactory.makeButton(game.getAssetManager().get("previousArrowButtonUp.png", Texture.class),
													   game.getAssetManager().get("previousArrowButtonDown.png", Texture.class), 
													   SCREEN_WIDTH*3/100, 
													   SCREEN_HEIGHT*37/100, 
													   (int)(SCREEN_WIDTH*4/100), 
													   (int)(SCREEN_HEIGHT*8/100));

		stage.addActor(previousArrowButton);
	}
	
	
	private void addButtonListeners() {
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
        
        nextArrowButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	instructions.setDrawable(new TextureRegionDrawable(new TextureRegion(
    					game.getAssetManager().get("desktopInstructions2.jpg", Texture.class))));
            	instructions.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
            }
        });
        
       previousArrowButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
            	Texture instructionsTex = game.getAssetManager().get("desktopInstructions1.png", Texture.class);
            	float texRatio = (float)instructionsTex.getWidth()/(float)instructionsTex.getHeight();
            	instructions.setDrawable(new TextureRegionDrawable(new TextureRegion(instructionsTex)));
            	
            	int imgWidth = SCREEN_WIDTH*92/100;
            	int imgHeight = (int)(imgWidth/texRatio);
            	instructions.setBounds(SCREEN_WIDTH*4/100, SCREEN_HEIGHT/2, imgWidth, imgHeight);
            }
        });
	}
	
}
