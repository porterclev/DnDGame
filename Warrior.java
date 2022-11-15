/*
Andrew Dante
Version 3
*/

public class Warrior extends Enemy implements Fighter{
  /* 
  Warrior constructor
  @param n - name of warrior
  @param mHp - max hp of warrior
  */
  public Warrior(String n, int mHp){
    super(n, mHp);  
  }

  /* 
  Overrides the attack method from enemy, randomly selects a special attack and uses it
  @param h - hero the enemy attacks
  @return String - output of sword or axe
  */
  @Override
  public String attack(Hero h){
    int randNum = (int)Math.round(Math.random() * 1);
    if(randNum == 0){
        return sword(h);
    }else{
        return axe(h);
    }
  }

  /* 
  Overrides sword from Figher
  @param e - Entity that the attack effects
  @return String - figher name, entity name, and damage
  */
  @Override
  public String sword(Entity e){
    int randDam = (int)Math.round(Math.random() * (int)(Math.ceil(super.maxHp / 3)) + 1);
    e.takeDamage(randDam);
    return super.getName() + " hits " + e.getName() +" with an arrow for " + randDam;  
  }

  /* 
  Overrides axe from Figher
  @param e - Entity that the attack effects
  @return String - figher name, entity name, and damage
  */
  @Override
  public String axe(Entity e){
    int randDam = (int)Math.round(Math.random() * (int)(Math.ceil(super.maxHp / 3)) + 2);
    e.takeDamage(randDam);
    return super.getName() + " hits " + e.getName() + " with a fire arrow for " + randDam;
  }
}