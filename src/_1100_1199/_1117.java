package _1100_1199;

import java.util.concurrent.Semaphore;

/**  
 * @ClassName: _1117  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月24日  
 *  
 */
public class _1117 {

    class H2O {

        private Semaphore h = new Semaphore(2);

        private Semaphore mutex = new Semaphore(1);

        private volatile int countH = 0;

        private Semaphore o = new Semaphore(0);

        public H2O() {}

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            h.acquire();

            mutex.acquire();

            ++countH;
            if (countH == 2) {
                countH = 0;
                o.release();
            }

            mutex.release();

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            o.acquire();

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();

            h.release();
            h.release();
        }
    }

}
