package com.dsa_dec_2021.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class P05_LC_345_Reverse_Vowels_of_a_String {

	/*
	 * Problem Statement:
	 * Given a string s, reverse only all the vowels in the string 
	 * and return it.The vowels are 'a', 'e', 'i', 'o', and 'u', and they 
	 * can appear in both cases.
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - String
	 * What is the expected output? - String
	 * Do I have constraints to solve the problem? - 
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive : "hello"
	 *   
	 *  Edge     : "o"
	 *  
	 *  Negative : "dll"
	 *  
	 *  Validate the data set with the interviewer 
	 *
	 * 3) Do I know how to solver it?
	 *	Yes - great, Is there any alternate solution?
	 *	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes
	 *	Yes - What are those? 
	 *	No – That is still fine, proceed to solve by what you know !!
	 *
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *  Approach 1: Two Pointer
	 *
	 * 7) Start with Pseudo code
	 * 		a.
	 * 		
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */



	@Test
	public void test1() {
		String s = "hello";
		Assert.assertTrue(reverseVowels(s).equals("holle"));
		Assert.assertTrue(reverseVowelsTwoPointer(s).equals("holle"));
	}

	@Test
	public void test2() {
		String s = "Marge, let's \"went.\" I await news telegram.";
		Assert.assertTrue(reverseVowels(s).equals("Marge, let's \"went.\" i awaIt news telegram."));
		Assert.assertTrue(reverseVowelsTwoPointer(s).equals("Marge, let's \"went.\" i awaIt news telegram."));
	}

	@Test
	public void test3() {
		String s = "dll";
		Assert.assertTrue(reverseVowels(s).equals("dll"));
		Assert.assertTrue(reverseVowelsTwoPointer(s).equals("dll"));
	}

	private String reverseVowels(String s) {
		List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
		char[] letters = s.toCharArray();
		int j = letters.length-1;
		for (int i = 0; i < j; i++) {
			if(!vowels.contains(letters[i])) continue;
			while(j >= i) {
				if(vowels.contains(letters[j])&& i !=j){
					char tmp = letters[j];
					letters[j--] = letters[i];
					letters[i] = tmp;
					break;
				}else j--;
			}
		}
		return new String(letters);
	}

	/*
	 * Approach:Two Pointer
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(n)
	 * 
	 * Pseudo Code:
	 *  a. Add all vowels to a list
	 *  b. Convert string to char array
	 *  c. Declare i = 0 and j as array length-1
	 *  d. Traverse the array in while loop until i <= j
	 *  e. ---> If char at i and j are vowels
	 *  f. -------> swap and increment i and decrement j
	 *  g. ---> else if char at j is not a vowel decrement it
	 *  h. ---> else increment i;
	 *  i. return the char array as string
	 */

	public String reverseVowelsTwoPointer(String s) {
		List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
		char[] letters = s.toCharArray();
		int i = 0, j = letters.length-1;
		while(i <= j){
			if(vowels.contains(letters[i]) && vowels.contains(letters[j])){
				char tmp = letters[j];
				letters[j--] = letters[i];
				letters[i++] = tmp;
			}else if(!vowels.contains(letters[j])) j--;
			else i++;
		}
		return new String(letters);
	}
}
