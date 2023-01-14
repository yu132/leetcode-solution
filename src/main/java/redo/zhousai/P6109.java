package redo.zhousai;

public class P6109 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int peopleAwareOfSecret(int n, int delay, int forget) {
            long[] newp = new long[n], totalp = new long[n], delayp = new long[n];
            newp[0] = 1;
            totalp[0] = 1;
            delayp[0] = 0;
            for (int i = 1; i < n; ++i) {
                delayp[i] = (delayp[i - 1] + get(newp, i - delay) - get(newp, i - forget) + MOD) % MOD;
                newp[i] = delayp[i];
                totalp[i] = (totalp[i - 1] + newp[i] - get(newp, i - forget) + MOD) % MOD;
            }
            return (int) totalp[n - 1];
        }

        long get(long[] arr, int index) {
            if (index < 0) {
                return 0;
            }
            return arr[index];
        }
    }


}
