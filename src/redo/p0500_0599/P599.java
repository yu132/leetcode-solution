package redo.p0500_0599;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P599  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P599 {

    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<Data> datalist1 = new ArrayList<>(list1.length);
            List<Data> datalist2 = new ArrayList<>(list2.length);

            for (int i = 0; i < list1.length; ++i) {
                datalist1.add(new Data(list1[i], i));
            }
            for (int i = 0; i < list2.length; ++i) {
                datalist2.add(new Data(list2[i], i));
            }

            Collections.sort(datalist1, (a, b) -> a.name.compareTo(b.name));
            Collections.sort(datalist2, (a, b) -> a.name.compareTo(b.name));

            int index1 = 0, index2 = 0, min = Integer.MAX_VALUE;

            List<String> ans = new ArrayList<>();

            while (index1 != datalist1.size() && index2 != datalist2.size()) {
                Data d1 = datalist1.get(index1);
                Data d2 = datalist2.get(index2);
                if (d1.name.equals(d2.name)) {
                    int indexes = d1.index + d2.index;
                    if (indexes < min) {
                        min = indexes;
                        ans.clear();
                        ans.add(d1.name);
                    } else if (indexes == min) {
                        ans.add(d1.name);
                    }
                    ++index1;
                    ++index2;
                } else if (d1.name.compareTo(d2.name) < 0) {
                    ++index1;
                } else {
                    ++index2;
                }
            }

            return ans.toArray(new String[0]);
        }

        class Data {
            String name;
            int index;

            Data(String name, int index) {
                super();
                this.name = name;
                this.index = index;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new String[] {"Shogun"},
            s.findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}));

        Assert.assertArrayEquals(new String[] {"Burger King", "Shogun"},
            s.findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[] {"Burger King", "KFC", "Shogun"}));
    }
}
