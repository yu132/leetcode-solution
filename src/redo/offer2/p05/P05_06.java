package redo.offer2.p05;

/**  
 * @ClassName: P05_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P05_06 {

    class Solution {
        public int convertInteger(int A, int B) {
            return Integer.bitCount(A ^ B);
        }
    }

}
