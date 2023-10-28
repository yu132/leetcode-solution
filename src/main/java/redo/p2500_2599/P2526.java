package redo.p2500_2599;

import java.util.LinkedList;

public class P2526 {

    class DataStream {

        int k;
        int value;
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
        }

        public boolean consec(int num) {
            if (queue.size() == k) {
                int val = queue.poll();
                if (val == value) {
                    --count;
                }
            }
            queue.offer(num);
            if (num == value) {
                ++count;
            }
            return count == k;
        }
    }

}
