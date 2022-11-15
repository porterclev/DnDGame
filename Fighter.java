/*
Andrew Dante
Version 2
*/
interface Fighter{
  public static final String FIGHTER_MENU = "1. Sword\n2. Axe";
  public static final int NUM_FIGHTER_MENU_ITEMS=2;   //total number of actions in figher menu of attacks
  public String sword(Entity e);  //overridable ability for sword attack
  public String axe(Entity e);  //pverrodable ability for axe attack
}