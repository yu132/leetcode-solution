package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1472  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1472 {

    static//

    class BrowserHistory {

        DualLinkedNode<String> head = new DualLinkedNode<>(""), pointer = head;

        public BrowserHistory(String homepage) {
            visit(homepage);
        }

        public void visit(String url) {
            pointer.next = null;
            pointer.appendNext(url);
            pointer = pointer.next;
        }

        public String back(int steps) {
            while (steps-- != 0 && pointer.last != head) {
                pointer = pointer.last;
            }
            return pointer.data;
        }

        public String forward(int steps) {
            while (steps-- != 0 && pointer.next != null) {
                pointer = pointer.next;
            }
            return pointer.data;
        }

        static class DualLinkedNode<T> {

            T data;

            DualLinkedNode<T> last, next;

            public DualLinkedNode(T data) {
                super();
                this.data = data;
            }

            void appendNext(T data) {
                if (next == null) {
                    next = new DualLinkedNode<T>(data);
                    next.last = this;
                    return;
                }

                DualLinkedNode<T> node = new DualLinkedNode<T>(data);
                node.last = this;
                node.next = this.next;
                this.next.last = node;
                this.next = node;
            }
        }
    }



    @Test
    public void test() {
        BrowserHistory s = new BrowserHistory("leetcode.com");
        s.visit("google.com");
        s.visit("facebook.com");
        s.visit("youtube.com");
        Assert.assertEquals("facebook.com", s.back(1));
        Assert.assertEquals("google.com", s.back(1));
        Assert.assertEquals("facebook.com", s.forward(1));
        s.visit("linkedin.com");
        Assert.assertEquals("linkedin.com", s.forward(2));
        Assert.assertEquals("google.com", s.back(2));
        Assert.assertEquals("leetcode.com", s.back(7));
    }

}
