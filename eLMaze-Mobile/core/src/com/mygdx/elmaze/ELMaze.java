package com.mygdx.elmaze;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.elmaze.view.MenuFactory;
import com.mygdx.elmaze.view.MenuView;

public class ELMaze extends Game {

    private AssetManager assetManager;

	@Override
	public void create () {
        assetManager = new AssetManager();
        MenuView mainMenu = MenuFactory.makeMenu(this, MenuView.TYPE.MAIN);
        mainMenu.activate();
        setScreen(mainMenu);
	}

	public void activateMenu(MenuView menu) {
        menu.activate();
        setScreen(menu);
	}

	public AssetManager getAssetManager() {
	    return assetManager;
    }

}
