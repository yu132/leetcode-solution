package redo.p0300_0399;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**  
 * @ClassName: P384  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P384 {

    class Solution {

        int[] nums, copy;

        public Solution(int[] nums) {
            this.nums = nums;
            copy = Arrays.copyOf(nums, nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            nums = Arrays.copyOf(copy, copy.length);
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            shuffle(nums);
            return nums;
        }

        void shuffle(int[] nums) {
            ThreadLocalRandom r = ThreadLocalRandom.current();
            for (int i = nums.length - 1; i >= 1; --i) {
                int IndexToSwap = r.nextInt(i + 1);
                swap(nums, i, IndexToSwap);
            }
        }

        void swap(int[] array, int x, int y) {
            int num = array[x];
            array[x] = array[y];
            array[y] = num;
        }
    }

}
