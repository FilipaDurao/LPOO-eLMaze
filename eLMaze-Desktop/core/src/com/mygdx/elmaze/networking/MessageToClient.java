package com.mygdx.elmaze.networking;

import java.io.Serializable;

/**
 * Message sent from Server to a Client
 */
public class MessageToClient implements Serializable {
	
	/** Content of the message */
	public enum CONTENT { GAME_START, GAME_FINISH , SERVER_FULL };

	private static final long serialVersionUID = 1L;
	private final CONTENT content;

	/**
	 * @param content Message's content
	 */
	public MessageToClient(CONTENT content) {
		this.content = content;
	}
	
	/**
	 * @return Returns the Message's content
	 */
	public CONTENT getContent() {
		return content;
	}

}
