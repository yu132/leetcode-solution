package redo.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P45  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P45 {

    class Solution {
        public String minNumber(int[] nums) {
            List<String> strs = new ArrayList<>();
            for (int num : nums) {
                strs.add(String.valueOf(num));
            }
            Collections.sort(strs, (a, b) -> (a + b).compareTo(b + a));
            return String.join("", strs);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("102", s.minNumber(new int[] {10, 2}));
        Assert.assertEquals("3033459",
            s.minNumber(new int[] {3, 30, 34, 5, 9}));
    }

}
