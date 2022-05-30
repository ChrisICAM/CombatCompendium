package com.example.combatcompendium.Fragment;

public class Characters {
    private String charName;
    private int charId;

    public Characters(String charName, int charId) {
        this.charName = charName;
        this.charId = charId;
    }

    public String getCharName() { return charName; }

    public int getCharId() { return charId; }
}
