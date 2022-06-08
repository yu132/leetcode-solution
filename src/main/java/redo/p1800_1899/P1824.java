package redo.p1800_1899;

public class P1824 {

    class Solution {
        public int minSideJumps(int[] obstacles) {
            int now = indexOf(obstacles, 2, 0) - 1, ans = 0;
            if (now == -2) {
                return 0;
            }
            while (true) {
                int x1 = indexOf(obstacles, 1, now),
                        x2 = indexOf(obstacles, 2, now),
                        x3 = indexOf(obstacles, 3, now);
                if (x1 == -1 || x2 == -1 || x3 == -1) {
                    return ans + 1;
                }
                if (x1 > x2 && x1 > x3) {
                    now = x1 - 1;
                } else if (x2 > x1 && x2 > x3) {
                    now = x2 - 1;
                } else {
                    now = x3 - 1;
                }
                ++ans;
            }
        }

        public int indexOf(int[] arr, int target, int start) {
            for (int i = start; i < arr.length; ++i) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }

}
