package old._0000_0099;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _17 {
	
	public List<String> letterCombinations(String digits) {
		
		if(digits.length()==0)
			return Collections.emptyList();
        
		char[] nums=digits.toCharArray();
		
		List<String> ans=new ArrayList<>();
		
		dfs(nums,0,ans,new char[nums.length]);
		
		return ans;
    }
	
	public void dfs(char[] nums,int index,List<String> ans,char[] temp){
		if(nums[index]<='6'){
			if(index<nums.length-1){
				for(int i=0;i<3;i++){
					temp[index]=(char)((nums[index]-'2')*3+i+'a');
					dfs(nums,index+1,ans,temp);
				}
			}else{
				for(int i=0;i<3;i++){
					temp[index]=(char)((nums[index]-'2')*3+i+'a');
					ans.add(new String(temp));
				}
			}
		}else if(nums[index]=='7'){
			if(index<nums.length-1){
				for(int i=0;i<4;i++){
					temp[index]=(char)('p'+i);
					dfs(nums,index+1,ans,temp);
				}
			}else{
				for(int i=0;i<4;i++){
					temp[index]=(char)('p'+i);
					ans.add(new String(temp));
				}
			}
		}else if(nums[index]=='8'){
			if(index<nums.length-1){
				for(int i=0;i<3;i++){
					temp[index]=(char)('t'+i);
					dfs(nums,index+1,ans,temp);
				}
			}else{
				for(int i=0;i<3;i++){
					temp[index]=(char)('t'+i);
					ans.add(new String(temp));
				}
			}
		}else if(nums[index]=='9'){
			if(index<nums.length-1){
				for(int i=0;i<4;i++){
					temp[index]=(char)('w'+i);
					dfs(nums,index+1,ans,temp);
				}
			}else{
				for(int i=0;i<4;i++){
					temp[index]=(char)('w'+i);
					ans.add(new String(temp));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new _17().letterCombinations("67").size());
	}
	
	
}
