package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testValid(){
        int[] p1 = new int[5];
        int[] p2 = new int[5];

        String s1 = "aaaaa";
        String s2 = "bbbbb";
        for(int i= 0;i<5;i++){
            p1[i] = 97;
            p2[i]= 97;
        }
        assertTrue(new App().guessGame(p1, p2, s1, s2) == "p1");
    }
    public void testNotValid(){
        int[] p1 = new int[5];
        int[] p2 = new int[5];

        String s1 = "abcde";
        String s2 = "aaaaa";
        for(int i= 0;i<5;i++){
            p1[i] = 97;
            p2[i]= 97;
        }
        assertFalse(new App().guessGame(p1, p2, s1, s2) == "p1");
    }
    public void testEmpty() {
        int[] p1 = new int[5];
        int[] p2 = new int[5];
        String s1 = "abcde";
        String s2 = "aaaaa";

        assertTrue(new App().guessGame(p1, p2, s1, s2) == "p2");
    }
    public void testBoundry(){
        int[] p1 = new int[7];
        int[] p2 = new int[7];

        String s1 = "abcde";
        String s2 = "aaaaa";
        for(int i= 0;i<5;i++){
            p1[i] = 97;
            p2[i]= 97;
        }
        assertTrue(new App().guessGame(p1, p2, s1, s2) == "p2");
    }
    public void testNull() {
        int[] p1 = new int[5];
        int[] p2 = new int[5];

        String s1 = "";
        String s2 = "";
        for(int i= 0;i<5;i++){
            p1[i] = 97;
            p2[i]= 97;
        }
        assertTrue(new App().guessGame(p1, p2, s1, s2) == "tie");
    }
}
