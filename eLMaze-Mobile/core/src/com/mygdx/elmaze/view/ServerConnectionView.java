package com.mygdx.elmaze.view;

import com.badlogic.gdx.ScreenAdapter;
import com.mygdx.elmaze.ELMaze;

public class ServerConnectionView extends ScreenAdapter {

    private final ELMaze game;

    public ServerConnectionView(ELMaze game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        // TODO

        handleInput();
    }

    public void handleInput(){
        // TODO
    }

}
