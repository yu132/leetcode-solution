package redo.p0800_0899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P830  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P830 {

    class Solution {
        public List<List<Integer>> largeGroupPositions(String s) {
            s += ' ';
            int start = 0;
            char group = '\0';
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != group) {
                    if (i - start >= 3) {
                        ans.add(Arrays.asList(start, i - 1));
                    }
                    start = i;
                    group = s.charAt(i);
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(Arrays.asList(3, 6)), s.largeGroupPositions("abbxxxxzzy"));
        Assert.assertEquals(Arrays.asList(), s.largeGroupPositions("abc"));
        Assert.assertEquals(Arrays.asList(Arrays.asList(3, 5), Arrays.asList(6, 9), Arrays.asList(12, 14)),
            s.largeGroupPositions("abcdddeeeeaabbbcd"));
    }

}
