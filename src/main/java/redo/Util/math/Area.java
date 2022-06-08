package redo.Util.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: Area  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class Area {

    public static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (double)Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
    }


    @Test
    public void test() {
        assertEquals(2, area(0, 0, 2, 0, 0, 2));
        assertEquals(0.5, area(0, 0, 1, 0, 0, 1));
    }

}
