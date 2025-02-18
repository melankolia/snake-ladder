package com.ageng_setyo;

public class Player {
    String name;
    int position = 0;

    public Player(String name) {
        this.name = name;
    }

    public void move(int number, int maxCell) {

        // Validate if Player move exceed the maxCell then it Doesn't Move at all
        if (position + number <= maxCell)
            position += number;
    }

    public void takeEffect(int number) {
        position = number;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
