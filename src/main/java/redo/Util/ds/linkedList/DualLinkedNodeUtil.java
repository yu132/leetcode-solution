package redo.Util.ds.linkedList;

/**
 * @author 余定邦
 * @ClassName: DualLinkedNode
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月7日
 */
public class DualLinkedNodeUtil {

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
