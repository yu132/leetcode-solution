package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**  
 * @ClassName: P349  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P349 {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }
            for (int num : nums2) {
                set2.add(num);
            }
            for (Iterator<Integer> it = set1.iterator(); it.hasNext();) {
                if (!set2.contains(it.next())) {
                    it.remove();
                }
            }
            int[] nums = new int[set1.size()];
            int index = 0;
            for (int num : set1) {
                nums[index++] = num;
            }
            return nums;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2}, s.intersection(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
        assertArrayEquals(new int[] {4, 9}, s.intersection(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}));
    }

}
