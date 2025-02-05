import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Effect {
    ArrayList<HashMap<Integer, Integer>> position;
    Integer total;

    Effect(Integer total) {
        this.position = new ArrayList<>();
        this.total = total;

        for (int i = 0; i < this.total ; i++) {
            Scanner scan = new Scanner(System.in);

            System.out.print("Position: ");
            int x = scan.nextInt();
            int y = scan.nextInt();

            HashMap<Integer, Integer> position = new HashMap<>();
            position.put(x, y);

            this.position.add(position);
        }
    }

    public Integer check(Integer position) {
        Integer result = 0;
        for (HashMap<Integer, Integer> map : this.position) {
            if (map.containsKey(position)) {
                result = map.get(position);
                break;
            }
        }

        return result;
    }
}
