import java.util.ArrayList;
import java.util.HashMap;

public class Ladder {
    ArrayList<HashMap<Integer, Integer>> position;
    Integer total;

    Ladder(Integer total) {
        this.position = new ArrayList<>();
        this.total = total;
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
