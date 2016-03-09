/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juanylaura.algorithms;

import java.util.Arrays;

/**
 *
 * @author jara
 */
public class Mergesort {

    public int[] mergeSort(int[] a) {
        if (a.length == 1) {
            return a; //base case
        }
        
        //divide in two and recursively call mergeSort
        int[] left = mergeSort(Arrays.copyOfRange(a, 0, a.length / 2));
        int[] right = mergeSort(Arrays.copyOfRange(a, a.length / 2, a.length));

        return merge(left, right); //merge both sides

    }

    private int[] merge(int[] left, int[] right) {
        int[] retValue = new int[left.length + right.length];

        int i = 0; //increment left side
        int j = 0; //decrement right side
        int a = 0; //idx to fill retValue
        while (i < left.length && j < right.length) {
            //still elements at left side;
            //element at left side is less than j element at last side
            while (i < left.length && left[i] < right[j]) {
                retValue[a++] = left[i++];
            }
            if (i >= left.length) { //case break, ended
                break;
            }
            //still elements at right side
            //and they are smaller than left side
            while (j < right.length && right[j] < left[i]) {
                retValue[a++] = right[j++];
            }
        }

        //we left with elements on either side, add them, firt left, then rigth
        while (i < left.length) {
            retValue[a++] = left[i++];
        }
        while (j < right.length) {
            retValue[a++] = right[j++];
        }

        return retValue;
    }

    private void swap(int[] left, int i, int[] right, int j) {
        int tmp;
        tmp = left[i];
        left[i] = right[j];
        right[j] = tmp;
    }
}
