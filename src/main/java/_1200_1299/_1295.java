/**
 * @Title: _1295.java
 *
 * @Package _1200_1299
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 *
 */
package _1200_1299;

/**
 * @ClassName: _1295
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 * 
 */
public class _1295 {

    class Solution {
        public int findNumbers(int[] nums) {

            int count = 0;

            for (int each : nums) {
                int digits = 0;
                while (each != 0) {
                    ++digits;
                    each /= 10;
                }
                if (digits % 2 == 0) {
                    ++count;
                }
            }

            return count;
        }
    }

}
