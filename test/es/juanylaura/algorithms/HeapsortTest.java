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
public class HeapsortTest {

    public HeapsortTest() {
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
    public void testSomeMethod() {
        int[] data = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        int[] sorted = {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};

        Heapsort h = new Heapsort();
        h.heapsort(data);
        
        assertArrayEquals(sorted, data);
    }

}
