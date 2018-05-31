package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;

public class CreditsView extends MenuView{

    private Image textTableImage;
    private Button backButton;

    public CreditsView(ELMaze game) {
        super(game, TYPE.CREDITS);

        createBackButton();
        addButtonListeners();
        
        textTableImage = ImageFactory.makeImage("creditsTableDesktop.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*55/100,SCREEN_WIDTH*80/100);
        stage.addActor(textTableImage);
    }

	@Override
	protected void loadAssets() {
		this.game.getAssetManager().load( "creditsTableDesktop.png" , Texture.class);
        this.game.getAssetManager().load( "backButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "backButtonDown.png" , Texture.class);

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
			  	 							  SCREEN_HEIGHT/7, 
			  	 							  (int)(SCREEN_WIDTH*3/10), 
											  (int)(SCREEN_HEIGHT/8));
		
		stage.addActor(backButton);
	}
	
	private void addButtonListeners() {
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	playButtonSound();
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.MAIN));
            }
        });
	}

}
