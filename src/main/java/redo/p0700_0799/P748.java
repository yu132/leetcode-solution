package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P748  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P748 {

    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] templete = new int[26];
            for (char ch : licensePlate.toCharArray()) {
                if (Character.isLetter(ch)) {
                    ++templete[Character.toLowerCase(ch) - 'a'];
                }
            }

            String ans = null;

            l:
            for (String str : words) {
                int[] count = new int[26];
                for (char ch : str.toCharArray()) {
                    ++count[ch - 'a'];
                }
                for (int i = 0; i < 26; ++i) {
                    if (templete[i] > count[i]) {
                        continue l;
                    }
                }
                if (ans == null || str.length() < ans.length()) {
                    ans = str;
                }
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("steps",
            s.shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"}));

        Assert.assertEquals("pest",
            s.shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "show"}));
    }

}
