package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P709  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P709 {

    class Solution {
        public String toLowerCase(String str) {
            char[] chs = str.toCharArray();
            int diff = 'a' - 'A';
            for (int i = 0; i < chs.length; ++i) {
                if (chs[i] >= 'A' && chs[i] <= 'Z') {
                    chs[i] = (char)(chs[i] + diff);
                }
            }
            return String.valueOf(chs);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("hello", s.toLowerCase("Hello"));
        Assert.assertEquals("here", s.toLowerCase("here"));
        Assert.assertEquals("lovely", s.toLowerCase("LOVELY"));
        Assert.assertEquals("al&phabet", s.toLowerCase("al&phaBET"));
    }
}
