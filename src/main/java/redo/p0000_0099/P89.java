package redo.p0000_0099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P89  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P89 {

    class Solution {
        public List<Integer> grayCode(int n) {
            return generateCode(n);
        }

        // N代表编码的位数
        List<Integer> generateCode(int N) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0, len = 1 << N; i < len; ++i) {
                ans.add(i ^ (i >> 1));
            }
            return ans;
        }
    }

}
