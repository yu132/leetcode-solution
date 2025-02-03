package redo.p2900_2999;

import java.util.ArrayList;
import java.util.List;

public class P2961 {

    class Solution {
        public List<Integer> getGoodIndices(int[][] variables, int target) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < variables.length; ++i) {
                int[] arr = variables[i];
                int tmp1 = pow(arr[0], arr[1], 10);
                int tmp2 = pow(tmp1, arr[2], arr[3]);
                if (tmp2 == target) {
                    ans.add(i);
                }
            }
            return ans;
        }

        int pow(long base, long exp, long MOD) {
            long ans = 1;
            base %= MOD;
            while (exp > 0) {
                if (exp % 2 != 0) {
                    ans = (ans * base) % MOD;
                }
                exp >>= 1;
                base = (base * base) % MOD;
            }
            return (int) ans;
        }

    }

}
