/**
 * @Title: _1304.java
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
 * @ClassName: _1304
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 * 
 */
public class _1304 {

    class Solution {
        public int[] sumZero(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n / 2; ++i) {
                arr[i]         = -i - 1;
                arr[n - i - 1] = i + 1;
            }
            if (n % 2 != 0) {
                arr[n / 2] = 0;
            }
            return arr;
        }
    }

}
