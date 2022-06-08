package redo.p0400_0499;

/**  
 * @ClassName: P470  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P470 {

    class Solution extends SolBase {
        public int rand10() {
            int a, b, val;
            do {
                a = rand7();
                b = rand7();
                val = (a - 1) * 7 + b;
            } while (val > 40);
            return (val - 1) % 10 + 1;
        }
    }

    class SolBase {
        public int rand7() {
            return 0;
        }
    }

}
