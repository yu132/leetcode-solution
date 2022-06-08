package redo.p0400_0499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P467  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月19日  
 *  
 */
public class P467 {

    class Solution {
        public int findSubstringInWraproundString(String p) {

            int len = 0;
            char last = '\0';

            int count = 0;

            boolean[][] visited = new boolean[26][26];

            for (char ch : p.toCharArray()) {
                if (last + 1 == ch) {
                    ++len;
                    last = ch;
                    if (last == 'z') {
                        last = 'a' - 1;
                    }
                } else {
                    if (last != '\0') {
                        int high = last - 'a' + 1;
                        count +=
                            count((high - len + 26) % 26, high % 26, visited);
                    }
                    len = 1;
                    last = ch;
                    if (last == 'z') {
                        last = 'a' - 1;
                    }
                }
            }

            int high = last - 'a' + 1;
            count += count((high - len + 26) % 26, high % 26, visited);

            return count;
        }

        int count(int low, int high, boolean[][] visited) {
            if (low == high) {
                return 0;
            }
            if (low == 26) {
                low = 0;
            } else if (high == -1) {
                high = 25;
            }

            if (visited[low][high]) {
                return 0;
            }
            visited[low][high] = true;
            int count = 1;
            count += count(low + 1, high, visited);
            count += count(low, high - 1, visited);
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(3, s.findSubstringInWraproundString("abab"));
        Assert.assertEquals(6, s.findSubstringInWraproundString("zab"));
    }

}
