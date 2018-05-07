package com.free.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	public static void main(String[] args) {
		String[] array = {"a","b","c","c","d","e","e","e","a"};  
		String[] goal = {"e"};  
//		String[] arry = removeDuplicateArr(array);
		String[] arry = removeGoalStr(array, goal);
		for (String arr : arry) {
			System.out.println(arr);
		}
	}
	/**
	 * 补足字符串长度
	 * @param goal
	 * @param length
	 * @param location 0:在前补位  1：在后补位
	 * @param flag
	 * @return
	 */
	public static String complementLengh(String goal ,int length ,int location , String flag){
		goal = (goal == null) ? "" : goal;
		while ( goal.length() < length) {
			if(location == 0){
				goal = flag + goal ;
			}else if(location == 1){
				goal = goal +flag ;
			}else {
				break;
			}
		}
		return goal ;
	}
	
	/**
	 * 去除数组中重复 元素
	 * @param array
	 * @return
	 */
	public static String[] removeDuplicateArr(String[] array) {
		List<String> result = new ArrayList<String>();  
		boolean flag;  
		for(int i=0;i<array.length;i++){  
		    flag = false;  
		    for(int j=0;j<result.size();j++){  
		        if(array[i].equals(result.get(j))){  
		            flag = true;  
		            break;  
		        }  
		    }  
		    if(!flag){  
		        result.add(array[i]);  
		    }  
		}  
		String[] arrayResult = (String[]) result.toArray(new String[result.size()]); 
		return arrayResult;
	}
	
	/**
	 * 去除 目标数组指定的 元素
	 * @param array
	 * @param goal
	 * @return
	 */
	public static String[] removeGoalStr(String[] array , String[] goal) {
		List<String> result = new ArrayList<String>();  
		boolean flag;  
		for(int i=0;i<array.length;i++){  
		    flag = false;  
		    for(int j=0;j<goal.length;j++){  
		        if(array[i].equals(goal[j])){  
		            flag = true;  
		            break;
		        }  
		    }  
		    if(!flag){  
		        result.add(array[i]);  
		    }  
		}  
		return (String[]) result.toArray(new String[result.size()]);
	}
}
