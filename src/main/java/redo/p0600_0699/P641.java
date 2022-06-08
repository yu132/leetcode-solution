package redo.p0600_0699;

public class P641 {

    class MyCircularDeque {

        DualLinkedNode<Integer> head, tail;

        int size = 0, maxSize;

        public MyCircularDeque(int k) {
            maxSize = k;
            head = new DualLinkedNode<>(-1);
            tail = new DualLinkedNode<>(-1);
            head.next = tail;
            tail.prev = head;
        }

        public boolean insertFront(int value) {
            if (size >= maxSize) {
                return false;
            }
            head.appendNext(value);
            ++size;
            return true;
        }

        public boolean insertLast(int value) {
            if (size >= maxSize) {
                return false;
            }
            tail.appendPrev(value);
            ++size;
            return true;
        }

        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            head.next.removeSelf();
            --size;
            return true;
        }

        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            tail.prev.removeSelf();
            --size;
            return true;
        }

        public int getFront() {
            return head.next.data;
        }

        public int getRear() {
            return tail.prev.data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == maxSize;
        }

        class DualLinkedNode<T> {

            T data;

            DualLinkedNode<T> prev, next;

            public DualLinkedNode(T data) {
                super();
                this.data = data;
            }

            void appendNext(T data) {
                if (next == null) {
                    next = new DualLinkedNode<T>(data);
                    next.prev = this;
                    return;
                }

                DualLinkedNode<T> node = new DualLinkedNode<T>(data);
                node.prev = this;
                node.next = this.next;
                this.next.prev = node;
                this.next = node;
            }

            void appendPrev(T data) {
                if (prev == null) {
                    prev = new DualLinkedNode<>(data);
                    prev.next = this;
                    return;
                }
                prev.appendNext(data);
            }

            void removeSelf() {
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }
            }
        }
    }

}
