
import java.util.*;

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;

        ArrayList<Seeds> seeds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Seeds s = new Seeds(plantTime[i], growTime[i]);
            seeds.add(s);
        }

        // Grow time descending order
        seeds.sort((x, y) -> {
            return Integer.compare(y.grow, x.grow);
        });

        int bloom = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {

            Seeds s = seeds.get(i);

            start += s.plant;

            int currentBloom = start + s.grow;

            bloom = Math.max(bloom, currentBloom);
        }

        return bloom;
    }
}

class Seeds {
    int plant;
    int grow;

    Seeds(int plant, int grow) {
        this.plant = plant;
        this.grow = grow;
    }
}
