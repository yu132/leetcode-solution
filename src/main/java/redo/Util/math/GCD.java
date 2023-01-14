package redo.Util.math;

/**
 * @author 余定邦
 * @ClassName: GCD
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月8日
 */
public class GCD {

    /**
     * 求两个数的最小公约数
     *
     * @param m 不能为0
     * @param n 可为0
     * @return
     */
    public int gcd(int m, int n) {
        int r;
        while (n > 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    /**
     * 求两个数的最大公倍数
     *
     * @param m
     * @param n
     * @return
     */
    public int mcm(int m, int n) {
        return m * n / gcd(m, n);
    }

}
