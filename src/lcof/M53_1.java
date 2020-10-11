package lcof;

/**  
 * @ClassName: M53_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class M53_1 {

    class Solution {
        public int search(int[] nums, int target) {
            return upperBound(nums, 0, nums.length, target) - lowerBound(nums, 0, nums.length, target);
        }

        /**
         * 下界，即为第一个大于等于key的位置，不存在的话返回长度
         * 
         * @param array     需要查找的数组
         * @param from      查找的起始位置（包括）
         * @param size      查找的长度
         * @param key       需要查找界的key
         * @return          下界，如果不存在大于等于key的值，则返回数组长度
         */
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

        /**
         * 上界，即为第一个大于key的值，不存在的话返回长度
         * 
         * @param array     需要查找的数组
         * @param from      查找的起始位置（包括）
         * @param size      查找的长度
         * @param key       需要查找界的key
         * @return          上界，如果不存在大于key的值，则返回数组长度
         */
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
