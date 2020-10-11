package _0300_0399;

import java.util.HashSet;
import java.util.LinkedList;

/**  
 * @ClassName: _379  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _379 {

    class PhoneDirectory {

        private LinkedList<Integer> list = new LinkedList<>();
        private HashSet<Integer> used = new HashSet<>();
        private int max;

        /** Initialize your data structure here
            @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            max = maxNumbers;
            for (int i = 0; i < maxNumbers; ++i) {
                list.add(i);
            }
        }

        /** Provide a number which is not assigned to anyone.
            @return - Return an available number. Return -1 if none is available. */
        public int get() {
            if (list.size() <= 0) {
                return -1;
            }
            int num = list.removeFirst();
            used.add(num);
            return num;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return number >= 0 && number < max && !used.contains(number);
        }

        /** Recycle or release a number. */
        public void release(int number) {
            if (used.contains(number)) {
                used.remove(number);
                list.add(number);
            }
        }
    }

}
