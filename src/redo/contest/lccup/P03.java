package redo.contest.lccup;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月5日  
 *  
 */
public class P03 {

    class Solution {
        public int magicTower(int[] nums) {

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            long hp = 1, sum = 0;
            int count = 0;

            for (int num : nums) {
                if (num < 0) {
                    pq.offer(num);
                }
                hp += num;
                sum += num;
                if (hp <= 0) {
                    int min = pq.poll();
                    hp -= min;
                    ++count;
                }
            }

            if (sum < 0) {
                return -1;
            }

            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.magicTower(
            new int[] {100, 100, 100, -250, -60, -140, -50, -50, 100, 150}));
        Assert.assertEquals(-1, s.magicTower(new int[] {-200, -300, 400, 0}));

    }

}
