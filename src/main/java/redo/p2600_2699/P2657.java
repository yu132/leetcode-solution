package redo.p2600_2699;

import java.util.HashSet;
import java.util.Set;

public class P2657 {

    class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            Set<Integer> setA = new HashSet<>(), setB = new HashSet<>();
            int[] ans = new int[A.length];
            int now = 0;
            for (int i = 0; i < A.length; ++i) {
                setA.add(A[i]);
                setB.add(B[i]);
                now += setA.contains(B[i]) ? 1 : 0;
                now += setB.contains(A[i]) ? 1 : 0;
                if (A[i] == B[i]) {
                    --now;
                }
                ans[i] = now;
            }
            return ans;
        }
    }

}
