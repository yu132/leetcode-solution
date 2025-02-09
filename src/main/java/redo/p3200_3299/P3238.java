package redo.p3200_3299;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P3238 {

    class Solution {
        public int winningPlayerCount(int n, int[][] pick) {
            HashSet<Integer> winner = new HashSet<>();
            Map<Integer, Map<Integer, Integer>> counters = new HashMap<>();
            for (int[] ints : pick) {
                int player = ints[0];
                int color = ints[1];

                int val = counters.computeIfAbsent(player, x -> new HashMap<>())
                        .merge(color, 1, Integer::sum);

                if (val > player) {
                    winner.add(player);
                }
            }
            return winner.size();
        }
    }
}
