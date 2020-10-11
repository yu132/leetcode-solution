package lcof;

/**  
 * @ClassName: M21  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M21 {

    class Solution {
        public int[] exchange(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                while (low < high && nums[low] % 2 == 1) {
                    ++low;
                }
                while (low < high && nums[high] % 2 == 0) {
                    --high;
                }
                int temp = nums[low];
                nums[low]  = nums[high];
                nums[high] = temp;
            }
            return nums;
        }
    }

}
