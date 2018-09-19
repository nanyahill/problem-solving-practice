package com.problems.epi.test.playful;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static String[] findWords(String[] board, String list_path) {
        if(board == null || board.length == 0) return null;
        List<String> result = new ArrayList<>();
        List<String> dict = buildDictionary(list_path);
        int[][] directions = { {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1} };
        findWords(board, 0, 0, dict, new StringBuilder(), result, directions);
        return result.toArray(new String[result.size()]);
    }

    private static void findWords(String[] board, int row, int col, List<String> dict, StringBuilder tmp, List<String> result, int[][] directions) {
        if(!isValidCell(board, row, col)) return;
        if(dict.contains(tmp.toString())) {
            result.add(tmp.toString());
            return;
        }
        for(int[] direction : directions) {
            tmp.append(Character.toLowerCase(board[row].charAt(col)));
            findWords(board, row + direction[0], col + direction[1], dict, tmp, result, directions);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    private static List<String> buildDictionary(String list_path) {
        List<String> words = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(list_path));
            String line = br.readLine();
            while(line != null) {
                words.add(line);
                line = br.readLine();
            }
        }
        catch(IOException exception) {System.err.println("File Error");}
        return words;
    }

    private static boolean isValidCell(String[] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length();
    }

}
