package com.mygdx.elmaze;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.elmaze.networking.NetworkManager;
import com.mygdx.elmaze.view.GameView;

public class ELMaze extends Game {
	
	private SpriteBatch spriteBatch;
	private AssetManager assetManager;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		assetManager = new AssetManager();
		
		startElMaze();
	}
	
	private void startElMaze() {
		GameView view = new GameView(this);
		
		NetworkManager networkManager = new NetworkManager();
		networkManager.startServer();
		
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
}
