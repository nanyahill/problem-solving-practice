package com.problems.ctci.chapter8;

import java.util.ArrayList;
import java.util.List;

public class Question8_7 {

    public List<String> permute(String str) {
		List<String> result = new ArrayList<>();
        if(str == null || str.length() == 0) return result;
        return getPerms(str);
    }

 private static List<String> getPerms(String str) {
 	List<String> result = new ArrayList<>();
 	if(str.length() == 0) {
 		result.add("");
 		return result;
 	}
 	String c = str.substring(0, 1);
	 List<String> perms = getPerms(str.substring(1));
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
}
