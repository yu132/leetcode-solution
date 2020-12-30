package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P917  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月24日  
 *  
 */
public class P917 {

    class Solution {
        public String reverseOnlyLetters(String S) {
            int low = 0, high = S.length() - 1;
            char[] chs = S.toCharArray();
            while (low < high) {
                while (low < high && !Character.isLetter(chs[low])) {
                    ++low;
                }
                while (low < high && !Character.isLetter(chs[high])) {
                    --high;
                }
                char temp = chs[low];
                chs[low] = chs[high];
                chs[high] = temp;
                ++low;
                --high;
            }
            return String.valueOf(chs);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("dc-ba", s.reverseOnlyLetters("ab-cd"));
        Assert.assertEquals("j-Ih-gfE-dCba", s.reverseOnlyLetters("a-bC-dEf-ghIj"));
        Assert.assertEquals("Qedo1ct-eeLg=ntse-T!", s.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

}
