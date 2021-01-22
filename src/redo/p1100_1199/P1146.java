package redo.p1100_1199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1146  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1146 {

    static//

    class SnapshotArray {

        int[] arr;
        List<List<Snap>> snap;
        int snapSize = 0;

        Map<Integer, Integer> changed = new HashMap<>();

        public SnapshotArray(int length) {
            arr = new int[length];
            snap = new ArrayList<>(length);
            for (int i = 0; i < length; ++i) {
                snap.add(new ArrayList<>());
            }
        }

        public void set(int index, int val) {
            arr[index] = val;
            changed.put(index, val);
        }

        public int snap() {
            for (Map.Entry<Integer, Integer> entry : changed.entrySet()) {
                snap.get(entry.getKey()).add(new Snap(snapSize, entry.getValue()));
            }
            changed.clear();
            return snapSize++;
        }

        public int get(int index, int snap_id) {
            List<Snap> list = snap.get(index);
            int low = 0, high = list.size();
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (list.get(mid).snapId > snap_id) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (low == 0) {
                return 0;
            }
            return list.get(low - 1).val;
        }

        static class Snap {
            int snapId, val;

            public Snap(int snapId, int val) {
                super();
                this.snapId = snapId;
                this.val = val;
            }
        }
    }



    @Test
    public void test() {
        SnapshotArray s = new SnapshotArray(3);
        s.set(0, 5);
        Assert.assertEquals(0, s.snap());
        s.set(0, 6);
        Assert.assertEquals(5, s.get(0, 0));
    }

}
