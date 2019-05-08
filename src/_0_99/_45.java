package _0_99;

public class _45 {

	//[1,1,1,1,1,1,1,1]
	
	/**
	 * 这题由于一定能够跳到终点，所以我建立一个数组，记录能跳到这个地方最早的索引位置
	 * 但是这里必须进行简化，就是记录上一个地方能跳到的最远的位置，这个位置之前的数组无需置数，
	 * 并且将这个值置为当前能跳到最远位置和上一个值的最大值，这样就将复杂度从O(n^2)降低到O(n)。
	 * 
	 * 然后我们从最后一个块开始向前找能够到达这个地方最前的索引，然后跳过去，这个贪心是没有错误的，
	 * 然后到0号索引就结束，中间找的次数即为跳的次数。
	 * 
	 * @author 87663
	 *
	 */
	
/*	 v1
	class Solution {
	    public int jump(int[] nums) {
	    	
	    	if(nums.length==0)
	    		return 0;
	        
	    	int[] min=new int[nums.length];
	    	
	    	for(int i=0,before=0;i<nums.length;i++){
	    		for(int j=before;j<=i+nums[i]&&j<nums.length;j++){
	    			min[j]=i;
	    		}
	    		before=Math.max(before, i+nums[i]+1);
	    	}
	    	
	    	int index=nums.length-1,count=0;
	    	while(index!=0){
	    		index=min[index];
	    		++count;
	    	}
	    	
	    	return count;
	    }
	}*/
	
	//思想更好，速度差不多
	class Solution {
		   public int jump(int[] nums) {
		    int cont=0;
		    int n=nums.length;
		    int i=0;
		    int max=0;
		       while (max<n-1){
		            cont++;
		            int a=max;
		            for (;i<=a;i++){
		                max=Math.max(max,i+nums[i]);
		            }
		       }
		       return cont++;
		    }
		}
	
}
