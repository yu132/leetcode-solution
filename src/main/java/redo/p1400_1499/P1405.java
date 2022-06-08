package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1405  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1405 {

    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            int aa = 0, bb = 0, cc = 0;
            StringBuilder buf = new StringBuilder(a + b + c);
            while (a > 0 || b > 0 || c > 0) {
                if (a >= b && a >= c) {
                    if (aa == 2) {
                        if (b == 0 && c == 0) {
                            break;
                        }
                        if (b >= c) {
                            buf.append('b');
                            --b;
                            ++bb;
                        } else {
                            buf.append('c');
                            --c;
                            ++cc;
                        }
                        aa = 0;
                    } else {
                        bb = 0;
                        cc = 0;
                        ++aa;
                        --a;
                        buf.append('a');
                    }
                } else if (b >= c) {// b>a
                    if (bb == 2) {
                        if (a == 0 && c == 0) {
                            break;
                        }
                        if (a >= c) {
                            buf.append('a');
                            --a;
                            ++aa;
                        } else {
                            buf.append('c');
                            --c;
                            ++cc;
                        }
                        bb = 0;
                    } else {
                        aa = 0;
                        cc = 0;
                        --b;
                        ++bb;
                        buf.append('b');
                    }
                } else {// c>a && c>b
                    if (cc == 2) {
                        if (a == 0 && b == 0) {
                            break;
                        }
                        if (a >= b) {
                            buf.append('a');
                            --a;
                            ++aa;
                        } else {
                            buf.append('b');
                            --b;
                            ++bb;
                        }
                        cc = 0;
                    } else {
                        aa = 0;
                        bb = 0;
                        --c;
                        ++cc;
                        buf.append('c');
                    }
                }
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("ccaccbcc", s.longestDiverseString(1, 1, 7));
        Assert.assertEquals("ababc", s.longestDiverseString(2, 2, 1));
        Assert.assertEquals("aabaa", s.longestDiverseString(7, 1, 0));
    }

}
