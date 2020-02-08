package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] p1 = new int[10];
        int[] p2 = new int[10];
        String s1= "";
        String s2= "";
        for(int i = 0; i<p1.length; i++){
            p1[i] = (int)(Math.random()*25)+97; 
            p2[i] = (int)(Math.random()*25)+97; 

        }
        System.out.println(guessGame(p1,p2,s1,s2));
    }

    public static String guessGame(int[] player1, int[] player2, String s1, String s2){
        if(player1.length >=0 || player2.length >=0){
            int p1=0,p2 = 0;
            
            for(int i = 0; i<player1.length; i++){
                if(i < s1.length())
                p1 += Math.abs(s1.charAt(i) - player1[i]);
            }        
            for(int i = 0; i<player2.length; i++){
                if(i < s2.length())
                p2 += Math.abs(s2.charAt(i) - player2[i]);
            }
            if(p1==p2){
                return "tie";
            }
            else if(p1>p2){
                return "p2";
            }
            else
                return "p1";
        } 
        else return null;
    }
}
