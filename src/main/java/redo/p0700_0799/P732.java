package redo.p0700_0799;

public class P732 {

    class MyCalendarThree {

        DualLinkedNode<Data> head, tail;

        int max = 0;

        public MyCalendarThree() {
            head = new DualLinkedNode<>(new Data(-1, 0));
            tail = new DualLinkedNode<>(new Data(Integer.MAX_VALUE, 0));
            head.next = tail;
            tail.prev = head;
        }

        /*
         * a | b c d e | f
         * 一个node即为一段区间的起始点，start和end可能会将原有的区间拆分为更多的区间，因此本质上就是将node插入链表的过程
         * 然后另start到end（不含）中间的区间计数加一，然后最后统计最大值即可
         */
        public int book(int start, int end) {
            DualLinkedNode<Data> node = head;

            //找到a
            while (node.next.data.from <= start) {
                node = node.next;
            }
            //如果start和a不重合，那么创建新的node，即将[a,b)拆分为[a,start) 和[start,b)
            if (node.data.from != start) {
                node.appendNext(new Data(start, node.data.height));
                node = node.next;
            }
            //为中间的区间增加计数，并找到e
            while (node.next.data.from <= end) {
                max = Math.max(max, ++node.data.height);
                node = node.next;
            }
            //如果e和end不重合，那么新增node，即将[e,f)拆分为[e,end) 和[end,f)，并为end前的最后一个区间增加计数
            if (node.data.from != end) {
                node.appendNext(new Data(end, node.data.height));
                max = Math.max(max, ++node.data.height);
            }
            //返回最大值
            return max;
        }

        class Data {
            int from;
            int height;

            public Data(int from, int height) {
                this.from = from;
                this.height = height;
            }
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
