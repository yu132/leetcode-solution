package _1300_1399;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: _1346  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月10日  
 *  
 */
public class _1346 {

    class Solution {
        public boolean checkIfExist(int[] arr) {

            Set<Integer> set    = new HashSet<>();

            int          count0 = 0;
            for (int each : arr) {
                set.add(each);
                if (each == 0) {
                    ++count0;
                }
            }

            for (int each : arr) {
                if (set.contains(each * 2)) {
                    if (each == 0) {
                        if (count0 >= 2) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }

            return false;
        }
    }

}
