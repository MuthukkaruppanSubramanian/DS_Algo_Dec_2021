package com.dsa_dec_2021.week3;
import org.junit.*;

import java.lang.reflect.Array;
import java.util.*;

public class P17_Find_Shortest_Unique_SubString {

	/*
	Given a string s, find the length of the longest substring without repeating characters.

	Example 1:
	Input: s = "abcabcbb"
	Output: 3
	Explanation: The answer is "abc", with the length of 3.
	Example 2:
	Input: s = "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.
	Example 3:
	Input: s = "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3.
	Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 *
	 * Approach 1: 
	 * 
	 * Pseudo code:
	 * Declare a int[] with size of 128, left and right = 0, uniqueCount=0 , max=0.
	 * Traverse the array till right < input.len
	 * If char value is == 0 then uniqueCount++ and increase the charvalue++
	 * if uniqueCount > 1 and charValue > 0 
	 * Decrement the charValue and increment left
	 * find the max by right-left
	 *
	 * Time / Space Complexity:
	 * 		
	 */

	@Test
	public void test1() {
		String str = "abcabcbb";
		System.out.println(shortestUniqueSubStrMap(str));
	}

	@Test
	public void test2() {
		String str = "bbbbb";
		System.out.println(shortestUniqueSubStrMap(str));
	}

	@Test
	public void test3() {
		String str = "pwwkew";
		System.out.println(shortestUniqueSubStrMap(str));
	}

	@Test
	public void test4() {
		String str = "abbcafcb";
		System.out.println(shortestUniqueSubStrMap(str));
	}

	public String shortestUniqueSubStrMap(String s) {
		String word = "";
		int left = 0, right = 0, max = 0;
		Map<Character,Integer> asciiArray = new HashMap<>();
		while(right < s.length()) {
			asciiArray.put(s.charAt(right), asciiArray.getOrDefault(s.charAt(right), 0)+1);
			while(asciiArray.get(s.charAt(right)) > 1) {
				asciiArray.put(s.charAt(left), asciiArray.getOrDefault(s.charAt(left++), 0)-1);
			}
			max = Math.max(max, right-left+1);
			if(max == right-left+1) word = s.substring(left,right+1);
			right++;
		}
		return word;
	}
}


















