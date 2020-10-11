/**
 * @Title: _1299.java
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
 * @ClassName: _1299
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 * 
 */
public class _1299 {

    class Solution {
        public int[] replaceElements(int[] arr) {
            int maxNow = -1;
            for (int i = arr.length - 1; i >= 0; --i) {
                int temp = arr[i];
                arr[i] = maxNow;
                maxNow = Math.max(maxNow, temp);
            }
            return arr;
        }
    }

}
