package com.mygdx.elmaze.networking;

import java.io.Serializable;

public class MessageToServer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final float accelerometerX;
	private final float accelerometerY;

	public MessageToServer(float accelerometerX, float accelerometerY) {
		this.accelerometerX = accelerometerX;
		this.accelerometerY = accelerometerY;
	}
	
	public float getAccelerometerX() {
		return accelerometerX;
	}
	
	public float getAccelerometerY() {
		return accelerometerY;
	}
}
