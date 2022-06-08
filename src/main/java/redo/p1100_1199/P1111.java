package redo.p1100_1199;

/**  
 * @ClassName: P1111  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1111 {

    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int la = 0, lb = 0;
            int[] ans = new int[seq.length()];
            for (int i = 0; i < seq.length(); ++i) {
                char ch = seq.charAt(i);
                if (ch == '(') {
                    if (la <= lb) {
                        ++la;
                        ans[i] = 0;
                    } else {
                        ++lb;
                        ans[i] = 1;
                    }
                } else {// ')'
                    if (la >= lb) {
                        --la;
                        ans[i] = 0;
                    } else {
                        --lb;
                        ans[i] = 1;
                    }
                }
            }
            return ans;
        }
    }

}
