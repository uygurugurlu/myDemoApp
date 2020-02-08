# Simple Check Game

myDemoApp is a Java Project for a simple game of guessing a sentence correctly. 
The one that gets closest alphabetically to the target string wins.

## Usage
In your main class
```Java

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
```
## Travis image
[![Build Status](https://travis-ci.org/uygurugurlu/myDemoApp.svg?branch=master)](https://travis-ci.org/uygurugurlu/myDemoApp)

## Demo App
https://pure-harbor-36019.herokuapp.com/compute

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)