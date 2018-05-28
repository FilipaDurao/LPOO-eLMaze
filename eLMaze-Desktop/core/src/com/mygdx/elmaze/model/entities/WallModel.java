package com.mygdx.elmaze.model.entities;

public class WallModel extends EntityModel {
	
	private float width;
	private float height;
	
	/**
	 * @param x The Wall's x position
	 * @param y The Wall's y position
	 * @param width The Wall's width
	 * @param height The Wall's height
	 */
	public WallModel(float x, float y, float width, float height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	/**
	 * @return Returns the Wall's width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @brief Sets the Wall's width to the value passed as parameter
	 * 
	 * @param width The value to set the Wall's width with
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return Returns the Wall's height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @brief Sets the Wall's height to the value passed as parameter
	 * 
	 * @param height The value to set the Wall's height with
	 */
	public void setHeight(float height) {
		this.height = height;
	}
	
	/**
	 * @brief Resizes the Wall to the width and height passed as parameter
	 * 
	 * @param width The value to set the Wall's width with
	 * @param height The value to set the Wall's height with
	 */
	public void resize(float width, float height) {
		this.width = width;
		this.height = height;
	}
}
