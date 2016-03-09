/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juanylaura.algorithms;

import java.util.Arrays;
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
public class QuicksortTest {
    
    public QuicksortTest() {
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
    public void testQuicksort() {
        
        int[] data = {4,1,3,2,16,9,10,14,8,7};
        
        Quicksort q = new Quicksort();
        q.quicksort(data, 0, data.length-1);
        
        for (int e : data) {
            System.out.print(e+",");
        }
        
        
    }
}
