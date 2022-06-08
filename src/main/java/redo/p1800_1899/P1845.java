package redo.p1800_1899;

import java.util.TreeSet;

public class P1845 {

    class SeatManager {

        TreeSet<Integer> set = new TreeSet<>();

        public SeatManager(int n) {
            for (int i = 1; i <= n; ++i) {
                set.add(i);
            }
        }

        public int reserve() {
            int min = set.first();
            set.remove(min);
            return min;
        }

        public void unreserve(int seatNumber) {
            set.add(seatNumber);
        }
    }

}
