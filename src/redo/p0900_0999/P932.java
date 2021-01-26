package redo.p0900_0999;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P932  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P932 {

    class Solution {

        private HashMap<Integer, int[]> map;

        public int[] beautifulArray(int N) {
            map = new HashMap<>();
            return helper(N);
        }

        int[] helper(int N) {
            if (map.containsKey(N)) {
                return map.get(N);
            }

            int[] arr = new int[N];
            if (N == 1) {
                arr[0] = 1;
            } else {
                int index = 0;
                for (int x : helper((N + 1) / 2)) {
                    arr[index++] = 2 * x - 1;
                }
                for (int x : helper(N / 2)) {
                    arr[index++] = 2 * x;
                }
            }

            map.put(N, arr);
            return arr;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 3, 2, 4}, s.beautifulArray(4));
        Assert.assertArrayEquals(new int[] {1, 5, 3, 2, 4}, s.beautifulArray(5));
    }

}
