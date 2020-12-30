package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1576  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1576 {

    class Solution {
        public String modifyString(String s) {
            s = '0' + s + '0';
            char[] chs = s.toCharArray();
            for (int i = 1; i < chs.length - 1; ++i) {
                if (chs[i] == '?') {
                    if (chs[i - 1] != 'a' && chs[i + 1] != 'a') {
                        chs[i] = 'a';
                    } else if (chs[i - 1] != 'b' && chs[i + 1] != 'b') {
                        chs[i] = 'b';
                    } else {
                        chs[i] = 'c';
                    }
                }
            }
            return String.copyValueOf(chs, 1, chs.length - 2);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("azs", s.modifyString("?zs"));
        Assert.assertEquals("ubvaw", s.modifyString("ubv?w"));
        Assert.assertEquals("jaqgacb", s.modifyString("j?qg??b"));
        Assert.assertEquals("abywaipkja", s.modifyString("??yw?ipkj?"));
    }

}
