package _1000_1099;

/**  
 * @ClassName: _1197  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月15日  
 *  
 */
public class _1197 {

    class Solution {
        public int minKnightMoves(int x, int y) {
            x = Math.abs(x);
            y = Math.abs(y);
            if (x + y == 1) {
                return 3;
            }
            int res = Math.max(Math.max((x + 1) / 2, (y + 1) / 2), (x + y + 2) / 3);
            res += (res ^ x ^ y) & 1;
            return res;
        }
    }

}
