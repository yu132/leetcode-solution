package redo.p0600_0699;

import redo.testUtil.Arrs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P630 {

    class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, Comparator.<int[]>comparingInt(x -> x[1]).thenComparing(x -> x[0]));
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int nowSum = 0;
            for (int[] course : courses) {
                if (course[0] > course[1]) {
                    continue;
                }
                if (nowSum + course[0] > course[1]) {
                    if (course[0] >= pq.peek()) {
                        continue;
                    }
                    nowSum -= pq.poll();
                    nowSum += course[0];
                    pq.offer(course[0]);
                } else {
                    pq.offer(course[0]);
                    nowSum += course[0];
                }
            }
            return pq.size();
        }
    }

    public static void main(String[] args) {
        new P630().new Solution().scheduleCourse(Arrs.build2D("[[100,200],[200,1300],[1000,1250],[2000,3200]]"));
    }
}
