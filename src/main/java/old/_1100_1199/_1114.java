package old._1100_1199;

import java.util.concurrent.Semaphore;

/**  
 * @ClassName: _1114  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月23日  
 *  
 */
public class _1114 {

    class Foo {

        private Semaphore sec = new Semaphore(0);
        private Semaphore thr = new Semaphore(0);

        public Foo() {}

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();

            sec.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            sec.acquire();

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();

            thr.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            thr.acquire();

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
