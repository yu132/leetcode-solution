package lcof;

/**  
 * @ClassName: M14_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M14_1 {

    class Solution {
        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }
            switch (n % 3) {
                case 0:
                    return (int)Math.pow(3, n / 3);
                case 1:
                    return (int)Math.pow(3, n / 3 - 1) * 4;
                case 2:
                    return (int)Math.pow(3, n / 3) * 2;
            }
            return -1;
        }
    }

}
