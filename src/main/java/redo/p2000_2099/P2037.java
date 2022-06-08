package redo.p2000_2099;

import java.util.Arrays;

public class P2037 {

    class Solution {
        public int minMovesToSeat(int[] seats, int[] students) {
            Arrays.sort(seats);
            Arrays.sort(students);
            int count = 0;

            for (int i = 0; i < seats.length; ++i) {
                count += Math.abs(seats[i] - students[i]);
            }

            return count;
        }
    }

}
