package com.example.projectfrogger.level;

import java.io.File;

import com.example.projectfrogger.Main;
import com.example.projectfrogger.actor.*;
import com.example.projectfrogger.page.StartPage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class LevelOne extends Level {
	@Override
	public void act(long now) {
		
	}

	// It is the same code present in Main class, I have isolated it fo better modularization and multiple level management
	public LevelOne() {
		levelNumber = 1;
		setPrefSize(600, 800);

		BackgroundImage backgroundImage = new BackgroundImage("file:src/main/resources/sprites/frog background.png");
		backgroundImage.setLayoutX(-10);
		backgroundImage.setLayoutY(0);
		backgroundImage.setFitHeight(850);

		add(backgroundImage);

		add(new Log("file:src/main/resources/sprites/log3.png", 150, 0, 166, 0.75));
		add(new Log("file:src/main/resources/sprites/log3.png", 150, 220, 166, 0.75));
		add(new Log("file:src/main/resources/sprites/log3.png", 150, 440, 166, 0.75));
		add(new Log("file:src/main/resources/sprites/logs.png", 300, 0, 276, -2));
		add(new Log("file:src/main/resources/sprites/logs.png", 300, 400, 276, -2));

		add(new Log("file:src/main/resources/sprites/log3.png", 150, 50, 329, 0.75));
		add(new Log("file:src/main/resources/sprites/log3.png", 150, 270, 329, 0.75));
		add(new Log("file:src/main/resources/sprites/log3.png", 150, 490, 329, 0.75));


		add(new Turtle(500, 376, -1, 130, 130));
		add(new Turtle(300, 376, -1, 130, 130));
		add(new WetTurtle(700, 376, -1, 130, 130));
		add(new WetTurtle(600, 217, -1, 130, 130));
		add(new WetTurtle(400, 217, -1, 130, 130));
		add(new WetTurtle(200, 217, -1, 130, 130));
		add(new End(13,96));
		add(new End(141,96));
		add(new End(141 + 141-13,96));
		add(new End(141 + 141-13+141-13+1,96));
		add(new End(141 + 141-13+141-13+141-13+3,96));

		Main.frog = new Frog("file:src/main/resources/sprites/froggerUp.png");
		add(Main.frog);


		add(new Obstacle("file:src/main/resources/sprites/truck1"+"Right.png", 0, 649, 1, 120, 120));
		add(new Obstacle("file:src/main/resources/sprites/truck1"+"Right.png", 300, 649, 1, 120, 120));
		add(new Obstacle("file:src/main/resources/sprites/truck1"+"Right.png", 600, 649, 1, 120, 120));
		add(new Obstacle("file:src/main/resources/sprites/car1Left.png", 100, 597, -1, 50, 50));
		add(new Obstacle("file:src/main/resources/sprites/car1Left.png", 250, 597, -1, 50, 50));
		add(new Obstacle("file:src/main/resources/sprites/car1Left.png", 400, 597, -1, 50, 50));
		add(new Obstacle("file:src/main/resources/sprites/car1Left.png", 550, 597, -1, 50, 50));
		add(new Obstacle("file:src/main/resources/sprites/truck2Right.png", 0, 540, 1, 200, 200));
		add(new Obstacle("file:src/main/resources/sprites/truck2Right.png", 500, 540, 1, 200, 200));
		add(new Obstacle("file:src/main/resources/sprites/car1Left.png", 500, 490, -5, 50, 50));
		add(new Digit(0, 30, 360, 25));
		playMusic();
		start();
		Main.start();
	}

}
