package redo.p1000_1099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1002  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1002 {

    class Solution {
        public List<String> commonChars(String[] A) {
            if (A.length == 0) {
                return Collections.emptyList();
            }
            int[][] count = new int[A.length][26];
            for (int i = 0; i < A.length; ++i) {
                for (char ch : A[i].toCharArray()) {
                    ++count[i][ch - 'a'];
                }
            }
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < 26; ++i) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < A.length; ++j) {
                    min = Math.min(min, count[j][i]);
                }
                for (int j = 0; j < min; ++j) {
                    ans.add(String.valueOf((char)(i + 'a')));
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("e", "l", "l"), s.commonChars(new String[] {"bella", "label", "roller"}));
        Assert.assertEquals(Arrays.asList("c", "o"), s.commonChars(new String[] {"cool", "lock", "cook"}));
        Assert.assertEquals(Arrays.asList(), s.commonChars(new String[] {}));

    }

}
