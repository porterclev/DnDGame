/* 
Porter Clevidence
Version 2
*/
/**
* Wizard class displays Wizard enemy and his abilities if selected from enemyGenerator
 *
 * 
 */
public class Wizard extends Enemy implements Magical{
    public Wizard(String n, int mHp){
        super(n, mHp);
    }
  /**
   * attack randomly selects either fireball or magic missle to hit the hero for a random damage
   * 
   * @param Hero h - takes damage from Wizard
   * @return magicMissle(h) - hits hero with magic missle
   * @return fireball(h) - hits hero with fireball
   */
    @Override
    public String attack(Hero h){
        int randNum = (int)Math.round(Math.random() * 1);
        if(randNum == 0){
            return magicMissile(h);
        }else{
            return fireball(h);
        }
    }
  /**
   * magicMissle attack from enemy to hero
   * 
   * @param Entity e - character in game 
   * @return - string with magic missle attack message 
   */
    @Override
    public String magicMissile(Entity e){
        int randDam = (int)Math.round(Math.random() * (int)(Math.ceil(super.maxHp / 2)) + 2);
        e.takeDamage(randDam);
        return super.getName() + " hits " + e.getName() +" with an arrow for " + randDam;  
    }
  /**
   * fireball attack from enemy to hero
   * 
   * @param Entity e - character in game 
   * @return - string with fireball attack message 
   */
    @Override
    public String fireball(Entity e){
        int randDam = (int)Math.round(Math.random() * (int)(Math.ceil(super.maxHp / 2)) + 3);
        e.takeDamage(randDam);
        return super.getName() + " hits " + e.getName() + " with a fire arrow for " + randDam;
    }
}
