// Created by Navika Singhal
import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    System.out.println();
    
    // create game Battleship object
    Battleship game = new Battleship();

    // game welcome
    game.welcome();

    // user placing ships
    game.placeShips();

    // playing the game
    game.play();
  }
}
