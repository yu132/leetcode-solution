package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: P228  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P228 {

    class Solution {
        public List<String> summaryRanges(int[] nums) {
            if (nums.length == 0) {
                return Collections.emptyList();
            }
            List<String> ans = new ArrayList<>();
            int start = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] != nums[i - 1] + 1) {
                    ans.add(range(start, nums[i - 1]));
                    start = nums[i];
                }
            }
            ans.add(range(start, nums[nums.length - 1]));
            return ans;
        }

        public String range(int from, int to) {
            if (from == to) {
                return String.valueOf(from);
            }
            return from + "->" + to;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("0->2", "4->5", "7"), s.summaryRanges(new int[] {0, 1, 2, 4, 5, 7}));
        assertEquals(Arrays.asList("0", "2->4", "6", "8->9"), s.summaryRanges(new int[] {0, 2, 3, 4, 6, 8, 9}));
        assertEquals(Arrays.asList("0"), s.summaryRanges(new int[] {0}));

    }

}
