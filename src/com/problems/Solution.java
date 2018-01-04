package com.problems;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanya on 12/28/17.
 */
public class Solution {

    public static void testArrayListAdd() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.print(list);
        System.out.println();
    }

    public static void testStringBuilder() {
        StringBuilder builder = new StringBuilder();
        builder.append("A");
        builder.append("B");
        builder.append("C");
        System.out.print(builder.toString());

    }

    public static void main(String[] args) {
        testArrayListAdd();
        testStringBuilder();
    }
}
