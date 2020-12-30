package redo.p0500_0599;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P575  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P575 {

    class Solution {
        public int distributeCandies(int[] candyType) {
            Set<Integer> set = new HashSet<>();
            for (int num : candyType) {
                set.add(num);
            }
            return Math.min(set.size(), candyType.length / 2);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.distributeCandies(new int[] {1, 1, 2, 2, 3, 3}));
        Assert.assertEquals(2, s.distributeCandies(new int[] {1, 1, 2, 3}));
    }

}
