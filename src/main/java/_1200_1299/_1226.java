package _1200_1299;

import java.util.concurrent.Semaphore;

/**  
 * @ClassName: _1226  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月24日  
 *  
 */
public class _1226 {

    class DiningPhilosophers {

        private Semaphore[] flag =
            new Semaphore[] {new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)};

        private Semaphore mutex = new Semaphore(1);

        public DiningPhilosophers() {}

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
            Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {

            mutex.acquire();

            flag[philosopher].acquire();
            flag[(philosopher + 1) % 5].acquire();

            pickLeftFork.run();
            pickRightFork.run();

            mutex.release();

            eat.run();

            putLeftFork.run();
            putRightFork.run();

            flag[philosopher].release();
            flag[(philosopher + 1) % 5].release();
        }
    }

}
