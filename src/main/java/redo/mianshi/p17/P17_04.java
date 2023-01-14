package redo.mianshi.p17;

/**  
 * @ClassName: P17_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P17_04 {

    class Solution {
        public int missingNumber(int[] nums) {

            int n = nums.length;

            for (int i = 0; i < nums.length; ++i) {
                int swap = nums[i];
                nums[i] = -1;
                while (swap != -1 && swap != n) {
                    int temp = swap;
                    swap = nums[temp];
                    nums[temp] = temp;
                }
            }

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != i) {
                    return i;
                }
            }

            return n;
        }
    }

}
