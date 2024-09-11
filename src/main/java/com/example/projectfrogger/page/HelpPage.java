package com.example.projectfrogger.page;

import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Represents the Help Page of the application.
 * This class extends Pane and initializes its layout and components
 * as specified in the provided FXML layout.
 */
public class HelpPage extends Pane {

    private TextArea helpTextArea;
    private ImageView backgroundImageView;

    /**
     * Constructs the HelpPage and initializes its layout and components.
     */
    public HelpPage() {
        // Set the background color of the pane
        setStyle("-fx-background-color: #737373;");
        setPrefSize(600, 800);

        // Initialize and configure the TextArea for help text
        helpTextArea = new TextArea();
        helpTextArea.setText("Objective:\n" +
                "        Guide the Frog: Safely guide the frog from the starting position to the home area across a busy road and a river filled with hazards.\n\n\n" +
                "Game Rules:\n" +
                "        Movement: Use WASD to move the frog up, down, left, or right.\n" +
                "        Hazards:\n" +
                "        Road: Dodge moving cars, trucks, and other vehicles. If hit, the frog loses a life.\n" +
                "        River: Jump on logs, turtles, and other floating objects to cross the river. Falling into the water causes the frog to lose a life.\n" +
                "        Home Slots: Reach the designated slots at the top safely to win. Some slots may contain hazards like alligators.\n\n\n" +
                "Winning:\n" +
                "        Reach All Home Slots:\n" +
                "        Successfully guide the frog to all home slots.\n" +
                "        Typically, there are 5 slots to fill.\n\n\n" +
                "Losing:\n" +
                "        Lose All Lives:\n" +
                "        The frog loses a life if hit by a vehicle, drowns, or runs out of time.\n" +
                "        Game over if all lives are lost.\n\n\n" +
                "Scoring:\n" +
                "        Points: Earn points by moving forward, reaching the home area, and collecting bonuses (like flies).");
        helpTextArea.setWrapText(true);
        helpTextArea.setFont(new Font(15));
        helpTextArea.setPrefSize(546, 290);
        helpTextArea.setLayoutX(31);
        helpTextArea.setLayoutY(485);
        helpTextArea.setEditable(false);

        // Initialize and configure the ImageView for the background image
        backgroundImageView = new ImageView(new Image("file:src/main/resources/keys/key help.png"));
        backgroundImageView.setFitHeight(400);
        backgroundImageView.setFitWidth(652);
        backgroundImageView.setLayoutY(56);
        backgroundImageView.setPreserveRatio(true);

        // Add all components to the pane
        getChildren().addAll(helpTextArea, backgroundImageView);
    }
}
