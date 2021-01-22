package redo.p1000_1099;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1079  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月17日  
 *  
 */
public class P1079 {

    class Solution {

        int n, ans;

        public int numTilePossibilities(String tiles) {
            n = tiles.length();
            ans = 0;
            char[] chs = tiles.toCharArray();
            Arrays.sort(chs);
            backtrack(0, 0, new boolean[n], chs);
            return ans;
        }

        public void backtrack(int index, int bannedIndex, boolean[] used, char[] chs) {
            if (index == n) {
                return;
            }
            for (int i = 0; i < n; ++i) {
                if (i != 0 && chs[i - 1] == chs[i]) {
                    if (used[i - 1] && !used[i]) {
                        used[i] = true;
                        ++ans;
                        backtrack(index + 1, bannedIndex, used, chs);
                        used[i] = false;
                    }
                } else {
                    if (!used[i]) {
                        used[i] = true;
                        ++ans;
                        backtrack(index + 1, bannedIndex, used, chs);
                        used[i] = false;
                    }
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(8, s.numTilePossibilities("AAB"));
        Assert.assertEquals(188, s.numTilePossibilities("AAABBC"));
    }
}
