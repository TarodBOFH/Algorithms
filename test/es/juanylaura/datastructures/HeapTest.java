/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juanylaura.datastructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jara
 */
public class HeapTest {
    
    public HeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() {
        Integer[] data = {4,1,3,2,16,9,10,14,8,7};
        //Integer[] expectedResult = {5,4,3,2,1};
        
        Heap<Integer> h = Heap.heapify(data);
        int i = 1;
        int j = 1;
        for (Object data1 : h.data) {
            System.out.print(data1+" ");
            j++;
            if ( (Math.pow(2, i)) % j == 0 ) {
                System.out.println("");
                i++;
            }
        }
        System.out.println("");
    }
}
