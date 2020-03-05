//package Week4;
package com.company;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

// sudiptac: include this for running parameterized tests
@RunWith(Parameterized.class)

public class ParameterizedTest{
//	public int sum, a, b;
    public int[] arrayAns, array;
	// classic constructor
//	public ParameterizedTest (int sum, int a, int b) {
//    	this.sum = sum;
//    	this.a = a;
//    	this.b = b;
//    }
public ParameterizedTest(int[] arrayAns, int[] array ){
	this.arrayAns = arrayAns;
	this.array = array;
}
	 // sudiptac: decide the list of parameters to be sent to the class
   @Parameters public static Collection<Object[]> parameters() {
//	return Arrays.asList (new Object [][] {{0, 0, 0}, {2, 1, 1}});
        return Arrays.asList (new Object [][]
				{
						{new int[] {1, 2, 3}, new int[] {2, 1, 3}},
						{new int[] {1,2,3,4}, new int[] {2,3,4,1}}
				});
    }

	 // sudiptac: This test is invoked for each of the parameter sent via parameters()	
   @Test public void additionTest() { 
		QuickSort sort_array = new QuickSort();
		sort_array.sort(array);
//		assertEquals(sum, Sum.sum(a, b));
	   assertArrayEquals(arrayAns, array);
   }
}
