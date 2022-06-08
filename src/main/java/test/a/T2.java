package test.a;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: T2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月29日  
 *  
 */
public class T2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<List<Integer>> ans = helper(arr);

        System.out.println(ans);
    }

    public static List<List<Integer>> helper(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        helper2(0, new ArrayList<>(), arr, ans);
        return ans;
    }

    private static void helper2(int index, List<Integer> list, int[] arr,
        List<List<Integer>> ans) {
        if (index == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        helper2(index + 1, list, arr, ans);
        list.add(arr[index]);
        helper2(index + 1, list, arr, ans);
        list.remove(list.size() - 1);
    }

}
