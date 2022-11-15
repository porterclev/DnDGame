/*
Lucas Gonzalez
Verision 2
*/

public abstract class Enemy extends Entity{
  /* 
  Enemy Constructor
  @param n - name of the enemy
  @param mHp - the maximum hp of the enemy
  */
  public Enemy (String n, int mHp){
    super (n, mHp);
  }

  /* 
  Requires any class extending enemy to override the attack method, which selects a
  random special attack and calls the method.
  */
  public abstract String attack (Hero h);
}
