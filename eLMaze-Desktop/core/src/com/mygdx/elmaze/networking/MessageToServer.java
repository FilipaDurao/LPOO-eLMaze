package com.mygdx.elmaze.networking;

import java.io.Serializable;

/**
 * Message sent from Client to the Server, regarding the status of the Client's accelerometer
 */
public class MessageToServer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final float accelerometerX;
	private final float accelerometerY;

	/**
	 * @param accelerometerX Client's current accelerometer X axis value
	 * @param accelerometerX Client's current accelerometer Y axis value
	 */
	public MessageToServer(float accelerometerX, float accelerometerY) {
		this.accelerometerX = accelerometerX;
		this.accelerometerY = accelerometerY;
	}
	
	/**
	 * @return Returns the accelerometer X axis value sent from the Client
	 */
	public float getAccelerometerX() {
		return accelerometerX;
	}

	/**
	 * @return Returns the accelerometer Y axis value sent from the Client
	 */
	public float getAccelerometerY() {
		return accelerometerY;
	}
}
