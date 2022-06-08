package redo.p2000_2099;

public class P2079 {

    class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int now = capacity, ans = 0;
            for (int i = 0; i < plants.length; ++i) {
                if (now >= plants[i]) {
                    ++ans;
                    now -= plants[i];
                } else {
                    ans += i + i + 1;
                    now = capacity - plants[i];
                }
            }

            return ans;
        }
    }

}
