package com.mygdx.elmaze;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.elmaze.networking.MessageToServer;
import com.mygdx.elmaze.view.MainMenuView;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ELMaze extends ApplicationAdapter {

	//private SpriteBatch batch;
	private Texture img;
	private Socket socket;
	private ObjectOutputStream o;
	private MainMenuView mainMenu;
	private int menuOption;

	@Override
	public void create () {

		menuOption = 0;
		mainMenu = new MainMenuView();
		//batch = new SpriteBatch();
		//img = new Texture("background.png");

	}

	public void connectToHostSocket(){
		try {
			socket = new Socket("192.168.1.69", 8500);
		}
		catch(IOException e) {
			System.out.println("Failed to connect...");
			e.printStackTrace();
			System.exit(1);
		}

		o = null;

		try {
			o = new ObjectOutputStream(socket.getOutputStream());
		}
		catch(IOException e) {
			System.out.println("Failed to create stream...");
			System.exit(2);
		}
	}

	public void handleInput(){
		try {
			o.writeObject(new MessageToServer(
					Gdx.input.getAccelerometerY(),
					-Gdx.input.getAccelerometerX())
			);
		}
		catch (IOException e){
			System.out.println("Failed to write message...");
			System.exit(2);
		}
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(menuOption == 0){
			mainMenu.render();
		}
		else if (menuOption == 1){
			//singlePlayerMenu.render();
		}
		else if (menuOption == 2){
			//multiPlayerMenu.render();
		}
		else if (menuOption == 3){
			//gameScreen.render();
			//handleInput();
		}

		//handleInput();
		/*
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
	}

	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}
