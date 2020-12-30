package redo.p0400_0499;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P412  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P412 {

    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 1; i <= n; ++i) {
                if (i % 3 == 0 && i % 5 == 0) {
                    ans.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    ans.add("Fizz");
                } else if (i % 5 == 0) {
                    ans.add("Buzz");
                } else {
                    ans.add(String.valueOf(i));
                }
            }
            return ans;
        }
    }

}
