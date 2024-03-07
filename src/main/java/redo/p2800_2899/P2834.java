package redo.p2800_2899;

public class P2834 {

    class Solution {
        public int minimumPossibleSum(int n, int target) {
            if (n <= target / 2) {
                return (int) (((long) n * (n + 1) / 2) % MOD);
            }
            long rr = n + (target - 1) / 2;
            long rrSum = rr * (rr + 1) / 2;
            long mid = (target - 1);
            long midSum = mid * (mid + 1) / 2;
            long ll = target / 2;
            long llSum = ll * (ll + 1) / 2;
            return (int) ((rrSum - midSum + llSum) % MOD);
        }

        public final static int MOD = 1_000_000_007;
    }

}
