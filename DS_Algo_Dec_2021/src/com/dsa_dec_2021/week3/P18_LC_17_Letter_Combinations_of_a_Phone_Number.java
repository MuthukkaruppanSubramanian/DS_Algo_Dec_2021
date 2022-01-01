package com.dsa_dec_2021.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class P18_LC_17_Letter_Combinations_of_a_Phone_Number {
	
	/* Problem Statement:
	 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	 *
	 *
	 * Approach 1: BruteForce Using HashMap
	 * 
	 *
	 * Time / Space Complexity: O(n^2) / O(n)
	 * 		
	 */
	
	
	@Test
	public void test1() {
		String nums = "23";
		System.out.println(letterCombinations(nums));
	}
	
	@Test
	public void test2() {
		String nums = "";
		System.out.println(letterCombinations(nums));
	}
	
	@Test
	public void test3() {
		String nums = "2";
		System.out.println(letterCombinations(nums));
	}

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<String>();
        HashMap<Character,ArrayList<String>> phone = new HashMap<>();
        phone.put('2', new ArrayList<String>(Arrays.asList("a","b","c")));
        phone.put('3', new ArrayList<String>(Arrays.asList("d","e","f")));
        phone.put('4', new ArrayList<String>(Arrays.asList("g","h","i")));
        phone.put('5', new ArrayList<String>(Arrays.asList("j","k","l")));
        phone.put('6', new ArrayList<String>(Arrays.asList("m","n","o")));
        phone.put('7', new ArrayList<String>(Arrays.asList("p","q","r","s")));
        phone.put('8', new ArrayList<String>(Arrays.asList("t","u","v")));
        phone.put('9', new ArrayList<String>(Arrays.asList("w","x","y","z")));
        
        //If input digit length is 1 then return the value of that digit
        if(digits.length()==1) return phone.get(digits.charAt(0));
        
        //Product of two list for digit at 0 and 1 position, store it in output list
        List<String> output = product(phone.get(digits.charAt(0)), phone.get(digits.charAt(1)));
        
        //Iterate the remaining digits
        for(int i=2;i<digits.length();i++)
        	
        	//Product the output list with the corresponding list of that digit
        	output = product(output, phone.get(digits.charAt(i)));
        
        return output;
    }
    
    public List<String> product(List<String> s, List<String> s1){
    	List<String> list = new ArrayList<>();
    	int max = Math.max(s.size(), s1.size());
    	int min = Math.min(s.size(), s1.size());
    	for (int i = 0; i < max; i++) {
			for (int j = 0; j < min; j++) {
				list.add(s.get(i)+""+s1.get(j));
			}
		}
    	return list;
    }
}
