package com.dsa_dec_2021.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class P20_LC_187_Repeated_DNA_Sequences {

	/*
	 * Problem Statement:
	 * 
	 * You are given an integer array nums consisting of n elements, 
	 * and an integer k. Find a contiguous subarray whose length is equal 
	 * to k that has the maximum average value and return this value.
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int[]
	 * What is the expected output? - double 
	 * Do I have constraints to solve the problem? - Slinding Window
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive : [1,12,-5,-6,50,3]  k = 4
	 *   
	 *  Edge     : [5] , k = 1
	 *  
	 *  Negative : [2,3,4], k = 4
	 *
	 */
	
	
	
	@Test
	public void test1() {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		Assert.assertEquals(findRepeatedDnaSequences(s), Arrays.asList("AAAAACCCCC","CCCCCAAAAA"));
	}
	
	@Test
	public void test2() {
		String s = "AAAAAAAAAAAA";
		Assert.assertEquals(findRepeatedDnaSequences(s), Arrays.asList("AAAAAAAAAA"));
	}
	
	@Test
	public void test3() {
		String s = "AAAAAAAAAA";
		Assert.assertEquals(findRepeatedDnaSequences(s), new ArrayList<>());
	}
		
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> dna = new HashMap<>();
        Set<String> output = new HashSet<String>();
        for(int i=0; i<=s.length()-10;i++){
            String str = s.substring(i,i+10);
            dna.put(str,dna.getOrDefault(str,0)+1);
            if(dna.get(str)>1)output.add(str);
        }
        
        for(Map.Entry<String,Integer> l : dna.entrySet()) {
        	if(l.getValue() > 1) 
        		output.add(l.getKey());
        }
        
        return new ArrayList<>(output);
    }
    
    public List<String> findRepeatedDnaSequences2(String s) {
        HashMap<String,Integer> dna = new HashMap<>();
        
        for(int i=0; i<=s.length()-10;i++)
            dna.put(s.substring(i,i+10),dna.getOrDefault(s.substring(i,i+10),0)+1);
        
        List<String> keys = dna.entrySet().stream()
				             .filter(d -> d.getValue() > 1)
				             .map(Map.Entry::getKey)
				             .collect(Collectors.toList());
        return keys;
    }    
}
