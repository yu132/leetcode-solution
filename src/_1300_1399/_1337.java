package _1300_1399;

import java.util.Arrays;

/**  
 * @ClassName: _1337  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月10日  
 *  
 */
public class _1337 {

    class Solution {

        private class Node {
            int num;
            int index;

            public Node(int num, int index) {
                super();
                this.num   = num;
                this.index = index;
            }
        }

        private int count(int[] arr) {
            int low = 0, high = arr.length;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (mid > 0 && arr[mid - 1] + arr[mid] == 1) {
                    return mid;
                } else if (mid < arr.length - 1 && arr[mid] + arr[mid + 1] == 1) {
                    return mid + 1;
                } else if (arr[mid] == 0) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public int[] kWeakestRows(int[][] mat, int k) {
            Node[] list = new Node[mat.length];
            for (int i = 0; i < mat.length; ++i) {
                list[i] = new Node(count(mat[i]), i);
            }
            Arrays.sort(list, (a, b) -> {
                if (a.num != b.num) {
                    return a.num - b.num;
                }
                return a.index - b.index;
            });
            int[] ans = new int[k];
            for (int i = 0; i < k; ++i) {
                ans[i] = list[i].index;
            }
            return ans;
        }
    }

}
