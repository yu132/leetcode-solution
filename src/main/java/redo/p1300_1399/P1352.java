package redo.p1300_1399;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1352  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1352 {

    class ProductOfNumbers {

        List<Integer> prefixProduct = new ArrayList<>(500);

        public ProductOfNumbers() {
            prefixProduct.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                prefixProduct.clear();
                prefixProduct.add(1);
                return;
            }
            prefixProduct.add(num * prefixProduct.get(prefixProduct.size() - 1));
        }

        public int getProduct(int k) {
            if (k >= prefixProduct.size()) {
                return 0;
            }
            return prefixProduct.get(prefixProduct.size() - 1) / prefixProduct.get(prefixProduct.size() - k - 1);
        }
    }

    @Test
    public void test() {
        ProductOfNumbers s = new ProductOfNumbers();
        s.add(3);
        s.add(0);
        s.add(2);
        s.add(5);
        s.add(4);
        Assert.assertEquals(20, s.getProduct(2));
        Assert.assertEquals(40, s.getProduct(3));
        Assert.assertEquals(0, s.getProduct(4));
        s.add(8);
        Assert.assertEquals(32, s.getProduct(2));
    }

}
