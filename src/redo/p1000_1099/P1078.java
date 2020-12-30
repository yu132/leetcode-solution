package redo.p1000_1099;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1078  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1078 {

    class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            String[] sp = text.split(" ");
            List<String> ans = new ArrayList<>();
            for (int i = 2; i < sp.length; ++i) {
                if (sp[i - 2].equals(first) && sp[i - 1].equals(second)) {
                    ans.add(sp[i]);
                }
            }
            return ans.toArray(new String[0]);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new String[] {"girl", "student"},
            s.findOcurrences("alice is a good girl she is a good student", "a", "good"));
        Assert.assertArrayEquals(new String[] {"we", "rock"},
            s.findOcurrences("we will we will rock you", "we", "will"));
    }

}
