package redo2012_05_29start;

import java.util.PriorityQueue;

/**  
 * @ClassName: P0215  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月29日  
 *  
 */
public class P0215 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int num : nums) {
                if (pq.size() < k) {
                    pq.offer(num);
                } else {
                    if (num > pq.peek()) {
                        pq.offer(num);
                        pq.poll();
                    }
                }
            }

            return pq.peek();
        }
    }

}
