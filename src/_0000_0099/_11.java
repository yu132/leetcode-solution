package _0000_0099;

public class _11 {

	public static int maxArea(int[] height) {
		
		int maxi=height[0];
		int maxiIndex=0;
		
		int maxj=height[height.length-1];
		int maxjIndex=height.length-1;
		
		int maxArea=Math.min(maxi, maxj)*(height.length-1);
		
		boolean flag;
		if(maxi>=maxj)
			flag=true;
		else
			flag=false;
		for(int i=0,j=height.length-1;i<j;){
			if(flag){
				j--;
				if(height[j]>maxj){
					maxj=height[j];
					maxjIndex=j;
					
					if(maxj>maxi)
						flag=false;
					
					int temp=Math.min(maxi, maxj)*(maxjIndex-maxiIndex);
					if(maxArea<temp)
						maxArea=temp;
				}
			}else{
				i++;
				if(height[i]>maxi){
					maxi=height[i];
					maxiIndex=i;
					
					if(maxi>maxj)
						flag=true;
					
					int temp=Math.min(maxi, maxj)*(maxjIndex-maxiIndex);
					if(maxArea<temp)
						maxArea=temp;
				}
			}
		}
		
        return maxArea;
    }
	
	
	public static int maxArea1(int[] height) {
		int maxArea=0;
		
		int maxi=-1;
		for(int i=0;i<height.length;i++){
			if(height[i]>maxi)
				maxi=height[i];
			else
				continue;
			
			int maxj=-1;
			for(int j=height.length-1;j>=i+1;j--){
				if(height[j]>maxj)
					maxj=height[j];
				else
					continue;
				
				int ans=(j-i)*Math.min(height[i], height[j]);
				if(maxArea<ans)
					maxArea=ans;
			}
		}
		
        return maxArea;
    }
	
	public static void main(String[] args) {
		int[] a={15000,14999,14998,14997};
		System.out.println(maxArea(a));
	}
}
