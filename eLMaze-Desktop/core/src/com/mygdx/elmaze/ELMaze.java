package com.mygdx.elmaze;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.model.GameModel;
import com.mygdx.elmaze.networking.NetworkManager;
import com.mygdx.elmaze.view.GameView;
import com.mygdx.elmaze.view.menus.MainMenuView;
import com.mygdx.elmaze.view.menus.MenuView;

public class ELMaze extends Game {
	
	public enum NUM_PLAYERS { SINGLE_PLAYER, MULTIPLAYER }
	public enum PLATFORM { PHONE, KEYBOARD }
	
	private SpriteBatch spriteBatch;
	private AssetManager assetManager;
	private NUM_PLAYERS numPlayers;
	private PLATFORM platform;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		assetManager = new AssetManager();
		
		startElMaze();
	}
	
	private void startElMaze() {
		MainMenuView mainMenuView = new MainMenuView(this);
		GameView view = new GameView(this, true);
		GameModel.getInstance().setSinglePlayerMode();
		GameController.getInstance().setSinglePlayerMode();

		// TODO: This is temporary!!!!
		if (NetworkManager.getInstance().startServer()) {
			String[] symbols = {"alpha", "beta", "chi", "delta", "epsilon", "eta", "gama", "lamba",
								"mu", "omega", "phi", "pi", "psi", "rho", "sigma", "tau"};
			
			for (Integer num : NetworkManager.getInstance().parse()) {
				System.out.println(num + " - " + symbols[num]);
			}
		}
		
        setScreen(view);
    }

    @Override
	public void dispose () {
    	spriteBatch.dispose();
		assetManager.dispose();
	}

	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}

	public void activateMenu(MenuView menu) {
        menu.activate();
        setScreen(menu);
	}

	public NUM_PLAYERS getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(NUM_PLAYERS numPlayers) {
		this.numPlayers = numPlayers;
	}

	public PLATFORM getPlatform() {
		return platform;
	}

	public void setPlatform(PLATFORM platform) {
		this.platform = platform;
	}
	
}
