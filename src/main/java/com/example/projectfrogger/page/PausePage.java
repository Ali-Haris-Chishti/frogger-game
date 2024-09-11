package com.example.projectfrogger.page;

import com.example.projectfrogger.Main;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * PausePage represents a custom pane for the "Game Paused" screen.
 * It contains a label and three buttons: one to resume the game, another to quit, and one to return to the main menu.
 */
public class PausePage extends Pane {

    private Label pausedLabel;
    private Button resumeButton;
    private Button quitButton;
    private Button returnToMenuButton;

    /**
     * Constructor that initializes the PausePage with the required components.
     */
    public PausePage() {
        initializePane();
        addComponents();
    }

    /**
     * Initializes the pane with default settings.
     */
    private void initializePane() {
        this.setPrefSize(600, 800);
        this.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6);");
    }

    /**
     * Creates and adds the components (label and buttons) to the pane.
     */
    private void addComponents() {
        pausedLabel = createPausedLabel();
        resumeButton = createResumeButton();
        quitButton = createQuitButton();
        returnToMenuButton = createReturnToMenuButton();

        this.getChildren().addAll(pausedLabel, resumeButton, quitButton, returnToMenuButton);
    }

    /**
     * Creates the label that displays "Game Paused".
     *
     * @return the initialized Label.
     */
    private Label createPausedLabel() {
        Label label = new Label("| Game Paused |");
        label.setLayoutX(140.0);
        label.setLayoutY(170.0);
        label.setTextFill(Color.WHITE);
        label.setFont(new Font("Corbel Bold", 47.0));
        return label;
    }

    /**
     * Creates the "Resume" button.
     *
     * @return the initialized Button.
     */
    private Button createResumeButton() {
        Button button = new Button("Resume");
        button.setLayoutX(225.0);
        button.setLayoutY(350.0);
        button.setPrefSize(150.0, 40.0);
        button.setStyle("-fx-background-color: rgb(100, 200, 100);");
        button.setCursor(Cursor.HAND);
        button.setFont(new Font("Candara Light", 26.0));
        button.setOnMouseClicked((mouseEvent -> {
            Main.pauseGame();
        }));
        return button;
    }

    /**
     * Creates the "Quit" button.
     *
     * @return the initialized Button.
     */
    private Button createQuitButton() {
        Button button = new Button("Quit");
        button.setLayoutX(225.0);
        button.setLayoutY(450.0);
        button.setPrefSize(150.0, 40.0);
        button.setStyle("-fx-background-color: rgb(100, 200, 100);");
        button.setFont(new Font("Candara Light", 26.0));
        button.setCursor(Cursor.HAND);
        button.setOnMouseClicked((mouseEvent -> {
            Stage stage = new Stage();
            stage.setTitle("Save Score!");
            stage.setScene(new Scene(new SavePage(stage)));
            stage.show();
        }));
        return button;
    }

    /**
     * Creates the "Return To Menu" button.
     *
     * @return the initialized Button.
     */
    private Button createReturnToMenuButton() {
        Button button = new Button("Return To Menu");
        button.setLayoutX(185.0);
        button.setLayoutY(558.0);
        button.setPrefSize(230.0, 40.0);
        button.setStyle("-fx-background-color: rgb(100, 200, 100);");
        button.setFont(new Font("Candara Light", 26.0));
        button.setCursor(Cursor.HAND);
        button.setOnMouseClicked((mouseEvent -> {
            Main.pauseGame();
            Main.showStartPage();
        }));
        return button;
    }

    // Getters for the buttons to allow event handling from the main application
    public Button getResumeButton() {
        return resumeButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }

    public Button getReturnToMenuButton() {
        return returnToMenuButton;
    }
}
