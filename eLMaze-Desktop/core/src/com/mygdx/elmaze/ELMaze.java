package com.mygdx.elmaze;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.model.GameModel;
import com.mygdx.elmaze.networking.MessageToClient;
import com.mygdx.elmaze.networking.NetworkManager;
import com.mygdx.elmaze.view.GameView;
import com.mygdx.elmaze.view.menus.MenuFactory;
import com.mygdx.elmaze.view.menus.MenuView;

public class ELMaze extends Game {
	
	public enum PLAY_MODE { SINGLEPLAYER, MULTIPLAYER }
	public enum PLATFORM { PHONE, KEYBOARD }
	
	private SpriteBatch spriteBatch;
	private AssetManager assetManager;
	private PLAY_MODE playMode;
	private PLATFORM platform;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		assetManager = new AssetManager();
		
		startElMaze();
	}
	
	private void startElMaze() {
		MenuView mainMenuView = MenuFactory.makeMenu(this, MenuView.TYPE.MAIN);	//TODO PUT MAIN MENU BACK

        setScreen(mainMenuView);
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

	public PLAY_MODE getPlayMode() {
		return playMode;
	}

	public void setNumPlayers(PLAY_MODE playMode) {
		this.playMode = playMode;
	}

	public PLATFORM getPlatform() {
		return platform;
	}

	public void setPlatform(PLATFORM platform) {
		this.platform = platform;
	}
	
	public void startGame() {
		if (playMode == PLAY_MODE.SINGLEPLAYER) {
			GameModel.getInstance().setSinglePlayerMode();
			GameController.getInstance().setSinglePlayerMode();
		} 
		else {
			GameModel.getInstance().setMultiPlayerMode();
			GameController.getInstance().setMultiPlayerMode();
		}
		
		if (platform == PLATFORM.PHONE) {
			NetworkManager.getInstance().getSocketManager().
				broadcastMessage(new MessageToClient(MessageToClient.CONTENT.GAME_START));
		}
		
		GameView.getInstance().setGameReference(this);
        setScreen(GameView.getInstance());
	}
	
	public void startServer() {
		int numPlayers = (playMode == PLAY_MODE.SINGLEPLAYER ? 1 : 2);
		
		if (NetworkManager.getInstance().startServer(numPlayers)) {
			String[] symbols = {"alpha", "beta", "chi", "delta", "epsilon", "eta", "gama", "lamba",
								"mu", "omega", "phi", "pi", "psi", "rho", "sigma", "tau"};
			
			for (Integer num : NetworkManager.getInstance().parse()) {
				System.out.println(num + " - " + symbols[num]);
			}
			
		}
		else {
			// TODO ///////////////////////
			// Deal with error!!!!  ///////
			///////////////////////////////
		}
	}
	
}
