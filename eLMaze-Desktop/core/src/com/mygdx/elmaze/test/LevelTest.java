package com.mygdx.elmaze.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mygdx.elmaze.model.levels.MPLevel1Model;
import com.mygdx.elmaze.model.levels.MPLevel2Model;
import com.mygdx.elmaze.model.levels.MPLevel3Model;
import com.mygdx.elmaze.model.levels.SPLevel1Model;
import com.mygdx.elmaze.model.levels.SPLevel2Model;
import com.mygdx.elmaze.model.levels.SPLevel3Model;
import com.mygdx.elmaze.model.levels.SPLevel4Model;

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
		SPLevel4Model level = new SPLevel4Model();
		
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
		MPLevel1Model level = new MPLevel1Model();
		
		// Test Balls Player number
		assertEquals(level.getBall1().getPlayerNum(), 0);
		assertEquals(level.getBall2().getPlayerNum(), 1);
		
		// Test exit is existent
		assertTrue(level.getExit() != null);
		
		// Test buttons and doors quantities
		assertEquals(level.getDoors().size(), 2);
		assertEquals(level.getButtons().size(), 2);
		
		// Test walls quantites
		assertEquals(level.getWalls().size(), 7);
	}
	
	@Test 
	public void MPLevelTwoTest() {
		MPLevel2Model level = new MPLevel2Model();
		
		// Test Balls Player number
		assertEquals(level.getBall1().getPlayerNum(), 0);
		assertEquals(level.getBall2().getPlayerNum(), 1);
		
		// Test exit is existent
		assertTrue(level.getExit() != null);
		
		// Test buttons and doors quantities
		assertEquals(level.getDoors().size(), 2);
		assertEquals(level.getButtons().size(), 2);
		
		// Test walls quantites
		assertEquals(level.getWalls().size(), 15);
	}
	
	@Test 
	public void MPLevelThreeTest() {
		MPLevel3Model level = new MPLevel3Model();
		
		// Test Balls Player number
		assertEquals(level.getBall1().getPlayerNum(), 0);
		assertEquals(level.getBall2().getPlayerNum(), 1);
		
		// Test exit is existent
		assertTrue(level.getExit() != null);
		
		// Test buttons and doors quantities
		assertEquals(level.getDoors().size(), 1);
		assertEquals(level.getButtons().size(), 4);
		
		// Test walls quantites
		assertEquals(level.getWalls().size(), 16);
	}

}
