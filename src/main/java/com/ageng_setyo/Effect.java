package com.ageng_setyo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Effect {
    ArrayList<HashMap<Integer, Integer>> position;
    int total;

    public Effect(int total) {
        this.position = new ArrayList<>();
        this.total = total;

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < this.total ; i++) {

            System.out.print("Position: ");
            int x = scan.nextInt();
            int y = scan.nextInt();

            System.out.println("Position: " + x + ", " + y);
            HashMap<Integer, Integer> position = new HashMap<>();
            position.put(x, y);

            this.position.add(position);
        }
    }

    public int check(int position) {
        int result = 0;
        for (HashMap<Integer, Integer> map : this.position) {
            if (map.containsKey(position)) {
                result = map.get(position);
                break;
            }
        }

        return result;
    }

    public int getTotal() {
        return total;
    }
}
