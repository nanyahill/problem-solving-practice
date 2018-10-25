package com.problems.ctci.chapter8;

import java.util.Collections;
import java.util.List;

public class Question8_13 {

    private static class Box {
        public int width;
        public int height;
        public int depth;

        public Box(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        public boolean canBeAbove(Box b) {
            if(b == null) return false;
            return width > b.width && height > b.height && depth > b.depth;
        }
    }

    public static int findTallestStackOfBoxes_Recursive(List<Box> boxes) {
        if(boxes == null || boxes.size() == 0) return 0;
        int maxHeight = 0;
        for(int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private static int createStack(List<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for(int i = 0; i < boxes.size(); i++) {
            if(i == bottomIndex) continue;
            if(boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        maxHeight += bottom.height;
        return maxHeight;
    }

    public static int findTallestStackOfBoxes_BottomUp(List<Box> boxes) {
        if(boxes == null || boxes.size() == 0) return 0;
        int[] cache = new int[boxes.size()];
        Collections.sort(boxes, (Box b1, Box b2) -> b2.height - b1.height);
        initCache(boxes,cache);
        int result = 0;
        for(int i = 0; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            for(int j = 0; j < i; j++) {
                if(box.canBeAbove(boxes.get(j))) {
                    cache[i] = Math.max(cache[i], cache[j] + box.height);
                }
            }
            result = Math.max(result, cache[i]);
        }
        return result;
    }

    private static void initCache(List<Box> boxes, int[] cache) {
        for(int i = 0; i < boxes.size(); i++) cache[i] = boxes.get(i).height;
    }
}
