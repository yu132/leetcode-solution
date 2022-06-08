package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1170  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class P1170 {

    class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] greater = new int[12];
            for (String str : words) {
                int count = countMinChCount(str);
                ++greater[count];
            }
            for (int i = 10; i >= 1; --i) {
                greater[i - 1] += greater[i];
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                ans[i] = greater[countMinChCount(queries[i]) + 1];
            }
            return ans;
        }

        private int countMinChCount(String str) {
            char min = str.charAt(0);
            int count = 1;
            for (int i = 1; i < str.length(); ++i) {
                if (str.charAt(i) < min) {
                    min = str.charAt(i);
                    count = 1;
                } else if (str.charAt(i) == min) {
                    ++count;
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1}, s.numSmallerByFrequency(new String[] {"cbd"}, new String[] {"zaaaz"}));
        Assert.assertArrayEquals(new int[] {1, 2},
            s.numSmallerByFrequency(new String[] {"bbb", "cc"}, new String[] {"a", "aa", "aaa", "aaaa"}));

    }

}
