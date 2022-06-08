package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P796  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P796 {

    class Solution {
        public boolean rotateString(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            } else if (A.equals(B)) {
                return true;
            }
            l:
            for (int i = 0; i < A.length(); ++i) {
                for (int j = 0; j < B.length(); ++j) {
                    if (A.charAt(j) != B.charAt((i + j) % B.length())) {
                        continue l;
                    }
                }
                return true;
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.rotateString("abcde", "cdeab"));
        Assert.assertEquals(false, s.rotateString("abcde", "abced"));
    }

}
