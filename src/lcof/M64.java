package lcof;

/**  
 * @ClassName: M64  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月24日  
 *  
 */
public class M64 {

    class Solution {
        public int sumNums(int n) {
            int     sum = n;
            boolean f   = n > 0 && (sum += sumNums(n - 1)) > 0;
            return sum;
        }
    }

}
