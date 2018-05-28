package com.mygdx.elmaze.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mygdx.elmaze.model.levels.SPLevel1Model;
import com.mygdx.elmaze.model.levels.SPLevel2Model;
import com.mygdx.elmaze.model.levels.SPLevel3Model;

public class LevelTest {

	@Test 
	public void SPLevelOneTest() {
		SPLevel1Model level = new SPLevel1Model();
		
		// Test Ball Player number
		assertEquals(level.getBall().getPlayerNum(), 0);
		
		// Test exit is existent
		assertTrue(level.getExit() != null);
		
		// Test buttons and doors quantities
		assertEquals(level.getDoors().size(), 0);
		assertEquals(level.getButtons().size(), 0);
		
		// Test walls quantites
		assertEquals(level.getWalls().size(), 7);
	}
	
	@Test 
	public void SPLevelTwoTest() {
		SPLevel2Model level = new SPLevel2Model();
		
		// Test Ball Player number
		assertEquals(level.getBall().getPlayerNum(), 0);
		
		// Test exit is existent
		assertTrue(level.getExit() != null);
		
		// Test buttons and doors quantities
		assertEquals(level.getDoors().size(), 1);
		assertEquals(level.getButtons().size(), 1);
		
		// Test walls quantites
		assertEquals(level.getWalls().size(), 7);
	}
	
	@Test 
	public void SPLevelThreeTest() {
		SPLevel3Model level = new SPLevel3Model();
		
		// Test Ball Player number
		assertEquals(level.getBall().getPlayerNum(), 0);
		
		// Test exit is existent
		assertTrue(level.getExit() != null);
		
		// Test buttons and doors quantities
		assertEquals(level.getDoors().size(), 2);
		assertEquals(level.getButtons().size(), 2);
		
		// Test walls quantites
		assertEquals(level.getWalls().size(), 9);
	}
	
	@Test 
	public void SPLevelFourTest() {
		SPLevel3Model level = new SPLevel3Model();
		
		// Test Ball Player number
		assertEquals(level.getBall().getPlayerNum(), 0);
		
		// Test exit is existent
		assertTrue(level.getExit() != null);
		
		// Test buttons and doors quantities
		assertEquals(level.getDoors().size(), 2);
		assertEquals(level.getButtons().size(), 2);
		
		// Test walls quantites
		assertEquals(level.getWalls().size(), 13);
	}
	
	@Test 
	public void MPLevelOneTest() {
		
	}
	
	@Test 
	public void MPLevelTwoTest() {
		
	}
	
	@Test 
	public void MPLevelThreeTest() {
		
	}

}
