package old._1100_1199;

/**  
 * @ClassName: _1150  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1150 {

    class Solution {
        public boolean isMajorityElement(int[] nums, int target) {
            return upperBound(nums, 0, nums.length, target) - lowerBound(nums, 0, nums.length, target) > nums.length
                / 2;
        }

        public int lowerBound(int[] array, int from, int size, int key) {
            int first = from, middle;
            int half, len;
            len = size;

            while (len > 0) {
                half   = len >> 1;
                middle = first + half;
                if (array[middle] < key) {
                    first = middle + 1;
                    len   = len - half - 1; // 在右边子序列中查找
                } else
                    len = half; // 在左边子序列（包含middle）中查找
            }
            return first;
        }

        public int upperBound(int[] array, int from, int size, int key) {
            int first = from, len = size;
            int half, middle;

            while (len > 0) {
                half   = len >> 1;
                middle = first + half;
                if (array[middle] > key) // 中位数大于key,在包含last的左半边序列中查找。
                    len = half;
                else {
                    first = middle + 1;    // 中位数小于等于key,在右半边序列中查找。
                    len   = len - half - 1;
                }
            }
            return first;
        }
    }

}
