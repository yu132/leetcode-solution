package redo.Util.math;

/**  
 * @ClassName: Maths  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class Maths {

    public int gcd(int m, int n) {
        int r;
        while (n > 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public int sum1toN(int N) {
        return (int)((long)N * (N + 1) / 2);
    }

}
