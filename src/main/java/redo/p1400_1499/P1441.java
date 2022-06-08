package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1441  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1441 {

    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> ans = new ArrayList<>();
            int last = 0;
            for (int i = 0; i < target.length; ++i) {
                for (int j = last + 1; j < target[i]; ++j) {
                    ans.add("Push");
                    ans.add("Pop");
                }
                ans.add("Push");
                last = target[i];
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("Push", "Push", "Pop", "Push"), s.buildArray(new int[] {1, 3}, 3));
        Assert.assertEquals(Arrays.asList("Push", "Push", "Push"), s.buildArray(new int[] {1, 2, 3}, 3));
        Assert.assertEquals(Arrays.asList("Push", "Push"), s.buildArray(new int[] {1, 2}, 3));
        Assert.assertEquals(Arrays.asList("Push", "Pop", "Push", "Push", "Push"), s.buildArray(new int[] {2, 3, 4}, 4));
    }

}
