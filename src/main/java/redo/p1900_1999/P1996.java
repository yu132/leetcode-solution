package redo.p1900_1999;

import java.util.Arrays;
import java.util.Comparator;

public class P1996 {

    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            Arrays.sort(properties, Comparator.<int[], Integer>comparing(x -> x[0])
                    .thenComparing(x -> x[1], Comparator.reverseOrder()));

            int maxY = 0, ans = 0;

            for (int i = properties.length - 1; i >= 0; --i) {
                if (maxY > properties[i][1]) {
                    ++ans;
                }
                maxY = Math.max(maxY, properties[i][1]);
            }

            return ans;
        }
    }

}
