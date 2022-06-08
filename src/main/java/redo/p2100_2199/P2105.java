package redo.p2100_2199;

public class P2105 {

    class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int nowA = capacityA, nowB = capacityB, ans = 0;
            for (int i = 0, j = plants.length - 1; i <= j; ++i, --j) {
                if (i == j) {
                    if (Math.max(nowA, nowB) < plants[i]) {
                        return ans + 1;
                    } else {
                        return ans;
                    }
                }
                if (nowA >= plants[i]) {
                    nowA -= plants[i];
                } else {
                    nowA = capacityA - plants[i];
                    ++ans;
                }
                if (nowB >= plants[j]) {
                    nowB -= plants[j];
                } else {
                    nowB = capacityB - plants[j];
                    ++ans;
                }
            }
            return ans;
        }
    }

}
