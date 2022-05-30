package com.example.combatcompendium.Fragment;

public class Games {
    private String gameName;
    private int gameId;

    public Games(String gameName, int gameId) {
        this.gameName = gameName;
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public int getGameId() {
        return gameId;
    }
}
