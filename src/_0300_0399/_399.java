package _0300_0399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _399 {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new _399().new Solution().calcEquation(new String[][]{{"a","b"},{"b","c"}},
				new double[]{2.0,3.0}, new String[][]{{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}})));
	}
	

	class Solution {
		
		class Temp{
			String w;
			double div;
			public Temp(String w, double div) {
				super();
				this.w = w;
				this.div = div;
			}
		}
		
	    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
	        Map<String,List<Temp>> map=new HashMap<>();
	        
	        Map<String,Integer> mapIndex=new HashMap<>();
	        
	        for(int i=0;i<equations.length;++i){
	        	List<Temp> list=map.get(equations[i][0]);
	        	if(list==null){
	        		list=new ArrayList<>();
	        		map.put(equations[i][0], list);
	        		mapIndex.put(equations[i][0], mapIndex.size());
	        	}
	        	list.add(new Temp(equations[i][1],values[i]));
	        	
	        	List<Temp> list2=map.get(equations[i][1]);
	        	if(list2==null){
	        		list2=new ArrayList<>();
	        		map.put(equations[i][1], list2);
	        		mapIndex.put(equations[i][1], mapIndex.size());
	        	}
	        	list2.add(new Temp(equations[i][0],1/values[i]));
	        }
	        
	        System.out.println(map);
	        System.out.println(mapIndex);
	        
	        double[] ans=new double[queries.length];
	        
	        for(int i=0;i<queries.length;++i){
	        	ans[i]=dfs(map, mapIndex, queries[i][0], queries[i][1], 1, new boolean[mapIndex.size()]);
	        }
	        
	        System.out.println(Arrays.toString(ans));
	        
	        return ans;
	    }
	    
	    double dfs(Map<String,List<Temp>> map,Map<String,Integer> mapIndex,String next,String aim,double div,boolean[] been){
	    	
	    	Integer index=mapIndex.get(next);
	    	if(index==null)
	    		return -1;
	    		
	    	if(been[index])
	    		return -1;
	    	
	    	been[index]=true;
	    	
	    	if(next.equals(aim)){
	    		return div;
	    	}
	    	
	    	List<Temp> list=map.get(next);
	    	
	    	for(int i=0;i<list.size();++i){
	    		double res=dfs(map, mapIndex, list.get(i).w, aim, div*list.get(i).div, been);
	    		
	    		System.out.println(res);
	    		
	    		if(Double.compare(res, -1)!=0){
	    			return res;
	    		}
	    	}
	    	
	    	return -1;
	    }
	}
	
}
