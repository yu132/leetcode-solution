package _0900_0999;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _902 {

	class Solution {
	    public int atMostNGivenDigitSet(String[] D, int N) {
	        
	    	if(N==0)
	    		return 0;
	    	
	    	int[] d=new int[D.length];
	    	
	    	Set<Integer> set=new HashSet<>();
	    	
	    	List<Integer> list=new ArrayList<>();
	    	
	    	for(int i=0;i<D.length;++i){
	    		d[i]=D[i].charAt(0)-'0';
	    		set.add(d[i]);
	    	}
	    	
	    	int[] temp=new int[10];
	    	
	    	int digit=0;
	    	int n=N;
	    	
	    	while(n!=0){
	    		list.add(n%10);
	    		n/=10;
	    		++digit;
	    	}
	    	
	    	Collections.reverse(list);
	    	
	    	for(int i=0;i<d.length;i++){
	    		for(int j=d[i];j<temp.length;j++)
	    			++temp[j];
	    	}
	    	
	    	int count=0;
	    	for(int i=0,power=d.length;i<digit-1;i++,power*=d.length){
	    		count+=power;
	    	}
	    	
	    	int count2=dfs(list, set, temp, 0);
	    	
	    	System.out.println(count+" "+count2);
	    	
	    	return count+count2;
	    }
	    
	    public int dfs(List<Integer> list,Set<Integer> set,int[] temp,int index){
	    	if(index==list.size())
	    		return 1;
	    	
	    	int countNow=0;
	    	
	    	if(set.contains(list.get(index)))
	    		countNow+=dfs(list, set, temp, index+1);
	    	
	    	if(list.get(index)!=0)
	    		countNow+=temp[list.get(index)-1]*Math.pow(set.size(), list.size()-1-index);
	    	
	    	return countNow;
	    }
	    
	}
	
}
