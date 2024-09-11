package com.example.projectfrogger.page;

import com.example.projectfrogger.Main;
import com.example.projectfrogger.model.HighScore;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * SavePage represents a custom pane where the user can enter their name and
 * choose to save or cancel.
 *
 * This pane contains a label prompting the user to enter their name, a text field
 * for input, and three buttons to handle saving, saving and quitting, or canceling.
 */
public class SavePage extends Pane {

    private Label nameLabel;
    private TextField nameTextField;
    private Button saveButton;
    private Button saveAndQuitButton;
    private Button cancelButton;

    Stage stage;

    /**
     * Constructor that initializes the SavePage with the required components.
     */
    public SavePage(Stage stage) {
        this.stage = stage;
        initializePane();
        addComponents();
    }

    /**
     * Initializes the pane with default settings such as size and background color.
     */
    private void initializePane() {
        this.setPrefSize(400, 250);
        this.setStyle("-fx-background-color: rgb(50, 60, 65);");
    }

    /**
     * Creates and adds the components (label, text field, and buttons) to the pane.
     */
    private void addComponents() {
        nameLabel = createNameLabel();
        nameTextField = createNameTextField();
        saveButton = createSaveButton();
        saveAndQuitButton = createSaveAndQuitButton();
        cancelButton = createCancelButton();

        this.getChildren().addAll(nameLabel, nameTextField, saveButton, saveAndQuitButton, cancelButton);
    }

    /**
     * Creates the label prompting the user to enter their name.
     *
     * @return the initialized Label.
     */
    private Label createNameLabel() {
        Label label = new Label("Enter Your Name");
        label.setLayoutX(85.0);
        label.setLayoutY(32.0);
        label.setPrefSize(253.0, 61.0);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(24.0));
        return label;
    }

    /**
     * Creates the text field for the user to enter their name.
     *
     * @return the initialized TextField.
     */
    private TextField createNameTextField() {
        TextField textField = new TextField();
        textField.setLayoutX(56.0);
        textField.setLayoutY(93.0);
        textField.setPrefSize(289.0, 43.0);
        textField.setPromptText("Name");
        textField.setFont(new Font(18.0));
        return textField;
    }

    File highScoresFile = new File("HighScores.txt");

    /**
     * Creates the "Save" button.
     *
     * @return the initialized Button.
     */
    private Button createSaveButton() {
        Button button = new Button("Save");
        button.setLayoutX(56.0);
        button.setLayoutY(166.0);
        button.setFont(new Font(14.0));

        button.setOnMouseClicked(_ -> {
            if (writeScore()){
                Main.pauseGame();
                Main.showStartPage();
                stage.close();
            }
        });

        return button;
    }


    /**
     * Creates the "Save and Quit" button.
     *
     * @return the initialized Button.
     */
    private Button createSaveAndQuitButton() {
        Button button = new Button("Save and Quit");
        button.setLayoutX(148.0);
        button.setLayoutY(166.0);
        button.setFont(new Font(14.0));

        button.setOnMouseClicked(mouseEvent -> {

            if (writeScore()) {
                stage.close();
                System.out.println("Exiting Game!!!");
                System.exit(0);
            }
        });

        return button;
    }

    private boolean writeScore(){
        System.out.println("Saving Score!!!");
        if (nameTextField.getText().isEmpty()) {
            nameTextField.setPromptText("Name Can not be Empty");
            return false;
        }
        try {
            FileWriter fileWriter = new FileWriter(highScoresFile, true);
            HighScore highScore = new HighScore(Main.frog.getPoints(), nameTextField.getText(), Main.level.levelNumber);
            fileWriter.write(highScore.getScore() + "\n");
            fileWriter.write(highScore.getName() + "\n");
            fileWriter.write(highScore.getDateTimeString() + "\n");
            fileWriter.write(highScore.getLevel() + "\n");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Score Saved!!!");
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates the "Cancel" button.
     *
     * @return the initialized Button.
     */
    private Button createCancelButton() {
        Button button = new Button("Cancel");
        button.setLayoutX(286.0);
        button.setLayoutY(166.0);
        button.setFont(new Font(14.0));

        button.setOnMouseClicked(mouseEvent -> {
            stage.close();
        });

        return button;
    }

    // Getters for components to allow event handling from the main application
    public TextField getNameTextField() {
        return nameTextField;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getSaveAndQuitButton() {
        return saveAndQuitButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
}
