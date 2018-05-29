package com.mygdx.elmaze.model.entities;

/**
 * Represents a DoorModel
 */
public class DoorModel extends EntityModel {

	private boolean isOpen;	
	private float width;
	private float height;
	
	/**
	 * @param x The Door's x position
	 * @param y The Door's y position
	 * @param width The Door's width
	 * @param height The Door's height
	 */
	public DoorModel(float x, float y, float width, float height) {
		super(x, y);
		this.isOpen = false;
		this.width = width;
		this.height = height;
	}

	/**
	 * @return Returns true if the Door is open, false otherwise
	 */
	public boolean isOpen() {
		return isOpen;
	}
	
	/**
	 * @return Returns true if the Door is closed, false otherwise
	 */
	public boolean isClosed() {
		return !isOpen;
	}

	/**
	 *  Sets the Door to open
	 */
	public void open() {
		this.isOpen = true;
	}

	/**
	 * @return Returns the Door's width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 *  Sets the Door's width to the value passed as parameter
	 * 
	 * @param width The value to set the Door's width with
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return Returns the Door's height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 *  Sets the Door's height to the value passed as parameter
	 * 
	 * @param width The value to set the Door's width height
	 */
	public void setHeight(float height) {
		this.height = height;
	}
	
	
}
