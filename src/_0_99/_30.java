package _0_99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30 {

	class Solution {
		
		/**
		 * 
		 * 首先完成这个有4个数据结构
		 * 1.Map<String,Integer> wordIndexMap; 键为word 值为索引
		 * 
		 * 2.int[] count; 表示每个word出现的次数，上面Map的索引即为这个数组的索引
		 * 
		 * 3.int[] sWordIndexMap; 由于每个word都是等长的，所以用这个word在s中开始的位置表示索引，内容为这个word在
		 * 		wordIndexMap中的index，如果这个word没有出现过，那么就是-1
		 * 
		 * 4.int[] count2; 表示以某个索引开始时这个字串包含每个word的个数，如果比count大，那么就不合法
		 * 
		 * 然后：
		 * 1.记录所有的word的map和count
		 * 
		 * 2.找出s中每个子word对应word的index
		 * 
		 * 3.数以某个索引开始s中的字串所包含的word的数量，不能是没有出现过或者这个word出现次数比words中给的要多
		 * 
		 * 4.如果这个字串通过检验，把开始的那个索引加入ans中
		 * 
		 * 5.返回ans
		 * 
		 * @param s
		 * @param words
		 * @return
		 */
		
	    public List<Integer> findSubstring(String s, String[] words) {
	    	
	    	if(words.length==0)
	    		return Collections.emptyList();
	    	
	        int[] count=new int[words.length];
	        
	        int wordLength=words[0].length();
	        
	        Map<String,Integer> wordIndexMap=new HashMap<>(words.length);
	        
	        for(int i=0;i<words.length;i++){
	        	if(!wordIndexMap.containsKey(words[i]))
	        		wordIndexMap.put(words[i], wordIndexMap.size());
	        	++count[wordIndexMap.get(words[i])];
	        }
	        
	        int[] sWordIndexMap=new int[s.length()-wordLength+1];
	        
	        for(int i=0;i<sWordIndexMap.length;i++)
	        	sWordIndexMap[i]=wordIndexMap.getOrDefault(s.substring(i, i+wordLength), -1);
	        
	        List<Integer> ans=new ArrayList<>();
	        
	        l:for(int i=0;i<s.length()-wordLength*words.length+1;i++){
	        	
	        	int[] count2=new int[wordIndexMap.size()];
	        	
	        	for(int j=0;j<words.length;j++){
	        		
	        		int nowWordIndex=i+j*wordLength;
	        		
	        		int wordMapIndex=sWordIndexMap[nowWordIndex];
	        		
	        		if(wordMapIndex==-1)
	        			continue l;
	        		
	        		++count2[wordMapIndex];
        			
        			if(count2[wordMapIndex]>count[wordMapIndex])
        				continue l;
	        	}
	        	
	        	ans.add(i);
	        }
	        
	        return ans;
	    }
	    
	}
	
}
