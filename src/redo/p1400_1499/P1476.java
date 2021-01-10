package redo.p1400_1499;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1476  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1476 {

    static//

    class SubrectangleQueries {

        List<Rect> list = new ArrayList<>(500);
        int[][] rectangle;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            list.add(new Rect(row1, col1, row2, col2, newValue));
        }

        public int getValue(int row, int col) {
            for (int i = list.size() - 1; i >= 0; --i) {
                if (list.get(i).inRect(row, col)) {
                    return list.get(i).val;
                }
            }
            return rectangle[row][col];
        }

        static class Rect {
            int x1, y1, x2, y2, val;

            public Rect(int x1, int y1, int x2, int y2, int val) {
                super();
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
                this.val = val;
            }

            public boolean inRect(int x, int y) {
                return x1 <= x && y1 <= y && x <= x2 && y <= y2;
            }
        }
    }



    @Test
    public void test() {
        SubrectangleQueries s = new SubrectangleQueries(new int[][] {{0, 1}, {2, 3}});
        Assert.assertEquals(0, s.getValue(0, 0));
        Assert.assertEquals(3, s.getValue(1, 1));
        s.updateSubrectangle(1, 0, 1, 1, 4);
        Assert.assertEquals(4, s.getValue(1, 0));
        Assert.assertEquals(4, s.getValue(1, 1));
        s.updateSubrectangle(1, 0, 1, 0, 5);
        Assert.assertEquals(5, s.getValue(1, 0));
        Assert.assertEquals(4, s.getValue(1, 1));
        Assert.assertEquals(1, s.getValue(0, 1));
        Assert.assertEquals(0, s.getValue(0, 0));
    }

}
