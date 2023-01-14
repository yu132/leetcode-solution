package old._0200_0299;

/**  
 * @ClassName: _277  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月9日  
 *  
 */
public class _277 {

    class Relation {
        public boolean knows(int a, int b) {
            return false;
        }
    }

    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int i = 0;
            for (int j = 0; j < n; ++j) {
                if (knows(i, j)) {
                    i = j;
                }
            }
            for (int k = 0; k < n; ++k) {
                if (i == k) {
                    continue;
                }
                if (knows(i, k) || !knows(k, i)) {
                    return -1;
                }
            }
            return i;
        }
    }

}
