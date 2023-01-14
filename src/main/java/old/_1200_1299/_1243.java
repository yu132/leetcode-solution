package old._1200_1299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1243  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月1日  
 *  
 */
public class _1243 {

    class Solution {
        public List<Integer> transformArray(int[] arr) {

            int     a      = arr[0];
            boolean change = true;
            while (change) {
                change = false;
                a      = arr[0];
                for (int i = 2; i < arr.length; ++i) {
                    int temp = arr[i - 1];
                    if (arr[i] > arr[i - 1] && a > arr[i - 1]) {
                        ++arr[i - 1];
                        change = true;
                    } else if (arr[i] < arr[i - 1] && a < arr[i - 1]) {
                        --arr[i - 1];
                        change = true;
                    }
                    a = temp;
                }
            }

            List<Integer> list = new ArrayList<>();
            for (int each : arr) {
                list.add(each);
            }

            return list;
        }
    }

}
