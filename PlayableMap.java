/*
Andrew Dante
Edited by: Lucas Gonzalez
Version 3
*/
import java.util.*;
import java.io.*;
import java.awt.*;
/* 
The map the hero goes through
*/
public class PlayableMap{
  private char [][] map = new char[5][5];
  private boolean [][] revealed = new boolean[5][5];
  private static PlayableMap instance = null;
  private PlayableMap(){  
  }
/*
The map by ways of using a singleton
@return the instance of the map
*/
  public static PlayableMap getInstance(){
    if(instance == null){
      instance = new PlayableMap();
    }
      return instance;
  }
  
/* 
Loads in a map from a file and puts it in the map
@param mapNum the number of the map, determining what file to read from
*/
  public void loadMap(int mapNum){
    try{
      Scanner read = new Scanner(new File("Map" + mapNum + ".txt"));  //Reads a map file
      char[] charArr;
      int count = 0;
      while(read.hasNext()){  //goes through each line of the file to read through
        for(int i = 0; i < map.length; i++){
          charArr = read.nextLine().toCharArray();
          count = 0;
          for(int j = 0; j < charArr.length; j++){
            if(charArr[j] != ' '){
              map[i][j - count] = charArr[j];
            }else{
              count++;
            }
          }
        }
        for(int i = 0; i < revealed.length; i++){
          for(int j = 0; j < revealed[i].length; j++){
            revealed[i][j] = false;
          }
        }
      }
      read.close();
    }catch(FileNotFoundException fnf){  //If the map is not there, then the file will not be found
      System.out.println("File was not found.");
    }
  }
/*
Gets the hero's location
@param p the point where the player is
@return the coordinates of the her's location
*/
  public char getCharAtLoc(Point p){
    return map[(int)p.getX()][(int)p.getY()];
  }
/**
 * findStart finds the starting point on map 
 * @return - Returns the location of 
 * the start on the 2D array
 */
  public Point findStart(){
    Point point = new Point (0,0);
    for (int i = 0;i < map.length;i++){
      for (int j = 0;j < map[0].length; j++){
        if (map [i][j] == 's'){
          point = new Point(i, j);
          reveal(point);
        }
      }
    }
    return point;
  }
/**
 * 
 * @param Point p - takes in the point on the 2D array to reveal the letter
 */
  public void reveal(Point p){
    int x = p.x;
    int y = p.y;
    revealed [x][y] = true;
  }
  /**
   * 
   * @param Point p - takes in the point of where the trainer is at and removes the trainer from the point
   */
  public void removeCharAtLoc(Point p){
    int x = p.x;
    int y = p.y;
    map [x][y] = 'n';
  }
  /**
   * mapToString returns a string of the map with the Hero’s position, revealed rooms, & any unrevealed rooms
   * 
   * @param Point p - acts as value for x & y in 2D array
   * @return level - map with revealed and/or unrevealed rooms
   */
  public String maptoString(Point p){
    String level = "";
    System.out.println(map[0].length);
    for (int i = 0; i < map.length; i++){
      for (int j = 0; j < map[i].length; j++){
        if (p.x == i && p.y == j){
          level = level +"* ";
        }else if (revealed[i][j] != true){
          level = level +"x ";
        }else {
          level = level + map[i][j] + " ";
        }
      }
      level = level + "\n";
    }
    return level;
  }
}