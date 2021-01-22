package redo.Util;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: BinaryGrayCode  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class BinaryGrayCode {

    // N代表编码的位数
    List<Integer> generateCode(int N) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, len = 1 << N; i < len; ++i) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }

}
