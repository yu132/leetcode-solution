package _0000_0099;

public class _27 {

	public int removeElement(int[] nums, int val) {
		if(nums.length==0)
			return 0;
		
		int index=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==val)
				continue;
			
			nums[index++]=nums[i];
		}
		
		return index;
    }
	
}
