package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P921  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P921 {

    class Solution {
        public int minAddToMakeValid(String S) {
            int l = 0, count = 0;
            for (char ch : S.toCharArray()) {
                if (ch == '(') {
                    ++l;
                } else {
                    if (l > 0) {
                        --l;
                    } else {
                        ++count;
                    }
                }
            }
            return count + l;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minAddToMakeValid("())"));
        Assert.assertEquals(3, s.minAddToMakeValid("((("));
        Assert.assertEquals(0, s.minAddToMakeValid("()"));
        Assert.assertEquals(4, s.minAddToMakeValid("()))(("));
    }

}
