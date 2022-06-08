package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P605  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P605 {

    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if (n == 0) {
                return true;
            }
            if (flowerbed.length == 0) {
                return false;
            } else if (flowerbed.length == 1) {
                if (flowerbed[0] == 1) {
                    return false;
                }
                return n == 1;
            }

            for (int i = 0; i < flowerbed.length - 1;) {
                if (flowerbed[i] == 1) {// 如果这里有朵花，这个位置和下个位置都不能种，跳到下下个位置
                    i += 2;
                    continue;
                } else if (flowerbed[i + 1] == 1) {
                    // 如果下一个位置是花，那么这个位置，下个位置和下下个位置都不能种，跳到下下下个位置
                    i += 3;
                    continue;
                }

                // 此处可以种，那么就种，然后下个位置不能种，跳到下下个位置
                flowerbed[i] = 1;
                --n;
                i += 2;
                if (n == 0) {
                    return true;
                }
            }

            // 由于最后一个位置没有下一个位置，因此需要单独判断，需要判断前一个位置有没有花
            if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
                --n;
            }
            return n == 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 1));
        Assert.assertEquals(false, s.canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 2));
        Assert.assertEquals(true, s.canPlaceFlowers(new int[] {0, 0, 1, 0, 1}, 1));
        Assert.assertEquals(true, s.canPlaceFlowers(new int[] {1, 0, 1, 0, 0}, 1));
        Assert.assertEquals(false, s.canPlaceFlowers(new int[] {1, 0, 1, 0, 1, 0}, 1));
        Assert.assertEquals(true, s.canPlaceFlowers(new int[] {0, 0, 0, 0, 0, 0}, 3));
        Assert.assertEquals(false, s.canPlaceFlowers(new int[] {0, 0, 0, 0, 0, 0}, 4));
        Assert.assertEquals(true, s.canPlaceFlowers(new int[] {0, 0, 0, 0, 0, 0, 0}, 4));
        Assert.assertEquals(false, s.canPlaceFlowers(new int[] {0, 0, 0, 0, 0, 0, 0}, 5));
    }
}
