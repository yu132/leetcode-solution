/**
 * @Title: _1313.java
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
 * @ClassName: _1313
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月28日
 * 
 */
public class _1313 {

    class Solution {
        public int[] decompressRLElist(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i += 2) {
                count += nums[i];
            }
            int[] arr   = new int[count];
            int   index = 0;
            for (int i = 0; i < nums.length; i += 2) {
                for (int j = 0; j < nums[i]; ++j) {
                    arr[index++] = nums[i + 1];
                }
            }
            return arr;
        }
    }

}
