package old._1600_1699;

/**  
 * @ClassName: _1603  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年10月17日  
 *  
 */
public class _1603 {

    class ParkingSystem {

        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            super();
            this.big    = big;
            this.medium = medium;
            this.small  = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    if (big == 0) {
                        return false;
                    }
                    --big;
                    break;
                case 2:
                    if (medium == 0) {
                        return false;
                    }
                    --medium;
                    break;
                case 3:
                    if (small == 0) {
                        return false;
                    }
                    --small;
                    break;
            }
            return true;
        }
    }

}
