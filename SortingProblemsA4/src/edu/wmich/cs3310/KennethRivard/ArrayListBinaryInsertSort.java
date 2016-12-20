package edu.wmich.cs3310.KennethRivard;

import java.util.ArrayList;

/**
 * Created by Kenneth Rivard on 11/9/16.
 */
public class ArrayListBinaryInsertSort {


    private ArrayList<String> strList;

    public ArrayListBinaryInsertSort(ArrayList<String> input) {
        strList = input;
    }//end ArrayListBinaryInsertSort

    public int binInsSearch(ArrayList<String> nameArrList, int left, int right, String txt) {
        int middle = -1;
        while(left <= right) {
            middle = (right + left) / 2;
            if(txt.compareTo(nameArrList.get(middle)) == 0) {
                return middle;
            }
            if(txt.compareTo(nameArrList.get(middle)) < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return middle;
    }//end binInsSearch

    public void binInsSort(ArrayList<String> nameArrList, int left, int right) {
        for(int i = left + 1; i < nameArrList.size() - 1; i++) {
            String txt = nameArrList.remove(i);

            int index = binInsSearch(nameArrList, left, i, txt);
            nameArrList.add(index, txt);
            //System.out.println("LIST: " + nameArrList.toString());
        }//end for

    }//end binInsSort

    public void displayBinInsSort() {
        System.out.println("BINARY INSERTION SORTED ARRAY . . .");
        for(int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }
    }


}//end class
