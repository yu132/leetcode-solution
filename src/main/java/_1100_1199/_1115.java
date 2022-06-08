package _1100_1199;

import java.util.concurrent.Semaphore;

/**  
 * @ClassName: _1115  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月23日  
 *  
 */
public class _1115 {

    class FooBar {

        private Semaphore foo = new Semaphore(1);
        private Semaphore bar = new Semaphore(0);

        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                foo.acquire();

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();

                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                bar.acquire();

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();

                foo.release();
            }
        }
    }

    public static void main(String[] args) {
        FooBar f = new _1115().new FooBar(5);
        new Thread(() -> {
            try {
                f.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                f.foo(() -> {
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }

}
