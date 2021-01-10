package redo.p1300_1399;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1387  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1387 {

    static//

    class Solution {

        Map<Integer, Integer> map = new HashMap<>();

        public int getKth(int lo, int hi, int k) {
            Data[] ans = new Data[hi - lo + 1];
            for (int i = lo; i <= hi; ++i) {
                ans[i - lo] = new Data(i, dp(i));
            }
            // Arrays.sort(ans, (a, b) -> Integer.compare(a.weight, b.weight));
            // return ans[k - 1].val;
            return minK(ans, k, (a, b) -> {
                if (a.weight == b.weight) {
                    return Integer.compare(a.val, b.val);
                }
                return Integer.compare(a.weight, b.weight);
            }).val;
        }

        public static <T> T minK(T[] arr, int k, Comparator<T> comparator) {

            if (arr.length == 0) {
                return null;
            }

            int low = 0, high = arr.length - 1;

            int pviotIndex = partition(arr, low, high, comparator);

            while (pviotIndex != k - 1) {
                if (pviotIndex > k - 1) {
                    high = pviotIndex - 1;
                } else {
                    low = pviotIndex + 1;
                }
                pviotIndex = partition(arr, low, high, comparator);
            }

            return arr[k - 1];
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

        class Data {
            int val;
            int weight;

            public Data(int val, int weight) {
                super();
                this.val = val;
                this.weight = weight;
            }
        }

        public int dp(int n) {
            if (n == 1) {
                return 0;
            }
            if (!map.containsKey(n)) {
                int ans;
                if (n % 2 == 0) {
                    ans = dp(n / 2) + 1;
                } else {
                    ans = dp(n * 3 + 1) + 1;
                }
                map.put(n, ans);
                return ans;
            }
            return map.get(n);
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(13, s.getKth(12, 15, 2));
        Assert.assertEquals(1, s.getKth(1, 1, 1));
        Assert.assertEquals(7, s.getKth(7, 11, 4));
        Assert.assertEquals(13, s.getKth(10, 20, 5));
        Assert.assertEquals(570, s.getKth(1, 1000, 777));
        Assert.assertEquals(39, s.getKth(1, 43, 40));
    }

}
