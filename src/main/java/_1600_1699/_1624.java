package _1600_1699;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: _1624  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月14日  
 *  
 */
public class _1624 {

    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int[] charMaxIndex = new int[26];
            int max = 0;
            for (int i = 0; i < s.length(); ++i) {
                charMaxIndex[s.charAt(i) - 'a'] = i;
            }
            for (int i = 0; i < s.length(); ++i) {
                max = Math.max(max, charMaxIndex[s.charAt(i) - 'a'] - i);
            }
            return max - 1;
        }
    }

    @Test
    public void test() {
        assertEquals(4, new Solution().maxLengthBetweenEqualCharacters("cabbac"));
    }

    @Test
    public void test2() {
        assertEquals(-1, new Solution().maxLengthBetweenEqualCharacters("cbzxy"));
    }

}
