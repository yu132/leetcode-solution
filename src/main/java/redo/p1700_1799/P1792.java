package redo.p1700_1799;

import java.util.PriorityQueue;

public class P1792 {

    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<Class> pq = new PriorityQueue<>();
            for (int[] clazz : classes) {
                pq.offer(new Class(clazz[0], clazz[1]));
            }
            for (int i = 0; i < extraStudents; ++i) {
                Class clazz = pq.poll();
                ++clazz.pass;
                ++clazz.total;
                pq.offer(clazz);
            }
            double val = 0;
            for (Class clazz : pq) {
                val += (double) clazz.pass / clazz.total;
            }
            return val / classes.length;
        }

        class Class implements Comparable<Class> {
            int pass, total;

            public Class(int pass, int total) {
                this.pass = pass;
                this.total = total;
            }

            @Override
            public int compareTo(Class o) {
                double rate1 = (double) (pass + 1) / (total + 1) - (double) pass / total;
                double rate2 = (double) (o.pass + 1) / (o.total + 1) - (double) o.pass / o.total;
                return Double.compare(rate2, rate1);
            }
        }
    }

}
