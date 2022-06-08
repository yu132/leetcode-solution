package redo.LCP;

import java.util.PriorityQueue;

/**  
 * @ClassName: LCP33  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class LCP33 {

    class Solution {
        public int storeWater(int[] bucket, int[] vat) {

            PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

            int n = bucket.length;

            int updateTime = 0;

            for (int i = 0; i < n; ++i) {
                if (vat[i] == 0) {
                    continue;
                }

                if (bucket[i] == 0) {
                    ++updateTime;
                    ++bucket[i];
                }

                pq.offer(new int[] {ceilDevide(vat[i], bucket[i]), i});
            }

            if (pq.isEmpty()) {
                return 0;
            }

            int ans = 1000000;

            while (true) {
                int[] node = pq.poll();
                if (updateTime >= ans) {
                    return ans;
                }
                ans = Math.min(ans, node[0] + updateTime);
                ++bucket[node[1]];
                ++updateTime;
                node[0] = ceilDevide(vat[node[1]], bucket[node[1]]);
                pq.offer(node);
            }
        }

        int ceilDevide(int x, int y) {
            return (x - 1) / y + 1;
        }
    }

}
