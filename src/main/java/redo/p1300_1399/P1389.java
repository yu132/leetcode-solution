package redo.p1300_1399;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1389  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1389 {

    static//

    class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                list.add(index[i], nums[i]);
            }
            return toIntArray(list);
        }

        public static int[] toIntArray(List<Integer> list) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {0, 4, 1, 3, 2},
            s.createTargetArray(new int[] {0, 1, 2, 3, 4}, new int[] {0, 1, 2, 2, 1}));
        Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 4},
            s.createTargetArray(new int[] {1, 2, 3, 4, 0}, new int[] {0, 1, 2, 3, 0}));
        Assert.assertArrayEquals(new int[] {1}, s.createTargetArray(new int[] {1}, new int[] {0}));
    }

}
