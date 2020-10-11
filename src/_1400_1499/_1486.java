package _1400_1499;

/**  
 * @ClassName: _1486  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年6月26日  
 *  
 */
public class _1486 {

    class Solution {
        public int xorOperation(int n, int start) {
            int num = start;
            for (int i = 1; i < n; ++i) {
                num ^= start + i * 2;
            }
            return num;
        }
    }

}
