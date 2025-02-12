package com.ageng_setyo;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    ArrayList<Player> players;
    String status;
    Player winner;
    Dice dice;
    Ladder ladder;
    Snake snake;

    int maxPlayers = 2;
    int maxCell = 100;

    Board() {
        players = new ArrayList<>();
        dice = new Dice(6);

        initSnake();
        initLadder();
        initPlayer();
    }

    public void initSnake() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Total main.java.com.ageng_setyo.Snake: ");

        snake = new Snake(scan.nextInt());
    }

    public void initLadder() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Total main.java.com.ageng_setyo.Ladder: ");

        ladder = new Ladder(scan.nextInt());
    }

    public void initPlayer() {
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= maxPlayers; i++) {
            System.out.print("Input main.java.com.ageng_setyo.Player " + i + " Name: ");
            addPlayer(scan.nextLine());
        }
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void play() {
       status = "Play";

       while (status.equals("Play")) {
           for (int i = 0; i < maxPlayers ; i++) {
               Player player = players.get(i);

               int step = dice.shuffle();

               System.out.print(player.name + " rolled a " + step + " and moved From " + player.position);

               player.move(step, maxCell);

               step = ladder.check(player.position);
               if (step != 0) player.takeEffect(step);

               step = snake.check(player.position);
               if (step != 0) player.takeEffect(step);

               System.out.println(" to " + player.position);

               if (player.position.equals(maxCell) && winner == null) {
                   status = "Stop";
                   winner = player;
                   break;
               }
           }
       }
    }
}
