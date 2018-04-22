package com.mygdx.elmaze.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.EntityModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

public class ModelTest {

	@Test 
	public void EntityModelPositionTest() {
		EntityModel model1 = new EntityModel(5f, 2f);
		
		// Position
		assertEquals(model1.getX(), 5f, 0.001f);
		assertEquals(model1.getY(), 2f, 0.001f);
		
		// Position changing
		model1.setX(10f);
		model1.setY(11f);
		assertEquals(model1.getX(), 10f, 0.001f);
		assertEquals(model1.getY(), 11f, 0.001f);
		model1.setPosition(1.41f, 2.82f);
		assertEquals(model1.getX(), 1.41f, 0.001f);
		assertEquals(model1.getY(), 2.82f, 0.001f);
		
		// Position changing using Vector
		model1.setPosition(new Vector2(0.5f, 1.5f));
		assertEquals(model1.getX(), 0.5f, 0.001f);
		assertEquals(model1.getY(), 1.5f, 0.001f);
		
		// Position using Vector
		assertEquals(model1.getPosition().x, 0.5f, 0.001f);
		assertEquals(model1.getPosition().y, 1.5f, 0.001f);
	}
	
	@Test 
	public void EntityModelDistanceTest() {
		EntityModel model1 = new EntityModel(0f, 0f);
		EntityModel model2 = new EntityModel(0f, 3f);
		EntityModel model3 = new EntityModel(4f, 0f);
		
		// Self Distance
		assertEquals(model1.getDistanceTo(model1), 0f, 0.001f);
		assertEquals(model2.getDistanceTo(model2), 0f, 0.001f);
		assertEquals(model3.getDistanceTo(model3), 0f, 0.001f);
		
		// Distances between different models
		assertEquals(model1.getDistanceTo(model2), 3f, 0.001f);
		assertEquals(model2.getDistanceTo(model1), 3f, 0.001f);
		
		assertEquals(model1.getDistanceTo(model3), 4f, 0.001f);
		assertEquals(model3.getDistanceTo(model1), 4f, 0.001f);
		
		assertEquals(model2.getDistanceTo(model3), 5f, 0.001f);
		assertEquals(model3.getDistanceTo(model2), 5f, 0.001f);
	}
	
	@Test 
	public void BallModelTest() {
		BallModel ball = new BallModel(2f, 1f, 1.8f, 0);
		
		// Radius
		assertEquals(ball.getRadius(), 1.8f, 0.001f);
		
		// Radius changing 
		ball.setRadius(2.46f);
		assertEquals(ball.getRadius(), 2.46f, 0.001f);
		
		// Player Number
		assertEquals(ball.getPlayerNum(), 0);
		
		// Player Number changing
		ball.setPlayerNum(2);
		assertEquals(ball.getPlayerNum(), 2);
	}
	
	@Test 
	public void ButtonModelTest() {
		ButtonModel button = new ButtonModel(1f, 5f, 1.5f);
		
		// Radius
		assertEquals(button.getRadius(), 1.5f, 0.001f);
		
		// Radius changing 
		button.setRadius(2.09f);
		assertEquals(button.getRadius(), 2.09f, 0.001f);
		
		// Button pressing
		assertFalse(button.isPressed());
		button.press();
		assertTrue(button.isPressed());
	}
	
	@Test 
	public void DoorModelTest() {
		DoorModel door = new DoorModel(10f, 10f, 2f, 5f);
		
		// Width and Height
		assertEquals(door.getWidth(), 2f, 0.001f);
		assertEquals(door.getHeight(), 5f, 0.001f);
		
		// Width and Height changing
		door.setWidth(15f);
		door.setHeight(6.8f);
		assertEquals(door.getWidth(), 15f, 0.001f);
		assertEquals(door.getHeight(), 6.8f, 0.001f);
		
		// Door opening
		assertFalse(door.isOpen());
		assertTrue(door.isClosed());
		door.open();
		assertTrue(door.isOpen());
		assertFalse(door.isClosed());
	}
	
	@Test 
	public void ExitModelTest() {
		ExitModel exit = new ExitModel(0.02f, 3.17f, 3.945f);
		
		// Radius
		assertEquals(exit.getRadius(), 3.945f, 0.001f);
		
		// Radius changing 
		exit.setRadius(4.196f);
		assertEquals(exit.getRadius(), 4.196f, 0.001f);
	}
	
	@Test 
	public void WallModelTest() {
		WallModel wall = new WallModel(4.5f, 5.4f, 1f, 1.5f);
		
		// Width and Height
		assertEquals(wall.getWidth(), 1f, 0.001f);
		assertEquals(wall.getHeight(), 1.5f, 0.001f);
		
		// Width and Height changing
		wall.setWidth(2.05f);
		wall.setHeight(2.17f);
		assertEquals(wall.getWidth(), 2.05f, 0.001f);
		assertEquals(wall.getHeight(), 2.17f, 0.001f);
		
		// Resizing
		wall.resize(3.15f, 4.72f);
		assertEquals(wall.getWidth(), 3.15f, 0.001f);
		assertEquals(wall.getHeight(), 4.72f, 0.001f);
	}
	
	@Test 
	public void ButtonDoorInteractionTest() {
		DoorModel openableDoor = new DoorModel(5f,6.5f, 2f, 0.5f);
		ButtonModel button = new ButtonModel(1f, 1f, 2.5f, openableDoor);	// button opens openableDoor
		
		// Starting status
		assertFalse(button.isPressed());
		assertFalse(openableDoor.isOpen());
		assertTrue(openableDoor.isClosed());
		
		// Press the button and verify button and door status change
		button.press();
		assertTrue(button.isPressed());
		assertTrue(openableDoor.isOpen());
		assertFalse(openableDoor.isClosed());
	}

}
