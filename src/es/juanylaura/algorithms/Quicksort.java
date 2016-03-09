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
public class Quicksort {

    public void quicksort(int[] array, int left, int right) {
        if (left < right) {
            //chose a pivot and partition there
            /*int pivot = partitionTop(array, left, right);*/
            /*int pivot = partitionBottom(array, left, right);*/
            int pivot = partitionMiddle(array, left, right);
            quicksort(array, left, pivot - 1); //sort left side 
            quicksort(array, pivot + 1, right); //sort right side
        }
    }

    @SuppressWarnings("empty-statement")
    private int partitionTop(int[] array, int left, int right) {

        int pivot = array[right];
        for (int i = left; i < right; i++) {
            if (array[i] <= pivot) {
                if (i != left++) {
                    swap(array, left, i);
                }
            }
        }

        if (array[left] > array[right]) {
            swap(array, left, right);
        }

        return left;
    }

    @SuppressWarnings("empty-statement")
    private int partitionBottom(int[] array, int left, int right) {
        int pivot = array[left];
        while (left < right) {
            while (array[right] > pivot && right-- > left);
            while (array[left] < pivot && left++ < right);
            if (left < right) {
                swap(array, left, right);
            }
        }

        return right;
    }

    @SuppressWarnings("empty-statement")
    private int partitionMiddle(int[] array, int left, int right) {
        int pivotIdx = left + (right - left) / 2;
        int pivot = array[pivotIdx];
        while (left < right) {
            //compare left/right elements with pivot
            while (array[right] > pivot && right-- > left);//lookup greater than 
            while (array[left] < pivot && left++ < right);//lookup less than
            if (left < right)  swap(array, left, right); //swap 'em
            //we end with elements bigger than pivot on the rigth side and
            //lower than pivot on the left side
        }
        
        //sanity check, out of bounds? 
        return pivotIdx+1; //this case we don't assume pivot is already ordered.
        //so the first orderer (partially) item wont include pivot
        //pivotIdx-1 has the same effect
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
