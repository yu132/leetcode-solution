package old._0000_0099;

public class _53 {
	
	public int maxSubArray(int[] nums) {
		
		int minMax=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			if(nums[i]>=0){
				minMax=nums[i];
				break;
			}else{
				if(minMax<nums[i])
					minMax=nums[i];
			}
		}
		if(minMax<0)
			return minMax;
		
		return getMax(nums, 0, 0);
    }
	
	public int getMax(int[] nums,int from,int before){
		
		int sum=0;
		for(int i=from;i<nums.length;i++){
			
			if(nums[i]>=0)
				sum+=nums[i];
			else{
				int temp=getMax(nums,i+1,Math.max(sum+nums[i], sum+nums[i]+before));
				return Math.max(Math.max(before+sum, sum), temp);
			}
		}
		
		return Math.max(before+sum, sum);
	}
	
	public static void main(String[] args) {
		int[] test={100,-1,100,-1,100,-1,100};
		System.out.println(new _53().maxSubArray(test));
	}
}
