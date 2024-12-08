package redo.p2900_2999;

import java.util.ArrayList;
import java.util.List;

public class P2951 {

    class Solution {
        public List<Integer> findPeaks(int[] mountain) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i < mountain.length - 1; ++i) {
                if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

}
