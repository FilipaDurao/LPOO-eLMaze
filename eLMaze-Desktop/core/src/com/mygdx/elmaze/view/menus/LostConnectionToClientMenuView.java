package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;

public class LostConnectionToClientMenuView extends MenuView {

	private Image winText;
    private Button backButton;
	
	public LostConnectionToClientMenuView(ELMaze game) {
		super(game, TYPE.LOSTCONTOCLIENT);
        
		winText = ImageFactory.makeImage("lostConnectionToClient.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*65/100, SCREEN_WIDTH*92/100);
        stage.addActor(winText);
        
		createBackButton();
        addButtonListeners();
	}

	@Override
	protected void loadAssets() {
		this.game.getAssetManager().load( "lostConnectionToClient.png" , Texture.class);
        this.game.getAssetManager().load( "backButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "backButtonDown.png" , Texture.class);
		this.game.getAssetManager().load( "menuBackground.jpg" , Texture.class);

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
	
	private void addButtonListeners() {
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
	}

}
