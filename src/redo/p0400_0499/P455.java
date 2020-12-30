package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Test;

/**  
 * @ClassName: P455  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P455 {

    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int gIndex = g.length - 1, sIndex = s.length - 1, ans = 0;

            while (sIndex >= 0 && gIndex >= 0) {
                if (s[sIndex] >= g[gIndex]) {
                    ++ans;
                    --sIndex;
                }
                --gIndex;
            }

            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1}));
        assertEquals(2, s.findContentChildren(new int[] {1, 2}, new int[] {1, 2, 3}));
    }

}
