package redo.p1800_1899;

/**  
 * @ClassName: P1812  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class P1812 {

    class Solution {
        public boolean squareIsWhite(String coordinates) {
            int x = coordinates.charAt(0) - 'a',
                y = coordinates.charAt(1) - '1';
            return (x + y) % 2 == 1;
        }
    }

}
