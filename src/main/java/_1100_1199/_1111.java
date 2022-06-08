package _1100_1199;

/**  
 * @ClassName: _1111  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月20日  
 *  
 */
public class _1111 {

    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int[] ans       = new int[seq.length()];

            int   countLeft = 0;
            for (int i = 0; i < seq.length(); ++i) {
                if (seq.charAt(i) == '(') {
                    ++countLeft;
                    ans[i] = countLeft & 1;
                } else {
                    ans[i] = countLeft & 1;
                    --countLeft;
                }
            }

            return ans;
        }
    }

}
