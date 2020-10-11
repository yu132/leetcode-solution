package lcci.M10;

/**  
 * @ClassName: M10_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * 
 * 思想为先找到插入点，然后再两部分分别二分查找
 *
 * @author 余定邦  
 *
 * @date 2020年3月8日  
 *  
 */
public class M10_03 {

    class Solution {

        public int minArrayIndex(int[] numbers) {
            int low = 0, high = numbers.length - 1;
            while (true) {
                if (low >= high) {
                    return low;
                }
                int mid = (low + high) >>> 1;
                if (numbers[mid] > numbers[high]) {
                    low = mid + 1;
                } else if (numbers[mid] == numbers[high]) {
                    --high;
                } else {
                    high = mid;
                }
            }
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

        public int search(int[] arr, int target) {
            int index = minArrayIndex(arr);
            int i     = lowerBound(arr, 0, index, target);
            if (i != arr.length && arr[i] == target) {
                return i;
            }
            i = lowerBound(arr, index, arr.length - index, target);
            if (i != arr.length && arr[i] == target) {
                return i;
            } else {
                return -1;
            }
        }
    }

}
