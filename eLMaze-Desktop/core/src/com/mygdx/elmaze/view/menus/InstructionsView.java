package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;

public class InstructionsView extends MenuView {

    private Image textTableImage;
    private Button exitButton;
	
	public InstructionsView(ELMaze game) {
		super(game, TYPE.INSTRUCTIONS);

		createExitButton();
        addButtonListeners();
        
        textTableImage = ImageFactory.makeImage("creditsTable.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*6/10,SCREEN_WIDTH*20/100);
        stage.addActor(textTableImage);
	}

	@Override
	protected void loadAssets() {
		//this.game.getAssetManager().load( "instructionsTable.png" , Texture.class);
		this.game.getAssetManager().load( "creditsTable.png" , Texture.class);	//TODO: delete this
        this.game.getAssetManager().load( "exitButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "exitButtonDown.png" , Texture.class);

        this.game.getAssetManager().finishLoading();
		
	}
    
    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
    }

	private void createExitButton() {
		exitButton = ButtonFactory.makeButton(game.getAssetManager().get("exitButtonUp.png", Texture.class),
			  	 							  game.getAssetManager().get("exitButtonDown.png", Texture.class), 
			  	 							  SCREEN_WIDTH/2, 
			  	 							  SCREEN_HEIGHT/6, 
			  	 							  (int)(SCREEN_WIDTH*4/10), 
											  (int)(SCREEN_HEIGHT/6));
		
		stage.addActor(exitButton);
	}
	
	private void addButtonListeners() {
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
	}


}
