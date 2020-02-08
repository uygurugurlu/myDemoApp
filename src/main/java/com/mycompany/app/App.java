package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        port(getHerokuAssignedPort());
        get("/", (req, res) -> "Hello, World");
        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));
  
            String input1 = req.queryParams("input1");
            String input2 = req.queryParams("input2");
            String s1 = "selam";
            String s2 = "merhaba";
            String[] inp1list = input1.split(",");
            String[] inp2list = input2.split(",");
            int[] player1 = new int[inp1list.length];
            int[] player2 = new int[inp1list.length];
            for(int i =0; i<player1.length; i++){
                player1[i] = Integer.parseInt(inp1list[i]);
            }
            for(int i =0; i<player2.length; i++){
                player2[i] = Integer.parseInt(inp2list[i]);
            }
            String result = guessGame(player1, player2, s1, s2);
           Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
          }, new MustacheTemplateEngine());
  
          get("/compute",
          (rq, rs) -> {
            Map map = new HashMap();
            map.put("result", "not computed yet!");
            return new ModelAndView(map, "compute.mustache");
          },
          new MustacheTemplateEngine());

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
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
