package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: P506  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P506 {

    class Solution {

        private class Data {
            int val;
            int index;

            Data(int val, int index) {
                super();
                this.val = val;
                this.index = index;
            }
        }

        public String[] findRelativeRanks(int[] nums) {
            List<Data> list = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                list.add(new Data(nums[i], i));
            }
            Collections.sort(list, (a, b) -> Integer.compare(b.val, a.val));
            String[] ans = new String[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                Data data = list.get(i);
                ans[data.index] = get(i + 1);
            }
            return ans;
        }

        private String get(int index) {
            if (index > 3) {
                return String.valueOf(index);
            }
            switch (index) {
                case 1:
                    return "Gold Medal";
                case 2:
                    return "Silver Medal";
                case 3:
                    return "Bronze Medal";
            }
            throw new RuntimeException("unreachable");
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new String[] {"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"},
            s.findRelativeRanks(new int[] {5, 4, 3, 2, 1}));
    }

}
