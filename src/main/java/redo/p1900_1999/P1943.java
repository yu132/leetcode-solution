package redo.p1900_1999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1943 {

    class Solution {
        public List<List<Long>> splitPainting(int[][] segments) {

            List<List<Long>> result = new ArrayList<List<Long>>();
            long[][] change = new long[(int) (1e5 + 1)][2];
            for (int i = 0; i < segments.length; ++i) {
                change[segments[i][0]][0] += segments[i][2];
                change[segments[i][1]][1] -= segments[i][2];
            }
            long sum = 0;
            long start = 0;
            for (int i = 0; i < change.length; ++i) {
                if (change[i][0] != 0 || change[i][1] != 0) {
                    //和为0，由于累加值里没有负数，因此一定为起始点
                    if (sum == 0) {
                        start = i;
                    }
                    //和不为0，表示之前已经有过累加了，因此为终点，同时可能也为起始点
                    if (sum != 0) {
                        result.add(Arrays.asList(start, (long) i, sum));
                        start = i;
                    }
                    sum += change[i][0] + change[i][1];
                }
            }
            return result;
        }

    }

}
