package redo.p1300_1399;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1337  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1337 {

    static//

    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            Data[] datas = new Data[mat.length];
            for (int i = 0; i < mat.length; ++i) {
                datas[i] = new Data(count(mat[i]), i);
            }

            Comparator<Data> comparator = (a, b) -> {
                if (a.val == b.val) {
                    return Integer.compare(a.index, b.index);
                }
                return Integer.compare(a.val, b.val);
            };

            Data[] minK = minK(datas, k, comparator);
            Arrays.sort(minK, comparator);
            int[] ans = new int[k];
            for (int i = 0; i < k; ++i) {
                ans[i] = minK[i].index;
            }
            return ans;
        }

        static class Data {
            int val;
            int index;

            Data(int val, int index) {
                super();
                this.val = val;
                this.index = index;
            }
        }

        @SuppressWarnings("unchecked")
        public static <T> T[] minK(T[] arr, int k, Comparator<T> comparator) {

            if (arr.length == 0) {
                return (T[])new Object[0];
            }

            int low = 0, high = arr.length - 1;

            int pviotIndex = partition(arr, low, high, comparator);

            while (pviotIndex != k && pviotIndex != k - 1) {
                if (pviotIndex > k) {
                    high = pviotIndex - 1;
                } else {
                    low = pviotIndex + 1;
                }
                pviotIndex = partition(arr, low, high, comparator);
            }

            return Arrays.copyOf(arr, k);
        }

        public static <T> int partition(T[] arr, int low, int high, Comparator<T> comparator) {
            T pivot = arr[low];// 取最低位为主元
            while (low < high) {
                while (low < high && comparator.compare(arr[high], pivot) >= 0) {
                    --high;
                }
                arr[low] = arr[high];
                while (low < high && comparator.compare(arr[low], pivot) <= 0) {
                    ++low;
                }
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            return low;
        }

        private int count(int[] nums) {
            int low = 0, high = nums.length;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] == 1) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 0, 3},
            s.kWeakestRows(Arrs.build2D("[[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]]"), 3));
        Assert.assertArrayEquals(new int[] {0, 2},
            s.kWeakestRows(Arrs.build2D("[[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]]"), 2));
    }

}
