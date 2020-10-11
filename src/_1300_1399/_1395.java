package _1300_1399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: _1395  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _1395 {

    class Solution {
        public int numTeams(int[] rating) {
            int ans = 0;
            for (int i = 1; i < rating.length - 1; ++i) {
                int left = 0, right = 0;
                for (int j = 0; j < i; ++j) {
                    if (rating[j] < rating[i]) {
                        ++left;
                    }
                }
                for (int j = i + 1; j < rating.length; ++j) {
                    if (rating[j] < rating[i]) {
                        ++right;
                    }
                }
                ans += left * (rating.length - i - 1 - right) + (i - left) * right;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Arrays.setAll(arr, (i) -> i + 1);
        List<Integer> list = new ArrayList<>();
        for (int each : arr) {
            list.add(each);
        }
        Collections.shuffle(list);
        System.out.println(list);
    }
}
