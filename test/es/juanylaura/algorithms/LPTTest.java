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
public class LPTTest {

    public LPTTest() {
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
        int[] data = {15,15,30,5,10};
        int[][] expected = { {2},{0,4},{1,3} };

        LPT lpt = new LPT();
        int[][] ret = lpt.lpt(data, 3);
        assertArrayEquals(expected, ret);
    }

}
