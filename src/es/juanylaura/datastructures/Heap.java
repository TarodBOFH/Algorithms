/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juanylaura.datastructures;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author jara
 * @param <T>
 */
public class Heap<T extends Comparable> {

    private int elements;
    Object[] data;

    public Heap() {
        this.elements = 0;
        this.data = new Object[1];
    }

    public void swap(int i, int j) {
        T temp = (T) this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = temp;
    }

    public T extract() {
        if (elements <= 0 ) return null;
        
        T retValue = (T) data[0];
        data[0] = data[--elements];
        data[elements] = null;
        
        System.out.println("Extract "+retValue);
        
        percolateDown(0);
        
        return retValue;
    }
    
    private void percolateDown(int idx) {
        T tmp = (T) data[idx];

        int min = idx;

        //overwrites idx, keep track of original for last position.
        while (idx < elements) {
            idx = min;
            min = left(idx);
            if (min < elements && data[right(idx)] != null && ((T)data[min]).compareTo(data[right(idx)]) > 0 )  min = right(idx);
            if (min < elements && data[min] != null && tmp.compareTo(data[min]) > 0 ) data[idx] = data[min];
            else break;
        }
        
        data[idx] = tmp;
    }

    public T peek() {
        return null;
    }

    public void insert(T o) {
        if (elements == data.length) {
            resize();
        }
        
        //always insert in the last position
        this.data[elements] = o;
        
        int parent = parent(elements);
        int idx = elements++;
        
        while(parent >= 0 && o.compareTo(this.data[parent]) < 0) {
            swap(idx, parent);
            if (parent == 0) break; //root node already processed?
            idx = parent;
            parent=parent(parent); //WTF?
        }
    }

    public static <T extends Comparable> Heap<T> heapify(T[] a) {
        Heap retValue = new Heap();
        
        for (T a1 : a) {
            retValue.insert(a1);
        }
        return retValue;
    }

    public static <T extends Comparable> Heap<T> heapify(Collection<T>[] c) {
        return null;
    }

    private void resize() {
        Object[] newData = new Object[this.data.length * 2]; //add a new full 
                                                             //set of leafs
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    }
    
    
    //Heap data structure
    //Root element has no parent (-1/2, outside of the array)
    private int parent(int idx) {
        return (idx - 1)/2;
    }
    
    private int left(int idx) {
        return 2*idx+1;
    }
    
    private int right(int idx) {
        return 2*idx+2;
    }
    
}