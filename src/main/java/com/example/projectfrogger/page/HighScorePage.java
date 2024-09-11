package com.example.projectfrogger.page;

import com.example.projectfrogger.model.HighScore;
import com.example.projectfrogger.model.HighScoreView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class HighScorePage extends ScrollPane {

    File highScoreFile;

    VBox vBox;

    public HighScorePage() {
        initialize();
        setContent(vBox);
        setPrefSize(600, 800);
    }

    public void initialize(){
        vBox = new VBox();
        vBox.setPadding(new Insets(30, 50, 30, 50));
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(50, 60, 40), null, null)));
        try {
            loadHighScores();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Vector<HighScore> highScores = new Vector<>();

    public void loadHighScores() throws FileNotFoundException {
        highScoreFile = new File("HighScores.txt");
        Scanner scanner = new Scanner(highScoreFile);

        while (scanner.hasNextLine()) {
            int score = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            String date = scanner.nextLine();
            int level = Integer.parseInt(scanner.nextLine());

            HighScore highScore = new HighScore(score, name, date, level);
            highScores.add(highScore);
        }
        highScores.sort(new Comparator<HighScore>() {
            @Override
            public int compare(HighScore hs1, HighScore hs2) {
                // First compare levels in descending order
                int levelComparison = Integer.compare(hs2.getLevel(), hs1.getLevel());
                if (levelComparison != 0) {
                    return levelComparison;
                }

                // If levels are the same, compare scores in descending order
                return Integer.compare(hs2.getScore(), hs1.getScore());
            }
        });

        int maxLevel = highScores.getFirst().getLevel();
        vBox.getChildren().add(getLevelNumber("Level " + maxLevel));
        for (HighScore highScore : highScores) {
            if (highScore.getLevel() < maxLevel) {
                maxLevel--;
                vBox.getChildren().add(getLevelNumber("Level " + maxLevel));
            }
            vBox.getChildren().add(new HighScoreView(highScore));
        }
    }

    HBox getLevelNumber(String number){
        Label label = new Label(number);
        label.setTextFill(Color.WHITE);
        label.setFont(new Font("Times New Roman BOLD", 32));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(15, 10, 10, 10));

        HBox hBox = new HBox(label);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

}
