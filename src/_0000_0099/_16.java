package _0000_0099;

import java.util.Arrays;

public class _16 {
	
	public int threeSumClosest(int[] nums, int target) {
        
		Arrays.sort(nums);
		
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				int temp=nums[i]+nums[j]-target;
				int index=Arrays.binarySearch(nums, -temp);
				if(index>=0&&index!=i&&index!=j)
					return target;
				
				int tindex1=-index-1;
				int tindex2=-index-2;
				
				while(tindex1==i||tindex1==j)
					tindex1++;
				while(tindex2==i||tindex2==j)
					tindex2--;
				
				if(tindex1>=0&&tindex1<nums.length){
					int temp2=temp+nums[tindex1];
					if(Math.abs(min)>Math.abs(temp2)){
						min=temp2;
					}
				}
				
				if(tindex2>=0&&tindex2<nums.length){
					int temp2=temp+nums[tindex2];
					if(Math.abs(min)>Math.abs(temp2)){
						min=temp2;
					}
				}
				
			}
		}
		
		return target+min;
    }
	
	public static void main(String[] args) {
		int[] a={0,1,100,4};
		System.out.println(new _16().threeSumClosest(a, 0));
	}
	
}
