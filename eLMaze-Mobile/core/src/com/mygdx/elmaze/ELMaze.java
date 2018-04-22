package com.mygdx.elmaze;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.elmaze.networking.MessageToServer;
import com.mygdx.elmaze.view.MainMenuView;
import com.mygdx.elmaze.view.PlayGameView;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ELMaze extends Game {

	@Override
	public void create () {
        setScreen(new MainMenuView(this));
	}

}
