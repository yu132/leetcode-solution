package redo.Util.math;

/**  
 * @ClassName: Factorial  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class Factorial {

    public int factorial(int num, int mod) {
        int n = 1;
        for (int i = 2; i < num; ++i) {
            n *= num;
            n %= mod;
        }
        return n;
    }

    public int factorial(int num) {
        int n = 1;
        for (int i = 2; i < num; ++i) {
            n *= num;
        }
        return n;
    }

}
