package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P912  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P912 {

    static//

    class Solution {
        public int[] sortArray(int[] nums) {
            countSort(new IntMockArrayImpl(nums), -50000, 50001);
            return nums;
        }

        public static void countSort(IntMockArray arr, int start, int end) {
            int[] count = count(arr, start, end);

            for (int i = 0, index = 0; i < end - start; ++i) {
                for (int j = 0; j < count[i]; ++j) {
                    arr.set(index++, start + i);
                }
            }
        }

        public static int[] count(IntMockArray nums, int start, int end) {
            int[] count = new int[end - start];
            for (int i = 0; i < nums.size(); ++i) {
                ++count[nums.get(i) - start];
            }
            return count;
        }

        static class IntMockArrayImpl implements IntMockArray {

            int[] arr;

            public IntMockArrayImpl(int[] arr) {
                super();
                this.arr = arr;
            }

            @Override
            public int size() {
                return arr.length;
            }

            @Override
            public int get(int index) {
                return arr[index];
            }

            @Override
            public int set(int index, int val) {
                return arr[index] = val;
            }

        }

        static interface IntMockArray {
            int size();

            int get(int index);

            int set(int index, int val);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 2, 3, 5}, s.sortArray(new int[] {5, 2, 3, 1}));
        Assert.assertArrayEquals(new int[] {0, 0, 1, 1, 2, 5}, s.sortArray(new int[] {5, 1, 1, 2, 0, 0}));
    }

}
