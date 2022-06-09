package com.aditya.project.array.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeOverlappingSubIntervals {

    public static void main(String[] args) {
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("Given Matrix : ");
        print(a);
        a = merge(a);
        System.out.println("After Merging : ");
        print(a);
    }

    public static int[][] merge(int[][] a) {
        Arrays.sort(a, (x, y) -> x[0]-y[0]);
        List<int[]> list = Arrays.stream(a)
                .collect(Collectors.toList());
        int k=1;
        while(k<list.size()) {
            if (list.get(k)[0]<=list.get(k-1)[1]) {
                if (list.get(k)[1]>=list.get(k-1)[1]) {
                    list.get(k-1)[1]=list.get(k)[1];
                }
                list.remove(k);
            } else {
                k++;
            }
        }
        int[][] b = new int[list.size()][];
        list.toArray(b);
        return b;
    }

    public static int[][] mergeAlternative(int[][] a) {
        Arrays.sort(a, (x, y) -> x[0]-y[0]);
        List<int[]> list = new ArrayList<>();
        int x = a[0][0];
        int y = a[0][1];
        for(int[] i: a) {
            if (i[0] <= y) {
                y = Math.max(y, i[1]);
            } else {
                list.add(new int[]{x, y});
                x = i[0];
                y = i[1];
            }
        }
        list.add(new int[]{x, y});
        int[][] b = new int[list.size()][];
        list.toArray(b);
        return b;
    }

    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
