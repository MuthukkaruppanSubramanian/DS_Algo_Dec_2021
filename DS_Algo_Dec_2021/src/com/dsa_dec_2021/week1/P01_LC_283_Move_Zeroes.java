package com.dsa_dec_2021.week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class P01_LC_283_Move_Zeroes {

	/*
	 * Problem Statement:
	 * Given an integer array nums, move all 0's to the end of it while 
	 * maintaining the relative order of the non-zero elements.
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int array ex:{0,1,0,3,12}
	 * What is the expected output? - int array ex:{1,3,12,0,0}
	 * Do I have constraints to solve the problem? - 
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive : {0,1,0,3,12}
	 *   
	 *  Edge     : {0}
	 *  
	 *  Negative : {1,1,5,3,12}
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
	 *  Approach 1: Two Pointer Algorithm
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
		int[] num = {0,1,0,3,12,0};
		Assert.assertTrue(Arrays.equals(moveZerosTwoPointer(num), new int[] {1,3,12,0,0,0}));
	}
	
	@Test
	public void test2() {
		int[] num = {0};
		Assert.assertTrue(Arrays.equals(moveZerosBruteForce(num), new int[] {0}));
	}
	
	@Test
	public void test3() {
		int[] num = {1,3,12,1,12};
		Assert.assertTrue(Arrays.equals(moveZerosBruteForce(num), new int[] {1,3,12,1,12}));
	}

	/*
	 * Approach:Brute Force
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(n)
	 * 
	 * Pseudo Code:
	 *  a. Create a output array with the same length as input array
	 *  b. Create a int var index for storing value in output array
	 *  c. Traverse the input array and store the non zeros value to new array
	 *  d. Since the default value of array is zero no need to add zero explicitly
	 */
	public int[] moveZerosBruteForce(int[] nums) {
		int[] output = new int[nums.length];
		int index = 0;
		for (int i = 0; i < output.length; i++) {
			if(nums[i] !=0) output[index++] = nums[i];
		}
		return output;
	}
	
	
	/*
	 * Approach:Two Algorithm
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * Pseudo Code:
	 *  a.Create two pointers left starts from 0 and right from 0
	 *  b.Traverse the array until right reach end of array
	 *  c.if value at right index != 0 then swap
	 *  b.By default increment right index
	 */
	
	public int[] moveZerosTwoPointer(int[] nums) {
		int left = 0, right = 0;
		while(right < nums.length){
			if(nums[right] !=0) {
				int tmp = nums[right];
				nums[right] = nums[left];
				nums[left++] = tmp;
			}
			right++;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
