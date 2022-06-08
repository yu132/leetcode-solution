package redo.p0300_0399;

/**  
 * @ClassName: P397  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P397 {

    class Solution {
        public int integerReplacement(int n) {
            int count = 0;

            long N = n;

            while (N != 1) {
                if ((N & 1) == 0) {// "xxx0" => "xxx"
                    N >>= 1;
                } else if ((N & 2) == 0 || N == 3) {// "xx01" => "xx00" | "11" => "10"
                    --N;
                } else {
                    ++N;
                }
                ++count;
            }

            return count;
        }
    }

}
