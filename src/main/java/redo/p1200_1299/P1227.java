package redo.p1200_1299;

/**  
 * @ClassName: P1227  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1227 {

    // 11 22 33 -> 1, 12 (21 23) (33 31)->0.5, 13 22 31 ->0 = 1.5/3=0.5
    class Solution {
        public double nthPersonGetsNthSeat(int n) {
            return n == 1 ? 1 : 0.5;
        }
    }

}
