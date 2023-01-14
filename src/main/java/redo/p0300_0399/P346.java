package redo.p0300_0399;

import java.util.LinkedList;

public class P346 {

    class MovingAverage {

        /**
         * Initialize your data structure here.
         */

        int sum = 0;
        int maxSize, size = 0;
        LinkedList<Integer> vals = new LinkedList<>();

        public MovingAverage(int size) {
            maxSize = size;
        }

        public double next(int val) {
            if (size < maxSize) {
                ++size;
            } else {
                sum -= vals.removeFirst();
            }
            sum += val;
            vals.addLast(val);
            return (double) sum / size;
        }
    }

}
