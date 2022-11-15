/* 
Version 4.0
*/
import java.io.*;
import java.util.*;

public class EnemyGenerator{
  private HashMap<String, Integer> enemies = new HashMap<String, Integer>();
  /* 
  Reads enemy file list and stores enemies in a HashMap so they can be accessed by
  other methods.
  */
  public EnemyGenerator(){
    try{
      
      Scanner enemyList = new Scanner(new File("Enemies.txt"));
      String name;
      int hp;
      while(enemyList.hasNext()){   //test if the enemyList has another line of characters
        String line[] = enemyList.nextLine().split(",");  //creates an array spliting the name of the enemies and the hp
        name = line[0]; //retrieves the name of the enemy, always the first element
        hp = Integer.parseInt(line[1]); //retrieves the hp of the enemy, also 2nd element and converted from string to int
        enemies.put(name, hp);  //adds name and hp of enemy to "enemies"
      }
      
      
    }catch(FileNotFoundException fnf){
      System.out.println("File not found.");
    }
  }

  /* 
  Selects a random enemy from "enemies" and returns it with a random sub class
  @param level - the level of the hero, scales Hp of enemies with Hp of hero
  */
  public Enemy generateEnemy(int level){
    String[] names = new String[enemies.keySet().size()];  //creates an empty array for enemy names
    int count = 0;
    for(String name : enemies.keySet()){ //iterates through enemy names
      names[count] = name;  //adds name to array of enemy names
      count++;
    }
    int randClass = (int)Math.round(Math.random() * 2); //gets a random number for the new enemy's class
    int randMonster = (int)Math.round(Math.random() * (names.length - 1)); //random number for monster name in enemy name list
    String newName = names[randMonster];  //gets name with random number

    if(randClass == 0){   //if random class number = 0, then its a ranger
      return new Ranger(newName + " Ranger", enemies.get(newName) + ((level) * 4));
    }else if(randClass == 1){   //if random class number = 1, then its a Warrior
      return new Warrior(newName + " Warrior", enemies.get(newName) + ((level) * 5));
    }else{    //else, then it's a Wizard
      return new Wizard(newName + " Wizard", enemies.get(newName) + ((level) * 3));
    }

  }
}