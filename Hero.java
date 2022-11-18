
/* 
Porter Clevidence
Lucas Gonzalez
Andrew Dante
Version 4
*/
import java.awt.Point;

/*
The hero of the map, to which the player controls
*/
public class Hero extends Entity {
  private Point loc; // location of the hero
  private int level; // level of the hero
  private int gold; // amount of gold the hero has
  private int keys; // amount of keys the hero has
  private int potions; // amount of potions the hero has

  /*
   * Constructor for the hero, sets up his beginning, health, items, and level
   * 
   * @param n the name of the hero
   */
  public Hero(String n) {
    super(n, 25);
    gold = 10;
    level = 1;
    potions = 2;
    keys = 0;
    PlayableMap.getInstance().loadMap(level);
    loc = PlayableMap.getInstance().findStart();
  }

  /*
   * Describing the hero's current status and items
   * 
   * @return A string describing the hero's situation
   */
  @Override
  public String toString() {
    return super.getName() + "\nHP: " + super.getHp() + "/" + super.maxHp + "\nGold: " + gold + "\nLvl: " + level
        + "\nP: " + potions + " K: " + keys;
  }

  /*
   * @return the location of the hero
   */
  public Point getLocation() {
    return loc;
  }

  /*
   * Levels up the hero
   */
  public void levelUp() {
    level++;
  }

  /*
   * @return the level of the hero
   */
  public int getLevel() {
    return level;
  }

  /*
   * Leaves a reveal on the place the hero is to track where he has been, then
   * moves the hero north
   * 
   * @return The hero's location upon moving
   */
  public char goNorth() {
    PlayableMap.getInstance().reveal(loc);
    loc.translate(-1, 0);
    try {
      return PlayableMap.getInstance().getCharAtLoc(loc);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("out of bounds\n");
      loc.translate(1, 0);
      return 'u';
    }
  }

  /*
   * Leaves a reveal on the place the hero is to track where he has been, then
   * moves the hero south
   * 
   * @return The hero's location upon moving
   */
  public char goSouth() {
    PlayableMap.getInstance().reveal(loc);
    loc.translate(1, 0);
    try {
      return PlayableMap.getInstance().getCharAtLoc(loc);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("out of bounds\n");
      loc.translate(-1, 0);
      return 'u';
    }
  }

  /*
   * Leaves a reveal on the place the hero is to track where he has been, then
   * moves the hero east
   * 
   * @return The hero's location upon moving
   */
  public char goEast() {
    PlayableMap.getInstance().reveal(loc);
    loc.translate(0, 1);
    try {
      return PlayableMap.getInstance().getCharAtLoc(loc);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("out of bounds\n");
      loc.translate(0, -1);
      return 'u';
    }
  }

  /*
   * Leaves a reveal on the place the hero is to track where he has been, then
   * moves the hero west
   * 
   * @return The hero's location upon moving
   */
  public char goWest() {
    PlayableMap.getInstance().reveal(loc);
    loc.translate(0, -1);
    try {
      return PlayableMap.getInstance().getCharAtLoc(loc);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("out of bounds\n");
      loc.translate(0, 1);
      return 'u';
    }
  }

  /**
   * 
   * @return - attack menu shown for user
   * 
   */
  public String getAtackMenu() {
    return "1. Physical Attack\n2. Magical Attack\n3. Ranged Attack";
  }

  /**
   * 
   * @return - total number of attack menu items
   * 
   */
  public int getNumAttackMenuItems() {
    return 3;
  }

  /**
   * 
   * @return - total number of sub attack menu items
   * 
   */
  public int getNumSubAttackMenuItems() {
    return 2;
  }

  /**
   * getSubAttackMenu displays different attack menus from each interface
   * 
   * @param int choice - user's interface choice
   * @return - selected menu from interface
   */
  public String getSubAttackMenu(int choice) {
    if (choice == 1) {
      return Fighter.FIGHTER_MENU;
    } else if (choice == 2) {
      return Magical.MAGIC_MENU;
    } else {
      return Archer.ARCHER_MENU;
    }
  }

  /**
   * attack calls the selected ability method that does random amount of damage to
   * enemy
   * 
   * @param Enemy e - damage done to the enemy
   * @param int   choice - user's ability choice
   * @param int   subChoice - user's interfaced ability choice
   * @return - String that represents damage done to enemy
   */
  public String attack(Enemy e, int choice, int subChoice) {
    int d = (int) (Math.random() * 6) + (level * 2);
    if (choice == 1) {
      if (subChoice == 1) {
        e.takeDamage(d);
        return super.getName() + " slashes " + e.getName() + " for " + d + " damage.";
      } else {
        e.takeDamage(d);
        return super.getName() + " slashes " + e.getName() + " for " + d + " damage.";
      }
    } else if (choice == 2) {
      if (subChoice == 1) {
        e.takeDamage(d);
        return super.getName() + " hits " + e.getName() + " with a Magic Missle for " + d + " damage.";
      } else {
        e.takeDamage(d);
        return super.getName() + " hits " + e.getName() + " with a Fireball for " + d + " damage.";
      }
    } else {
      if (subChoice == 1) {
        e.takeDamage(d);
        return super.getName() + " hits " + e.getName() + " with an Arrow for " + d + " damage.";
      } else {
        e.takeDamage(d);
        return super.getName() + " hits " + e.getName() + " with a Fire Arrow for " + d + " damage.";
      }
    }
  }// end attack method

  /*
   * Returns the gold ofthe hero
   * 
   * @return gold of the hero
   */
  public int getGold() {
    return gold;
  }

  /*
   * Collects gold from defeated enemy
   * 
   * @param g the additional gold given
   */
  public void collectGold(int g) {
    gold += g;
  }

  /*
   * Spends gold to pay for selected item. If the hero doesn't have the required
   * amount of money, the the transaction doesn't go through
   * 
   * @param g the amound of gold required to make the purchase
   * 
   * @return validation of the purchase, if false it doesn't go through
   */
  public boolean spendGold(int g) {
    if (gold - g > 0) {
      gold -= g;
      return true;
    } else {
      return false;
    }
  }

  /*
   * If the hero has a key, then he passes through. If not, he is denied
   * 
   * @return if the hero has a key, he goes. If not, he is denied
   */
  public boolean hasKey() {
    if (keys > 0) {
      return true;
    } else {
      return false;
    }
  }

  /*
   * The hero picks up and additional key
   */
  public void pickUpKey() {
    keys++;
  }

  /*
   * The key will be used, and thus depleted
   * 
   * @return validation of using a key
   */
  public boolean useKey() {
    if (keys > 0) {
      keys--;
      return true;
    } else {
      return false;
    }
  }

  /*
   * The hero uses a potion to heal up
   * 
   * @return Validation of the potion being used up
   */
  public boolean hasPotion() {
    if (potions > 0) {
      return true;
    } else {
      return false;
    }
  }

  /*
   * Potion is picked up, getting an additional potion
   */
  public void pickUpPotion() {
    potions++;
  }

  /*
   * The hero uses up a poition to heal up entirely
   * 
   * @return Using up a potion if they have a potion, returninf false if they
   * don't
   */
  public boolean usePotion() {
    if (potions > 0) {
      potions--;
      heal();
      return true;
    } else {
      return false;
    }
  }
}