package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1670  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1670 {

    static//

    class FrontMiddleBackQueue {

        private Node head, middle, tail;

        int nodeNumLow = 0, nodeNumHigh = -1;

        public FrontMiddleBackQueue() {
            head = new Node(0);
            tail = new Node(0);
            middle = tail;
            head.next = tail;
            tail.last = head;
        }

        public void pushFront(int val) {
            Node node = new Node(val);
            node.last = head;
            head.next.last = node;
            node.next = head.next;
            head.next = node;
            if (middle == head) {
                ++nodeNumHigh;
            } else {
                ++nodeNumLow;
            }
        }

        public void pushMiddle(int val) {
            while (nodeNumLow > nodeNumHigh) {
                middle = middle.last;
                --nodeNumLow;
                ++nodeNumHigh;
            }
            while (nodeNumLow < nodeNumHigh) {
                middle = middle.next;
                ++nodeNumLow;
                --nodeNumHigh;
            }
            Node node = new Node(val);
            node.last = middle.last;
            middle.last.next = node;
            node.next = middle;
            middle.last = node;
            ++nodeNumLow;
        }

        public void pushBack(int val) {
            Node node = new Node(val);
            node.next = tail;
            node.last = tail.last;
            tail.last.next = node;
            tail.last = node;
            if (tail == middle) {
                middle = tail.last;
            }
            if (middle == tail) {
                ++nodeNumLow;
            } else {
                ++nodeNumHigh;
            }
        }

        public int popFront() {
            if (head.next == tail) {
                return -1;
            }
            int temp = head.next.val;
            if (head.next == middle) {
                middle = head;
                --nodeNumLow;
                ++nodeNumHigh;
            }
            head.next = head.next.next;
            head.next.last = head;
            if (middle == head) {
                --nodeNumHigh;
            } else {
                --nodeNumLow;
            }
            return temp;
        }

        public int popMiddle() {
            while (nodeNumLow < nodeNumHigh) {
                middle = middle.next;
                ++nodeNumLow;
                --nodeNumHigh;
            }
            while (nodeNumLow > nodeNumHigh) {
                middle = middle.last;
                --nodeNumLow;
                ++nodeNumHigh;
            }
            if (middle == head) {
                return -1;
            }
            middle.next.last = middle.last;
            middle.last.next = middle.next;
            int temp = middle.val;
            middle = middle.next;
            --nodeNumHigh;
            return temp;
        }

        public int popBack() {
            if (head.next == tail) {
                return -1;
            }
            int temp = tail.last.val;
            if (tail.last == middle) {
                middle = tail;
                ++nodeNumLow;
                --nodeNumHigh;
            }
            tail.last = tail.last.last;
            tail.last.next = tail;
            if (middle == tail) {
                --nodeNumLow;
            } else {
                --nodeNumHigh;
            }
            return temp;
        }

        static class Node {
            int val;
            Node next;
            Node last;

            public Node(int val) {
                super();
                this.val = val;
            }
        }
    }



    @Test
    public void test() {
        FrontMiddleBackQueue s = new FrontMiddleBackQueue();
        s.pushFront(1);
        s.pushBack(2);
        s.pushMiddle(3);
        s.pushMiddle(4);
        Assert.assertEquals(1, s.popFront());
        Assert.assertEquals(3, s.popMiddle());
        Assert.assertEquals(4, s.popMiddle());
        Assert.assertEquals(2, s.popBack());
        Assert.assertEquals(-1, s.popFront());
    }

    @Test
    public void test2() {
        FrontMiddleBackQueue s = new FrontMiddleBackQueue();
        Assert.assertEquals(-1, s.popMiddle());
        Assert.assertEquals(-1, s.popMiddle());
        s.pushMiddle(3);
        Assert.assertEquals(3, s.popBack());
        Assert.assertEquals(-1, s.popFront());
        Assert.assertEquals(-1, s.popMiddle());
    }

    @Test
    public void test3() {
        FrontMiddleBackQueue s = new FrontMiddleBackQueue();
        s.pushBack(1);
        s.pushBack(2);
        s.pushBack(3);
        s.pushBack(4);
        Assert.assertEquals(2, s.popMiddle());
        Assert.assertEquals(3, s.popMiddle());
        Assert.assertEquals(1, s.popMiddle());
        Assert.assertEquals(4, s.popMiddle());
    }

    @Test
    public void test4() {
        FrontMiddleBackQueue s = new FrontMiddleBackQueue();
        Assert.assertEquals(-1, s.popMiddle());
        s.pushMiddle(3);
        s.pushFront(6);
        s.pushMiddle(6);
        s.pushMiddle(3);
        Assert.assertEquals(3, s.popMiddle());
        s.pushMiddle(7);
        Assert.assertEquals(7, s.popMiddle());
        s.pushMiddle(8);
    }

    @Test
    public void test5() {
        FrontMiddleBackQueue s = new FrontMiddleBackQueue();
        s.pushMiddle(874835);

        Assert.assertEquals(874835, s.popBack());
        Assert.assertEquals(-1, s.popMiddle());
        Assert.assertEquals(-1, s.popMiddle());

        s.pushBack(319750);
        s.pushFront(782168);

        Assert.assertEquals(782168, s.popFront());

        s.pushMiddle(16473);
        s.pushMiddle(495349);

        Assert.assertEquals(495349, s.popMiddle());
        Assert.assertEquals(16473, s.popMiddle());

        s.pushMiddle(596131);

        Assert.assertEquals(596131, s.popMiddle());

        s.pushMiddle(583563);
    }

    @Test
    public void test6() {
        FrontMiddleBackQueue s = new FrontMiddleBackQueue();
        Assert.assertEquals(-1, s.popMiddle());

        s.pushMiddle(5422);// 5422
        s.pushMiddle(532228);// 532228, 5422

        Assert.assertEquals(5422, s.popBack());// 532228

        s.pushMiddle(206486);// 206486, 532228
        s.pushBack(351927);// 206486, 532228, 351927

        Assert.assertEquals(206486, s.popFront());// 532228, 351927
        Assert.assertEquals(532228, s.popFront());// 351927
    }


}
