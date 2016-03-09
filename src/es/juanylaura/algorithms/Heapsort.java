/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juanylaura.algorithms;

import es.juanylaura.datastructures.Heap;

/**
 *
 * @author jara
 */
public class Heapsort {
    public void heapsort(int[] array) {
        Integer[] a = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            int b = array[i];
            a[i] = b;
        }
        Heap<Integer> h = Heap.heapify(a);
        Integer d = h.extract();
        int i = 0;
        while (d != null) {
            a[i++]=d;
            d=h.extract();
        }
        
        for (int j = 0; j < a.length; j++) {
            array[j] = a[j];
        }
    }
}