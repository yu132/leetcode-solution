package old._1100_1199;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

/**  
 * @ClassName: _1195  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月24日  
 *  
 */
public class _1195 {

    class FizzBuzz {
        private int n;

        private CyclicBarrier cb = new CyclicBarrier(4);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1; i <= n; ++i) {
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                }
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1; i <= n; ++i) {
                if (i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                }
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 1; i <= n; ++i) {
                if (i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                }
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; ++i) {
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                }
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
