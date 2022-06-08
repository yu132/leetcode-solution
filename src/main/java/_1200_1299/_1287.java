/**
 * @Title: _1287.java
 *
 * @Package _1200_1299
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月7日
 *
 */
package _1200_1299;

/**
 * @ClassName: _1287
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月7日
 * 
 */
public class _1287 {

    class Solution {
        public int findSpecialInteger(int[] arr) {

            int count = 1;
            int cur   = arr[0];

            for (int i = 1; i < arr.length; ++i) {
                if (arr[i] == cur) {
                    ++count;
                } else {
                    if (count > arr.length * 0.25) {
                        return cur;
                    }
                    cur   = arr[i];
                    count = 1;
                }
            }

            return cur;

        }
    }

}
