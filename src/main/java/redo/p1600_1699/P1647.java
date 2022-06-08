package redo.p1600_1699;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1647  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1647 {

    class Solution {
        public int minDeletions(String s) {
            int[] count = countLowercaseLetters(s);
            Set<Integer> feq = new HashSet<>(40);
            int ans = 0;

            outter:
            for (int num : count) {
                if (num == 0) {
                    continue;
                }
                while (feq.contains(num)) {
                    if (num == 0) {
                        continue outter;
                    }
                    --num;
                    ++ans;
                }
                feq.add(num);
            }
            return ans;
        }

        public int[] countLowercaseLetters(String str) {
            int[] chs = new int[26];
            for (char ch : str.toCharArray()) {
                ++chs[ch - 'a'];
            }
            return chs;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.minDeletions("aab"));
        Assert.assertEquals(2, s.minDeletions("aaabbbcc"));
        Assert.assertEquals(2, s.minDeletions("ceabaacb"));
        Assert.assertEquals(2, s.minDeletions("bbcebab"));
    }

}
