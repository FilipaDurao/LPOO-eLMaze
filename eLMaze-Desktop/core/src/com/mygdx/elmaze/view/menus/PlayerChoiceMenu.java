package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.ELMaze.NUM_PLAYERS;
import com.mygdx.elmaze.controller.GameController;

public class PlayerChoiceMenu extends MenuView {


	private Button onePlayerButton;
    private Button twoPlayersButton;
    private Image title;
	
	public PlayerChoiceMenu(ELMaze game) {
		super(game, TYPE.NUMPLAYERCHOICE);
		
		Gdx.input.setInputProcessor(stage);
		
		createOnePlayerButton();
		createTwoPlayersButton();
		
		addButtonListeners();
		
		title = ImageFactory.makeImage("howManyPlayersTitle.png", SCREEN_WIDTH/2, SCREEN_HEIGHT*4.5f/7,SCREEN_WIDTH*70/100);
		stage.addActor(title);
	}

	protected void loadAssets() {
		this.game.getAssetManager().load( "howManyPlayersTitle.png" , Texture.class);
		this.game.getAssetManager().load( "menuBackground.jpg" , Texture.class);
        this.game.getAssetManager().load( "1PlayerButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "1PlayerButtonDown.png" , Texture.class);
        this.game.getAssetManager().load( "2PlayersButtonUp.png" , Texture.class);
        this.game.getAssetManager().load( "2PlayersButtonDown.png" , Texture.class);
        this.game.getAssetManager().finishLoading();
	}
	
	@Override
    public void render(float delta) {
        //handleInputs();
        GameController.getInstance().update(delta);

        stage.act(delta); //Perform ui logic
        stage.draw();
    }
	
	private void createOnePlayerButton() {
		onePlayerButton = ButtonFactory.makeButton(game.getAssetManager().get("1PlayerButtonUp.png", Texture.class),
											  game.getAssetManager().get("1PlayerButtonDown.png", Texture.class), 
											  SCREEN_WIDTH/4, 
											  SCREEN_HEIGHT*2/9, 
											  (int)(SCREEN_WIDTH*4/10), 
											  (int)(SCREEN_HEIGHT/6));

		stage.addActor(onePlayerButton);
	}
	
	private void createTwoPlayersButton() {
		twoPlayersButton = ButtonFactory.makeButton(game.getAssetManager().get("2PlayersButtonUp.png", Texture.class),
													  game.getAssetManager().get("2PlayersButtonDown.png", Texture.class), 
													  SCREEN_WIDTH*3/4, 
													  SCREEN_HEIGHT*2/9, 
													  (int)(SCREEN_WIDTH*4/10), 
													  (int)(SCREEN_HEIGHT/6));
		
		stage.addActor(twoPlayersButton);
	}
	
	
    private void addButtonListeners() {
    	onePlayerButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	game.setNumPlayers(NUM_PLAYERS.SINGLE_PLAYER);
                game.activateMenu(MenuFactory.makeMenu(game, TYPE.PLATFORMCHOICE));
            }
        });

    	twoPlayersButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	game.setNumPlayers(NUM_PLAYERS.MULTIPLAYER);
            	game.activateMenu(MenuFactory.makeMenu(game, TYPE.PLATFORMCHOICE));
            }
        });
    }

}
