package com.ageng_setyo;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    ArrayList<Player> players = new ArrayList<>();
    String status;
    Player winner;
    Dice dice = new Dice(6);
    public ArrayList<Effect> effects = new ArrayList<>();

    int maxPlayers = 2;
    int maxCell = 100;

    public Board() {
        Scanner scanner = new Scanner(System.in);
        initSnake(scanner);
        initLadder(scanner);
        initPlayer(scanner);
    }

    public void initSnake(Scanner scan) {
        System.out.print("Input Total Snake: ");

        effects.add(new Snake(scan.nextInt()));
    }

    public void initLadder(Scanner scan) {
        System.out.print("Input Total Ladder: ");

        effects.add(new Ladder(scan.nextInt()));
    }

    public void initPlayer(Scanner scan) {
        for (int i = 1; i <= maxPlayers; i++) {
            System.out.print("Input Player " + i + " Name: ");
            addPlayer(scan.nextLine());
        }
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void play() {
        status = "Play";

        while (status.equals("Play")) {
            for (int i = 0; i < maxPlayers; i++) {
                Player player = players.get(i);

                int step = dice.shuffle();

                System.out.print(player.name + " rolled a " + step + " and moved From " + player.position);

                player.move(step, maxCell);

                for (Effect effect : effects) {
                    step = effect.check(player.position);
                    if (step != 0)
                        player.takeEffect(step);
                }

                System.out.println(" to " + player.position);

                if (player.position == maxCell && winner == null) {
                    status = "Stop";
                    winner = player;
                    break;
                }
            }
        }
    }

    public ArrayList<Effect> getEffects() {
        return effects;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Dice getDice() {
        return dice;
    }

    public Player getWinner() {
        return winner;
    }

    public int getMaxCell() {
        return maxCell;
    }
}
