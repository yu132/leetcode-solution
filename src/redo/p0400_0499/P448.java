package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: P448  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P448 {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {

                // nums[nums[i] - 1] != nums[i]成立时，nums[i]内的内容多余了
                while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != i + 1) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(5, 6), s.findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
    }

}
