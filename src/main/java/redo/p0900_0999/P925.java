package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P925  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月24日  
 *  
 */
public class P925 {

    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int nameIndex = 0, typedIndex = 0;
            while (nameIndex < name.length() && typedIndex < typed.length()) {
                if (name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                    ++nameIndex;
                    ++typedIndex;
                } else {
                    if (typedIndex == 0 || typed.charAt(typedIndex) != typed.charAt(typedIndex - 1)) {
                        return false;
                    }
                    ++typedIndex;
                }
            }
            while (typedIndex < typed.length()) {
                if (typedIndex == 0 || typed.charAt(typedIndex) != typed.charAt(typedIndex - 1)) {
                    return false;
                }
                ++typedIndex;
            }
            return nameIndex == name.length();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isLongPressedName("alex", "aaleex"));
        Assert.assertEquals(true, s.isLongPressedName("alex", "aaleexxxx"));
        Assert.assertEquals(false, s.isLongPressedName("saeed", "ssaaedd"));
        Assert.assertEquals(true, s.isLongPressedName("leelee", "lleeelee"));
        Assert.assertEquals(true, s.isLongPressedName("laiden", "laiden"));
        Assert.assertEquals(false, s.isLongPressedName("a", "b"));
        Assert.assertEquals(false, s.isLongPressedName("aaa", "b"));
        Assert.assertEquals(false, s.isLongPressedName("alex", "alexa"));
        Assert.assertEquals(false, s.isLongPressedName("alex", "ale"));
    }

}
