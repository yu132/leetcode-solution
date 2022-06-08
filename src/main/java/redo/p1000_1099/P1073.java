package redo.p1000_1099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1073  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月17日  
 *  
 */
public class P1073 {

    static//

    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int inc = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < Math.max(arr1.length, arr2.length); ++i) {
                int temp = inc + valueOf(arr1, i) + valueOf(arr2, i);
                if (temp == -1) {
                    inc = 1;
                    list.add(1);
                } else if (temp == 0 || temp == 1) {
                    inc = 0;
                    list.add(temp);
                } else if (temp == 2) {
                    inc = -1;
                    list.add(0);
                } else if (temp == 3) {
                    inc = -1;
                    list.add(1);
                }
            }
            if (inc == 1) {
                list.add(1);
            } else if (inc == -1) {
                list.add(1);
                list.add(1);
            }

            while (list.size() > 1 && list.get(list.size() - 1) == 0) {
                list.remove(list.size() - 1);
            }

            return toReverseIntArray(list);
        }

        public static int[] toReverseIntArray(List<Integer> list) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = list.get(arr.length - i - 1);
            }
            return arr;
        }

        public int valueOf(int[] arr, int index) {
            if (index >= arr.length) {
                return 0;
            }
            return arr[arr.length - index - 1];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.addNegabinary(new int[] {1, 1, 1, 1, 1}, new int[] {1, 0, 1})));

        Assert.assertArrayEquals(new int[] {1, 0, 0, 0, 0},
            s.addNegabinary(new int[] {1, 1, 1, 1, 1}, new int[] {1, 0, 1}));

        Assert.assertArrayEquals(new int[] {1, 1, 0, 1, 0}, s.addNegabinary(new int[] {1, 0, 1}, new int[] {1}));

        Assert.assertArrayEquals(new int[] {0}, s.addNegabinary(new int[] {0}, new int[] {0}));

        Assert.assertArrayEquals(new int[] {0}, s.addNegabinary(new int[] {1}, new int[] {1, 1}));

        Assert.assertArrayEquals(new int[] {1, 1, 1, 1, 0}, s.addNegabinary(new int[] {1, 0, 1}, new int[] {1, 0, 1}));

    }

}
