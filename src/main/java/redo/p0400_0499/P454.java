package redo.p0400_0499;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P454  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P454 {

    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < A.length; ++i) {
                for (int j = 0; j < B.length; ++j) {
                    plus1(map, A[i] + B[j]);
                }
            }

            int count = 0;

            for (int i = 0; i < C.length; ++i) {
                for (int j = 0; j < D.length; ++j) {
                    count += map.getOrDefault(-C[i] - D[j], 0);
                }
            }

            return count;
        }

        void plus1(Map<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
    }

    // class Solution {
    // public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    //
    // if (A.length == 0 || B.length == 0 || C.length == 0
    // || D.length == 0) {
    // return 0;
    // }
    //
    // Arrays.sort(C);
    // Arrays.sort(D);
    //
    // int[] cc = new int[C.length], cd = new int[D.length];
    //
    // int cl = unique(C, cc), dl = unique(D, cd);
    //
    // int count = 0;
    //
    // for (int i = 0; i < A.length; ++i) {
    // for (int j = 0; j < B.length; ++j) {
    // count += find(-A[i] - B[j], C, D, cl, dl, cc, cd);
    // }
    // }
    //
    // return count;
    // }
    //
    // int unique(int[] arr, int[] count) {
    // int i2i = 1, i2c = 1;
    //
    // count[0] = 1;
    //
    // for (; i2c < arr.length; ++i2c) {
    // if (arr[i2c] == arr[i2i - 1]) {
    // ++count[i2i - 1];
    // } else {
    // arr[i2i] = arr[i2c];
    // count[i2i++] = 1;
    // }
    // }
    //
    // return i2i;
    // }
    //
    // int find(int target, int[] a, int[] b, int al, int bl, int[] ca,
    // int[] cb) {
    // int low = 0, high = bl - 1;
    //
    // int count = 0;
    //
    // while (low < al && high >= 0) {
    // int sum = a[low] + b[high];
    //
    // if (sum > target) {
    // --high;
    // } else if (sum < target) {
    // ++low;
    // } else {
    // count += ca[low] * cb[high];
    // ++low;
    // }
    // }
    //
    // return count;
    // }
    // }

}
