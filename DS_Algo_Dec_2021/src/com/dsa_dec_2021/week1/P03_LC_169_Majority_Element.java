package com.dsa_dec_2021.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class P03_LC_169_Majority_Element {

	/*
	 * Problem Statement:
	 * Given an array nums of size n, return the majority element.
	 * The majority element is the element that appears more than 
	 * n / 2 times. You may assume that the majority element always 
	 * exists in the array.
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int[]
	 * What is the expected output? - int 
	 * 
	 * Do I have constraints to solve the problem? 
	 * Yes - solve the problem in linear time and in O(1) space
	 * 
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive : [3,2,3]
	 *   
	 *  Edge     : [2]
	 *  
	 *  Negative : [1,2,3,4,5]
	 *  
	 *  Validate the data set with the interviewer 
	 *
	 * 3) Do I know how to solver it? - Yes
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
	 *  Approach 1:
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
		int[] nums = {3,2,3};
		Assert.assertTrue(majorityElement(nums)==3);
		Assert.assertTrue(majorityElementOptimzed(nums)==3);
	}
	
	@Test
	public void test2() {
		int[] nums = {2};
		Assert.assertTrue(majorityElement(nums)==2);
		Assert.assertTrue(majorityElementOptimzed(nums)==2);
	}
	
	@Test(expected = RuntimeException.class)
	public void test3() {
		int[] nums = {1,3,2,4};
		Assert.assertTrue(majorityElement(nums)==0);
		Assert.assertTrue(majorityElementOptimzed(nums)==0);
	}

	/*
	 * Approach:Brute Force
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(n)
	 * 
	 * Pseudo Code:
	 *  a. Declare a hashmap to store the number and its occurrence
	 *  b. Iterate the given array in for loop and store the values in map
	 *  c. Iterate the map and check if any of the element's occurrence is > array size/2
	 *  d. else throw exception 
	 */
	private int majorityElement(int[] nums) {
		HashMap<Integer,Integer> numbers = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			numbers.put(nums[i],numbers.getOrDefault(nums[i], 0)+1);
		}
		int len = nums.length/2;
		for(Entry<Integer, Integer> pair : numbers.entrySet()) {
			if(pair.getValue() > len) return pair.getKey();
		}
		throw new RuntimeException("No Majority Element");
	}

	private int majorityElement2(int[] nums) {
		HashMap<Integer,Integer> numbers = new HashMap<>();
		int len = nums.length/2;
		for (int i = 0; i < nums.length; i++) {
			numbers.put(nums[i],numbers.getOrDefault(nums[i], 0)+1);
			if(numbers.get(nums[i]) > len) return nums[i];
		}
		throw new RuntimeException("No Majority Element");
	}
	
	/*
	 * Approach:Two Pointer
	 * 
	 * Time Complexity: O(nlogn)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * Pseudo Code:
	 *  a. Sort the given array
	 *  b. Declare two pointer left = 0 and right = 0, count = 0
	 *  c. Traverse the array in while loop until right reach the end
	 *  d. Until left and right value are same increase the counter
	 *  e. Check if count > array length /2 then return element
	 *  f. else count = 0 and continue for other elements
	 *  g. if none of the element occurrence is not > array length/2 then throw exception
	 */
	
	private int majorityElementOptimzed(int[] nums) {
		if(nums.length == 1) return nums[0];
		Arrays.sort(nums);
		int left = 0, right = 0, count = 0, len = nums.length/2;
		while(right < nums.length) {
			if(nums[left] == nums[right]) {
				count++;
				right++;
			}else left=right;
			if(count > len) return nums[left];
		}
		return 0;
	}
	
	private int majorityElements(int[] nums) {
		if(nums.length == 1) return nums[0];
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
}
