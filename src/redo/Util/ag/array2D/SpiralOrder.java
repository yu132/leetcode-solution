package redo.Util.ag.array2D;

import java.util.function.BiConsumer;

/**  
 * @ClassName: SpiralOrder  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class SpiralOrder {

    static void spiralOrder(int m, int n, BiConsumer<Integer, Integer> consumer) {
        int top = 0, bottom = m - 1, left = 0, right = n - 1, eleNum = m * n;
        while (eleNum >= 1) {
            for (int i = left; i <= right && eleNum >= 1; ++i) {
                consumer.accept(top, i);
                --eleNum;
            }
            ++top;
            for (int i = top; i <= bottom && eleNum >= 1; ++i) {
                consumer.accept(i, right);
                --eleNum;
            }
            --right;
            for (int i = right; i >= left && eleNum >= 1; --i) {
                consumer.accept(bottom, i);
                --eleNum;
            }
            --bottom;
            for (int i = bottom; i >= top && eleNum >= 1; --i) {
                consumer.accept(i, left);
                --eleNum;
            }
            ++left;
        }
    }

}
