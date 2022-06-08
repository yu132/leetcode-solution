package redo.Util.math;

/**  
 * @ClassName: GCD  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class GCD {

    public int gcd(int m, int n) {
        int r;
        while (n > 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public int mcm(int m, int n) {
        return m * n / gcd(m, n);
    }

}
