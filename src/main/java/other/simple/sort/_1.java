package other.simple.sort;

public class _1 {

	class Solution {
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int i1=0,i2=0,i3=0;
	        
	        int[] nums3=new int[n+m];
	        
	        while(i1<m&&i2<n){
	        	if(nums1[i1]<nums2[i2])
	        		nums3[i3++]=nums1[i1++];
	        	else if(nums1[i1]>nums2[i2])
	        		nums3[i3++]=nums2[i2++];
	        	else{
	        		nums3[i3++]=nums1[i1++];
	        		nums3[i3++]=nums2[i2++];
	        	}
	        }
	        
	        for(int i=i1;i<m;i++)
	        	nums3[i3++]=nums1[i1++];
	        
	        for(int i=i2;i<n;i++)
	        	nums3[i3++]=nums2[i2++];
	        
	        for(int i=0;i<nums3.length;i++){
	        	nums1[i]=nums3[i];
	        }
	    }
	}
	
}
