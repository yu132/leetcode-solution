package redo.testUtil;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

/**  
 * @ClassName: SortTest  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class SortTest {

    public static void test(Consumer<int[]> sorter) {
        int[] arr = new int[1000];
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Arrays.setAll(arr, (x) -> random.nextInt());
        int[] copy = Arrays.copyOf(arr, arr.length);
        sorter.accept(copy);
        Arrays.sort(arr);
        assertArrayEquals(arr, copy);
    }

    public static void testWithDataRange(Consumer<int[]> sorter, int min, int max) {
        int[] arr = new int[1000];
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Arrays.setAll(arr, (x) -> min + random.nextInt(max - min));
        int[] copy = Arrays.copyOf(arr, arr.length);
        sorter.accept(copy);
        Arrays.sort(arr);
        assertArrayEquals(arr, copy);
    }

}
