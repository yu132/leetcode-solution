package old._0900_0999;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _969  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月3日  
 *  
 */
public class _969 {

    class Solution {
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < arr.length; ++i) {
                int max = arr[0], index = 0;
                for (int j = 1; j < arr.length - i; ++j) {
                    if (max < arr[j]) {
                        max   = arr[j];
                        index = j;
                    }
                }
                reverse(arr, index);
                reverse(arr, arr.length - i - 1);
                ans.add(index + 1);
                ans.add(arr.length - i);
            }
            return ans;
        }

        public void reverse(int[] arr, int len) {
            int low = 0, high = len;
            while (low < high) {
                int temp = arr[low];
                arr[low]  = arr[high];
                arr[high] = temp;
                --high;
                ++low;
            }
        }
    }

}
