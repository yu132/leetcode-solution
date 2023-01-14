package redo.mianshi.p17;

/**  
 * @ClassName: P17_19  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月18日  
 *  
 */
public class P17_19 {

    class Solution {
        public int[] missingTwo(int[] nums) {
            int n = nums.length + 2;

            boolean fn_1 = false;

            for (int i = 0; i < nums.length; ++i) {
                int swap = nums[i];
                nums[i] = -1;
                while (swap > 0 && swap <= n - 2) {
                    int temp = swap;
                    swap = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
                if (swap == n - 1) {
                    fn_1 = true;
                }
            }
            int[] missing = {-1, -1};
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == -1) {
                    if (missing[0] == -1) {
                        missing[0] = i + 1;
                    } else {
                        missing[1] = i + 1;
                        return missing;
                    }
                }
            }
            if (missing[0] != -1) {
                if (fn_1) {
                    missing[1] = n;
                } else {
                    missing[1] = n - 1;
                }
                return missing;
            }

            return new int[] {n - 1, n};
        }
    }

}
