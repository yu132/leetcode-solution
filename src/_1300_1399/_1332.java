/**
 * @Title: _1332.java
 *
 * @Package _1300_1399
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 *
 */
package _1300_1399;

/**
 * @ClassName: _1332
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 * 
 */
public class _1332 {
    class Solution {
        public int removePalindromeSub(String s) {

            if (s.length() == 0) {
                return 0;
            }

            boolean temp = true;
            for (int i = 0; i < s.length() / 2; ++i) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return 2;
                }
            }

            return 1;

        }
    }
}
