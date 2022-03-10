package redo.p0400_0499;

import org.junit.Assert;
import org.junit.Test;

/***@ClassName: P423  
  *
  * @Description: TODO(这里用一句话描述这个类的作用)  
  *
  * @author 余定邦  
  *
  * @date 2021年3月16日  
  *  
  */
public class P423 {

    class Solution {
        /*
         * 0 zero   z
         * 1 one        o
         * 2 two    w
         * 3 three      h
         * 4 four   u
         * 5 five       f
         * 6 six    x
         * 7 seven      s
         * 8 eight  g
         * 9 nine       
         */
        public String originalDigits(String s) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                ++count[ch - 'a'];
            }
            int[] ans = new int[10];

            minus("zero", 'z', 0, ans, count);
            minus("two", 'w', 2, ans, count);
            minus("four", 'u', 4, ans, count);
            minus("six", 'x', 6, ans, count);
            minus("eight", 'g', 8, ans, count);
            minus("one", 'o', 1, ans, count);
            minus("three", 'h', 3, ans, count);
            minus("five", 'f', 5, ans, count);
            minus("seven", 's', 7, ans, count);
            minus("nine", 'n', 9, ans, count);

            StringBuilder buf = new StringBuilder(s.length() / 3);

            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < ans[i]; ++j) {
                    buf.append(i);
                }
            }

            return buf.toString();
        }

        void minus(String str, char uniqueSign, int val, int[] ans,
            int[] count) {

            while (count[uniqueSign - 'a'] != 0) {
                minus(count, str);
                ++ans[val];
            }
        }

        void minus(int[] count, String str) {
            for (int i = 0; i < str.length(); ++i) {
                --count[str.charAt(i) - 'a'];
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("012", s.originalDigits("owoztneoer"));
    }

}
