package reredo;

import java.util.PriorityQueue;

/**  
 * @ClassName: P0215  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月2日  
 *  
 */
public class P0215 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> max = new PriorityQueue<>();

            for (int num : nums) {
                if (max.size() < k) {
                    max.offer(num);
                } else {
                    if (num > max.peek()) {
                        max.poll();
                        max.offer(num);
                    }
                }
            }

            return max.peek();
        }
    }

}
