/* 
Porter Clevidence
Version 4
*/
public class Ranger extends Enemy implements Archer{
    /* 
    Ranger Constructor
    @param n - name of ranger
    @param mHp -  max hp of the ranger
    */
    public Ranger(String n, int mHp){
        super(n, mHp);
    }

    /* 
    Overrides the attack method from enemy, randomly selects a special attack and uses it
    @param h - hero the enemy attacks
    */
    @Override
    public String attack(Hero h){
        int randNum = (int)Math.round(Math.random() * 1);
        if(randNum == 0){   //test if randNum is 0
            return arrow(h);
        }else{  //test if randNum is 1
            return fireArrow(h);
        }
    }

    /* 
    Overrides the arrow method from Archer
    @param e - entity the arrow attacks effects
    @return String - archer name, entity name, and damage
    */
    @Override
    public String arrow(Entity e){
        int randDam = (int)Math.round(Math.random() * (int)(Math.ceil(super.maxHp / 2)) + 1);   //random number multiplied by the max hp of the implicit entity divided by 2
        e.takeDamage(randDam);
        return super.getName() + " hits " + e.getName() +" with an arrow for " + randDam;  
    }

    /* 
    Overrides the fire arrow from Archer
    @param e - entity the fire attack effects
    @return String - archer name, entity name, and damage
    */
    @Override
    public String fireArrow(Entity e){
        int randDam = (int)Math.round(Math.random() * (int)(Math.ceil(super.maxHp / 2)) + 2);   //random number multiplied by the max hp of the implicit entity divided by 2
        e.takeDamage(randDam);
        return super.getName() + " hits " + e.getName() + " with a fire arrow for " + randDam;
    }
}
