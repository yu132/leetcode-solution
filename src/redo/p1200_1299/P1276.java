package redo.p1200_1299;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1276  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1276 {

    class Solution {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            if (tomatoSlices < 2 * cheeseSlices || tomatoSlices > 4 * cheeseSlices
                || (tomatoSlices - 2 * cheeseSlices) % 2 != 0) {
                return Collections.emptyList();
            }
            int jumbo = (tomatoSlices - 2 * cheeseSlices) / 2;
            return Arrays.asList(jumbo, cheeseSlices - jumbo);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(1, 6), s.numOfBurgers(16, 7));
        Assert.assertEquals(Arrays.asList(), s.numOfBurgers(17, 4));
        Assert.assertEquals(Arrays.asList(), s.numOfBurgers(4, 17));
        Assert.assertEquals(Arrays.asList(0, 0), s.numOfBurgers(0, 0));
        Assert.assertEquals(Arrays.asList(0, 1), s.numOfBurgers(2, 1));
    }

}
