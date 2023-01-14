package redo.mianshi.p03;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P03_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P03_06 {

    static//

    class AnimalShelf {

        final static int[] EMPTY = new int[] {-1, -1};

        Deque<Integer> queueCat = new LinkedList<>(),
            queueDog = new LinkedList<>();

        int index = 0;

        public AnimalShelf() {}

        public void enqueue(int[] animal) {
            int id = animal[0], type = animal[1];// 0 cat; 1 dog
            if (type == 0) {
                queueCat.offer(idIndexHash(id, index++));
            } else {
                queueDog.offer(idIndexHash(id, index++));
            }
        }

        public int idIndexHash(int id, int index) {
            return 20001 * id + index;
        }

        public int id(int hash) {
            return hash / 20001;
        }

        public int index(int hash) {
            return hash % 20001;
        }

        public int[] dequeueAny() {

            if (queueDog.isEmpty()) {
                return dequeueCat();
            }

            if (queueCat.isEmpty()) {
                return dequeueDog();
            }

            if (index(queueDog.peek()) < index(queueCat.peek())) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }

        public int[] dequeueDog() {
            if (queueDog.isEmpty()) {
                return EMPTY;
            }
            return new int[] {id(queueDog.poll()), 1};
        }

        public int[] dequeueCat() {
            if (queueCat.isEmpty()) {
                return EMPTY;
            }
            return new int[] {id(queueCat.poll()), 0};
        }

    }

}
