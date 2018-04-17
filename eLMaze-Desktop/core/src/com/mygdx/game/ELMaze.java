package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.GameModel;
import com.mygdx.game.view.GameView;

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
		GameModel model = new GameModel();
		//GameController controller = new GameController();
		GameView view = new GameView(this, model);
		
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
