package redo.Util.newcommutil;

import java.util.Collection;

public class CollectionsFastUtil {

    int max(Collection<Integer> collection) {
        int ans = Integer.MIN_VALUE;
        for (int num : collection) {
            ans = Math.max(num, ans);
        }
        return ans;
    }

}
