package com.ageng_setyo;

public class Dice {
    int maxPoint;
    int minPoint = 1;

    public Dice(int maxPoint) {
        this.maxPoint = maxPoint;
    }

    public int shuffle() {

        /**
         * This is Formula For Calculate Min - Max main.java.com.ageng_setyo.Dice Point
         * */
        return (int) Math.floor(Math.random() * (maxPoint - minPoint + 1) + minPoint);
    }

    public int getMaxPoint() {
        return maxPoint;
    }
}
