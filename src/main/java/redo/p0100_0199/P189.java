package redo.p0100_0199;

/**  
 * @ClassName: P189  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P189 {

    static//

    class Solution {
        public void rotate(int[] nums, int k) {
            arrayRotationBackward(nums, 0, nums.length, k);
        }

        public static void arrayRotationBackward(int[] array, int from,
            int length, int k) {
            k %= length;
            int mid = from + length - k;
            rotate(array, from, mid, from + length);
        }

        public static void rotate(int[] array, int from, int mid, int to) {
            reverse(array, from, mid - 1);
            reverse(array, mid, to - 1);
            reverse(array, from, to - 1);
        }

        public static void reverse(int[] array, int from, int to) {
            for (; from < to; ++from, --to) {
                swap(array, from, to);
            }
        }

        public static void swap(int[] array, int x, int y) {
            int num = array[x];
            array[x] = array[y];
            array[y] = num;
        }
    }

}
