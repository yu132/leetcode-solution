package redo.p1700_1799;

/**  
 * @ClassName: P1720  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1720 {

    class Solution {
        public int[] decode(int[] encoded, int first) {
            int[] ans = new int[encoded.length + 1];
            ans[0] = first;
            for (int i = 0; i < encoded.length; ++i) {
                ans[i + 1] = ans[i] ^ encoded[i];
            }
            return ans;
        }
    }

}
