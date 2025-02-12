package com.ageng_setyo;

public class App 
{
    public static void main( String[] args ) {
        Board board = new Board();
        board.play();

        System.out.println(board.winner.name + " wins the game");
    }
}
