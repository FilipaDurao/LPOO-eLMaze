package com.mygdx.elmaze;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.model.GameModel;
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
		GameModel.getInstance().setMultiPlayerMode();
		GameController.getInstance().setMultiPlayerMode();
		GameView view = new GameView(this, false);

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
}
