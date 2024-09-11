package com.example.projectfrogger.level;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.projectfrogger.Main;
import com.example.projectfrogger.actor.Actor;
import com.example.projectfrogger.page.StartPage;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public abstract class Level extends Pane {
    private AnimationTimer timer;
    MediaPlayer mediaPlayer;
    public int levelNumber;
    
    public Level() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
                            if (event.getCode() == KeyCode.ESCAPE) {
                                System.out.println("Escape Pressed!!!");
                                Main.pauseGame();
                            }
                            else if (event.getCode() == KeyCode.M){
                                mutePlayer();
                            }
                            else if (event.getCode() == KeyCode.Q){
                                System.out.println("Q pressed!");
                                System.out.println("Exiting Game ...");
                                System.exit(0);
                            }
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    public void start() {
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    public abstract void act(long now);

    public void playMusic() {
        if (!StartPage.getSoundEnabled())
            return;
        String musicFile = "src/main/resources/Audio/Frogger Main Song Theme (loop).mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void stopMusic() {
        if (!StartPage.getSoundEnabled())
            return;
        mediaPlayer.stop();
    }

    boolean isMute = false;
    public void mutePlayer(){
        if (StartPage.getSoundEnabled() && mediaPlayer != null){
            System.out.println("M pressed");
            String status = isMute ? "UnMuting" : "Muting";
            System.out.println(status + " music");
            mediaPlayer.setMute(!isMute);
            isMute = !isMute;
        }
    }
}
