package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1415  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1415 {

    class Solution {

        int count;
        String ans;

        public String getHappyString(int n, int k) {
            count = k;
            ans = "";
            backtrack(0, '\0', new char[n]);
            return ans;
        }

        boolean backtrack(int index, char last, char[] ch) {
            if (index == ch.length) {
                --count;
                if (count == 0) {
                    ans = String.valueOf(ch);
                    return true;
                }
                return false;
            }
            if (bt(index, last, ch, 'a') || bt(index, last, ch, 'b') || bt(index, last, ch, 'c')) {
                return true;
            }
            return false;
        }

        private boolean bt(int index, char last, char[] ch, char c) {
            if (last != c) {
                ch[index] = c;
                return backtrack(index + 1, c, ch);
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("c", s.getHappyString(1, 3));
        Assert.assertEquals("", s.getHappyString(1, 4));
        Assert.assertEquals("cab", s.getHappyString(3, 9));
        Assert.assertEquals("", s.getHappyString(2, 7));
        Assert.assertEquals("abacbabacb", s.getHappyString(10, 100));
    }

}
