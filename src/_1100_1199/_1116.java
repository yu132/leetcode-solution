package _1100_1199;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**  
 * @ClassName: _1116  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月23日  
 *  
 */
public class _1116 {

    class ZeroEvenOdd {
        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        private volatile boolean finish = false;

        private volatile boolean nextOdd = true;

        private volatile int value = 1;

        private Semaphore zero = new Semaphore(1);

        private Semaphore odd = new Semaphore(0);

        private Semaphore even = new Semaphore(0);

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                zero.acquire();
                if (finish) {
                    return;
                }
                printNumber.accept(0);
                if (nextOdd) {
                    odd.release();
                } else {
                    even.release();
                }
                nextOdd = !nextOdd;
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                even.acquire();
                if (finish) {
                    return;
                }
                printNumber.accept(value++);
                if (value - 1 == n) {
                    finish = true;
                    zero.release();
                    odd.release();
                    return;
                }
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                odd.acquire();
                if (finish) {
                    return;
                }
                printNumber.accept(value++);
                if (value - 1 == n) {
                    finish = true;
                    zero.release();
                    even.release();
                    return;
                }
                zero.release();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd z = new _1116().new ZeroEvenOdd(10);
        new Thread(() -> {
            try {
                z.zero((i) -> {
                    System.out.println(i);
                });
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                z.odd((i) -> {
                    System.out.println(i);
                });
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                z.even((i) -> {
                    System.out.println(i);
                });
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }

}
