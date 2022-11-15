/* 
Porter Clevidence
Version 3
*/
public abstract class Entity{
    private String name;
    private int hp;
    int maxHp;

    /* 
    Entity Constructor
    @param n - name of entity
    @param mHp - max Hp of entity
    */
    public Entity(String n, int mHp){
        name = n;
        maxHp = mHp;
        hp = mHp;
    }

    /* 
    retrieves the name of the entity
    @return String - name variable
    */
    public String getName(){
        return name;
    }

    /* 
    retrieves the hp of the entity
    @return int - hp variable
    */
    public int getHp(){
        return hp;
    }

    /* 
    Heals the entity to its max hp
    */
    public void heal(){
        hp = maxHp;
    }

    /* 
    subtracts damage from hp of entity, if the hp ends up being less than 0 then 
    set the hp to 0
    @param d - damage subtracting from hp
    */
    public void takeDamage(int d){
        hp -= d;
        if(hp < 0){
            hp = 0;
        }
    }

    /* 
    String of entity Hp and name
    @return String - string of name and hp
    */
    @Override
    public String toString(){
        return name + "\nHP: " + hp + "/" + maxHp;
    }
}