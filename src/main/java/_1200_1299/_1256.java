package _1200_1299;

/**  
 * @ClassName: _1256  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月14日  
 *  
 */
public class _1256 {

    class Solution {
        public String encode(int num) {
            return Integer.toBinaryString(num + 1).substring(1);
        }
    }

}
