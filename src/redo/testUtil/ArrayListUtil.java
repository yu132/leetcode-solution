package redo.testUtil;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: ArrayListUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class ArrayListUtil {

    public static List<?> build(String str) {
        return new Helper().build(str);
    }

    public static String toStr(List<Integer> list) {
        return list.toString().replaceAll("\\s", "");
    }

    private static class Helper {
        int index = 0;
        String str;

        public List<?> build(String str) {
            this.str = str.replaceAll("\\s", "");
            int dem = 0;
            while (this.str.charAt(dem) == '[') {
                ++dem;
            }
            return build(dem);
        }

        private List<?> build(int dem) {

            if (dem > 1) {
                ++index;
                List<List<?>> lists = new ArrayList<>();
                lists.add(build(dem - 1));
                while (str.charAt(index) == ',') {
                    ++index;
                    lists.add(build(dem - 1));
                }
                ++index;
                return lists;
            } else {
                ++index;
                List<Integer> list = new ArrayList<>();

                list.add(num());
                while (str.charAt(index) == ',') {
                    ++index;
                    list.add(num());
                }
                ++index;
                return list;
            }
        }

        private int num() {
            int num = 0;
            while (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                num = num * 10 + (str.charAt(index++) - '0');
            }
            return num;
        }
    }


    @Test
    public void test() {
        assertEquals("[[15,7],[9,20],[3]]",
            build("[\r\n" + "  [15,7],\r\n" + "  [9,20],\r\n" + "  [3]\r\n" + "]").toString().replaceAll("\\s", ""));

        assertEquals("[[[0],[1]],[[12,13]]]", build("[[[0],[1]],[[12,13]]]").toString().replaceAll("\\s", ""));
    }

}
