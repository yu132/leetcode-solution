package redo.p1000_1099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1023  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1023 {

    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {

            List<Boolean> ans = new ArrayList<>(queries.length);

            for (String query : queries) {
                ans.add(match(query, pattern));
            }

            return ans;
        }

        public boolean match(String str, String pattern) {
            int iS = 0, iP = 0;
            while (iS < str.length() && iP < pattern.length()) {
                if (str.charAt(iS) == pattern.charAt(iP)) {
                    ++iS;
                    ++iP;
                } else {
                    if (Character.isUpperCase(str.charAt(iS))) {
                        return false;
                    } else {
                        ++iS;
                    }
                }
            }
            if (iP != pattern.length()) {// pattern没匹配完
                return false;
            }
            while (iS < str.length()) {// pattern已经用完了，但是str还有大写字符
                if (Character.isUpperCase(str.charAt(iS))) {
                    return false;
                }
                ++iS;
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(true, false, true, true, false),
            s.camelMatch(new String[] {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB"));
        Assert.assertEquals(Arrays.asList(true, false, true, false, false),
            s.camelMatch(new String[] {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa"));
        Assert.assertEquals(Arrays.asList(false, true, false, false, false),
            s.camelMatch(new String[] {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT"));
    }

}
