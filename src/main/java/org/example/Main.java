package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Main {

    public static final int ARRAY_SIZE = 10;
    public static void main(String[] args) {
        ArrayList<Integer> arr = generateArray(ARRAY_SIZE);
        System.out.println(arr);
        arr = cocktailSort(arr);
        System.out.println(arr);
    }

    //Generate array of integer
    // int size  - number of Integers
    public static ArrayList<Integer> generateArray(int size){
        int max = 100;
        Random rn = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=1;i<=size;i++){
            arr.add(rn.nextInt(max));
        }
        return arr;
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr){
        //if array contains 1 or 0 elements that returns that array, cause its already sorted
        if (arr.size() <= 1){
            return arr;
        }

        ArrayList<Integer> leftPart = new ArrayList<>();
        ArrayList<Integer> middlePart = new ArrayList<>();
        ArrayList<Integer> rightPart = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Random rn = new Random();

        int rndIndex = rn.nextInt(arr.size());
        int pivot = arr.get(rndIndex);

        for (int i = 0; i <= arr.size()-1; i++){
            if (pivot > arr.get(i)) {
                leftPart.add(arr.get(i));
            } else if (pivot < arr.get(i)){
                rightPart.add(arr.get(i));
            } else {
                middlePart.add(arr.get(i)); //third condition means that arr[i] equals pivot
            }
        }
        //we don't sort middle part, because its contains only elements which equals to each other
        leftPart = quickSort(leftPart);
        rightPart = quickSort(rightPart);
        //concats all the parts to results
        result.addAll(leftPart);
        result.addAll(middlePart);
        result.addAll(rightPart);
        return result;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr){
        for (int i = 0;i <= arr.size();i++){
            for (int j = i;j <= arr.size()-1;j++){
                if (arr.get(i)>=arr.get(j)){
                    Collections.swap(arr,i,j);
                }
            }
        }
        return arr;
    }

    public static ArrayList<Integer> cocktailSort(ArrayList<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            for (int i = left; i <= right-1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    Collections.swap(arr, i, i + 1);
                }
            }
            right--;

            for (int i = right; i>=left+1; i--){
                if (arr.get(i) < arr.get(i-1)){
                    Collections.swap(arr,i,i-1);
                }
            }
            left++;
        }

        return arr;
    }


}