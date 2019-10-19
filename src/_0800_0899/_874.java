package _0800_0899;

import java.util.HashSet;
import java.util.Set;

public class _874 {
	
	class Solution {
		
		class Pair{
			int x;
			int y;
			
			public Pair(int x, int y) {
				super();
				this.x = x;
				this.y = y;
			}
			
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + getOuterType().hashCode();
				result = prime * result + x;
				result = prime * result + y;
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pair other = (Pair) obj;
				if (!getOuterType().equals(other.getOuterType()))
					return false;
				if (x != other.x)
					return false;
				if (y != other.y)
					return false;
				return true;
			}
			private Solution getOuterType() {
				return Solution.this;
			}
		}
		
	    public int robotSim(int[] commands, int[][] obstacles) {
	    	
	    	int nowX=0,nowY=0,beforeX=0,beforeY=0,maxL=0;
	    	
	    	Set<Integer> rowSet=new HashSet<>();
	    	
	    	Set<Integer> colSet=new HashSet<>();
	    	
	    	Set<Pair> allSet=new HashSet<>();
	    	
	    	for(int i=0;i<obstacles.length;i++){
	    		int x=obstacles[i][0];
	    		int y=obstacles[i][1];
	    		
	    		colSet.add(x);
	    		rowSet.add(y);
	    		
	    		allSet.add(new Pair(x,y));
	    	}
	    	
	        int upDown=1;
	        int leftRight=0;
	        
	        for(int i=0;i<commands.length;i++){
	        	if(commands[i]==-1){//右转90�?
	        		if(upDown==1&&leftRight==0){
	        			upDown=0;
	        			leftRight=1;
	        		}else if(upDown==0&&leftRight==1){
	        			upDown=-1;
	        			leftRight=0;
	        		}else if(upDown==-1&&leftRight==0){
	        			upDown=0;
	        			leftRight=-1;
	        		}else if(upDown==0&&leftRight==-1){
	        			upDown=1;
	        			leftRight=0;
	        		}
	        	}else if(commands[i]==-2){
	        		if(upDown==1&&leftRight==0){
	        			upDown=0;
	        			leftRight=-1;
	        		}else if(upDown==0&&leftRight==-1){
	        			upDown=-1;
	        			leftRight=0;
	        		}else if(upDown==-1&&leftRight==0){
	        			upDown=0;
	        			leftRight=1;
	        		}else if(upDown==0&&leftRight==1){
	        			upDown=1;
	        			leftRight=0;
	        		}
	        	}else{
	        		
	        		beforeX=nowX;
	        		beforeY=nowY;
	        		
	        		if(leftRight!=0){
	        			nowX+=leftRight*commands[i];
	        			
	        			if(rowSet.contains(nowY))
		        			if(leftRight==1){
		        				
		        				for(int j=beforeX+1;j<=nowX;j++){
		        					if(allSet.contains(new Pair(j,nowY))){
		        						nowX=j-1;
		        						break;
		        					}
		        				}
		        				
		        			}else{
		        				
		        				for(int j=beforeX-1;j>=nowX;j--){
		        					if(allSet.contains(new Pair(j,nowY))){
		        						nowX=j+1;
		        						break;
		        					}
		        				}
		        				
		        			}
	        			
	        		}else{
	        			nowY+=upDown*commands[i];
	        			
	        			if(colSet.contains(nowX))
		        			if(upDown==1){
		        				
		        				for(int j=beforeY+1;j<=nowY;j++){
		        					if(allSet.contains(new Pair(nowX,j))){
		        						nowY=j-1;
		        						break;
		        					}
		        				}
		        				
		        			}else{
		        				
		        				for(int j=beforeY-1;j>=nowY;j--){
		        					if(allSet.contains(new Pair(nowX,j))){
		        						nowY=j+1;
		        						break;
		        					}
		        				}
		        				
		        			}
	        		}
	        		
	        		maxL=Math.max(maxL, nowX*nowX+nowY*nowY);
	        	}
	        	
	        }
	        
	        return maxL;
	    }
	}
	
			
	
	public static void main(String[] args) {
		System.out.println(new _874().new Solution().robotSim(new int[]{-2,-1,8,9,6}, new int[][]{{-1,3},{0,5},{-1,5},{-2,-4},{5,4},{-2,-3},{5,-1},{1,-1},{5,5},{5,2}}));
	}
	
}
