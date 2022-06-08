package redo.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P38  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P38 {

    class Solution {
        public String[] permutation(String s) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);

            List<String> ans = new ArrayList<>();

            backTrack(0, new char[chs.length], chs, new boolean[chs.length],
                ans);

            return ans.toArray(new String[0]);
        }

        public void backTrack(int index, char[] chNow, char[] chs,
            boolean[] used, List<String> ans) {
            if (index == chNow.length) {
                ans.add(String.valueOf(chNow));
                return;
            }

            for (int i = 0; i < chs.length; ++i) {
                if (!(used[i]
                    || (i != 0 && chs[i] == chs[i - 1] && !used[i - 1]))) {
                    used[i] = true;
                    chNow[index] = chs[i];
                    backTrack(index + 1, chNow, chs, used, ans);
                    used[i] = false;
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(
            new String[] {"abc", "acb", "bac", "bca", "cab", "cba"},
            s.permutation("abc"));

        Assert.assertArrayEquals(new String[] {"aa"}, s.permutation("aa"));
    }

}
