package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P844  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P844 {

    class Solution {
        public boolean backspaceCompare(String S, String T) {
            char[] ch1 = new char[S.length()], ch2 = new char[T.length()];
            int index1 = deal(ch1, S), index2 = deal(ch2, T);
            if (index1 != index2) {
                return false;
            }
            for (int i = 0; i < index1; ++i) {
                if (ch1[i] != ch2[i]) {
                    return false;
                }
            }
            return true;
        }

        private int deal(char[] chs, String S) {
            int index = 0;
            for (char ch : S.toCharArray()) {
                if (ch == '#') {
                    if (index > 0) {
                        --index;
                    }
                } else {
                    chs[index++] = ch;
                }
            }
            return index;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.backspaceCompare("ab#c", "ad#c"));
        Assert.assertEquals(true, s.backspaceCompare("ab##", "c#d#"));
        Assert.assertEquals(true, s.backspaceCompare("a##c", "#a#c"));
        Assert.assertEquals(false, s.backspaceCompare("a#c", "b"));
    }

}
