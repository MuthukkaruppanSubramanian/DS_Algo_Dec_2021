package com.dsa_dec_2021.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Pattern {
	

	@Test
	public void test1() {
		String[] ch = {"abb", "abc", "xyz", "xyy"};
		String pattern = "mnn";
		System.out.println(getMatches(ch, pattern));
		List<Integer> list = Arrays.asList(1,2,3);
		List<Integer> list1 = Arrays.asList(1,2,3);
		System.out.println(list.equals(list1));
	}
	
	private List<String> getMatches(String[] str, String s){
		String p = s;
		for(int i=0; i<s.length();i++) {
		}
		System.out.println(p);
		return new ArrayList<>();
	}
}
