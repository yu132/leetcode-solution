package reredo.rrrd;

import java.util.LinkedList;

/**  
 * @ClassName: P670  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P670 {

    class Solution {
        public int maximumSwap(int num) {
            Integer[] arr = toDigits(num);
            for (int i = 0; i < arr.length; ++i) {
                int greater = -1, gIndex = -1;
                for (int j = i + 1; j < arr.length; ++j) {
                    if (arr[j] > greater) {
                        greater = arr[j];
                        gIndex = j;
                    }
                }
                if (greater >= arr[i]) {
                    swap(arr, i, gIndex);
                    break;
                }
            }

            return toInt(arr);
        }

        void swap(Integer[] arr, int x, int y) {
            Integer temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        int toInt(Integer[] arr) {
            int num = 0;
            for (int i = 0; i < arr.length; ++i) {
                num = num * 10 + arr[i];
            }
            return num;
        }

        Integer[] toDigits(int num) {
            LinkedList<Integer> list = new LinkedList<>();
            while (num != 0) {
                list.addFirst(num % 10);
                num /= 10;
            }
            if (list.isEmpty()) {
                list.add(0);
            }
            return list.toArray(new Integer[0]);
        }
    }

}
