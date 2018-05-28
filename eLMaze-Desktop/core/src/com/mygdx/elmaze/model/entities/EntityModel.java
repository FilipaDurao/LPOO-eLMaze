package com.mygdx.elmaze.model.entities;

import com.badlogic.gdx.math.Vector2;

public class EntityModel {
	
	private float x;
	private float y;
	
	/**
	 * @param x The Entity's x position 
	 * @param y The Entity's y position
	 */
	public EntityModel(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @return Returns the Entity's x position
	 */
	public float getX() {
		return x;
	}

	/**
	 * @brief Sets the Entity's x position to the value passed as parameter
	 * 
	 * @param x The value to set the Entity's x position
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return Returns the Entity's y position
	 */
	public float getY() {
		return y;
	}

	/**
	 * @brief Sets the Entity's y position to the value passed as parameter
	 * 
	 * @param y The value to set the Entity's y position
	 */
	public void setY(float y) {
		this.y = y;
	}	
	
	/**
	 * @brief Sets the Entity's x and y positions to the values passed as parameter
	 * 
	 * @param x The value to set the Entity's x position
	 * @param y The value to set the Entity's y position
	 */
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @brief Sets the Entity's x and y positions to the values in the vector passed as parameter
	 * 
	 * @param position A vector with the x and y position values for the Entity
	 */
	public void setPosition(Vector2 position) {
		this.x = position.x;
		this.y = position.y;
	}
	
	/**
	 * @return Returns a vector with the x and y positions of the Entity
	 */
	public Vector2 getPosition() {
		return new Vector2(x, y);
	}
	
	/**
	 * @brief Calculates the distance between this Entity and another one passed as parameter
	 * 
	 * @param other The Entity we want to get the distance to
	 * 
	 * @return The distance between the two Entities
	 */
	public float getDistanceTo(EntityModel other) {
		Vector2 distanceVector = this.getPosition().sub(other.getPosition());
		
		return (float)(Math.sqrt(distanceVector.x*distanceVector.x + distanceVector.y*distanceVector.y));
	}
}
