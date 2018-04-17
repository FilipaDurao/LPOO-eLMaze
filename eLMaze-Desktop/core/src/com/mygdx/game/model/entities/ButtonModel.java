package com.mygdx.game.model.entities;

public class ButtonModel extends EntityModel {

	private boolean isPressed;
	
	public ButtonModel(float x, float y) {
		super(x, y);
		this.isPressed = false;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
}
