import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    ArrayList<Player> players;
    Integer maxPlayers;

    Board() {
        players = new ArrayList<>();
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        addPlayer(scan.nextLine());
        addPlayer(scan.nextLine());
        addPlayer(scan.nextLine());

        players.forEach(player -> {
            System.out.println(player.name);
        });
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }
}
