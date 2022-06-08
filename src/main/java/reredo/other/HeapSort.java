package reredo.other;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**  
 * @ClassName: HeapSort  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月2日  
 *  
 */
public class HeapSort {

    void heapSort(int[] arr) {
        heapify(arr);
        for (int i = arr.length - 1; i >= 0; --i) {
            arr[i] = poll(arr, i);
        }
    }

    void heapify(int[] arr) {
        for (int i = arr.length - 1; i >= 0; --i) {
            down(arr, i, arr.length);
        }
    }

    int poll(int[] arr, int last) {
        int ret = arr[0];
        arr[0] = arr[last];
        down(arr, 0, last);
        return ret;
    }

    // void up(int[] arr, int index) {
    // if (index == 0) {
    // return;
    // }
    // int parent = (index - 1) / 2;
    // if (arr[index] <= arr[parent]) {
    // return;
    // }
    // swap(arr, index, parent);
    // }

    void down(int[] arr, int index, int range) {
        int child1 = index * 2 + 1, child2 = index * 2 + 2;
        if (child1 >= range) {
            return;
        }
        if (child2 >= range) {
            if (arr[child1] > arr[index]) {
                swap(arr, index, child1);
                down(arr, child1, range);
            }
        } else {
            if (arr[child1] >= arr[child2]) {
                if (arr[child1] > arr[index]) {
                    swap(arr, index, child1);
                    down(arr, child1, range);
                }
            } else {
                if (arr[child2] > arr[index]) {
                    swap(arr, index, child2);
                    down(arr, child2, range);
                }
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        ThreadLocalRandom r = ThreadLocalRandom.current();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = r.nextInt();
        }
        new HeapSort().heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
