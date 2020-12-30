package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1528  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1528 {

    class Solution {
        public String restoreString(String s, int[] indices) {
            char[] chs = new char[s.length()];
            for (int i = 0; i < s.length(); ++i) {
                chs[indices[i]] = s.charAt(i);
            }
            return String.valueOf(chs);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("leetcode", s.restoreString("codeleet", new int[] {4, 5, 6, 7, 0, 2, 1, 3}));
        Assert.assertEquals("abc", s.restoreString("abc", new int[] {0, 1, 2}));
        Assert.assertEquals("nihao", s.restoreString("aiohn", new int[] {3, 1, 4, 2, 0}));
        Assert.assertEquals("arigatou", s.restoreString("aaiougrt", new int[] {4, 0, 2, 6, 7, 3, 1, 5}));
        Assert.assertEquals("rat", s.restoreString("art", new int[] {1, 0, 2}));
    }

}
