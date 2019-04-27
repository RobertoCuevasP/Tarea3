package com.test.tarea3;

import com.google.gson.annotations.Expose;

public class Juego {

    @Expose
    private int id;

    @Expose
    private String gameName;

    @Expose
    private int coverImage;

    @Expose
    private String description;

    @Expose
    private int prize;

    public Juego(int id, int coverImage, String gameName, String description, int prize) {
        this.id = id;
        this.coverImage = coverImage;
        this.gameName = gameName;
        this.description = description;
        this.prize = prize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
