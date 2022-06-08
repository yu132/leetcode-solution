package _1300_1399;

/**  
 * @ClassName: _1342  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月10日  
 *  
 */
public class _1342 {

    class Solution {
        public int numberOfSteps(int num) {

            int count = 0;
            while (num != 0) {
                ++count;
                if ((num & 1) == 1) {
                    --num;
                } else {
                    num >>= 1;
                }
            }

            return count;
        }
    }

}
