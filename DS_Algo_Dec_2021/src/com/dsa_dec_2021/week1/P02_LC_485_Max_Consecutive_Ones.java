package com.dsa_dec_2021.week1;

import org.junit.Assert;
import org.junit.Test;

public class P02_LC_485_Max_Consecutive_Ones {

	/*
	 * Problem Statement:
	 * Given a binary array nums, return the maximum number 
	 * of consecutive 1's in the array.
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int[] array [1,1,0,1,1,1]
	 * What is the expected output? - int 3
	 * Do I have constraints to solve the problem? - 
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive : [1,1,0,1,1,1]
	 *   
	 *  Edge     : [1,1]
	 *  
	 *  Negative : [0,0,0]
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
	 *  Approach 1: Brute Force
	 *  Approach 2: Two Pointer Algorithm
	 *
	 * 7) Start with Pseudo code
	 * 		
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	
	
	@Test
	public void test1() {
		int[] nums = {1,1,0,1,1,1};
		Assert.assertTrue(MaxConsicutiveOnesBruteForce(nums)==3);
		Assert.assertTrue(MaxConsicutiveOnesTwoPointer2(nums)==3);
	}
	
	@Test
	public void test2() {
		int[] nums = {1};
		Assert.assertTrue(MaxConsicutiveOnesBruteForce(nums)==1);
		Assert.assertTrue(MaxConsicutiveOnesTwoPointer2(nums)==1);
	}
	
	@Test
	public void test3() {
		int[] nums = {0,0,0,0,0};
		Assert.assertTrue(MaxConsicutiveOnesBruteForce(nums)==0);
		Assert.assertTrue(MaxConsicutiveOnesTwoPointer2(nums)==0);
	}
	
	/*
	 * Approach:Brute Force
	 * 
	 * Time Complexity: O(n^2)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * Pseudo Code:
	 *  a. Declare the int var max to return as output;
	 *  b. Traverse the given array in two nested for loop where i = 0 and j = i
	 *  c. In the outer for loop Declare a var int count = 0
	 *  d. -->In the inner for loop check if the nums[j] == 1 increment the count var
	 *  e. -->else break the loop
	 *  f. Compare the current count with existing max value and store it in max.
	 *  f. return max
	 */
	
	private int MaxConsicutiveOnesBruteForce(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = i; j < nums.length; j++) {
				if(nums[j]==1) count++;
				else break;
			}
			max = Math.max(max, count);
		}
		return max;
	}

	private int MaxConsicutiveOnesBruteForce2(int[] nums) {
		int max = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==1) count++;
			else count = 0;
			max = Math.max(max, count);
		}
		return max;
	}
	
	/*
	 * Approach:Two Pointer
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * Pseudo Code:
	 *  a. Declare the int var max to return as output and two pointer as left = 0 and right = 1;
	 *  b. Traverse the array in for loop till left reach the end of loop
	 *  c. ---> if nums[left] == 1
	 *  d. ------> then traverse the right pointer in a while loop until it reaches end of loop
	 *  e. ------> else if any value != 1 then break the loop
	 *  f. ---> then compare the max value with the right-left+1 and store the max
	 *  g. return max
	 */

	private int MaxConsicutiveOnesTwoPointer(int[] nums) {
		int max = 0, left = 0, right = 0;
		while(left < nums.length) {
			if(nums[left] == 1) {
				while(right < nums.length && nums[right] == 1) right++;
			}
			max = Math.max(max, right++-left);
			left = right;
		}
		return max;
	}
	
	private int MaxConsicutiveOnesTwoPointer2(int[] nums) {
		int max = 0, left = 0, right = 0;
		while(right < nums.length) {
			if(nums[right++] == 1 && nums[left] == 1);
			else {
				left = right;
			}
			max = Math.max(max, right-left);
		}
		return max;
	}
}
