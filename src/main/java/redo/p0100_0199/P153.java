package redo.p0100_0199;

/**  
 * @ClassName: P153  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P153 {

    class Solution {
        public int findMin(int[] nums) {
            return minArray(nums);
        }

        public int minArray(int[] numbers) {
            int low = 0, high = numbers.length - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (numbers[mid] < numbers[high]) {
                    high = mid;
                } else if (numbers[mid] > numbers[high]) {
                    low = mid + 1;
                } else {
                    --high;
                }
            }
            return numbers[low];
        }
    }

}
