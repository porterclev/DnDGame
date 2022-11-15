/* 
Porter Clevidence
Version 2.0
*/
interface Archer {
    public static final String ARCHER_MENU = "1. Arrow\n2. Fire Arrow";
    public static final int NUM_ARCHER_MENU_ITEMS = 2;  //Number of attacks for entities using class Archer
    public String arrow(Entity e);  //arrow attack
    public String fireArrow(Entity e);  //fire arrow attack
}
