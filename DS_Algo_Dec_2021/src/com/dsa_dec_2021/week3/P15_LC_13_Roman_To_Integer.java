package com.dsa_dec_2021.week3;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class P15_LC_13_Roman_To_Integer {

	/*
	 * 1.Roman numerals are represented by seven different symbols: I, V, X, L, C, D
	 * and M.
	 * 
	 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, 2 is written
	 * as II in Roman numeral, just two one's added together. 12 is written as XII,
	 * which is simply X + II. The number 27 is written as XXVII, which is XX + V +
	 * II.
	 * 
	 * Roman numerals are usually written largest to smallest from left to right.
	 * However, the numeral for four is not IIII. Instead, the number four is
	 * written as IV. Because the one is before the five we subtract it making four.
	 * The same principle applies to the number nine, which is written as IX. There
	 * are six instances where subtraction is used:
	 * 
	 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
	 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
	 * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
	 * integer.
	 */

	/* 
	 * 
	 * Given Input  data type:
	 *       Output data type:
	 * Sample Test Data 
	 *    Input : "III"
	 *    output: 3
	 *
	 * Approach 1: Two Pointers Equi Direction
	 *
	 * Time / Space Complexity: O(n) / O(n)		
	 */

	@Test
	public void test1() {
		String romanNum = "IV";
		Assert.assertTrue(romanToInt(romanNum)==4);
	}

	@Test
	public void test2() {
		String romanNum = "LVIII";
		Assert.assertTrue(romanToInt(romanNum)==58);
	}

	@Test
	public void test3() {
		String romanNum = "MCMXCIV";
		Assert.assertTrue(romanToInt(romanNum)==1994);
	}
	
	@Test
	public void test4() {
		String romanNum = "CMXCIX";
		Assert.assertTrue(romanToInt(romanNum)==999);
	}
	
	@Test
	public void test5() {
		String romanNum = "XIV";
		Assert.assertTrue(romanToInt(romanNum)==14);
	}

    public int romanToInt(String s) {
        int output = 0;
        char[] roman = s.toCharArray();
		HashMap<Character,Integer> romanMap = new HashMap<Character, Integer>();
		romanMap.put('M', 1000);
		romanMap.put('D', 500);
		romanMap.put('C', 100);
		romanMap.put('L', 50);
		romanMap.put('X', 10);
		romanMap.put('V', 5);
		romanMap.put('I', 1);

        output += romanMap.get(roman[roman.length-1]);
		for (int i = roman.length-2; i >=0; i--) {
            if(romanMap.get(roman[i]) < romanMap.get(roman[i+1])) output -= romanMap.get(roman[i]);
            else output += romanMap.get(roman[i]);
		}
        return output;
    }
}
