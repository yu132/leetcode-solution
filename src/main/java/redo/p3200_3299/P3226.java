package redo.p3200_3299;

public class P3226 {

    class Solution {
        public int minChanges(int n, int k) {
            int ans = 0;
            while (k > 0 || n > 0) {
                if ((k & 1) != (n & 1)) {
                    if ((k & 1) == 0 && (n & 1) == 1) {
                        ++ans;
                    } else {
                        return -1;
                    }
                }
                k >>= 1;
                n >>= 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new P3226().new Solution().minChanges(13, 4);
    }

}
