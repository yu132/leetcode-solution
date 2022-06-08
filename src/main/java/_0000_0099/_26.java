package _0000_0099;

public class _26 {
	
	public int removeDuplicates(int[] nums) {
		if(nums.length==0)
			return 0;
		
		int l=nums[0];
		int index=1;
		for(int i=1;i<nums.length;i++){
			if(nums[i]==l)
				continue;
			
			l=nums[i];
			nums[index++]=nums[i];
		}
		
		return index;
	}
	
}
