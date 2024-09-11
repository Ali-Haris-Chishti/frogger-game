package com.example.projectfrogger.page;

import com.example.projectfrogger.Main;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A custom Pane representing the start page of an application.
 * It includes an image view for the logo, a ComboBox for level selection,
 * three styled buttons, and a CheckBox for enabling music.
 */
public class StartPage extends Pane {

    private ComboBox<String> levelComboBox;
    private CheckBox musicCheckBox;

    /**
     * Creates a new StartPage instance and sets up its layout.
     */
    public StartPage() {
        initializePane();
        addChildren();
    }

    /**
     * Initializes the pane's properties including size, background color, and padding.
     */
    private void initializePane() {
        this.setMaxHeight(800.0);
        this.setMaxWidth(600.0);
        this.setMinHeight(800.0);
        this.setMinWidth(600.0);
        this.setPrefHeight(800.0);
        this.setPrefWidth(600.0);
        this.setStyle("-fx-background-color: rgb(50, 60, 70);");
        this.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
    }

    /**
     * Adds all child elements to the pane.
     */
    private void addChildren() {
        ImageView logoImageView = createLogoImageView();
        ImageView additionalImageView = createAdditionalImageView(); // Added the new ImageView
        levelComboBox = createLevelComboBox();
        Button playButton = createButton("Play", 500.0);
        Button highScoresButton = createButton("High Scores", 590.0);
        Button exitButton = createButton("Exit", 680.0);
        musicCheckBox = createMusicCheckBox();

        this.getChildren().addAll(logoImageView, additionalImageView, levelComboBox, playButton, highScoresButton, exitButton, musicCheckBox);
    }

    /**
     * Creates and configures the ImageView for the logo.
     *
     * @return the configured ImageView
     */
    private ImageView createLogoImageView() {
        ImageView imageView = new ImageView();
        imageView.setFitHeight(700.0);
        imageView.setFitWidth(315.0);
        imageView.setLayoutY(35.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image("file:src/main/resources/sprites/logo.png"));
        return imageView;
    }

    /**
     * Creates and configures an additional ImageView.
     *
     * @return the configured ImageView
     */
    private ImageView createAdditionalImageView() {
        ImageView imageView = new ImageView();
        imageView.setFitHeight(67.0);
        imageView.setFitWidth(53.0);
        imageView.setLayoutX(522.0);
        imageView.setLayoutY(35.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image("file:src/main/resources/keys/instructions.png"));
        imageView.setCursor(Cursor.HAND);

        imageView.setOnMouseClicked(_ -> {
            Stage stage = new Stage();
            stage.setScene(new Scene(new HelpPage()));
            stage.show();
        });

        return imageView;
    }

    private static boolean soundEnabled = false;

    public static boolean getSoundEnabled() {
        return soundEnabled;
    }

    /**
     * Creates and configures a ComboBox for level selection.
     *
     * @return the configured ComboBox
     */
    private ComboBox<String> createLevelComboBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Level One", "Level Two");
        comboBox.setValue("Level One"); // Set "Level One" as the default value
        comboBox.setLayoutX(62.0);
        comboBox.setLayoutY(650.0);
        comboBox.setPrefSize(150.0, 30.0);
        comboBox.setStyle("-fx-background-color: rgb(100, 200, 100); -fx-background-radius: 10px;");
        return comboBox;
    }

    /**
     * Creates and configures a styled Button with the given text and Y position.
     *
     * @param text the text to display on the button
     * @param layoutY the Y position of the button
     * @return the configured Button
     */
    private Button createButton(String text, double layoutY) {
        Button button = new Button(text);
        button.setAlignment(javafx.geometry.Pos.CENTER);
        button.setLayoutX(375.0);
        button.setLayoutY(layoutY);
        button.setPrefHeight(50.0);
        button.setPrefWidth(200.0);
        button.setStyle("-fx-background-radius: 15px; -fx-border-color: rgb(0, 250, 0); -fx-border-radius: 15px; -fx-border-width: 3px; -fx-background-color: rgb(100, 200, 100);");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(Font.font("Sitka Text", 24.0));
        button.setCursor(Cursor.HAND);

        button.setOnMouseClicked((mouseEvent) -> {
            if (button.getText().equals("Play")) {
                // Handle the Play button click, possibly using the selected level and music setting
                String selectedLevel = levelComboBox.getValue();
                boolean isMusicEnabled = musicCheckBox.isSelected();
                System.out.println("Selected level: " + selectedLevel);
                System.out.println("Music enabled: " + isMusicEnabled);
                soundEnabled = musicCheckBox.isSelected();
                Main.startGame(selectedLevel);
            }
            else if (button.getText().equals("High Scores")) {
                Stage stage = new Stage();
                stage.setScene(new Scene(new HighScorePage()));
                stage.show();
            }
            else if (button.getText().equals("Exit")) {
                System.exit(0);
            }
        });

        return button;
    }

    /**
     * Creates and configures a CheckBox for enabling or disabling music.
     *
     * @return the configured CheckBox
     */
    private CheckBox createMusicCheckBox() {
        CheckBox checkBox = new CheckBox("Enable Music");
        checkBox.setLayoutX(62.0);
        checkBox.setLayoutY(703.0);
        checkBox.setPrefSize(150.0, 30.0);
        checkBox.setStyle("-fx-background-color: rgb(100, 200, 100); -fx-background-radius: 10px;");
        checkBox.setTextFill(javafx.scene.paint.Color.WHITE);
        checkBox.setFont(Font.font("System Bold Italic", 15.0));
        checkBox.setPadding(new Insets(3.0, 5.0, 4.0, 10.0));
        checkBox.setSelected(true); // Set the CheckBox to be checked by default
        return checkBox;
    }
}
