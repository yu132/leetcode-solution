package redo.p0900_0999;

import java.util.PriorityQueue;

/**  
 * @ClassName: P973  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P973 {

    static//

    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            double[] dis = new double[points.length];
            for (int i = 0; i < points.length; ++i) {
                dis[i] = distance(0, 0, points[i][0], points[i][1]);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Double.compare(dis[b], dis[a]));
            for (int i = 0; i < dis.length; ++i) {
                if (pq.size() < K || dis[i] < dis[pq.peek()]) {
                    pq.offer(i);
                }
                if (pq.size() > K) {
                    pq.poll();
                }
            }
            int[][] ans = new int[K][];
            for (int i = 0; i < K; ++i) {
                ans[i] = points[pq.poll()];
            }
            return ans;
        }

        public static double distance(int x1, int y1, int x2, int y2) {
            return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        }

    }

}
