package redo.p1800_1899;

/**  
 * @ClassName: P1876  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1876 {

    class Solution {
        public int countGoodSubstrings(String s) {
            int count = 0;

            for (int i = 2; i < s.length(); ++i) {
                if (s.charAt(i - 2) != s.charAt(i - 1)
                    && s.charAt(i - 2) != s.charAt(i)
                    && s.charAt(i - 1) != s.charAt(i)) {
                    ++count;
                }
            }

            return count;
        }
    }

}
