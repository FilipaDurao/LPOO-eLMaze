package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.ELMaze.PLATFORM;
import com.mygdx.elmaze.ELMaze.PLAY_MODE;

public class PlatformChoiceMenuView extends MenuView {

	private Button phoneButton;
    private Button keyboardButton;
    private Image title;
	
	public PlatformChoiceMenuView(ELMaze game) {
		super(game, TYPE.PLATFORMCHOICE);
		
		Gdx.input.setInputProcessor(stage);
		
		createPhoneButton();
		createKeyboardButton();
		
		addButtonListeners();
		
		title = ImageFactory.makeImage("platformChoiceTitle.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*4.5f/7,SCREEN_WIDTH*70/100);
		stage.addActor(title);
	}

	protected void loadAssets() {
		this.game.getAssetManager().load( "platformChoiceTitle.png" , Texture.class);
		this.game.getAssetManager().load( "menuBackground.jpg" , Texture.class);
        this.game.getAssetManager().load( "phoneButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "phoneButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "keyboardButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "keyboardButtonDown.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
	}
	
	@Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }
	
	private void createPhoneButton() {
		phoneButton = ButtonFactory.makeButton(game.getAssetManager().get("phoneButtonUp.png", Texture.class),
											  game.getAssetManager().get("phoneButtonDown.png", Texture.class), 
											  SCREEN_WIDTH/4, 
											  SCREEN_HEIGHT*2/9, 
											  (int)(SCREEN_WIDTH*4/10), 
											  (int)(SCREEN_HEIGHT/6));

		stage.addActor(phoneButton);
	}
	
	private void createKeyboardButton() {
		keyboardButton = ButtonFactory.makeButton(game.getAssetManager().get("keyboardButtonUp.png", Texture.class),
													  game.getAssetManager().get("keyboardButtonDown.png", Texture.class), 
													  SCREEN_WIDTH*3/4, 
													  SCREEN_HEIGHT*2/9, 
													  (int)(SCREEN_WIDTH*4/10), 
													  (int)(SCREEN_HEIGHT/6));
		
		stage.addActor(keyboardButton);
	}
	
	
    private void addButtonListeners() {
    	phoneButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	game.setPlatform(PLATFORM.PHONE);
            	
            	if(game.getPlayMode() == PLAY_MODE.SINGLEPLAYER) {
            		game.activateMenu(MenuFactory.makeMenu(game, TYPE.SPMOBILE));
            	}
            	else {
            		game.activateMenu(MenuFactory.makeMenu(game, TYPE.MPMOBILE));
            	}
            }
        });

    	keyboardButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	game.setPlatform(PLATFORM.KEYBOARD);
            	
            	if(game.getPlayMode() == PLAY_MODE.SINGLEPLAYER) {
            		game.activateMenu(MenuFactory.makeMenu(game, TYPE.SPKEYBOARD));
            	}
            	else {
            		game.activateMenu(MenuFactory.makeMenu(game, TYPE.MPKEYBOARD));
            	}
            }
        });
    }
    
}
