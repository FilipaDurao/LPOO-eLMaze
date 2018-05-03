package com.mygdx.elmaze;

import com.badlogic.gdx.Game;
import com.mygdx.elmaze.view.MenuFactory;
import com.mygdx.elmaze.view.MenuView;

public class ELMaze extends Game {

	@Override
	public void create () {
        MenuView mainMenu = MenuFactory.makeMenu(this, MenuView.TYPE.MAIN);
        mainMenu.activate();
        setScreen(mainMenu);
	}

	public void activateMenu(MenuView menu) {
        menu.activate();
        setScreen(menu);
	}

}
