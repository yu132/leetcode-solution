package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1535  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1535 {

    class Solution {
        public int getWinner(int[] arr, int k) {
            int winner = arr[0], time = 0;
            for (int i = 1; i < arr.length; ++i) {
                if (winner > arr[i]) {
                    ++time;
                } else {
                    winner = arr[i];
                    time = 1;
                }
                if (time >= k) {
                    return winner;
                }
            }
            return winner;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.getWinner(new int[] {2, 1, 3, 5, 4, 6, 7}, 2));
        Assert.assertEquals(3, s.getWinner(new int[] {3, 2, 1}, 10));
        Assert.assertEquals(9, s.getWinner(new int[] {1, 9, 8, 2, 3, 7, 6, 4, 5}, 7));
        Assert.assertEquals(99, s.getWinner(new int[] {1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
    }

}
