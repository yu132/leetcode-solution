package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1147  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P1147 {

    class Solution {
        public int longestDecomposition(String text) {

            int n = text.length(), count = 0;

            if (n == 2) {
                if (text.charAt(0) != text.charAt(1)) {
                    return 1;
                } else {
                    return 2;
                }
            }

            int left = 0, right = text.length() - 1;

            for (; left < right; ++left) {

                if (text.charAt(left) == text.charAt(right)) {
                    int len = left - (n - right - 1) + 1;
                    boolean flag = true;
                    for (int i = 0; i < len; ++i) {
                        if (text.charAt(left - i) != text.charAt(right - i)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        right = right - len;
                        ++count;
                    }
                }
            }

            if (n % 2 == 0 && left == n / 2) {
                return 2 * count;
            } else {
                return 2 * count + 1;
            }

        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(12, s.longestDecomposition("abcaaaaaaaabca"));
    }

    // abcaaaaaaaabca;
}
