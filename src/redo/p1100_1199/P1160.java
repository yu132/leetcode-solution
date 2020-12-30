package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1160  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class P1160 {

    class Solution {
        public int countCharacters(String[] words, String chars) {
            int[] countCh = count(chars);
            int countWordLen = 0;

            outer:
            for (String str : words) {
                int[] strCountCh = count(str);
                for (int i = 0; i < 26; ++i) {
                    if (strCountCh[i] > countCh[i]) {
                        continue outer;
                    }
                }
                countWordLen += str.length();
            }
            return countWordLen;
        }

        private int[] count(String str) {
            int[] countCh = new int[26];
            for (char ch : str.toCharArray()) {
                ++countCh[ch - 'a'];
            }
            return countCh;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.countCharacters(new String[] {"cat", "bt", "hat", "tree"}, "atach"));
        Assert.assertEquals(10, s.countCharacters(new String[] {"hello", "world", "leetcode"}, "welldonehoneyr"));

    }

}
