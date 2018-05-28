package com.mygdx.elmaze.networking;

import java.io.Serializable;

public class MessageToClient implements Serializable {

    public enum CONTENT { GAME_START, GAME_FINISH , SERVER_FULL };

    private static final long serialVersionUID = 1L;
    private final CONTENT content;

    public MessageToClient(CONTENT content) {
        this.content = content;
    }

    public CONTENT getContent() {
        return content;
    }

}
