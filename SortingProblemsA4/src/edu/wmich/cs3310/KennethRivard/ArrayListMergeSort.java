package edu.wmich.cs3310.KennethRivard;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kenneth Rivard on 11/9/16.
 */
public class ArrayListMergeSort {

    private ArrayList<String> strList;

    public ArrayListMergeSort(ArrayList<String> input) {
        strList = input;
    }//end ArrayListMergeSort

    /*this sort method makes the main method cleaner when calling merge sort*/
    public void sort() {
        strList = mergeSort(strList);
    }//end sort


    public ArrayList<String> mergeSort(ArrayList<String> whole) {
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();
        int center;

        if(whole.size() == 1) {
            return whole;
        } else {
            center = whole.size() / 2; //cut array in half
            //copy left half
            for(int i = 0; i < center; i++) {
                left.add(whole.get(i));
            }//end for

            //copy the right half
            for(int i = center; i < whole.size(); i++) {
                right.add(whole.get(i));
            }//end for

            //sort the left and right halves
            left = mergeSort(left);
            right = mergeSort(right);
            //merge results together
            merge(left, right, whole);
        }//end else
        return whole;
    }//end mergeSort()

    private void merge(ArrayList<String> left, ArrayList<String> right, ArrayList<String> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while(leftIndex < left.size() && rightIndex < right.size()) {
            if(left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }//end else
            wholeIndex++;
        }//end while

        ArrayList<String> rest;
        int restIndex;
        if(leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for(int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }//end for

    }//end merge()

    public void displayMergeSortArray() {
        System.out.println("MERGE SORTED ARRAY . . . ");
        for(int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }//end for
    }//end displayMergeSortArray()


}//end class ArrayListMergeSort
