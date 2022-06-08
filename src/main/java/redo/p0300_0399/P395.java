package redo.p0300_0399;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P395  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P395 {

    class Solution {
        public int longestSubstring(String s, int k) {
            return helper(0, s.length(), s, k);
        }

        int helper(int low, int high, String s, int k) {
            if (low + k - 1 >= high) {
                return 0;
            }
            int[] count = new int[26];
            for (int i = low; i < high; ++i) {
                ++count[s.charAt(i) - 'a'];
            }
            Set<Character> set = new HashSet<>();

            for (int i = 0; i < 26; ++i) {
                if (count[i] < k && count[i] != 0) {
                    set.add((char)(i + 'a'));
                }
            }

            if (set.isEmpty()) {
                return high - low;
            }

            int start = low, max = 0;
            for (int i = low; i < high; ++i) {
                if (set.contains(s.charAt(i))) {
                    max = Math.max(max, helper(start, i, s, k));
                    start = i + 1;
                }
            }
            max = Math.max(max, helper(start, high, s, k));

            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.longestSubstring("aaabb", 3));
    }

}
