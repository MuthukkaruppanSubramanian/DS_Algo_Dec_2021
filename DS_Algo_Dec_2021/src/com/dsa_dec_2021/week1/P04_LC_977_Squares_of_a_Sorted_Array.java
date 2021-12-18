package com.dsa_dec_2021.week1;

import java.util.Arrays;

import org.junit.Test;

public class P04_LC_977_Squares_of_a_Sorted_Array {

	/*
	 * Problem Statement:
	 * Given an integer array nums sorted in non-decreasing order, 
	 * return an array of the squares of each number sorted in non-decreasing 
	 * order.
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int[]
	 * What is the expected output? - int[] 
	 * Do I have constraints to solve the problem? - 
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive : {-4,-1,0,3,10}
	 *   
	 *  Edge     : {-7,-3,2,3,11}
	 *  
	 *  Negative : {4,2,5,7}
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
		int[] nums = {-4,-1,0,3,10};
		System.out.println(Arrays.toString(sortedSquares(nums)));
	}

	@Test
	public void test2() {
		int[] nums = {-7,-3,2,3,11};
		System.out.println(Arrays.toString(sortedSquares(nums)));
	}

	@Test
	public void test3() {
		int[] nums = {4,2,5,7};
		System.out.println(Arrays.toString(sortedSquares(nums)));
	}
	
	
	/*
	 * Approach:Brute Force
	 * 
	 * Time Complexity: O(nlogn)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * Pseudo Code:
	 *  a. Traverse the arra in for loop
	 *  b. Square each num and store it in same index
	 *  c. Sort the array
	 *  d. return the array
	 */
	private int[] sortedSquaredBruteForce(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i]*nums[i];
		}
		Arrays.sort(nums);
		return nums;
	}
	
	/*
	 * Approach:Two Pointer
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(n)
	 * 
	 * Pseudo Code:
	 *  a. Declare two pointer left = 0 and right = array length-1
	 *  b. Declare a output array of same size and an index = array length-1 to store in a array
	 *  c. Traverse the array in while loop until left <= right
	 *  d. -->Square num at left and right
	 *  e. -->check if squared num at left > squared num at right
	 *  f. -----> then store squared value of left element and increment left
	 *  g. -----> else store squared value of right element and decrement right
	 *  h. --> decrement index
	 *  i. return output array.
	 */
    private int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1, i = nums.length-1;
		int[] result = new int[nums.length];
		while(left <= right) {
			int leftElement = nums[left] * nums[left];
			int rightElement = nums[right] * nums[right];
			if(leftElement > rightElement) {
				result[i] = leftElement;
				left++;
			}else {
				result[i] = rightElement;
				right--;
			}
			i--;
		}
		return result;
    }

}
