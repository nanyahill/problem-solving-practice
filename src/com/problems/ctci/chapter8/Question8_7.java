package com.problems.ctci.chapter8;

import java.util.ArrayList;
import java.util.List;

public class Question8_7 {

 private static List<String> getPerms_NonLexicographic(String str) {
 	List<String> result = new ArrayList<>();
 	if(str.length() == 0) {
 		result.add("");
 		return result;
 	}
 	String c = str.substring(0, 1);
	 List<String> perms = getPerms_NonLexicographic(str.substring(1));
 	for(String perm : perms) {
 		for(int j = 0; j <= perm.length(); j++) {
 			String newPerm = insertCharAt(perm, j, c);
 			result.add(newPerm);
 		}
 	}
 	return result;
 }

    private static String insertCharAt(String str, int pos, String c) {
    	String start = str.substring(0, pos);
    	String end = str.substring(pos);
    	return start + c + end;
    }

	public static List<String> getPerms_Lexicographic(String remainder, String prefix, List<String> result) {
		if(remainder.length() == 0) result.add(prefix);
		else {
			for(int i = 0; i < remainder.length(); i++) {
				String before = remainder.substring(0, i);
				String after = remainder.substring(i + 1);
				char c = remainder.charAt(i);
				getPerms_Lexicographic(before + after, prefix + c, result);

			}
		}
		return result;
	}
}
