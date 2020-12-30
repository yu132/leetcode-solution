package redo.Util;

/**  
 * @ClassName: Integers  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class Integers {

    public static int digitsCount(int num) {
        int digits = 0;
        while (num != 0) {
            ++digits;
            num /= 10;
        }
        return digits;
    }

    public static int digitsSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
