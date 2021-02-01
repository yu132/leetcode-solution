package redo.p0800_0899;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P870  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月27日  
 *  
 */
public class P870 {

    static//

    class Solution {
        public int[] advantageCount(int[] A, int[] B) {

            int n = A.length;

            Arrays.sort(A);
            int[] indexesB = indexSort(B);
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            int i = n - 1;
            for (int j = n - 1; i >= 0; --i) {
                while (j >= 0 && A[i] <= B[indexesB[j]]) {
                    --j;
                }
                if (j < 0) {
                    break;
                }
                ans[indexesB[j--]] = A[i];
            }
            for (int j = 0; j < n; ++j) {
                if (ans[j] == -1) {
                    ans[j] = A[i--];
                }
            }

            return ans;
        }

        static int[] indexSort(int[] arr) {
            int[] indexes = new int[arr.length];
            Arrays.setAll(indexes, (x) -> x);
            sort(indexes, (i, j) -> Integer.compare(arr[i], arr[j]));
            return indexes;
        }

        public static void sort(int[] arr, Comparator<Integer> comparator) {
            Integer[] copy = new Integer[arr.length];
            for (int i = 0; i < arr.length; ++i) {
                copy[i] = arr[i];
            }
            Arrays.sort(copy, comparator);
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = copy[i];
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 11, 7, 15},
            s.advantageCount(new int[] {2, 7, 11, 15}, new int[] {1, 10, 4, 11}));
        Assert.assertArrayEquals(new int[] {24, 32, 8, 12},
            s.advantageCount(new int[] {12, 24, 8, 32}, new int[] {13, 25, 32, 11}));
        Assert.assertArrayEquals(new int[] {0}, s.advantageCount(new int[] {0}, new int[] {0}));
    }

}
