package com.mygdx.elmaze.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mygdx.elmaze.networking.MessageToClient;
import com.mygdx.elmaze.networking.MessageToServer;

public class NetworkMessageTest {

	@Test 
	public void MessageToServerTest() {
		MessageToServer msg = new MessageToServer(6.17f, -5.887f);
		
		// Message content
		assertEquals(msg.getAccelerometerX(), 6.17f, 0.001f);
		assertEquals(msg.getAccelerometerY(), -5.887f, 0.001f);
	}
	
	@Test 
	public void MessageToClientTest() {
		MessageToClient msgStart = new MessageToClient(MessageToClient.CONTENT.GAME_START);
		MessageToClient msgFinish = new MessageToClient(MessageToClient.CONTENT.GAME_FINISH);
		MessageToClient msgFull = new MessageToClient(MessageToClient.CONTENT.SERVER_FULL);
		
		// Message content
		assertEquals(msgStart.getContent(), MessageToClient.CONTENT.GAME_START);
		assertEquals(msgFinish.getContent(), MessageToClient.CONTENT.GAME_FINISH);
		assertEquals(msgFull.getContent(), MessageToClient.CONTENT.SERVER_FULL);
	}
}
