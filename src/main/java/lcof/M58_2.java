package lcof;

import java.util.Arrays;

/**  
 * @ClassName: M58_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月23日  
 *  
 */
public class M58_2 {

    class Solution {
        public String reverseLeftWords(String s, int n) {

            n %= s.length();

            char[] chs = s.toCharArray();

            reverse(chs, 0, n);
            reverse(chs, n, s.length());
            reverse(chs, 0, s.length());

            return String.valueOf(chs);
        }

        public void reverse(char[] chs, int from, int to) {
            for (int i = from, mid = (from + to) >>> 1; i < mid; ++i) {
                char temp = chs[i];
                chs[i]                 = chs[to + from - i - 1];
                chs[to + from - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] chs = "fwasoefh".toCharArray();
        new M58_2().new Solution().reverse(chs, 2, "fwasoefh".length());
        System.out.println(Arrays.toString(chs));
    }

}
