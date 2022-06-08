package redo.p1000_1099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1018  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1018 {

    class Solution {
        public List<Boolean> prefixesDivBy5(int[] A) {
            int num = 0;
            List<Boolean> ans = new ArrayList<>();
            for (int n : A) {
                num = (num << 1) | n;
                num %= 10;
                ans.add(num % 5 == 0);
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(true, false, false), s.prefixesDivBy5(new int[] {0, 1, 1}));
        Assert.assertEquals(Arrays.asList(false, false, false), s.prefixesDivBy5(new int[] {1, 1, 1}));
        Assert.assertEquals(Arrays.asList(true, false, false, false, true, false),
            s.prefixesDivBy5(new int[] {0, 1, 1, 1, 1, 1}));
        Assert.assertEquals(Arrays.asList(false, false, false, false, false),
            s.prefixesDivBy5(new int[] {1, 1, 1, 0, 1}));

    }

}
