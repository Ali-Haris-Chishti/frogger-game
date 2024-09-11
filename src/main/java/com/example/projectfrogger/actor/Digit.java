package com.example.projectfrogger.actor;

import javafx.scene.image.Image;

public class Digit extends Actor {
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * sets image for score
	 * @param n = points digit
	 * @param dim = dimension of the digit
	 * @param x = x position of the image
	 * @param y = y position of the image
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/main/resources/numbers/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
