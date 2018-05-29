package com.mygdx.elmaze.model.entities;

/**
 * Represents an ExitModel
 */
public class ExitModel extends EntityModel {

	private float radius;

	/**
	 * @param x The Exit's x position
	 * @param y The Exit's y position
	 * @param radius The Exit's radius
	 */
	public ExitModel(float x, float y, float radius) {
		super(x, y);
		this.radius = radius;
	}

	/**
	 * @return Returns the radius of the Exit
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 *  Sets the Exit's radius to the value passed as parameter
	 * 
	 * @param radius The value to set the Exit's radius
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}
	
}
