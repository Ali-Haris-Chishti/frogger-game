package com.example.projectfrogger.model;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * A custom Pane for displaying high scores.
 * It includes three styled labels with different fonts and colors.
 */
public class HighScoreView extends Pane {

    /**
     * Creates a new HighScoreView instance and sets up its layout.
     */
    public HighScoreView(HighScore highScore) {
        initializePane();
        addChildren(highScore);
    }

    /**
     * Initializes the pane's properties including size, border, background color, and padding.
     */
    private void initializePane() {
        this.setPrefHeight(100.0);
        this.setPrefWidth(500.0);
        this.setStyle("-fx-border-width: 2 5 5 2; -fx-border-color: green; -fx-background-color: rgb(90, 90, 90);");
        this.setPadding(new Insets(5.0, 10.0, 5.0, 10.0));
    }

    /**
     * Adds all child elements to the pane.
     */
    private void addChildren(HighScore highScore) {
        Label label1 = createLabel(highScore.getScoreString(), 0.0, 0.0, 200.0, 100.0, "Microsoft New Tai Lue Bold", 36.0, "#cfd9da");
        Label label2 = createLabel(highScore.getName(), 250.0, 10.0, 250.0, 40.0, "Monospaced Bold Italic", 18.0, "#f8f6f6");
        Label label3 = createLabel(highScore.getDateTimeString(), 250.0, 55.0, 250.0, 40.0, "PMingLiU-ExtB", 14.0, "#fcf6f6");

        this.getChildren().addAll(label1, label2, label3);
    }

    /**
     * Creates and configures a Label with the specified properties.
     *
     * @param text the text to display on the label
     * @param layoutX the X position of the label
     * @param layoutY the Y position of the label
     * @param prefWidth the preferred width of the label
     * @param prefHeight the preferred height of the label
     * @param fontName the font name of the label
     * @param fontSize the font size of the label
     * @param textFill the color of the label's text
     * @return the configured Label
     */
    private Label createLabel(String text, double layoutX, double layoutY, double prefWidth, double prefHeight,
                              String fontName, double fontSize, String textFill) {
        Label label = new Label(text);
        label.setLayoutX(layoutX);
        label.setLayoutY(layoutY);
        label.setPrefWidth(prefWidth);
        label.setPrefHeight(prefHeight);
        label.setFont(Font.font(fontName, fontSize));
        label.setTextFill(javafx.scene.paint.Color.web(textFill));
        label.setAlignment(javafx.geometry.Pos.CENTER);
        return label;
    }
}

