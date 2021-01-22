package redo.p1100_1199;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1138  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1138 {

    static//

    class Solution {

        private final static Map<Character, int[]> MAPPING;

        static {
            MAPPING = new HashMap<>();
            for (int i = 0; i < 26; ++i) {
                MAPPING.put((char)(i + 'a'), new int[] {i / 5, i % 5});
            }
        }

        public String alphabetBoardPath(String target) {
            int x = 0, y = 0;
            StringBuilder buf = new StringBuilder(10 * target.length());
            for (char ch : target.toCharArray()) {
                int[] tarIndex = MAPPING.get(ch);

                while (y > tarIndex[1]) {
                    --y;
                    buf.append('L');
                }

                while (x > tarIndex[0]) {
                    --x;
                    buf.append('U');
                }

                while (x < tarIndex[0]) {
                    ++x;
                    buf.append('D');
                }

                while (y < tarIndex[1]) {
                    ++y;
                    buf.append('R');
                }

                buf.append('!');
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("DDR!UURRR!!DDD!", s.alphabetBoardPath("leet"));
        Assert.assertEquals("RR!DDRR!LUU!R!", s.alphabetBoardPath("code"));
        Assert.assertEquals("RRRR!LLLLDDDDD!UUUUURRRR!LLLLDDDDD!", s.alphabetBoardPath("ezez"));
    }

}
