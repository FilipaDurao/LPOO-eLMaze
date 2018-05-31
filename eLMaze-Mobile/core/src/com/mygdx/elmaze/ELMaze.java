package com.mygdx.elmaze;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.elmaze.controller.GameController;
import com.mygdx.elmaze.view.MenuFactory;
import com.mygdx.elmaze.view.MenuView;

/**
 * Represents the game
 */
public class ELMaze extends Game {

    private AssetManager assetManager;

    /**
     * Creates the Game
     */
	@Override
	public void create () {
	    GameController.getInstance().setGameReference(this);
        assetManager = new AssetManager();
        MenuView mainMenu = MenuFactory.makeMenu(this, MenuView.TYPE.MAIN);
        mainMenu.activate();
        setScreen(mainMenu);
	}

    /**
     * Activates the menu
     *
     * @param menu The menu to activate
     */
	public void activateMenu(MenuView menu) {
        menu.activate();
        setScreen(menu);
	}

    /**
     * @return Returns the asset manager
     */
	public AssetManager getAssetManager() {
	    return assetManager;
    }

}
