package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P904  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月26日  
 *  
 */
public class P904 {

    class Solution {
        public int totalFruit(int[] tree) {
            int left = 0, right = 0, kind1 = -1, kind2 = -1, count1 = 0, count2 = 0, max = 0;
            for (; right < tree.length; ++left) {
                while (right < tree.length
                    && (count1 == 0 || count2 == 0 || tree[right] == kind1 || tree[right] == kind2)) {
                    if (tree[right] == kind1) {
                        ++count1;
                    } else if (tree[right] == kind2) {
                        ++count2;
                    } else if (count1 == 0) {
                        kind1 = tree[right];
                        ++count1;
                    } else if (count2 == 0) {
                        kind2 = tree[right];
                        ++count2;
                    }
                    ++right;
                }
                max = Math.max(max, right - left);
                if (tree[left] == kind1) {
                    --count1;
                } else {
                    --count2;
                }
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.totalFruit(new int[] {1, 2, 1}));
        Assert.assertEquals(3, s.totalFruit(new int[] {0, 1, 2, 2}));
        Assert.assertEquals(4, s.totalFruit(new int[] {1, 2, 3, 2, 2}));
        Assert.assertEquals(5, s.totalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        Assert.assertEquals(5, s.totalFruit(new int[] {1, 1, 2, 2, 3, 3, 3}));
    }

}
