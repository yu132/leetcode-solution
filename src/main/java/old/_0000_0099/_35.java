package old._0000_0099;

import java.util.Arrays;

public class _35 {

	public int searchInsert(int[] nums, int target) {
		
		int index=Arrays.binarySearch(nums, target);
		
		if(index>=0)
			return index;
		else
			return -index-1;
		
    }

	public static void main(String[] args) {
		int[] a={1,2,6,8};
		System.out.println(new _35().searchInsert(a,11));
	}
	
}
