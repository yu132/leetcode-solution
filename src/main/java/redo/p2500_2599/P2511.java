package redo.p2500_2599;

public class P2511 {

    class Solution {
        public int captureForts(int[] forts) {

            int s = -1, flag = 0, ans = 0;
            for (int i = 0; i < forts.length; ++i) {
                if (forts[i] != 0) {
                    if (flag == 0) {
                        flag = forts[i];
                    } else if (flag != forts[i]) {
                        ans = Math.max(ans, i - s - 1);
                        flag = forts[i];
                    }
                    s = i;
                }
            }
            return ans;

        }
    }

}
