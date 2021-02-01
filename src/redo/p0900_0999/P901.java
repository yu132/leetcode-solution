package redo.p0900_0999;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P901  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月26日  
 *  
 */
public class P901 {

    static//

    class StockSpanner {

        List<Data> mqueue = new ArrayList<>();
        int index = 0;

        public StockSpanner() {}

        public int next(int price) {
            while (!mqueue.isEmpty() && mqueue.get(mqueue.size() - 1).val <= price) {
                mqueue.remove(mqueue.size() - 1);
            }

            int index = mqueue.isEmpty() ? -1 : mqueue.get(mqueue.size() - 1).index;

            mqueue.add(new Data(this.index++, price));

            return this.index - index - 1;
        }

        static class Data {
            int index, val;

            public Data(int index, int val) {
                super();
                this.index = index;
                this.val = val;
            }
        }
    }


}
