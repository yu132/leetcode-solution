package _0_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {

	 public List<List<Integer>> threeSum(int[] nums) {
		 
		 List<List<Integer>> ans=new ArrayList<>();

		 Arrays.sort(nums);
		 
		 int zCount=0;
		 
		 int zIndex=Arrays.binarySearch(nums, 0);
		 
		 int zLeft=-1,zRight=-1;
		 
		 if(zIndex>=0){
			 zCount++;
			 for(zLeft=zIndex-1;zLeft>=0;zLeft--){
				 if(nums[zLeft]==0)
					 zCount++;
				 else
					 break;
			 }
			 for(zRight=zIndex+1;zRight<nums.length;zRight++){
				 if(nums[zRight]==0)
					 zCount++;
				 else
					 break;
			 }
		 }else{
			 int x=-zIndex-1;
			 zLeft=x-1;
			 zRight=x;
		 }
		 
		 if(zCount>=3){
			List<Integer> temp=new ArrayList<>();
			temp.add(0);
			temp.add(0);
			temp.add(0);
			ans.add(temp);
		 }
		 
		 if(zCount>=1){
			 for(int i=0,j=nums.length-1;i<=zLeft&&j>=zRight;){
				 if(i!=0&&nums[i]==nums[i-1]){
					 i++;
					 continue;
				 }
				 if(j!=nums.length-1&&nums[j]==nums[j+1]){
					 j--;
					 continue;
				 }
			 	if(-nums[i]==nums[j]){
					List<Integer> temp=new ArrayList<>();
					temp.add(nums[i]);
					temp.add(0);
					temp.add(nums[j]);
					ans.add(temp);
					i++;
					j--;
			 	}else if(-nums[i]>nums[j]){
			 		i++;
			 	}else
			 		j--;
			 }
		 }
		 
		 for(int i=0;i<zLeft;i++){
			 if(i!=0&&nums[i]==nums[i-1])
				 continue;
			 for(int j=i+1;j<=zLeft;j++){
				 if(j!=i+1&&nums[j]==nums[j-1])
					 continue;
				 
				 int tempx=-(nums[i]+nums[j]);
				 if(Arrays.binarySearch(nums, zRight,nums.length,tempx)>=0){
					 List<Integer> temp=new ArrayList<>();
					 temp.add(nums[i]);
					 temp.add(nums[j]);
					 temp.add(tempx);
					 ans.add(temp);
				 }
			 }
		 }
		 
		 for(int i=zRight;i<nums.length;i++){
			 if(i!=0&&nums[i]==nums[i-1])
				 continue;
			 for(int j=i+1;j<nums.length;j++){
				 if(j!=i+1&&nums[j]==nums[j-1])
					 continue;
				 
				 int tempx=-(nums[i]+nums[j]);
				 if(Arrays.binarySearch(nums, 0,zLeft+1,tempx)>=0){
					 List<Integer> temp=new ArrayList<>();
					 temp.add(tempx);
					 temp.add(nums[i]);
					 temp.add(nums[j]);
					 ans.add(temp);
				 }
			 }
		 }
		 
		 return ans;
	 }
	
//	class Solution {
//	    public List<List<Integer>> threeSum(int[] nums) {
//	    	
//	    	Map<Integer,List<int[]>> map=new HashMap<>();
//	    	
//	        for(int i=0;i<nums.length;i++){
//	        	for(int j=i+1;j<nums.length;j++){
//	        		
//	        		int temp=nums[i]+nums[j];
//	        		
//	        		List<int[]> locs=map.get(temp);
//	        		
//	        		if(locs==null){
//	        			locs=new ArrayList<>();
//	        			map.put(temp, locs);
//	        		}
//	        		
//	        		locs.add(new int[]{nums[i],nums[j]});
//	        	}
//	        }
//	        
//	        for(int i=0;i<nums.length;i++){
//	        	if(map.containsKey(-nums[i])){
//	        		
//	        	}
//	        }
//	    }
//	}
	 
//	 public static void main(String[] args) {
//		 int[] nums={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//		System.out.println(new _15().threeSum(nums));
//	}
}





/*
public class ANS{
		ArrayList<Integer> ans;
		int f;
		boolean sf;
		public ANS(ArrayList<Integer> ans, int f,boolean sf) {
			super();
			this.ans = ans;
			Collections.sort(this.ans);
			this.f = f;
			this.sf=sf;
		}
	}
	
	class CA{
		ArrayList<Integer> ans;
		
		public CA(ArrayList<Integer> ans) {
			super();
			this.ans = ans;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof CA){
				CA o=(CA)obj;
				for(int i=0;i<3;i++){
					if(ans.get(i)!=o.ans.get(i))
						return false;
				}
				return true;
			}
			return super.equals(obj);
		}

		@Override
		public int hashCode() {
			return ans.get(0)+ans.get(1)*1000+ans.get(2)*100000;
		}

		@Override
		public String toString() {
			return ans.toString();
		}
		
	}
	
	 public List<List<Integer>> threeSum(int[] nums) {
		 
		 List<List<Integer>> ans=new ArrayList<>();
		 
		 Set<CA> tempans=new HashSet<>();
		 
		 Arrays.sort(nums);
		 
		 List<ANS> list=new ArrayList<>(nums.length*nums.length);
		 
		 for(int i=0;i<nums.length;i++){
			 for(int j=i+1;j<nums.length;j++){
				 ArrayList<Integer> temp=new ArrayList<>();
				 temp.add(nums[i]);
				 temp.add(nums[j]);
				 int temp2=-nums[i]-nums[j];
				 temp.add(temp2);
				 boolean sf=nums[i]==temp2||nums[j]==temp2;
				 list.add(new ANS(temp,temp2,sf));
			 }
		 }
		 
		 for(ANS a:list){
			 if(a.sf){
				 int count=0;
				 boolean flag=false;
				 for(int i=0;i<nums.length;i++){
					 if(nums[i]==a.f){
						 count++;
						 flag=true;
					 }else if(flag)
						 break;
				 }
				 if(count>=2&&a.f!=0)
					 tempans.add(new CA(a.ans));
				 if(count>=3&&a.f==0)
					 tempans.add(new CA(a.ans));
			 }
			 else
				 if(Arrays.binarySearch(nums,a.f)>=0){
					 tempans.add(new CA(a.ans));
				 }
		 }
		 
		 for(CA ca:tempans){
			 ans.add(ca.ans);
		 }
		 
		return ans;
	 }

*/