package com.example.projectfrogger;

import com.example.projectfrogger.actor.*;
import com.example.projectfrogger.level.Level;
import com.example.projectfrogger.level.LevelTwo;
import com.example.projectfrogger.page.PausePage;
import com.example.projectfrogger.page.SavePage;
import com.example.projectfrogger.page.StartPage;
import com.example.projectfrogger.level.LevelOne;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	static AnimationTimer timer;
	public static Level level;
	public static Frog frog;
	static PausePage pausePage = new PausePage();
	public static Stage stage;
	/**
	 * Launch JavaFX application
	 */
	public static void main(String[] args) {

		launch(args);
	}

	private static boolean gamePaused = false;

	public static void pauseGame() {
		if (gamePaused){
			level.start();
			level.getChildren().remove(pausePage);
			System.out.println("Game Resumed");
		}
		else {
			level.getChildren().add(pausePage);
			level.stop();
			System.out.println("Game Paused");
		}
		gamePaused = !gamePaused;
	}

	/**
	 * In background, we put the MyStage class, with elements like log,
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		showStartPage();
	}

	public static void showStartPage(){
		Scene scene  = new Scene(new StartPage(),600,800, Color.SKYBLUE);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * createTimer method is to create timer to animate 2D animation (
	 * animationTimer() = continuous frame update
	 * handle method is overridden to provide custom behavior when a key is released.
	 * If changeScore is true, setNumber on top right corner
	 * If getStop is true, stop the game
	 *
	 */
	public static void createTimer() {

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

            	if (frog.changeScore()) {

            		setNumber(frog.getPoints());
            	}
            	if (frog.getStop()) {
            		stop();
            		level.stop();
					level.stopMusic();
					Stage stage = new Stage();
					stage.setTitle("You Won!");
					stage.setScene(new Scene(new SavePage(stage)));
					stage.show();
            	}
            }
        };
    }
	/**
	 * playMusic came from MyStage class in background
	 * createTimer adds JavaFx animation timer
	 * start timer
	 */
	public static void start() {
    	createTimer();
        timer.start();
    }

	/**
	 * stop the animation timer
	 */
    public void stop() {
        timer.stop();
    }

	/**
	 * @param n = points, got from the getPoint() in Frog class
	 * converts the integer n into a series of Digit objects that represent each individual digit in the number
	 */
	public static void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  level.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }

	public static void startGame(String levelValue){
		if (levelValue.equals("Level One"))
			level = new LevelOne();
		else if (levelValue.equals("Level Two"))
			level = new LevelTwo();
		stage.setTitle("FROGGO");

		Scene scene  = new Scene(level, Color.SKYBLUE);
		stage.setScene(scene);
		stage.show();
	}
}
