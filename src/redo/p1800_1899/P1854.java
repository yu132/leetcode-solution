package redo.p1800_1899;

import java.util.Arrays;
import java.util.PriorityQueue;

/**  
 * @ClassName: P1854  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1854 {

    class Solution {
        public int maximumPopulation(int[][] logs) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            Arrays.sort(logs, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });

            int max = 0, year = 0;

            for (int[] log : logs) {
                int birth = log[0];
                int death = log[1];

                while (!pq.isEmpty() && pq.peek() < birth) {
                    pq.poll();
                }

                pq.offer(death);

                if (pq.size() > max) {
                    max = pq.size();
                    year = birth;
                }
            }

            return year;
        }
    }

}
