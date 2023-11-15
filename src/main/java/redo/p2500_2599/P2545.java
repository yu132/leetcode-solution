package redo.p2500_2599;

import java.util.Arrays;
import java.util.Comparator;

public class P2545 {

    class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
            Arrays.sort(score, Comparator.<int[]>comparingInt(a -> a[k]).reversed());
            return score;
        }
    }

}
