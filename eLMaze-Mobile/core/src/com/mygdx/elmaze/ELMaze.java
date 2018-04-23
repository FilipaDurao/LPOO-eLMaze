package com.mygdx.elmaze;

import com.badlogic.gdx.Game;
import com.mygdx.elmaze.view.MainMenuView;

public class ELMaze extends Game {

	@Override
	public void create () {
        setScreen(new MainMenuView(this));
	}

}
