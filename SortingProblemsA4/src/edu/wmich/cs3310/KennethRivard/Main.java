package edu.wmich.cs3310.KennethRivard;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        LinkedList nameList = new LinkedList();
        ArrayList<String> nameArrList = new ArrayList<String>();

        /*Read the file into the linked list*/
        //System.out.println("READING FILE TO LINKED LIST . . . \n");
        Scanner names = new Scanner(new File("NameList.txt"));
        int numNamesLink = 0;
        while (names.hasNextLine()) {
            numNamesLink++;
            nameList.insertAtHead(names.nextLine());
        }//end while

        /*====================NON SORTED ARRAY LIST==================================================================*/

        /*Read the file into the array list and display it unsorted*/
        System.out.println("READING FILE TO ARRAY LIST . . . \n");
        Scanner arrNames = new Scanner(new File("NameList.txt"));
        while(arrNames.hasNext()) {
            nameArrList.add(arrNames.next());
        }arrNames.close();  //end while and close the file for reading
        Arrays.toString(nameArrList.toArray());
        System.out.println(nameArrList);

        /*====================NON SORTED LINKED LIST==================================================================*/

        /*Display the unsoted linked list*/
        //display the linked list to prove it is reading in the file and storing the contents
        long startDisplayTime = System.currentTimeMillis();
        nameList.display();
        //long endDisplayTime = System.currentTimeMillis();
        long finalTime = System.currentTimeMillis() - startDisplayTime;
        System.out.println("Diaplaying the original linked-list took: " + finalTime + "ms\n");
        System.out.println("Total: " + numNamesLink);
        System.out.println();

        /*====================MERGE SORT LINKED LIST==================================================================*/

        /*Merge Sort the linked list and measure the time in ms*/
        long startMergeTime = System.currentTimeMillis();
        nameList.append((nameList.mergeSort(nameList.head)));
        System.out.println("MERGE SORT . . .");
        nameList.display();
        long endMergeTime = System.currentTimeMillis() - startMergeTime;
        System.out.println("Merge-Sorting the linked-list took: " + endMergeTime + "ms\n");

        /*======================SELECTION SORT LINKED LIST============================================================*/


        /*Selection Sort the linked list and measure time in ms*/
        long startSelectTime = System.currentTimeMillis();
        nameList.selectionSort(nameList.head);
        System.out.println("SELECTION SORT . . .");
        nameList.display();
        long endSelectTime = System.currentTimeMillis() - startSelectTime;
        System.out.println("Selection-Sorting the linked-list took: " + endSelectTime + "ms\n");

        /*=======================BINARY INSERTION SORT LINKED LIST====================================================*/

        /*Binary-Insertion Sort the linked list and measure the time in ms*/
        long startBinInsTime = System.currentTimeMillis();
        nameList.insertionSort(nameList.head);
        System.out.println("BINARY-INSERTION SORT . . .");
        nameList.display();
        long endBinInsTime = System.currentTimeMillis() - startBinInsTime;
        System.out.println("Binary-Insertion Sorting the linked-list took: " + endBinInsTime + "ms\n");

        /*=====================================BUBBLE SORT LINKED LIST================================================*/

        /*Bubble Sort the linked list and measure the time in ms*/
        long startBubbleSortTime = System.currentTimeMillis();
        nameList.bubbleSort();
        System.out.println("BUBBLE SORT . . .");
        nameList.display();
        long endBubbleSortTime = System.currentTimeMillis() - startBubbleSortTime;
        System.out.println("Bubble Sorting the linked-list took: " + endBubbleSortTime + "ms\n");


        /*==================================ARRAY LIST WORK===========================================================*/


        /*====================MERGE SORTED ARRAY LIST=================================================================*/

        /*Merge sort the array list and measure the time in ms*/
        ArrayListMergeSort mSort = new ArrayListMergeSort(nameArrList);
        long startArrMergeSort = System.currentTimeMillis();
        mSort.sort();
        long endArrMergeSort = System.currentTimeMillis() - startArrMergeSort;
        mSort.displayMergeSortArray();
        System.out.println("Sorting the array list using Merge Sort took " + endArrMergeSort + "ms\n");

        /*====================BINARY INSERTION SORTED ARRAY LIST======================================================*/

        /*Binary Insertion sort the array list and measure the time in ms*/
        ArrayListBinaryInsertSort biSort = new ArrayListBinaryInsertSort(nameArrList);
        long startBinInsSort = System.currentTimeMillis();
        biSort.binInsSort(nameArrList, 0 ,nameArrList.size());
        long endBinInsSort = System.currentTimeMillis() - startBinInsSort;
        biSort.displayBinInsSort();
        System.out.println("Sorting the array list using Binary-Insertion sort took " + endBinInsSort + "ms\n");


        /*====================BUBBLE SORTED ARRAY LIST================================================================*/

        /*Bubble Sort the array list and measure the time in ms*/
        System.out.println("\nBUBBLE SORT ARRAY LIST . . .");
        long startArrBubbleSort = System.currentTimeMillis();
        for(int bubI = 0; bubI < nameArrList.size(); bubI++) {
            for(int bubJ = bubI + 1; bubJ < nameArrList.size(); bubJ++)
                if (nameArrList.get(bubI).compareTo(nameArrList.get(bubI+1)) > 0) {
                    String t = nameArrList.get(bubI);
                    nameArrList.set(bubI, nameArrList.get(bubJ));
                    nameArrList.set(bubI+1, t);
                }//end if
            System.out.println(nameArrList.get(bubI));
        }//end for
        long endArrBubbleSort = System.currentTimeMillis() - startArrBubbleSort;
        System.out.println("Sorting the array list using Bubble Sort took " + endArrBubbleSort + "ms\n");

        /*====================SELECTION SORTED ARRAY LIST=============================================================*/

        /*Selection sort the linked list and measure the time in ms*/
        int  selI, selJ;
        String temp;
        String smallest;
        int smallestIndex;

        System.out.println("\nSELECTION SORT ARRAY LIST . . .");
        long startArrSelectSort = System.currentTimeMillis();
        for(selI = 0; selI < nameArrList.size(); selI++) {
            smallest = nameArrList.get(selI);
            smallestIndex = selI;
            for(selJ = selI + 1; selJ < nameArrList.size(); selJ++) {
                if(smallest.compareTo(nameArrList.get(selJ)) > 0) {
                    smallest = nameArrList.get(selJ);
                    smallestIndex = selJ;
                }
            }
            temp = nameArrList.get(selI);
            nameArrList.set(selI, nameArrList.get(smallestIndex));
            nameArrList.set(smallestIndex, temp);

            System.out.println(nameArrList.get(selI));
        }//end for
        long endArrSelectSort = System.currentTimeMillis() - startArrSelectSort;
        System.out.println("Sorting the array list using Selection Sort took " + endArrSelectSort + "ms\n");


    }//end main

}//end class Main
