package com.java.strings;

public class Regex {

	public static boolean matchPattern(char[] pattern, char[] input) {
		if (pattern.length == 0 || input.length == 0) {
			return false;
		}

		if (pattern[0] == '*') {
			return matchFromBack(pattern, input);
		} else if (pattern[pattern.length - 1] == '*') {
			return matchFromBeginning(pattern, input);
		} else {

			return (matchFromBeginning(pattern, input) && matchFromBack(
					pattern, input));
		}
	}

	//pattern = a*b, input = "acb"
	
	public static boolean matchFromBeginning(char[] pattern, char[] input) {
		boolean result = true;
		int i, j;

		for (i = 0, j = 0; i < input.length && j < pattern.length; i++, j++) {
			if (pattern[j] == '*') {

				return result;
			} else if (pattern[j] != input[i]) {
				result = false;
				return result;
			}
		}

		// input string did not finish
		if (i != input.length) {
			result = false;
		}
		return result;
	}

	public static boolean matchFromBack(char[] pattern, char[] input) {
		boolean result = true;
		int i, j;

		for (i = input.length - 1, j = pattern.length - 1; i >= 0 && j >= 0; i--, j--) {
			if (pattern[j] == '*') {

				return result;
			} else if (pattern[j] != input[i]) {

				result = false;
				return result;
			}

		}

		// input string did not finish
		if (i >= 0) {
			result = false;
		}
		return result;
	}

	public static void main(String[] args) {

		String pattern = "a*b";
		String input = "acb";

		 System.out.println(Regex.matchPattern(pattern.toCharArray(),
		 input.toCharArray()));
		
		 pattern = "abc*";
		 input = "abbc";
		
		 System.out.println(Regex.matchPattern(pattern.toCharArray(),
		 input.toCharArray()));

		pattern = "**bc";
		input = "bc";

		System.out.println(Regex.matchPattern(pattern.toCharArray(),
				input.toCharArray()));

	}

}