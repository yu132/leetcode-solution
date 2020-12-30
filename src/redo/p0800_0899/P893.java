package redo.p0800_0899;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P893  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月23日  
 *  
 */
public class P893 {

    static//

    class Solution {
        public int numSpecialEquivGroups(String[] A) {
            Set<String> set = new HashSet<>(A.length);

            String[] buf = genArr(A);

            for (int i = 0; i < A.length; ++i) {
                set.add(buf[i]);
            }
            return set.size();
        }

        public String[] genArr(String[] A) {
            String[] ans = new String[A.length];
            for (int i = 0; i < A.length; ++i) {
                int[][] buf = new int[2][26];
                for (int j = 0; j < A[i].length(); j += 2) {
                    ++buf[0][A[i].charAt(j) - 'a'];
                }
                for (int j = 1; j < A[i].length(); j += 2) {
                    ++buf[1][A[i].charAt(j) - 'a'];
                }
                ans[i] = Arrays.deepToString(buf);
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.numSpecialEquivGroups(new String[] {"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"}));
        Assert.assertEquals(3, s.numSpecialEquivGroups(new String[] {"abc", "acb", "bac", "bca", "cab", "cba"}));
    }

}
