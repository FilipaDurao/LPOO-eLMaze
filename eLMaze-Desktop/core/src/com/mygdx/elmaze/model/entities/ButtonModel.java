package com.mygdx.elmaze.model.entities;

/**
 * Represents a ButtonModel
 */
public class ButtonModel extends EntityModel {

	private boolean isPressed;
	private final DoorModel openableDoor;
	private float radius;
	
	/**
	 *  The constructor to use if the Button doesn't have a Door associated
	 * 
	 * @param x The Button's x position
	 * @param y The Button's y position
	 * @param radius The Button's radius
	 */
	public ButtonModel(float x, float y, float radius) {
		super(x, y);
		this.radius = radius;
		this.isPressed = false;
		this.openableDoor = null;
	}
	
	/**
	 *  The constructor to use if the Button has a Door associated
	 * 
	 * @param x The Button's x position
	 * @param y The Button's y position
	 * @param radius The Button's radius
	 * @param openableDoor The Door that the Button opens
	 */
	public ButtonModel(float x, float y, float radius, DoorModel openableDoor) {
		super(x, y);
		this.radius = radius;
		this.isPressed = false;
		this.openableDoor = openableDoor;
	}

	/**
	 * @return Returns true if the Button is pressed, false otherwise
	 */
	public boolean isPressed() {
		return isPressed;
	}

	/**
	 *  "Presses" the Button and opens the associated Door if there is one
	 */
	public void press() {
		this.isPressed = true;
		
		if (openableDoor != null) {
			openableDoor.open();
		}
	}
	
	/**
	 * @return Returns the radius of the Button
	 */
	public float getRadius() {
		return radius;
	}
	
	/**
	 *  Sets the Button's radius to the value passed as parameter
	 * 
	 * @param radius The value to set the Button's radius
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}
}
