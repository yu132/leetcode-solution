package reredo.other;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**  
 * @ClassName: Print1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class Print1 {

    public static void main(String[] args) {

        AtomicInteger val = new AtomicInteger(0);

        Semaphore s1 = new Semaphore(1), s2 = new Semaphore(0);

        Thread th1 = new Thread(() -> {
            while (true) {
                try {
                    s1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                    Thread.currentThread().toString() + val.getAndIncrement());
                s2.release();
                if (val.intValue() > 100) {
                    return;
                }
            }
        });

        Thread th2 = new Thread(() -> {
            while (true) {
                try {
                    s2.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                    Thread.currentThread().toString() + val.getAndIncrement());
                s1.release();
                if (val.intValue() > 100) {
                    return;
                }
            }
        });

        th1.start();
        th2.start();
    }

}
