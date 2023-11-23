package redo.p2700_2799;

import java.util.Arrays;

public class P2731 {

    class Solution {
        public int sumDistance(int[] nums, String s, int d) {
            long[] next = new long[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                next[i] = (s.charAt(i) == 'R' ? 1L : -1L) * d + nums[i];
            }
            Arrays.sort(next);
            long ans = 0;
            long prefix = next[0];
            for (int i = 1; i < next.length; ++i) {
                ans = add(ans, minus(multiply(i, next[i], MOD), prefix, MOD), MOD);
                prefix = add(prefix, next[i], MOD);
            }
            return (int) ans;
        }

        public final static int MOD = 1_000_000_007;

        int minus(long a, long b, int mod) {// a > b
            return (int) ((a % mod - b % mod + mod) % mod);// 加mod是为了防止为负数
        }

        int multiply(long a, long b, int mod) {
            return (int) (((a % mod) * (b % mod)) % mod);
        }

        int add(long a, long b, int mod) {
            return (int) ((a % mod + b % mod) % mod);
        }

        class Node {
            int idx;
            char dir;

            public Node(int idx, char dir) {
                this.idx = idx;
                this.dir = dir;
            }
        }
    }

    public static void main(String[] args) {
        new P2731().new Solution().sumDistance(new int[]{2000000000, -2000000000}, "RL", 1000000000);
    }
}
