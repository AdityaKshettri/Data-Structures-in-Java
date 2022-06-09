package com.aditya.project.greedy;

import java.util.Arrays;
import java.util.Comparator;

// TC : O(N)
// SC : O(N)
public class FractionalKnapsack {

    public static void main(String[] args) {
        int W = 50;
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        Arrays.sort(items, new ItemComparator());
        int currWeight = 0;
        double finalValue = 0;
        for (Item item : items) {
            if (currWeight + item.weight <= W) {
                currWeight += item.weight;
                finalValue += item.value;
            } else {
                int remain = W - currWeight;
                finalValue += (double) item.value / (double) item.weight * (double) remain;
                break;
            }
        }
        System.out.println("Final Value : " + finalValue);
    }

    private static class Item {

        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    private static class ItemComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            double r1 = (double) o1.value / (double) o1.weight;
            double r2 = (double) o2.value / (double) o2.weight;
            return Double.compare(r2, r1);
        }
    }
}