import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Board {
    ArrayList<Player> players;
    String status;
    Player winner;
    Dice dice;
    Ladder ladder;
    Snake snake;
    Integer maxPlayers = 2;
    Integer maxCell = 100;

    Board() {
        players = new ArrayList<>();
        dice = new Dice(6);

        initSnake();
        initLadder();
        initPlayer();
    }

    public void initLadder() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Total Ladder: ");

        ladder = new Ladder(scan.nextInt());
        for (int i = 0; i < ladder.total ; i++) {
            System.out.print("Position: ");
            int x = scan.nextInt();
            int y = scan.nextInt();

            HashMap<Integer, Integer> position = new HashMap<>();
            position.put(x, y);

            ladder.position.add(position);
        }
    }

    public void initSnake() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Total Snake: ");

        snake = new Snake(scan.nextInt());
        for (int i = 0; i < snake.total ; i++) {
            System.out.print("Position: ");
            int x = scan.nextInt();
            int y = scan.nextInt();

            HashMap<Integer, Integer> position = new HashMap<>();
            position.put(x, y);

            snake.position.add(position);
        }
    }

    public void initPlayer() {
        Scanner scan = new Scanner(System.in);
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
           for (int i = 0; i < maxPlayers ; i++) {
               Player player = players.get(i);

               Integer step = dice.shuffle();

               System.out.print(player.name + " rolled a " + step + " and moved From " + player.position);

               player.move(step, maxCell);

               step = ladder.check(player.position);
               if (step != 0) player.sliding(step);

               step = snake.check(player.position);
               if (step != 0) player.sliding(step);


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
