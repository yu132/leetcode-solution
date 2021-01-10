package redo.Util.ds.linkedList;

/**  
 * @ClassName: DualLinkedNode  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class DualLinkedNodeUtil {

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

        void removeThis() {
            if (next == null) {
                last.next = null;
                return;
            }

            last.next = next;
            next.last = last;
        }
    }

}
