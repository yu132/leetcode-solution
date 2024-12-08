package redo.p2300_2399;

import java.util.Arrays;

public class P2399 {

    class Solution {
        public boolean checkDistances(String s, int[] distance) {
            int[] dis = new int[26];
            Arrays.fill(dis, -1);
            for (int i = 0; i < s.length(); ++i) {
                if (dis[s.charAt(i) - 'a'] == -1) {
                    dis[s.charAt(i) - 'a'] = i;
                } else {
                    if (i - dis[s.charAt(i) - 'a'] - 1 != distance[s.charAt(i) - 'a']) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
