package com.company;

import java.util.*;


public class Main {
    public static List<Integer> mergeSortedArrays(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>(l1);
        List<Integer> iv = new ArrayList<>(l2);

        if (l1.size() == 0) {
            return l2;
        }
        if (l2.size() == 0) {
            return l1;
        }
        if (l1.get(0) > l2.get(0)) {
            res.clear();
            iv.clear();
            res.addAll(l2);
            iv.addAll(l1);
        }

        for (int i = 0; i < iv.size(); i++) {
            if (res.get(res.size() - 1) <= iv.get(i)) {
                res.addAll(res.size(), iv.subList(i, iv.size()));
                break;
            }
            for (int j = 0; j < res.size() - 1; j++) {
                if (iv.get(i) >= res.get(j) && iv.get(i) < res.get(j + 1)) {
                    res.add(j + 1, iv.get(i));
                    break;
                }
            }
        }
        return res;
    }


    public static int indexOfMax(List<Integer> a) {
        int max_index = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > a.get(max_index)) {
                max_index = i;
            }
        }
        return max_index;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(180));
        }
        for (int i = 0; i < 50; i++) {
            list1.add(random.nextInt(70) + 10);
        }
        System.out.println("\n" + list.toString() + " -> max index: " + Main.indexOfMax(list) + ", number " + list.get(Main.indexOfMax(list)) + "\n");

        Collections.sort(list);
        Collections.sort(list1);
        List<Integer> myFunctionResult = Main.mergeSortedArrays(list, list1);
        List<Integer> sortedResult = new ArrayList<>();
        sortedResult.addAll(list);
        sortedResult.addAll(list1);
        Collections.sort(sortedResult);
        System.out.println("list: " + list);
        System.out.println("list1: " + list1 + "\n");

        System.out.println("my function result: " + myFunctionResult.toString());
        System.out.println("sort method result: " + sortedResult);

        System.out.println("Test " + sortedResult.equals(myFunctionResult));
    }
}
