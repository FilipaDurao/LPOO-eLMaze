package com.mygdx.elmaze;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.elmaze.networking.MessageToServer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ELMaze extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;
	Socket socket;
	ObjectOutputStream o;

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
	public void create () {
		try {
			socket = new Socket("192.168.2.15", 8000);
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

		batch = new SpriteBatch();
		img = new Texture("background.png");
	}

	@Override
	public void render () {

		handleInput();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
