package com.dsa_dec_2021.week3;
import org.junit.*;

import java.lang.reflect.Array;
import java.util.*;

public class P16_LC_49_Group_Anagrams {
	
	/* Problem Statement:
	 * https://leetcode.com/problems/group-anagrams/
	 *
	 * Sample Test Data 
	 *    Input :  Input: strs = ["eat","tea","tan","ate","nat","bat"]
	 *    output:  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 *
	 * Approach 1: Using HashMap / ASCII array
	 * 
	 *
	 * Time / Space Complexity: O(n) / O(n)
	 * 		
	 */
	
	//@Test
	public void test1() {
		List<String> strList = Arrays.asList("");
		List<String> list1 = Arrays.asList("");
		List<List<String>> output = Arrays.asList(list1);
		Assert.assertEquals(output, groupByAnagram(strList));
	}

	//@Test
	public void test2() {
		List<String> strList = Arrays.asList("a");
		List<String> list1 = Arrays.asList("a");
		List<List<String>> output = Arrays.asList(list1);
		Assert.assertEquals(output, groupByAnagram(strList));
	}

	@Test
	public void test3() {
		List<String> strList = Arrays.asList("eat","tea","tan","ate","nat","bat");
		List<String> list1 = Arrays.asList("bat");
		List<String> list2 = Arrays.asList("tan","nat");
		List<String> list3 = Arrays.asList("eat","tea","ate");
		List<List<String>> output = Arrays.asList(list2,list3,list1);
		Assert.assertEquals(output, groupByAnagram(strList));
	}
	
	/* 6:39
	 * Input :  Input: strs = ["eat","tea","tan","ate","nat","bat"]
	 * output:  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 * Pseudo Code
	 * Declare a hash map to group the anagrams
	 * Declare a int[] of length 26
	 * Traverse the list in for loop till the length
	 * for each item add it to the ascii array and convert it to string
	 * Check if the string exists in map
	 * -----then add the current element to its value
	 * else
	 * -----add the string and element as value to the map
	 * 
	 * return the map.values
	 * 
	 */
	

	private List<List<String>> groupByAnagram(List<String> strList) {
		if(strList.isEmpty()) return Arrays.asList(Arrays.asList(""));
		HashMap<String,List<String>> map = new HashMap<>();
		for(String str : strList) {
			char[] ascii = new char[26];
			for(int i = 0; i<str.length(); i++) {
				ascii[str.charAt(i)-'a']++;
			}
			String s = String.valueOf(ascii);
			map.putIfAbsent(s, new ArrayList<>());
			map.get(s).add(str);
		}
		System.out.println(map.values());
		return new ArrayList<>(map.values());
	}
	
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Map<Character,Integer>,List<String>> map = new HashMap<>();
        for(int i = 0; i< strs.length; i++){
        	HashMap<Character,Integer> tmpMap = new HashMap<Character,Integer>();
            for(int j = 0; j< strs[i].length();j++){
            	tmpMap.put(strs[i].charAt(j), tmpMap.getOrDefault(strs[i].charAt(j), 0)+1);
            }
			map.putIfAbsent(tmpMap, new ArrayList<>());
			map.get(tmpMap).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}


















