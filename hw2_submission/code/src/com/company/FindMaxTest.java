package com.company;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FindMaxTest {
    @Test
    public void TestFailure()

    {
        System.out.println("Test 1: Result in failure (does not compute maximum)");
        int[] testarray = {1, 2, 3};
        assertEquals(3, FindMax.max(testarray));
    }

    @Test
    public void TestError(){
        System.out.println("Test 2: Result in Error (throw exception)");
        int[] testarray = {};
        try{
            int result = FindMax.max(testarray);
            System.out.println("Max is: " + result);
        }
        catch (Exception e){
            System.out.println("Cannot print empty array");
        }
    }

    @Test
    public void TestSuccess(){
        int[] testarray = {2,3,1};
        System.out.println("Max is: " + FindMax.max(testarray));
        assertEquals(3, FindMax.max(testarray));
    }
}
