// Created by Navika Singhal

import java.util.ArrayList;
import java.util.Scanner;

class Battleship {

  // instance variables - grids
  private String[][] comp;
  private String[][] user;
  private String[][] hits;
  private static int blankHelper = 0;
  
  // scan objects
  Scanner stringScan = new Scanner(System.in); // stringScan.nextLine();
  Scanner intScan = new Scanner(System.in); // intScan.nextInt();

  //methods - welcome, testingSetUser, printCompGrid, printUserGrid, printHitsGrid, getYPos, placeShips, strike, retaliate, loseCheck, winCheck, play
  
  // welcome method
  public void welcome() {
    //welcome statement
    System.out.println("Welcome to Horizontal Battleship! The Battleship you love new and improved with only horizontal ships! \n\nThe Computer is now creating its grid.");

    // initializing computer's grid
    int j = (int) (Math.random() * 5 + 1);
    String[][] one = { { "o", "o", ".", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", "o", "o", "o", ".", ".", ".", "." }, { "o", "o", "o", "o", ".", ".", ".", "." },
        { ".", ".", ".", ".", ".", "o", "o", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", ".", "o", "o", "o", ".", "." }, { ".", ".", ".", ".", ".", "o", "o", "." } };
    String[][] two = { { ".", ".", ".", "o", "o", "o", "o", "." }, { ".", ".", "o", "o", ".", ".", ".", "." },
        { "o", "o", "o", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", ".", ".", ".", ".", ".", "." }, { "o", "o", ".", ".", ".", ".", ".", "." },
        { ".", ".", ".", "o", "o", "o", ".", "." }, { ".", ".", ".", ".", "o", "o", ".", "." } };
    String[][] three = { { ".", ".", ".", ".", ".", "o", "o", "o" }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { "o", "o", "o", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", "o", "o", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", ".", ".", "o", "o", "o", "o" }, { "o", "o", ".", ".", ".", ".", "o", "o" } };
    String[][] four = { { ".", ".", "o", "o", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { "o", "o", "o", ".", ".", ".", ".", "." }, { ".", "o", "o", ".", "o", "o", "o", "o" },
        { ".", ".", ".", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", "o", "o", "o", ".", ".", "." }, { ".", ".", "o", "o", ".", ".", ".", "." } };
    String[][] five = { { ".", ".", ".", ".", ".", ".", "o", "o" }, { ".", ".", ".", ".", ".", "o", "o", "o" },
        { ".", ".", ".", "o", "o", ".", ".", "." }, { "o", "o", "o", ".", ".", ".", ".", "." },
        { ".", ".", ".", ".", "o", "o", "o", "o" }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", ".", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", "o", "o", "." } };
    if (j == 1)
    {
      comp = one;
    }
    else if (j == 2)
    {
      comp = two;
    }
    else if (j == 3)
    {
      comp = three;
    }
    else if (j == 4)
    {
      comp = four;
    }
    else
      comp = five;
    System.out.println();
  } // end welcome method

  // testing method - set user
  public void testingSetUser() {
    String[][] test = { { ".", ".", ".", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },{ ".", ".", ".", ".", ".", ".", ".", "." }, { "x", "x", "x", "x", ".", ".", ".", "." },
        { ".", ".", ".", ".", ".", "x", "x", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", ".", "x", "x", "x", ".", "." }, { ".", ".", ".", ".", ".", "x", "x", "." } };
    user = test;
  } // end testing - set user method
  
  // print comp
  public void printCompGrid() {
    String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H"};
    System.out.println("  12345678");
    for (int r = 0; r < 8; r++) 
      {
        System.out.print(alphabet[r] + "|");
        for (int c = 0; c < 8; c++)
          System.out.print(comp[r][c]);
        System.out.println("|" + alphabet[r]);
      }
    System.out.println("  12345678");
    System.out.println();
  } // end print comp method

  // print user
  public void printUserGrid() {
    String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H"};
    System.out.println("  12345678");
    for (int r = 0; r < 8; r++) 
      {
        System.out.print(alphabet[r] + "|");
        for (int c = 0; c < 8; c++)
          System.out.print(user[r][c]);
        System.out.println("|" + alphabet[r]);
      }
    System.out.println("  12345678");
    System.out.println();
  } // end print user method
  
  // print hits
  public void printHitsGrid() {
    String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H"};
    System.out.println("  12345678");
    for (int r = 0; r < 8; r++) 
      {
        System.out.print(alphabet[r] + "|");
        for (int c = 0; c < 8; c++)
          System.out.print(hits[r][c]);
        System.out.println("|" + alphabet[r]);
      }
    System.out.println("  12345678");
    System.out.println();
  } // end print hits method
  
  // helper - get y position
  public int getYPos(String letter) {
    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H"};
    int index = 0;
    for (int k = 0; k < alphabet.length; k++)
      {
        if (alphabet[k].equals(letter))
          index = k;
      }
    return index;
  } // end get y position helper method
  
  // ship placement for user
  public void placeShips() {
    // initializing ships and user
    ArrayList<String> ships = new ArrayList();
    ships.add("oooo");
    ships.add("ooo");
    ships.add("ooo");
    ships.add("oo");
    ships.add("oo");
    ships.add("oo");
    
    String[][] blank = { { ".", ".", ".", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", ".", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", ".", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." },
        { ".", ".", ".", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", "." } };
    user = blank;

    // the big while loop to place all of the ships
    while (ships.size() > 0) { // while ships left to place
      // printing user and ships
      System.out.println("Here is your current grid:");
      printUserGrid();
      System.out.println("Here are the ships you have left to place: \n" + ships);
      System.out.println();
      
      // getting coordinates
      System.out.println("You are now placing the first ship in the list. Make sure to not overlap ships! Please select a grid x location number to place the leftmost part of the ship at: ");
      int x = intScan.nextInt() - 1;
      
      int currShipLen = ships.get(0).length();
      while (x + currShipLen > 8 || x < 0)
        {
          System.out.println("Sorry, the place that you chose makes the ship go off of the board. Please select a different grid x location number: ");
          x = intScan.nextInt() - 1;
        }

      System.out.println("Please enter a grid row capital letter to place the ship at: ");
      int y = getYPos(stringScan.nextLine());

      // updating user and ships
      for (int c = x; c < x + currShipLen; c++)
        {
          user[y][c] = "o";
        }
      ships.remove(0);
      
      System.out.println();
    } // end while loop 

    // print final user grid
    System.out.println("Here is your final grid:");
    printUserGrid();
  } // end place ships method
  
  public void strike() {
    // initializing hits
    String[][] blank = { { " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " " },
        { " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " " },
        { " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " " },
        { " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " " } };
    if (blankHelper == 0)
      {
        hits = blank;
        blankHelper++;
      }
    
    // shows current hits grid
    System.out.println("Your turn \nHere is where you have hit: \nBlank = mystery \nx = ocean hit \n* = ship hit \n ");
    printHitsGrid();

    // user input for strike location
    System.out.println("Where would you like to strike?");
    System.out.println("x-location number 1 - 8?");
    int x = intScan.nextInt() - 1;
    System.out.println("y-location capital letter A - H?");
    int y = getYPos(stringScan.nextLine());

    // updating hits grid + telling outcome
    if (comp[y][x] == "o")
      {
        hits[y][x] = "*";
        comp[y][x] = "*";
        System.out.println("You hit a ship!");
      }
    else
      {
        hits[y][x] = "x";
        comp[y][x] = "x";
        System.out.println("You hit the ocean!");
      }
    System.out.println();
  } // end strike method

  public void retaliate() {
    // picking a location
    System.out.println("The computer is now playing...");
    int x = (int)(Math.random()*8);
    int y = (int)(Math.random()*8);
    if (user[x][y] == "*" || user[x][y] == "x")
    {
      x = (int)(Math.random()*8);
      y = (int)(Math.random()*8);
    }

    // updating user
    if (user[x][y] == ".")
    {
      user[x][y] = "x";
      System.out.println("The computer hit the ocean! Here is your grid now:");
    }
    else
    {
      user[x][y] = "*";
      System.out.println("The computer hit your ship! Here is your grid now:");
    }

    // print user grid
    printUserGrid();
  } // end retaliate method

  public int loseCheck() {
    boolean userO = false;
    for (int r = 0; r < 8; r++)
      {
        for (int c = 0; c < 8; c++)
          {
            if (user[r][c] == "o")
              userO = true;
          }
      }
    if (userO == false)
      return 0;
    return 1;
  } // end lose check method

  public int winCheck() {
  boolean compO = false;
    for (int r = 0; r < 8; r++)
      {
        for (int c = 0; c < 8; c++)
          {
            if (comp[r][c] == "o")
              compO = true;
          }
      }
    if (compO == false)
      return 0;
    return 1;    
  } // end win check method

  public void play() {
    // THE FINAL METHODDDDDDD WOOHOOOO

    // user plays
    strike();
    if (winCheck() == 0)
    {
      System.out.println("GAME OVER \nYOU WIN!!!!!!!");
      return;
    }

    // computer plays
    retaliate();
    if (loseCheck() == 0)
    {
      System.out.println("GAME OVER \nYOU LOSE :(");
      return;
    }

    // omg is that recursion woahhhhhh
    play(); // ¬_¬
  } // end play method
  
} // end Battleship class
