package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1357  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1357 {

    class Cashier {

        int[] prices;
        int n, now;
        double discountprecent;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.now = 0;
            this.discountprecent = 1 - 0.01 * discount;
            this.prices = new int[201];
            for (int i = 0; i < products.length; ++i) {
                this.prices[products[i]] = prices[i];
            }
        }

        public double getBill(int[] product, int[] amount) {
            double money = 0;
            for (int i = 0; i < product.length; ++i) {
                money += prices[product[i]] * amount[i];
            }
            if (++now % n == 0) {
                money *= discountprecent;
            }
            return money;
        }
    }



    @Test
    public void test() {
        Cashier s = new Cashier(3, 60, new int[] {1, 2, 3, 4, 5, 6, 7}, new int[] {100, 200, 300, 400, 300, 200, 100});
        Assert.assertEquals(500.0, s.getBill(new int[] {1, 2}, new int[] {1, 2}), 0.00001);
        Assert.assertEquals(4000.0, s.getBill(new int[] {3, 7}, new int[] {10, 10}), 0.00001);
        Assert.assertEquals(640.0, s.getBill(new int[] {1, 2, 3, 4, 5, 6, 7}, new int[] {1, 1, 1, 1, 1, 1, 1}),
            0.00001);
        Assert.assertEquals(4000.0, s.getBill(new int[] {4}, new int[] {10}), 0.00001);

    }

}
