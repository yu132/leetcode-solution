package redo.p1500_1599;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1593  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1593 {

    class Solution {

        int max;

        public int maxUniqueSplit(String s) {
            max = 0;
            helper(0, 0, 0, s, new HashSet<>(100));
            return max;
        }

        public void helper(int index, int from, int len, String s, Set<String> used) {
            if (index == s.length()) {
                if (index == from) {
                    max = Math.max(max, len);
                }
                return;
            }
            String str = s.substring(from, index + 1);
            if (!used.contains(str)) {
                used.add(str);
                helper(index + 1, index + 1, len + 1, s, used);
                used.remove(str);
            }
            helper(index + 1, from, len, s, used);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.maxUniqueSplit("ababccc"));
        Assert.assertEquals(2, s.maxUniqueSplit("aba"));
        Assert.assertEquals(1, s.maxUniqueSplit("aa"));
    }

}
