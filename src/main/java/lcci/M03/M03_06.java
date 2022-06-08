package lcci.M03;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: M03_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月28日  
 *  
 */
public class M03_06 {

    class AnimalShelf {

        private Deque<int[]> dogdq = new LinkedList<>();
        private Deque<int[]> catdq = new LinkedList<>();

        private int index = 0;

        public AnimalShelf() {}

        public void enqueue(int[] animal) {
            if (animal[1] == 0) {// cat
                catdq.addLast(new int[] {animal[0], index++});
            } else {// dog
                dogdq.addLast(new int[] {animal[0], index++});
            }
        }

        public int[] dequeueAny() {
            int[] dog = dogdq.peekFirst();
            int[] cat = catdq.peekFirst();
            if (dog == null && cat == null) {
                return new int[] {-1, -1};
            }
            if (dog == null || (cat != null && dog[1] > cat[1])) {
                catdq.pollFirst();
                return new int[] {cat[0], 0};
            } else {// dog[1]<cat[1]
                dogdq.pollFirst();
                return new int[] {dog[0], 1};
            }
        }

        public int[] dequeueDog() {
            int[] dog = dogdq.pollFirst();
            if (dog == null) {
                return new int[] {-1, -1};
            }
            return new int[] {dog[0], 1};
        }

        public int[] dequeueCat() {
            int[] cat = catdq.pollFirst();
            if (cat == null) {
                return new int[] {-1, -1};
            }
            return new int[] {cat[0], 0};
        }
    }

    public static void main(String[] args) {
        AnimalShelf as = new M03_06().new AnimalShelf();

        as.enqueue(new int[] {0, 0});

        as.enqueue(new int[] {1, 0});

        System.out.println(Arrays.toString(as.dequeueCat()));

        System.out.println(Arrays.toString(as.dequeueDog()));

        System.out.println(Arrays.toString(as.dequeueAny()));
    }
}
