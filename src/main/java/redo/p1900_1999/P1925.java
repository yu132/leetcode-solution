package redo.p1900_1999;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: P1925  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年8月1日  
 *  
 */
public class P1925 {

    class Solution {
        public int countTriples(int n) {
            int count = 0;

            Set<Integer> pow = new HashSet<>();

            for (int i = 1; i <= n; ++i) {
                pow.add(i * i);
            }

            for (int i = 1; i <= n; ++i) {
                for (int j = i + 1; j <= n; ++j) {
                    if (pow.contains(i * i + j * j)) {
                        ++count;
                    }
                }
            }

            return 2 * count;
        }
    }

}
