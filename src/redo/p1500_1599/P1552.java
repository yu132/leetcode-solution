package redo.p1500_1599;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1552  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1552 {

    class Solution {
        public int maxDistance(int[] position, int m) {
            Arrays.sort(position);
            int maxLen = position[position.length - 1] - position[0];
            int low = 0, high = maxLen + 1;
            while (low < high) {// 二分查找答案
                int mid = (low + high) >>> 1;
                if (possibleToPlace(position, mid, m)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }

        public boolean possibleToPlace(int[] position, int distance, int num) {
            if (distance == 0) {
                return false;
            }

            int last = 0, possible = 1;
            for (int i = 1; i < position.length; ++i) {
                if (position[i] - position[last] >= distance) {
                    ++possible;
                    if (possible >= num) {
                        return true;
                    }
                    last = i;
                }
            }

            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.maxDistance(new int[] {1, 2, 3, 4, 7}, 3));
        Assert.assertEquals(999999999, s.maxDistance(new int[] {5, 4, 3, 2, 1, 1000000000}, 2));
        Assert.assertEquals(-1, s.maxDistance(new int[] {1, 2, 3}, 4));
        Assert.assertEquals(1, s.maxDistance(new int[] {1, 2}, 2));
    }

}
