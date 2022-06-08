package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1603  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1603 {

    class ParkingSystem {

        int big, medium, small;

        public ParkingSystem(int big, int medium, int small) {
            super();
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:// big
                    if (big > 0) {
                        --big;
                        return true;
                    }
                    return false;
                case 2:// mid
                    if (medium > 0) {
                        --medium;
                        return true;
                    }
                    return false;
                case 3:// small
                    if (small > 0) {
                        --small;
                        return true;
                    }
                    return false;
            }
            throw new RuntimeException("Illegal carType");
        }
    }



    @Test
    public void test() {
        ParkingSystem s = new ParkingSystem(1, 1, 0);
        Assert.assertEquals(true, s.addCar(1));
        Assert.assertEquals(true, s.addCar(2));
        Assert.assertEquals(false, s.addCar(3));
        Assert.assertEquals(false, s.addCar(1));
    }

}
