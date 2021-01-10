package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1381  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1381 {

    static//

    class CustomStack {

        Data[] datas;
        int index = 0;

        public CustomStack(int maxSize) {
            datas = new Data[maxSize];
        }

        public void push(int x) {
            if (index < datas.length) {
                datas[index++] = new Data(x);
            }
        }

        public int pop() {
            if (index == 0) {
                return -1;
            }
            --index;
            int ret = datas[index].val + datas[index].change;
            if (index > 0) {
                datas[index - 1].change += datas[index].change;
            }
            return ret;
        }

        public void increment(int k, int val) {
            if (index > 0) {
                datas[Math.min(k - 1, index - 1)].change += val;
            }
        }

        static class Data {
            int val, change;

            public Data(int val) {
                super();
                this.val = val;
            }
        }
    }



    @Test
    public void test() {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        Assert.assertEquals(2, customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(4, 100);
        customStack.increment(2, 100);
        Assert.assertEquals(103, customStack.pop());
        Assert.assertEquals(202, customStack.pop());
        Assert.assertEquals(201, customStack.pop());
        Assert.assertEquals(-1, customStack.pop());
    }

}
