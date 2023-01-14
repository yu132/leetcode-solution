package old._1400_1499;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: _1496  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年7月28日  
 *  
 */
public class _1496 {

    class Solution {
        public boolean isPathCrossing(String path) {
            Set<Integer> set = new HashSet<>();

            int          x   = 10000, y = 10000;

            for (char each : path.toCharArray()) {
                set.add(x + y * 20001);
                switch (each) {
                    case 'N':
                        ++x;
                        break;
                    case 'S':
                        --x;
                        break;
                    case 'E':
                        ++y;
                        break;
                    case 'W':
                        --y;
                        break;
                }
                if (set.contains(x + y * 20001)) {
                    return true;
                }
            }

            return false;
        }
    }

}
