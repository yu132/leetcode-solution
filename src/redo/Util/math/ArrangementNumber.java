package redo.Util.math;

/**  
 * @ClassName: ArrangementNumber  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class ArrangementNumber {

    public int arrangementNumber(int m, int n, int mod) {
        return factorial(n, mod) / factorial(n - m, mod);
    }

    public int combinatorialNumber(int m, int n, int mod) {
        return factorial(n, mod) / (factorial(n - m, mod) * factorial(m, mod));
    }

    public int factorial(int num, int mod) {
        long n = 1;
        for (int i = 2; i < num; ++i) {
            n *= i;
            n %= mod;
        }
        return (int)n;
    }

    public int combinatorialNumber(int m, int n) {
        return factorial(n) / (factorial(n - m) * factorial(m));
    }

    public int factorial(int num) {
        int n = 1;
        for (int i = 2; i <= num; ++i) {
            n *= i;
        }
        return n;
    }

}
