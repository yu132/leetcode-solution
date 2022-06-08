package redo.Util.template;

import java.util.LinkedList;
import java.util.function.BiPredicate;

public class MonotonicQueueTemplateClass {

    public class MonotonicQueueTemplate<E> {

        public LinkedList<E> list = new LinkedList<>();

        public void removeAndAddFirst(E val, BiPredicate<E, E> removeWhenOldAndNew) {
            while (!list.isEmpty() && removeWhenOldAndNew.test(list.getFirst(), val)) {
                list.removeFirst();
            }
            list.addFirst(val);
        }

        public void removeAndAddLast(E val, BiPredicate<E, E> removeWhenOldAndNew) {
            while (!list.isEmpty() && removeWhenOldAndNew.test(list.getLast(), val)) {
                list.removeLast();
            }
            list.addLast(val);
        }

        public void maxSizeFromFirst(int size) {
            if (list.size() > size) {
                list.removeFirst();
            }
        }

        public void maxSizeFromLast(int size) {
            if (list.size() > size) {
                list.removeLast();
            }
        }
    }

}
