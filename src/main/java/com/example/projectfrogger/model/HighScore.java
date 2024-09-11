package com.example.projectfrogger.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HighScore {
    private final int score;
    private final String name;
    private final LocalDateTime dateTime;
    private final String dateTimeString;
    private final int level;

    public HighScore(int score, String name, int level) {
        this.score = score;
        this.name = name;
        this.level = level;
        this.dateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM/yyyy -> HH:mm:ss");
        this.dateTimeString = formatter.format(dateTime);
    }

    public HighScore(int score, String name, String dateTimeString, int level) {
        this.score = score;
        this.name = name;
        this.dateTimeString = dateTimeString;
        this.level = level;
        this.dateTime = LocalDateTime.now();
    }

    public String getScoreString() {
        return String.valueOf(score);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getDateTimeString() {
        return dateTimeString;
    }

    public int getLevel() {
        return level;
    }
}
