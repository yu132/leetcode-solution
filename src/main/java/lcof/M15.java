package lcof;

/**  
 * @ClassName: M15  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M15 {

    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for (char each : Integer.toUnsignedString(n, 2).toCharArray()) {
                if (each == '1') {
                    ++count;
                }
            }
            return count;
        }
    }

}
